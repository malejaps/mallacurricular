package org.jpa.Controller;

import org.jsf.util.JsfUtil;
import org.jsf.util.PaginationHelper;
import org.jpa.sessionBean.ResolucionesFacade;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.jdbc.entities.Resoluciones;

@ManagedBean(name = "resolucionesController")
@SessionScoped
public class ResolucionesController {

    private Resoluciones current;
    private Resoluciones current2;
    private DataModel items = null;
    @EJB
    private org.jpa.sessionBean.ResolucionesFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ResolucionesController() {
    }

    public String limpiarCurrent() {
        current = new Resoluciones();
        return "";
    }

    public Resoluciones getCurrent() {
        return current;
    }

    public void setCurrent(Resoluciones current) {
        this.current = current;
    }

    public Resoluciones getSelected() {
        if (current == null) {

            current = new Resoluciones();
            selectedItemIndex = -1;
            
          
        }

        return current;
    }

    private ResolucionesFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Resoluciones) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Resoluciones();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {

            //  int mes=current.getFechaResol().getMonth()+1;
            //current.getFechaResol().setMonth(mes);

            //int dia = current.getFechaResol().getDate() + 1;
            //current.getFechaResol().setDate(dia);

            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("//resource/Bundle").getString("ResolucionesCreated"));
            recreateModel();
            current = new Resoluciones();
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("//resource/Bundle").getString("PersistenceErrorOccured"));
            current = new Resoluciones();
            return null;
        }
    }

    /*  public String create() {
    try {
    getFacade().create(current);
    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("//resource/Bundle").getString("MallaCreated"));
    recreateModel();
    current = new Resoluciones();
    return prepareCreate();
    } catch (Exception e) {
    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("//resource/Bundle").getString("PersistenceErrorOccured"));
    //System.out.print("Error de persistencia");
    return null;
    }
    }
     */
    public String prepareEdit() {
        current = (Resoluciones) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "ModificarResolucionUI.xhtml";
    }

    public String VerResolucion() {
        return "VerResolucionUI.xhtml";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("//resource/Bundle").getString("ResolucionesUpdated"));
            recreateModel();
            current = new Resoluciones();
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("//resource/Bundle").getString("PersistenceErrorOccured"));
            current = new Resoluciones();
            return null;
        }
    }

    public String destroy() {
        current = (Resoluciones) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();

        return "ResolucionUI.xhtml";

    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    public void performDestroy() {
        try {
            getFacade().remove(current);
            recreateModel();
            current = new Resoluciones();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("//resource/Bundle").getString("ResolucionesDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("//resource/Bundle").getString("PersistenceErrorOccured"));
            current = new Resoluciones();
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        
          
        
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Resoluciones.class)
    public static class ResolucionesControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ResolucionesController controller = (ResolucionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "resolucionesController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Resoluciones) {
                Resoluciones o = (Resoluciones) object;
                return getStringKey(o.getCodResol());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ResolucionesController.class.getName());
            }
        }
    }
//exporter
}
