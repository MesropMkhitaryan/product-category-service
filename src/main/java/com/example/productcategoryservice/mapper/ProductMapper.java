package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.productDto.CreateProduct;
import com.example.productcategoryservice.dto.productDto.ProductResponseDto;
import com.example.productcategoryservice.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product map(CreateProduct createProduct);

    ProductResponseDto map(Product product);

    List<ProductResponseDto> map(List<Product> productList);
}
