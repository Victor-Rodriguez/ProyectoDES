
package sv.edu.udb.www.managed_beans;

import java.nio.file.Files;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import sv.edu.udb.www.entities.ImagenEntity;
import sv.edu.udb.www.model.ArticuloModel;
import sv.edu.udb.www.model.ImagenModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author Rodriguez
 */
@Named(value = "imagenBean")
@RequestScoped
public class ImagenBean {

    @EJB
    private ImagenModel imagenModel;
    
    @EJB
    private ArticuloModel articuloModel;
    
    private List<ImagenEntity> listaImagenes;
    
    private ImagenEntity imagen = new ImagenEntity();
   
    private Part imagen2;
    
    public ImagenBean() {
    }

    public List<ImagenEntity> getListaImagenes() {
        listaImagenes = imagenModel.listaImagenes();
        return listaImagenes;
    }

    public ImagenEntity getImagen() {
        return imagen;
    }

    public void setImagen(ImagenEntity imagen) {
        this.imagen = imagen;
    }

    public Part getImagen2() {
        return imagen2;
    }

    public void setImagen2(Part imagen2) {
        this.imagen2 = imagen2;
    }

    public ArticuloModel getArticuloModel() {
        return articuloModel;
    }

    public void setArticuloModel(ArticuloModel articuloModel) {
        this.articuloModel = articuloModel;
    }
    
    
    
    
    public String insertarImagen(){
        try {
            InputStream input = imagen2.getInputStream();
            imagen.setUrl(imagen2.getSubmittedFileName());
            
            if(imagenModel.insertarImagen(imagen) > 0){
                String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
               Files.copy(input, new File(path + "/resources/estilos/img/Hombre/", imagen.getUrl()).toPath());
                JsfUtils.addFlashMessage("exito", "Imágen de artículo insertada exitosamente");
            }
            else{
                JsfUtils.addFlashMessage("fracaso", "No se pudo insertar la imágen del artículo");
            }
            return "/empleado/nuevaImagen?faces-redirect=true";
        } catch (Exception e) {
            JsfUtils.addErrorMessage("idImagen",e.toString());
             return null;
        }
    }
    
    public String obtenerImagen(){
        int codigo = Integer.parseInt(JsfUtils.getRequest().getParameter("codigo"));
        imagen = imagenModel.obtenerImagen(codigo);
        return "/administrador/modificarImagen";
    }
    
    public String modificarImagen(){
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        try {
            InputStream input = imagen2.getInputStream();
            imagen.setUrl(imagen2.getSubmittedFileName());
            Files.copy(input, new File(path + "/resources/ciudadanos/", imagen.getUrl()).toPath());
        } catch (Exception e) {
            JsfUtils.addErrorMessage("idImagen", e.toString());
            return null;
        }
        
        if(imagenModel.modificarImagen(imagen) == 0){
            JsfUtils.addErrorMessage("idImagen", "Ya existe una imágen de artículo con este ID");
            return null;
        }
        JsfUtils.addErrorMessage("exito", "Imágen de artículo modificada con exito");
        return "/administrador/listaImagenes?faces-redirect=true";
    }
    
    
    
}
