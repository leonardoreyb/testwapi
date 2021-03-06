package view;

import entity.TwpCiudad;
import view.util.JsfUtil;
import view.util.JsfUtil.PersistAction;
import bean.TwpCiudadFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("twpCiudadController")
@SessionScoped
public class TwpCiudadController implements Serializable {

    @EJB
    private bean.TwpCiudadFacade ejbFacade;
    private List<TwpCiudad> items = null;
    private TwpCiudad selected;
    
    public List<TwpCiudad> completeCity(String query) {
        List<TwpCiudad> allCities = getItems();
        List<TwpCiudad> filteredCities = new ArrayList<TwpCiudad>();
         
        for (int i = 0; i < allCities.size(); i++) {
            TwpCiudad ciud = allCities.get(i);
            if(ciud.getTciudNombre().toLowerCase().startsWith(query)) {
                filteredCities.add(ciud);
            }
        }
         
        return filteredCities;
    }

    public TwpCiudadController() {
    }

    public TwpCiudad getSelected() {
        return selected;
    }

    public void setSelected(TwpCiudad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TwpCiudadFacade getFacade() {
        return ejbFacade;
    }

    public TwpCiudad prepareCreate() {
        selected = new TwpCiudad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TwpCiudadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TwpCiudadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TwpCiudadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TwpCiudad> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TwpCiudad getTwpCiudad(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TwpCiudad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TwpCiudad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TwpCiudad.class)
    public static class TwpCiudadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TwpCiudadController controller = (TwpCiudadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "twpCiudadController");
            return controller.getTwpCiudad(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TwpCiudad) {
                TwpCiudad o = (TwpCiudad) object;
                return getStringKey(o.getTciudId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TwpCiudad.class.getName()});
                return null;
            }
        }

    }
    
        public char getCityGroup(TwpCiudad city) {
        return city.getTciudNombre().charAt(0);
    }

}
