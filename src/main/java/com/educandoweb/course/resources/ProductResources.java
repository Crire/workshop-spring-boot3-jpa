package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        //Para o spring aceitar o parametro id e considera-lo como parametro
        //na Url, usamos o @PathVariable, que faz com que o id seja aceito
        // como valor do getMapping
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
