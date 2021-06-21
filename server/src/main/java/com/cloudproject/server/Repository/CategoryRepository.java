package com.cloudproject.server.Repository;

import com.cloudproject.server.Model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    @Query(value = "{}", sort = "{'id': 1}")
    List<Category> getAllCategories();

    boolean existsCategoryById(String id);
}
