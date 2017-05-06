package view;

import entity.TwProducto;
import view.util.JsfUtil;
import view.util.JsfUtil.PersistAction;
import bean.TwProductoFacade;

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

@Named("twProductoController")
@SessionScoped
public class TwProductoController implements Serializable {

    @EJB
    private bean.TwProductoFacade ejbFacade;
    private List<TwProducto> items = null;
    private TwProducto selected;
    

        public List<TwProducto> completeProducto(String query) {
        List<TwProducto> allProductos = getItems();
        List<TwProducto> filteredProductos = new ArrayList<TwProducto>();
         
        for (int i = 0; i < allProductos.size(); i++) {
            TwProducto prod = allProductos.get(i);
            if(prod.getTprodDetalle().toLowerCase().startsWith(query)) {
                filteredProductos.add(prod);
            }
        }
         
        return filteredProductos;
    }
    
    public TwProductoController() {
    }

    public TwProducto getSelected() {
        return selected;
    }

    public void setSelected(TwProducto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TwProductoFacade getFacade() {
        return ejbFacade;
    }

    public TwProducto prepareCreate() {
        selected = new TwProducto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TwProductoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TwProductoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TwProductoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TwProducto> getItems() {
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

    public TwProducto getTwProducto(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TwProducto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TwProducto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TwProducto.class)
    public static class TwProductoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TwProductoController controller = (TwProductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "twProductoController");
            return controller.getTwProducto(getKey(value));
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
            if (object instanceof TwProducto) {
                TwProducto o = (TwProducto) object;
                return getStringKey(o.getTprodId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TwProducto.class.getName()});
                return null;
            }
        }

    }
    
        public char getProductGroup(TwProducto product) {
        return product.getTprodDetalle().charAt(0);
    }

}
