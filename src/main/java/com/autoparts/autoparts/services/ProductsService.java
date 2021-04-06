// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.services;
import java.util.List;
import java.util.Optional;
import com.autoparts.autoparts.classes.Products;
import com.autoparts.autoparts.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    

    // get all products
    public List<Products> getAllProducts(){
        return (List<Products>) productsRepository.findAll();
    }

    // get one product
    public Products getOneProduct(Long productId){
        return productsRepository.findById(productId).get();
    }

    // add a product
    public void addProduct(Products products){
        productsRepository.save(products);
    }
    // update a product - updates the count - sell
    // .orElseThrow(()-> new IllegalStateException("ID doesn't exist"));

    // public Products updateProduct(Long productId){
    //     //
    // }

    // update product details
    public Optional<Products> updateProduct(Long productId){
        return productsRepository.findById(productId);
    }
    
    // delete a product
    public void delProduct(Long productId){
        boolean exists = productsRepository.existsById(productId);
        if (exists){
            productsRepository.deleteById(productId);
        }
        else {
            throw new IllegalStateException("ID doesn't exist"); 
        }
    }

    public void saveP(){
        Products products = new Products("name", 4335, 6, "sdfsdfsdfsd");
        // Products products2 = new Products();
        // products.setCount(3);
        // products.setName("Engine");
        // products.setPrice(2131);
        productsRepository.save(products);
        // productsRepository.save(products2);

    }

    

}
