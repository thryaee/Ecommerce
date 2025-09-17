package com.nie.csd.services;

import com.nie.csd.exceptions.IdNotPresentException;
import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductsService {

    Logger logger = LoggerFactory.getLogger(ProductsService.class);

    @Autowired
    ProductRepository repository;

    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    public Products getByProductId(String id)throws IdNotPresentException {
        return repository.findById(id)
        .orElseThrow(()->new IdNotPresentException("Product not found"));
    }

    public Products addProduct(Products products) {
        return repository.save(products);
    }

    public Products updateProduct(String id, Products products) {
        Products existingproduct=repository.findById(id).get();
        if(existingproduct!=null){
          existingproduct.setName(products.getName());
          existingproduct.setDescription(products.getDescription());
          existingproduct.setCategory(products.getCategory());
          existingproduct.setTags(products.getTags());
          existingproduct.setPrice(products.getPrice());
          existingproduct.setStock(products.getStock());
          return repository.save(existingproduct);
        }
        return repository.save(products);
    }

    public void deleteProduct(String id) {
        Products existingproduct=repository.findById(id).get();
        if(existingproduct!=null){
            repository.delete(existingproduct);
            System.out.println("Product deleted successfully");
        }
        else{
            System.out.println("Product not found");
        }
    }
}