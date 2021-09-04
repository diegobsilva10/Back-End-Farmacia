package org.generation.farmacia.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "produto")
public class ProdutoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;

    @NotBlank(message = "Nome do produto")
    @Size (min = 10, max = 200)
    private String nomeProduto;

    @NotBlank(message = "Insira a descrição do produto")
    @Size (min=10, max = 200)
    private String descricaoProduto;

    @NotNull(message = "Informe o preço")
    private float preco;

    @ManyToOne
    @JsonIgnoreProperties
    private CategoriaModels categoriaModels;


    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public CategoriaModels getCategoriaModels() {
        return categoriaModels;
    }

    public void setCategoriaModels(CategoriaModels categoriaModels) {
        this.categoriaModels = categoriaModels;
    }
}
