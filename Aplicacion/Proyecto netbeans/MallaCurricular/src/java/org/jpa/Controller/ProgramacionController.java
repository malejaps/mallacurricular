package org.jpa.Controller;

import org.jdbc.entities.Programacion;
import org.jpa.Controller.util.JsfUtil;
import org.jpa.Controller.util.PaginationHelper;
import org.jpa.sessionBean.ProgramacionFacade;

import java.io.Serializable;
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

@ManagedBean(name = "programacionController")
@SessionScoped
public class ProgramacionController implements Serializable {

    private Programacion current;
    private DataModel items = null;
    @EJB
    private org.jpa.sessionBean.ProgramacionFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ProgramacionController() {
    }

    public Programacion getSelected() {
        if (current == null) {
            current = new Programacion();
            selectedItemIndex = -1;
        }
        return current;
    }

    public String mostrarModificar() {
        current = new Programacion();
        // current = (Programas) getItems().getRowData();
        return "";
    }

    private ProgramacionFacade getFacade() {
        return ejbFacade;
    }

    public Programacion getCurrent() {
        return current;
    }

    public void setCurrent(Programacion current) {
        this.current = current;
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
        current = (Programacion) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Programacion();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage("La programacion se creo satisfactoriamente");

            current = new Programacion();
            //return prepareCreate();
            return "listarProgramacion";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "La programacion no se pudo crear");
            current = new Programacion();
            return null;
        }
    }

    public String prepareEdit() {
        current = (Programacion) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage("La programacion se actualizo satisfactoriamente");
            current = new Programacion();
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "La programacion no se pudo actualizar");
            current = new Programacion();
            return null;
        }
    }

    public String destroy() {
        current = (Programacion) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();
        return "List";
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
            current = new Programacion();
            //recreateModel();
            JsfUtil.addSuccessMessage("El programa se elimino satisfactoriamente");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "El programa no se pudo eliminar");
            current = new Programacion();
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
   
            items = getPagination().createPageDataModel();
        
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

    @FacesConverter(forClass = Programacion.class)
    public static class ProgramacionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProgramacionController controller = (ProgramacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "programacionController");
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
            if (object instanceof Programacion) {
                Programacion o = (Programacion) object;
                return getStringKey(o.getCodProgramacion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ProgramacionController.class.getName());
            }
        }
    }
}
