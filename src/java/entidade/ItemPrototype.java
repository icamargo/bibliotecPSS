package entidade;
//@author igor_

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorColumn (name = "tipoItem")
@Table (name = "Item")
public abstract class ItemPrototype implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    protected int numeroCatalogo;
    private boolean ativo;
    protected String nome;
    protected String status;
    protected int edicao;
    protected String autor;
    protected String editora;
    protected int volume;
    protected int anoPublicacao;
    protected int numPaginas;
    protected String origem;
    @Column(insertable=false, updatable=false)
    protected String tipoItem;
    protected float valorMultaDiaAtraso;
    
    public ItemPrototype(){
    }

    public ItemPrototype(int numeroCatalogo, String nome, String status, int edicao, String autor, String editora, int volume, int anoPublicacao, int numPaginas, String origem, String tipoItem, float valorMultaDiaAtraso) {
        this.numeroCatalogo = numeroCatalogo;
        this.nome = nome;
        this.status = status;
        this.edicao = edicao;
        this.autor = autor;
        this.editora = editora;
        this.volume = volume;
        this.anoPublicacao = anoPublicacao;
        this.numPaginas = numPaginas;
        this.origem = origem;
        this.tipoItem = tipoItem;
        this.valorMultaDiaAtraso = valorMultaDiaAtraso;
    }
    public abstract ItemPrototype clonar();

    public int getNumeroCatalogo() {
        return numeroCatalogo;
    }

    public void setNumeroCatalogo(int numeroCatalogo) {
        this.numeroCatalogo = numeroCatalogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
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

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
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

    public float getValorMultaDiaAtraso() {
        return valorMultaDiaAtraso;
    }

    public void setValorMultaDiaAtraso(float valorMultaDiaAtraso) {
        this.valorMultaDiaAtraso = valorMultaDiaAtraso;
    }
    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.numeroCatalogo;
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + this.edicao;
        hash = 61 * hash + Objects.hashCode(this.autor);
        hash = 61 * hash + Objects.hashCode(this.editora);
        hash = 61 * hash + this.volume;
        hash = 61 * hash + this.anoPublicacao;
        hash = 61 * hash + this.numPaginas;
        hash = 61 * hash + Objects.hashCode(this.origem);
        hash = 61 * hash + Float.floatToIntBits(this.valorMultaDiaAtraso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPrototype other = (ItemPrototype) obj;
        if (this.numeroCatalogo != other.numeroCatalogo) {
            return false;
        }
        if (this.edicao != other.edicao) {
            return false;
        }
        if (this.volume != other.volume) {
            return false;
        }
        if (this.anoPublicacao != other.anoPublicacao) {
            return false;
        }
        if (this.numPaginas != other.numPaginas) {
            return false;
        }
        if (Float.floatToIntBits(this.valorMultaDiaAtraso) != Float.floatToIntBits(other.valorMultaDiaAtraso)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        return true;
    }
}
