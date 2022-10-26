package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.categoryDto.CategoryResponseDto;
import com.example.productcategoryservice.dto.categoryDto.CreateCategory;
import com.example.productcategoryservice.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CreateCategory createCategory);

    CategoryResponseDto map(Category category);

    List<CategoryResponseDto> map(List<Category> categoryList);
}
