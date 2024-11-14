package gm.inventarios.controlador;


import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.ProductoServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//le podemos poner nombre a la aplicacion se le conoce como un context path :inventigen
// ejemplo  http://localhsot:8080/inventario-app
@RequestMapping("inventario-app") // esto es un context path
@CrossOrigin(value = "http://localhost:4200")  // esta es la direccion ip para recibir las peticiones
//de angular a los servicios spring
// el spring usara el puerto 8080 y angular 4200

public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
        // utilizar el logger del paquete slf4j
        // tambien llamaos el LoggerFatoria tabien slf4j
    // le asignamos el metodo getloger que llama la clase producto controlador
    //que estara enviado informaicon al logger
    // cuando mandamos infomacion a la consola se va a especificar que apartir de esta clase
    //vamos a utlizar esta variable para mandar informacion a la consola en este caso se manda al login de la aplicacion


    //PETICIONES
    //PARA LISTAR  SE USA GET
    //PARA


    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")  //peticion para tener todos los obejctos de tipo producto
    // la url praa usar el postman seria http://localhost:8080/invenatario-app/productos
    public List<Producto> obtenerProductos() {
        List<Producto>productos = this.productoServicio.listarProductos();
        logger.info("productos obtenidos con exito");
        productos.forEach((producto -> logger.info(producto.toString()))); // se manda a imprimir cada uno de los objecto
        return productos;
    }





}