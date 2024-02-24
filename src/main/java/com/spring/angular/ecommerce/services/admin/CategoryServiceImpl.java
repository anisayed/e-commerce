package com.spring.angular.ecommerce.services.admin;

import com.spring.angular.ecommerce.dto.CategoryDto;
import com.spring.angular.ecommerce.entities.Category;
import com.spring.angular.ecommerce.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryDto categoryDto) {
        Category category = Category
                .builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
