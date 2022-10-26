package com.example.productcategoryservice.dto.productDto;

import com.example.productcategoryservice.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProduct {
    private String title;
    private int count;
    private double price;
    private Category category;
}
