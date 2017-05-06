package view;

import entity.TwpCateg;
import view.util.JsfUtil;
import view.util.JsfUtil.PersistAction;
import bean.TwpCategFacade;

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

@Named("twpCategController")
@SessionScoped
public class TwpCategController implements Serializable {

    @EJB
    private bean.TwpCategFacade ejbFacade;
    private List<TwpCateg> items = null;
    private TwpCateg selected;

        public List<TwpCateg> completeCategoria(String query) {
        List<TwpCateg> allCategorias = getItems();
        List<TwpCateg> filteredCategorias = new ArrayList<TwpCateg>();
         
        for (int i = 0; i < allCategorias.size(); i++) {
            TwpCateg cat = allCategorias.get(i);
            if(cat.getTcatDet().toLowerCase().startsWith(query)) {
                filteredCategorias.add(cat);
            }
        }
         
        return filteredCategorias;
    }    
    
    
    public TwpCategController() {
    }

    public TwpCateg getSelected() {
        return selected;
    }

    public void setSelected(TwpCateg selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TwpCategFacade getFacade() {
        return ejbFacade;
    }

    public TwpCateg prepareCreate() {
        selected = new TwpCateg();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TwpCategCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TwpCategUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TwpCategDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TwpCateg> getItems() {
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

    public TwpCateg getTwpCateg(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TwpCateg> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TwpCateg> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TwpCateg.class)
    public static class TwpCategControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TwpCategController controller = (TwpCategController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "twpCategController");
            return controller.getTwpCateg(getKey(value));
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
            if (object instanceof TwpCateg) {
                TwpCateg o = (TwpCateg) object;
                return getStringKey(o.getTcatId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TwpCateg.class.getName()});
                return null;
            }
        }

    }

        public char getCategorygroup(TwpCateg category) {
        return category.getTcatDet().charAt(0);
    }

}
