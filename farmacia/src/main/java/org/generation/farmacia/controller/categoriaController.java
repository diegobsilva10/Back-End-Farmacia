package org.generation.farmacia.controller;


import org.generation.farmacia.models.CategoriaModels;
import org.generation.farmacia.repositoy.categoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class categoriaController {

    @Autowired
    private categoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<CategoriaModels>> GeAll(){
        return ResponseEntity.ok(repository.findAll());
    }


}
