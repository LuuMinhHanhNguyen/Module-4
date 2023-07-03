package com.example.blog1.controller;


import com.example.blog1.model.Blog;
import com.example.blog1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")

public class BlogController {
    @Autowired
    private IBlogService iBlogService;


    @GetMapping ("/list")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/home");
         modelAndView.addObject("blogs", iBlogService.findAll());
        return modelAndView;
    }

    @GetMapping()
    public ResponseEntity<List<Blog>> getAllBlogs(){
        return new ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createNewBlog(@RequestBody Blog newBlog) {
        iBlogService.save(newBlog);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showProductDetails(@PathVariable Integer id) {
        if (iBlogService.checkIDExistence(id)) {
            return new ResponseEntity<>(iBlogService.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        if (!iBlogService.checkIDExistence(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iBlogService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateProduct(@RequestBody Blog blog) {
        if (!iBlogService.checkIDExistence(blog.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iBlogService.save(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping ("/search/{title}")
    public ResponseEntity<?> searchByName(@PathVariable String title) {
        return new ResponseEntity<>(iBlogService.searchByTitle(title), HttpStatus.OK);
    }

    @RequestMapping ("/page/{pageNum}")
    public ResponseEntity<?> loadMoreBlogs(@PathVariable Integer pageNum){
        return new ResponseEntity<>(iBlogService.getBlogsByPageNum(pageNum), HttpStatus.OK);
    }

}
