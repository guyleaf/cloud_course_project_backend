package com.cloudproject.server.Service;

import com.cloudproject.server.Model.Category;
import com.cloudproject.server.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return this.categoryRepository.getAllCategories();
    }

    public boolean checkCategoryExists(String id) {
        return this.categoryRepository.existsCategoryById(id);
    }
}
