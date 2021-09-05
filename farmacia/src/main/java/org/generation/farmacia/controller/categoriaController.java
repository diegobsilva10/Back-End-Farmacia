package org.generation.farmacia.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "API REST FARMACIA")
public class categoriaController {

    @Autowired
    private categoriaRepository repository;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de produtos")
    public ResponseEntity<List<CategoriaModels>> GetAll()   {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna a busca por ID")
    public ResponseEntity<CategoriaModels> GetById(@PathVariable long idCategoria){
        return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound()
                .build());
    }
    @GetMapping("/nomeCategoria/{nomeCategoria}")
    @ApiOperation(value = "Retorna uma lista por nome da categoria")
    public ResponseEntity<List<CategoriaModels>> GetBynomeCategoria(@PathVariable String nomeCategoria){
        return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
    }

    @PostMapping
    @ApiOperation(value = "Insere uma nova categoria no banco")
    public ResponseEntity<CategoriaModels> post (@RequestBody CategoriaModels categoriaModels) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoriaModels));
    }
    @PutMapping
    @ApiOperation(value = "Altera dados da categoria no banco")
    public ResponseEntity<CategoriaModels> put (@RequestBody CategoriaModels categoriaModels) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoriaModels));
    }
    @DeleteMapping ("/{id}")
    @ApiOperation(value = "Deleta categoria por id")
    public void delete (@PathVariable long id){
        repository.deleteById(id);
    }






}
