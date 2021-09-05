package org.generation.farmacia.repositoy;


import org.generation.farmacia.models.ProdutoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface produtoRepository extends JpaRepository<ProdutoModels, Long> {
    public List<ProdutoModels> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);


}
