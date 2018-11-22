package sv.edu.udb.www.managed_beans;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import sv.edu.udb.www.entities.ArticuloEntity;
import sv.edu.udb.www.entities.CarritoEntity;
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.entities.DeseoEntity;
import sv.edu.udb.www.entities.MarcaEntity;
import sv.edu.udb.www.entities.ProveedorEntity;
import sv.edu.udb.www.entities.RubroEntity;
import sv.edu.udb.www.entities.SubCategoriaEntity;
import sv.edu.udb.www.entities.TallaEntity;
import sv.edu.udb.www.model.ArticuloModel;
import sv.edu.udb.www.model.CarritoModel;
import sv.edu.udb.www.model.CategoriaModel;
import sv.edu.udb.www.model.DeseoModel;
import sv.edu.udb.www.model.MarcaModel;
import sv.edu.udb.www.model.ProveedorModel;
import sv.edu.udb.www.model.RubrosModel;
import sv.edu.udb.www.model.SubcategoriaModel;
import sv.edu.udb.www.model.TallaModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "articuloBean")
@RequestScoped
public class ArticuloBean {

    @EJB
    private CarritoModel carritoModel;

    @EJB
    private DeseoModel deseoModel;

    @EJB
    private ArticuloModel articuloModel;
    @EJB
    private CategoriaModel categoriaModel;
    @EJB
    private ProveedorModel proveedorModel;
    @EJB
    private SubcategoriaModel subCategoriaModel;
    @EJB
    private MarcaModel marcaModel;
    @EJB
    private TallaModel tallaModel;

    @EJB
    private RubrosModel rubrosModel;

    private List<CarritoEntity> listaCarritos;

    private CarritoEntity carrito = new CarritoEntity();

    private List<DeseoEntity> listaDeseos;

    private DeseoEntity deseo = new DeseoEntity();

    public CarritoModel getCarritoModel() {
        return carritoModel;
    }

    public void setCarritoModel(CarritoModel carritoModel) {
        this.carritoModel = carritoModel;
    }

    //--------------------------------------------------------------------------
    public List<CarritoEntity> getListaCarritos() {
        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");

        listaCarritos = carritoModel.listarCarritos(correo);

        double total = 0;

        for (CarritoEntity carrito : listaCarritos) {
            total += carrito.getPrecio();
        }

        return listaCarritos;
    }

    //--------------------------------------------------------------------------
    public List<DeseoEntity> getListaDeseos() {

        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");

        listaDeseos = deseoModel.listarDeseos(correo);

        return listaDeseos;
    }

    public void setListaDeseos(List<DeseoEntity> listaDeseos) {
        this.listaDeseos = listaDeseos;
    }

    public DeseoEntity getDeseo() {
        return deseo;
    }

    public void setDeseo(DeseoEntity deseo) {
        this.deseo = deseo;
    }

    public void setListaCarritos(List<CarritoEntity> listaCarritos) {
        this.listaCarritos = listaCarritos;
    }

