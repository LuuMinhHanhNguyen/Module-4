package com.example.blog1.controller;

import com.example.blog1.model.Blog;
import com.example.blog1.model.Category;
import com.example.blog1.service.IBlogService;
import com.example.blog1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequestMapping("/categories")
@RestController
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/choice/{searchedCategoryId}")
    public ResponseEntity<List<Blog>> showByChoices(@PathVariable Integer searchedCategoryId) {
        if (iCategoryService.checkIDExistence(searchedCategoryId)) {
            return new ResponseEntity<>(iBlogService.findBlogsByCategory_IdAndFlagDeleteFalse(searchedCategoryId),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Category>> showAllCategories() {
        return new ResponseEntity<>(iCategoryService.findAllCategories(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createNewCategory(@RequestBody Category category) {
        iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        if (iCategoryService.checkIDExistence(id)) {
            iCategoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping()
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        if (!iCategoryService.checkIDExistence(category.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            iCategoryService.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
