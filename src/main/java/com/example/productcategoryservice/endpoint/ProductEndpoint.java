package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.productDto.CreateProduct;
import com.example.productcategoryservice.dto.productDto.ProductResponseDto;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")

public class ProductEndpoint {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("")
    public List<ProductResponseDto> getAllProducts() {
        return productMapper.map(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        return ResponseEntity.ok(productService.getProductById(id).get());
    }

    @PostMapping("")
    public ResponseEntity<?> saveProduct(@RequestBody CreateProduct createProduct) {
        Product savedProduct = productService.createProduct(productMapper.map(createProduct));
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") int id){
        productService.removeProducById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.getProductsByCategory(id));
    }

}
