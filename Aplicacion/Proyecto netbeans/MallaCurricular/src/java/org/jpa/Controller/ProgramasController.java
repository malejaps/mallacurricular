package org.jpa.Controller;

import java.io.IOException;
import org.jsf.util.JsfUtil;
import org.jsf.util.PaginationHelper;
import org.jpa.sessionBean.ProgramasFacade;

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
import javax.swing.text.Document;
import org.jdbc.entities.Programas;

 //import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@ManagedBean(name = "programasController")
@SessionScoped
public class ProgramasController {

    private Programas current;
    private DataModel items = null;
    @EJB
    private org.jpa.sessionBean.ProgramasFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ProgramasController() {
    }

    public Programas getSelected() {
        if (current == null) {
            current = new Programas();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    public String mostrarModificar()
    {
     current = new Programas();
    // current = (Programas) getItems().getRowData();
     return "";
    }

    private ProgramasFacade getFacade() {
        return ejbFacade;
    }

    
      public Programas getCurrent() {          
         return current;
    }

   
    public void setCurrent(Programas current) {
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
        current = (Programas) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String VerPrograma() {
        return "VerProgramaUI.xhtml";
    }

    public String CrearPrograma() {
        return "CrearProgramaUI";
    }

    public String VerTodosProgramas() {

        return "ProgramaUI.xhtml";
    }

    //mirar para modificar navegabilidad
    public String prepareCreate() {
        current = new Programas();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage("El programa se creó satisfactoriamente");
            recreateModel();
            current=new Programas();
            //return prepareCreate();
            return "listarProgramas";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e,"El programa no se pudo crear." );
            current=new Programas();
            return null;
        }
    }

    public String prepareEdit() {
        
        
        current = (Programas) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();        
        return "";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage("El programa se actualizó satisfactoriamente");
            current=new Programas();
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "El programa no se pudo actualizar ");
            current=new Programas();
            return null;
        }
    }

 

    public String destroy() {
        current = (Programas) getItems().getRowData();
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
            current=new Programas();
            JsfUtil.addSuccessMessage("El programa se elimino satisfactoriamente");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e,"El programa no se pudo eliminar ");
            current=new Programas();
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
        //if (items == null) {
        items = getPagination().createPageDataModel();
        //}
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

    @FacesConverter(forClass = Programas.class)
    public static class ProgramasControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProgramasController controller = (ProgramasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "programasController");
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
            if (object instanceof Programas) {
                Programas o = (Programas) object;
                return getStringKey(o.getCodProg());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ProgramasController.class.getName());
            }
        }
        
        
        
        
        
        
 /*    public void postProcessXLS(Object document) {  
    HSSFWorkbook wb = (HSSFWorkbook) document;  
    HSSFSheet sheet = wb.getSheetAt(0);  
    HSSFRow header = sheet.getRow(0);  
      
    HSSFCellStyle cellStyle = wb.createCellStyle();    
    cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);  
    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
      
    for(int i=0; i < header.getPhysicalNumberOfCells();i++) {  
        HSSFCell cell = header.getCell(i);  
          
        cell.setCellStyle(cellStyle);  
    }  

  
public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {  
    Document pdf = (Document) document;  
    pdf.open();  
    pdf.setPageSize(PageSize.A4);  
  
    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
    String logo = servletContext.getRealPath("") + File.separator + "images" + File.separator + "prime_logo.png";  
  
    pdf.add(Image.getInstance(logo));  
}}*/
    }}

