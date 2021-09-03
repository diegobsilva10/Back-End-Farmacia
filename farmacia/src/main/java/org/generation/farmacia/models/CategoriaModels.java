package org.generation.farmacia.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Classe utilizada como entidade no banco de dados para a criação das categorias.
 *
 * @author Diego Silva
 * @since 1.0
 *
 */


@Entity
@Table(name="produtos")
public class CategoriaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;

    @NotBlank(message = "Descrição da Categoria")
    @Size (min = 5, max = 100)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)

    private Date date = new java.sql.Date(System.currentTimeMillis());

    public CategoriaModels(long idCategoria, String descricao, Date date) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
        this.date = date;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setId(long id) {
        this.idCategoria = id;
    }

    public String getDecricacao() {
        return descricao;
    }

    public void setDecricacao(String decricacao) {
        this.descricao = descricao;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
