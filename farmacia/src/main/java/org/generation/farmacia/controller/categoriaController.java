package org.generation.farmacia.controller;


import org.generation.farmacia.models.CategoriaModels;
import org.generation.farmacia.repositoy.categoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class categoriaController {

    @Autowired
    private categoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<CategoriaModels>> GetAll()   {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModels> GetById(@PathVariable long idCategoria){
        return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound()
                .build());
    }
    @GetMapping("/nomeCategoria/{nomeCategoria}")
    public ResponseEntity<List<CategoriaModels>> GetBynomeCategoria(@PathVariable String nomeCategoria){
        return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
    }

    @PostMapping
    public ResponseEntity<CategoriaModels> post (@RequestBody CategoriaModels categoriaModels) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoriaModels));
    }
    @PutMapping
    public ResponseEntity<CategoriaModels> put (@RequestBody CategoriaModels categoriaModels) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoriaModels));
    }
    @DeleteMapping ("/{id}")
    public void delete (@PathVariable long id){
        repository.deleteById(id);
    }






}
