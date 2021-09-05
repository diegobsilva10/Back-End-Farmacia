package org.generation.farmacia.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.generation.farmacia.models.ProdutoModels;
import org.generation.farmacia.repositoy.produtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(value = "*")
@Api(value = "API REST FARMACIA")
public class produtoController {

    @Autowired
    private produtoRepository repository;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de produtos")
    public ResponseEntity<List<ProdutoModels>> GetAll()   {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna a busca por ID")
    public ResponseEntity<ProdutoModels> GetById(@PathVariable long idProduto){
        return repository.findById(idProduto).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound()
                .build());
    }
    @GetMapping("/nomeProduto/{nomeProduto}")
    @ApiOperation(value = "Retorna uma lista por nome do produto")
    public ResponseEntity<List<ProdutoModels>> GetBynomeProduto (@PathVariable String nomeProduto){
        return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
    }

    @PostMapping
    @ApiOperation(value = "Insere um produto no banco")
    public ResponseEntity<ProdutoModels> post (@RequestBody ProdutoModels produtoModels) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtoModels));
    }
    @PutMapping
    @ApiOperation(value = "Altera dados do produto no banco")
    public ResponseEntity<ProdutoModels> put (@RequestBody ProdutoModels ProdutoModels) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(ProdutoModels));
    }
    @DeleteMapping ("/{id}")
    @ApiOperation(value = "Deleta produto por id")
    public void delete (@PathVariable long id){
        repository.deleteById(id);
    }






}