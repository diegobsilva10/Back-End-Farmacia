package org.generation.farmacia.controller;


import org.generation.farmacia.repositoy.categoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class categoriaController {

    @Autowired
    private categoriaRepository repository;



}
