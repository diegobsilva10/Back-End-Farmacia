package org.generation.farmacia.repositoy;

import org.generation.farmacia.models.CategoriaModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface categoriaRepository extends JpaRepository<CategoriaModels, Long>{
    public List<CategoriaModels> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);


}