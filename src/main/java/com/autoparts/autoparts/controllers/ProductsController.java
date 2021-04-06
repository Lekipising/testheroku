// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.controllers;

import com.autoparts.autoparts.classes.Products;
import com.autoparts.autoparts.repository.ProductsRepository;
import com.autoparts.autoparts.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
// @RequestMapping(path = "/products")
// @SessionAttributes("products")
public class ProductsController  {

    @Autowired
    private ProductsService productsService;

    @Autowired
    ProductsRepository productsRepository;

    // GET - all products- view all - products page
    @GetMapping("/allproducts")
    public String getAllProducts(Model model){
        model.addAttribute("products", productsService.getAllProducts());
        return "allproducts";
    }

    // pass product to form 
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String contactForm() {
        return "admin";
    }

    // add a product - using a form - admin
    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public String saveProductSubmission(@ModelAttribute Products products, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){
            return "error";
        }
        productsService.addProduct(products);

        return "success";
    }


    // DELETE - delete a product
    @DeleteMapping("{allproducts/productId}")
    public void delProduct(@PathVariable("productId") Long productId){
        productsService.delProduct(productId);
    }

}
