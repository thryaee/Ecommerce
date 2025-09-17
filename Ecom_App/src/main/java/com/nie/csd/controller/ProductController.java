package com.nie.csd.controller;
import com.nie.csd.exceptions.IdNotPresentException;
import com.nie.csd.models.Products;
// import com.nie.csd.repositories.ProductRepository;
import com.nie.csd.services.ProductsService;
import java.util.List;
// for logger
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ProductController {

    Logger logger=Logger.getLogger(ProductController.class.getName());
    @Autowired
    ProductsService service;

    @GetMapping("/hello")
    public String sayhello(){
        return "hello";
    }

    @GetMapping("/demo")
    public String getProducts(){
        return "List of Products  from the products path";
    }

    // retriving all products
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts(){
        logger.info("Getting all products from the database of collection products msg from controller");
        List<Products> productsList=service.getAllProducts();
        return ResponseEntity.ok(productsList);
    }
    
    // retriving product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getByProductId(@PathVariable("id") String id)throws IdNotPresentException{
        logger.info("Getting product by id: "+id+" from the database of collection products msg from controller");
        Products products=service.getByProductId(id);
        return ResponseEntity.ok(products);
    
    }
    
    // adding new product
    @PostMapping("/products")
    public Products addProduct(@RequestBody Products products){
        logger.info("Adding new product to the database of collection products msg from controller");
        return service.addProduct(products);
    }

    // updating product by id
    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable("id") String id, @RequestBody Products products){
        logger.info("Updating product by id: "+id+" to the database of collection products msg from controller");
        return service.updateProduct(id,products);
        
    }

    // deleting product by id
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        logger.info("Deleting product by id: "+id+" from the database of collection products msg from controller");
    service.deleteProduct(id);
}

}