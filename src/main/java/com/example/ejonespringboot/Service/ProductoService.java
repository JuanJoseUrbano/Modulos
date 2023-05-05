package com.example.ejonespringboot.Service;

import com.example.ejonespringboot.Model.Producto;
import com.example.ejonespringboot.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepo;

    public Producto crearProducto(Producto producto){

        return productoRepo.save(producto);
    }

    public void borrarProducto(Long id){

        productoRepo.deleteById(id);
    }

    public List<Producto> listarProductos(){

        return productoRepo.findAll();
    }

    public Producto buscarProductoId(Long id){

        return productoRepo.findById(id).orElse(null);
    }

    public void modificarProducto(Producto producto) {
        // Se busca la persona en la base de datos por su ID
        Optional<Producto> productoEncontrado =
                productoRepo.findById(producto.getId());

        if(productoEncontrado.isPresent()) {
            // Si se encontró el producto, se actualizan sus datos
            Producto productoActualizado = productoEncontrado.get();
            productoActualizado.setName(producto.getName());
            productoActualizado.setMarca(producto.getMarca());
            productoActualizado.setCosto(producto.getCosto());
            productoActualizado.setCant(producto.getCant());
            productoRepo.save(productoActualizado);
        } else {
            // Si no se encontró el producto, se puede lanzar una excepción o manejar el error de otra forma
            throw new NoSuchElementException("No se encontró el producto con ID " + producto.getId());
        }
    }

}
