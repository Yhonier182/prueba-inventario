package gm.inventarios.servicio;

import gm.inventarios.modelo.Producto;
import gm.inventarios.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//definilar como capa de servicio
@Service
public class ProductoServicio implements IProductoServicio{
    //creamos un AutoWirred para inyectar propiedades
    @Autowired
    private ProductoRepositorio productoRepositorio;//inyectamos el obejeto de producto repositorio

    //de esta menera ya nos estamos comunicando con repositorio y a su vez
    // reposiotirio ya esta comunicando con los objectos de tipo ENTIDAD- modelo
    //ya contodoesto nos comunicamos con la base de datos.

    // ASI LAS PETICIONES DEL SERIVICIO PASA POR TODAS LAS CAPAS ANTERIORES
    //y la base de datos nos devuelve a servicios


    @Override
    public List<Producto> listarProductos() {
      return this.productoRepositorio.findAll();
       //este metodo retorna todos los objetos de tipo producto de la base de datos

    }

    @Override
    public Producto buscarProductoPorId(int idProducto) {
        Producto producto =
                this.productoRepositorio.findById(idProducto).orElse(null);//el orEsle es sino encuentra el producto que lo ponga null:
        //si se encuentra el registro regresa un obejeto de tipo producto
        //sino lo encuentra regresa el valor de null:
        return producto; // una vez se retorna al objecto producto que haya encontrado:
    }

    @Override
    public void guardarProducto(Producto producto) {
   this.productoRepositorio.save(producto);// save funciona de dos maneras
        // si el id ingresado  es igual a null  entonces se hace un Insert
        // si es diferente de null se hace un update
    }



    @Override
    public void eliminarProductoPorId(int idProducto) {
          this.productoRepositorio.deleteById(idProducto);
          // se usa el deletebyId para un solo id eliminado
        // si usas el deleteAllbyId elimina todos los registros de la base de datos
    }

    @Override
    public List<Producto> buscarProductoPorCategoria(int idPdroducto){
        this.buscarProductoPorId(idPdroducto);
        return null;
       
    }
}
