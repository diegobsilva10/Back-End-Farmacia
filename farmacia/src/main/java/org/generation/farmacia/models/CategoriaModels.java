package org.generation.farmacia.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Classe utilizada como entidade no banco de dados para a criação das categorias.
 *
 * @author Diego Silva
 * @since 1.0
 *
 */


@Entity
@Table(name="categoria")
public class CategoriaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;


    @NotBlank(message = "Nome da Categoria")
    @Size (min = 5, max = 800)
    private String nomeCategoria;

    @NotBlank(message = "Descrição da Categoria")
    @Size (min = 5, max = 800)
    private String descricao;

    @OneToMany(mappedBy = "nomeProduto", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("produto")
    private List<ProdutoModels> ProdutoModels;


    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ProdutoModels> getProdutoModels() {
        return ProdutoModels;
    }

    public void setProdutoModels(List<ProdutoModels> ProdutoModels) {
        this.ProdutoModels = ProdutoModels;
    }
}

