package view;

import entity.TwpContact;
import view.util.JsfUtil;
import view.util.JsfUtil.PersistAction;
import bean.TwpContactFacade;

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

@Named("twpContactController")
@SessionScoped
public class TwpContactController implements Serializable {

    @EJB
    private bean.TwpContactFacade ejbFacade;
    private List<TwpContact> items = null;
    private TwpContact selected;

    public List<TwpContact> completeContact(String query) {
        List<TwpContact> allContactos = getItems();
        List<TwpContact> filteredContactos = new ArrayList<TwpContact>();
         
        for (int i = 0; i < allContactos.size(); i++) {
            TwpContact cont = allContactos.get(i);
            if(cont.getTcontNombre().toLowerCase().startsWith(query)) {
                filteredContactos.add(cont);
            }
        }
         
        return filteredContactos;
    }
    
    
    public TwpContactController() {
    }

    public TwpContact getSelected() {
        return selected;
    }

    public void setSelected(TwpContact selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TwpContactFacade getFacade() {
        return ejbFacade;
    }

    public TwpContact prepareCreate() {
        selected = new TwpContact();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TwpContactCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TwpContactUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TwpContactDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TwpContact> getItems() {
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

    public TwpContact getTwpContact(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TwpContact> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TwpContact> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TwpContact.class)
    public static class TwpContactControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TwpContactController controller = (TwpContactController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "twpContactController");
            return controller.getTwpContact(getKey(value));
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
            if (object instanceof TwpContact) {
                TwpContact o = (TwpContact) object;
                return getStringKey(o.getTcontId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TwpContact.class.getName()});
                return null;
            }
        }

    }
    
            public char getContactGroup(TwpContact contact) {
        return contact.getTcontNombre().charAt(0);
    }

}
