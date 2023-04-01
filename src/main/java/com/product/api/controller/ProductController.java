package com.product.api.controller;

import com.product.api.model.Product;
import com.product.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping("/test")
    public String test(){
        return "API is working";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product save(@RequestBody Product product){
        Product created = this.service.save(product);
        return created;
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return this.service.getAllProducts();
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") int productId, @RequestBody Product product){
        Optional<Product> productOptional = this.service.getProductById(productId);
        Product productToUpdate = productOptional.get();
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        return productToUpdate;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId){
        this.service.deleteByProductId(productId);
        return "Product id = " + productId + " is deleted";
    }


}
