/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outros;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */

@Entity
@Table(name = "obra")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value = "O")
public abstract class Obra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numCatalogo;
    private String status = "Disponivel";
    private String nome;
    private int ediçao;
    private String autor;
    private String editora;
    private int volume;
    private int anoPublicaçao;
    private int numPaginas;
    private String origem;
    private float valorMulta;
    
    public Obra(){    
    }
    
    /*public Obra(long numCatalogo, String status, String nome, int ediçao, String autor, String editora, int volume, int anoPublicaçao, int numPaginas, String origem, float valorMulta) {
        super();
        this.numCatalogo = numCatalogo;
        this.status = status;
        this.nome = nome;
        this.ediçao = ediçao;
        this.autor = autor;
        this.editora = editora;
        this.volume = volume;
        this.anoPublicaçao = anoPublicaçao;
        this.numPaginas = numPaginas;
        this.origem = origem;
        this.valorMulta = valorMulta;
    }*/

    public long getNumCatalogo() {
        return numCatalogo;
    }

    public void setNumCatalogo(long numCatalogo) {
        this.numCatalogo = numCatalogo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEdiçao() {
        return ediçao;
    }

    public void setEdiçao(int ediçao) {
        this.ediçao = ediçao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAnoPublicaçao() {
        return anoPublicaçao;
    }

    public void setAnoPublicaçao(int anoPublicaçao) {
        this.anoPublicaçao = anoPublicaçao;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public float getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (this.numCatalogo ^ (this.numCatalogo >>> 32));
        hash = 37 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Obra other = (Obra) obj;
        return this.numCatalogo == other.numCatalogo;
    }

}
