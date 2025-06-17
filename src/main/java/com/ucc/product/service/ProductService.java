package com.ucc.product.service;

import com.ucc.product.model.Product;
import com.ucc.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //metodo que obtenga todos los products guardados
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //Metodo que crea un producto

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID" + id));
    }

    public void updateProduct(Long id, Product updatedProduct){
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setDescription(updatedProduct.getDescription());
        existing.setStock(updatedProduct.getStock());
        existing.setStatus(updatedProduct.getStatus());
        productRepository.save(existing);
    }

    // Eliminar un producto
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
