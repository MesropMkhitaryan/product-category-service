package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.categoryDto.CategoryResponseDto;
import com.example.productcategoryservice.dto.categoryDto.CreateCategory;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")

public class CategoryEndpoint {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("")
    public List<CategoryResponseDto> getAllCategories() {
        return categoryMapper.map(categoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id).get());
    }

    @PostMapping("")
    public ResponseEntity<?> saveCategory(@RequestBody CreateCategory createCategory) {
        Category savedCategory = categoryService.createCategory(categoryMapper.map(createCategory));
        return ResponseEntity.ok(savedCategory);
    }

    @PutMapping("")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        if (category.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        categoryService.createCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategoryById(@PathVariable("id") int id){
        categoryService.removeCategoriesById(id);
        return ResponseEntity.noContent().build();
    }

}
