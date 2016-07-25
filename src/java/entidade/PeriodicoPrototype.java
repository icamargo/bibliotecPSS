package entidade;
//@author igor_

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "Periodico")
public class PeriodicoPrototype extends ItemPrototype{
    private int issn;
    private String tipo;
    
    public PeriodicoPrototype(){
    }
    public PeriodicoPrototype(PeriodicoPrototype periodicoPrototype){
        this.issn = periodicoPrototype.getIssn();
        this.tipo = periodicoPrototype.getTipo();
    }
    public PeriodicoPrototype(int issn, String tipo, int numeroCatalogo, String nome, String status, int edicao, String autor, String editora, int volume, int anoPublicacao, int numPaginas, String origem, float valorMultaDiaAtraso) {
        super(numeroCatalogo, nome, status, edicao, autor, editora, volume, anoPublicacao, numPaginas, origem, valorMultaDiaAtraso);
        this.issn = issn;
        this.tipo = tipo;
    }
    
    @Override
    public PeriodicoPrototype clonar(){
        return new PeriodicoPrototype(this);
    }
    public int getIssn() {
        return issn;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
