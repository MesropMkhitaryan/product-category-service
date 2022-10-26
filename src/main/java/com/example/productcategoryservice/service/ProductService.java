package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product){
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public void removeProducById(int id){
        productRepository.deleteById(id);
    }
    public List<Product> getProductsByCategory(int id){
       return productRepository.findByCategoryId(id);
    }


}