    public CarritoEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoEntity carrito) {
        this.carrito = carrito;
    }

    private List<ArticuloEntity> listaArticulos;

    private ArticuloEntity articulo = new ArticuloEntity();

    public ArticuloBean() {
    }

    public List<TallaEntity> getListaTalla() {
        return tallaModel.listaTalla();
    }

    public List<MarcaEntity> getListaMarca() {
        return marcaModel.listarMarca();
    }

    public List<SubCategoriaEntity> getListaSubCategoria() {
        return subCategoriaModel.listaSubCategorias();
    }

    public List<ProveedorEntity> getListaProveedor() {
        return proveedorModel.listarProveedor();
    }

    public List<ArticuloEntity> getListaArticulos() {
        listaArticulos = articuloModel.listaArticulos();
        return listaArticulos;
    }

    public List<CategoriaEntity> getListaCategoria() {
        return categoriaModel.listarCategorias();
    }

    public List<RubroEntity> getListaRubro() {
        return rubrosModel.listarRubros();
    }

    public ArticuloEntity getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEntity articulo) {
        this.articulo = articulo;
    }

    public RubrosModel getRubrosModel() {
        return rubrosModel;
    }

    public void setRubrosModel(RubrosModel rubrosModel) {
        this.rubrosModel = rubrosModel;
    }

    private Part imagen;
    private Part imagen2;
    private Part imagen3;
    private Part imagen4;
    private Part imagen5;

    public Part getImagen2() {
        return imagen2;
    }

    public void setImagen2(Part imagen2) {
        this.imagen2 = imagen2;
    }

    public Part getImagen3() {
        return imagen3;
    }

    public void setImagen3(Part imagen3) {
        this.imagen3 = imagen3;
    }

    public Part getImagen4() {
        return imagen4;
    }

    public void setImagen4(Part imagen4) {
        this.imagen4 = imagen4;
    }

    public Part getImagen5() {
        return imagen5;
    }

    public void setImagen5(Part imagen5) {
        this.imagen5 = imagen5;
    }

    public Part getImagen() {
        return imagen;
    }

    public void setImagen(Part imagen) {
        this.imagen = imagen;
    }

    public double obtenerPrecio() {
        double total = 0;

        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");

        listaCarritos = carritoModel.listarCarritos(correo);

        for (CarritoEntity carrito : listaCarritos) {
            total += carrito.getPrecio();
        }

        return total;
    }

    public String insertarArticulo() {

        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");

        String cod = articuloModel.generarCodigo();

        articulo.setIdArticulo(cod);

        try {

            InputStream input = imagen.getInputStream();

            InputStream input2 = imagen2.getInputStream();
            InputStream input3 = imagen3.getInputStream();
            InputStream input4 = imagen4.getInputStream();
            InputStream input5 = imagen5.getInputStream();

            articulo.setImg1(imagen.getSubmittedFileName());

            articulo.setImg2(imagen2.getSubmittedFileName());
            articulo.setImg3(imagen3.getSubmittedFileName());
            articulo.setImg4(imagen4.getSubmittedFileName());
            articulo.setImg5(imagen5.getSubmittedFileName());

            Files.copy(input, new File(path + "/resources/img/", articulo.getImg1()).toPath());

            Files.copy(input2, new File(path + "/resources/img/", articulo.getImg2()).toPath());
            Files.copy(input3, new File(path + "/resources/img/", articulo.getImg3()).toPath());
            Files.copy(input4, new File(path + "/resources/img/", articulo.getImg4()).toPath());
            Files.copy(input5, new File(path + "/resources/img/", articulo.getImg5()).toPath());

        } catch (IOException e) {
            JsfUtils.addErrorMessage("idArticulo", e.toString());
            return null;
        }

        if (articuloModel.insertarArticulo(articulo) == 0) {
            JsfUtils.addErrorMessage("articulo", "Ya existe otro articulo con este nombre o código");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Articulo insertado exitosamente");
        return "/empleado/listarArticulo?faces-redirect=true";
    }

    public String obtenerArticulo() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        articulo = articuloModel.obtenerArticulo(codigo);
        return "/empleado/modificarArticulo";
    }

    public String obtenerArticulo2() {
        String codigo = JsfUtils.getRequest().getParameter("id");
        articulo = articuloModel.obtenerArticulo(codigo);
        return "/kleidung_detalle";
    }

    public String obtenerArticuloV() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        articulo = articuloModel.obtenerArticulo(codigo);
        return "/empleado/#carrito o cada uno";
    }

    public String modificarArticulo() {
        if (articuloModel.modificarArticulo(articulo) == 0) {
            JsfUtils.addErrorMessage("idArticulo", "No se pudo modificar");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Artículo modificado exitosamente");
        return "/empleado/listarArticulo?faces-redirect=true";
    }

    public String agregarCarrito() {

        HttpServletRequest request = JsfUtils.getRequest();

        if (request.getSession().getAttribute("user") == null) {
            return "/login?faces-redirect=true";
        } else {

            String correo = (String) request.getSession().getAttribute("user");
            String id = JsfUtils.getRequest().getParameter("id");
            String articulo = JsfUtils.getRequest().getParameter("nombre");
            String img = JsfUtils.getRequest().getParameter("img");

            double precio = Double.parseDouble(JsfUtils.getRequest().getParameter("precio"));

            carrito.setCorreo(correo);
            carrito.setIdProducto(id);
            carrito.setArticulo(articulo);
            carrito.setImg(img);
            carrito.setPrecio(precio);

            carritoModel.insertarCarrito(carrito);

            return "/kleidung?faces-redirect=true";
        }

    }

    //Principal al deseo
    public String agregarDeseo() {
        HttpServletRequest request = JsfUtils.getRequest();

        if (request.getSession().getAttribute("user") == null) {
            return "/login?faces-redirect=true";
        } else {

            String correo = (String) request.getSession().getAttribute("user");
            String id = JsfUtils.getRequest().getParameter("id");
            String articulo = JsfUtils.getRequest().getParameter("nombre");
            String img = JsfUtils.getRequest().getParameter("img");

            double precio = Double.parseDouble(JsfUtils.getRequest().getParameter("precio"));

            deseo.setCorreo(correo);
            deseo.setIdProducto(id);
            deseo.setArticulo(articulo);
            deseo.setImg(img);
            deseo.setPrecio(precio);

            deseoModel.insertarDeseo(deseo);

            return "/kleidung?faces-redirect=true";
        }
    }
    
    //Detalle al deseo
      public String alDeseo() {
        HttpServletRequest request = JsfUtils.getRequest();

        if (request.getSession().getAttribute("user") == null) {
            return "/login?faces-redirect=true";
        } else {

            String correo = (String) request.getSession().getAttribute("user");
            String id = JsfUtils.getRequest().getParameter("id");
            String articulo = JsfUtils.getRequest().getParameter("nombre");
            String img = JsfUtils.getRequest().getParameter("img");

            double precio = Double.parseDouble(JsfUtils.getRequest().getParameter("precio"));

            deseo.setCorreo(correo);
            deseo.setIdProducto(id);
            deseo.setArticulo(articulo);
            deseo.setImg(img);
            deseo.setPrecio(precio);

            deseoModel.insertarDeseo(deseo);

            return "/deseo?faces-redirect=true";
        }
    }

    public int contarDeseo() {
        int num = 0;
        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");

        listaDeseos = deseoModel.listarDeseos(correo);

        num = listaDeseos.size();

        return num;
    }

    public String eliminarArticulo() {

        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("codigo"));

        carritoModel.eliminarCarrito(id);

        return "/carrito?faces-redirect=true";
    }
    //Eliminar artículo de compra
     public String eliminarArticuloC() {

        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("codigo"));

        carritoModel.eliminarCarrito(id);

        return "/compra?faces-redirect=true";
    }
    //Eliminar 1 deseo
     public String eliminarLista() {

        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("codigo"));
        deseoModel.eliminarDeseo(id);        

        return "/deseo?faces-redirect=true";
    }
     
     public String limpiarLista() {

        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");

        List <DeseoEntity> lista = deseoModel.listarDeseos(correo);

        
        for(DeseoEntity d:lista){
            
            deseoModel.eliminarDeseo(d.getIdDeseo());
            
        }        
        return "/deseo?faces-redirect=true";
    }
     
     //Finalizar compra carrito
    public String compraH() {

        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");

        List <CarritoEntity> lista = carritoModel.listarCarritos(correo);
        
        for(CarritoEntity d:lista){
            
            carritoModel.eliminarCarrito(d.getIdCarrito());
            
        }        
        return "/kleidung?faces-redirect=true";
    }
    
    public String alCarrito() {

        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");
        String id = JsfUtils.getRequest().getParameter("producto");
        String articulo = JsfUtils.getRequest().getParameter("nombre");
        String img = JsfUtils.getRequest().getParameter("img");

        double precio = Double.parseDouble(JsfUtils.getRequest().getParameter("precio"));

        carrito.setCorreo(correo);
        carrito.setIdProducto(id);
        carrito.setArticulo(articulo);
        carrito.setImg(img);
        carrito.setPrecio(precio);

        carritoModel.insertarCarrito(carrito);

        int id1 = Integer.parseInt(JsfUtils.getRequest().getParameter("id"));

        deseoModel.eliminarDeseo(id1);

        return "/deseo?faces-redirect=true";
    }

    public int contarCarrito() {

        int num = 0;
        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");

        listaCarritos = carritoModel.listarCarritos(correo);

        num = listaCarritos.size();

        return num;

    }
    
    //Comprar
      public String aComprar() {

        HttpServletRequest request = JsfUtils.getRequest();

        String correo = (String) request.getSession().getAttribute("user");
        String id = JsfUtils.getRequest().getParameter("producto");
        String articulo = JsfUtils.getRequest().getParameter("nombre");
        String img = JsfUtils.getRequest().getParameter("img");

        double precio = Double.parseDouble(JsfUtils.getRequest().getParameter("precio"));

        carrito.setCorreo(correo);
        carrito.setIdProducto(id);
        carrito.setArticulo(articulo);
        carrito.setImg(img);
        carrito.setPrecio(precio);

        carritoModel.insertarCarrito(carrito);

        int id1 = Integer.parseInt(JsfUtils.getRequest().getParameter("id"));

        deseoModel.eliminarDeseo(id1);

        return "/comprar?faces-redirect=true";
    }
    

}
