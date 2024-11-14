package gm.inventarios.servicio;

import gm.inventarios.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(int idProducto);

    public void guardarProducto(Producto producto);

    public void eliminarProductoPorId(int idProducto);

    public List<Producto>buscarProductoPorCategoria(int idCategoria);

}
