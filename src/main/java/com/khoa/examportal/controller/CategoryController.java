package com.khoa.examportal.controller;

import com.khoa.examportal.model.exam.Category;
import com.khoa.examportal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //add new category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category caregory) {
        Category categoryAdd = this.categoryService.addCategory(caregory);
        return ResponseEntity.ok(categoryAdd);
    }

    //get category by id
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long id) {
        return this.categoryService.getCategory(id);
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //update category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping("{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long id) {
        this.categoryService.deleteCategory(id);
    }

}
