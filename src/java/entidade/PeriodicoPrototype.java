package entidade;
//@author igor_

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "Periodico")
public class PeriodicoPrototype extends ItemPrototype{
    private String issn;
    private String tipoPeriodico;
    
    public PeriodicoPrototype(){
    }
    public PeriodicoPrototype(PeriodicoPrototype periodicoPrototype){
        this.issn = periodicoPrototype.getIssn();
        this.tipoPeriodico = periodicoPrototype.getTipoPeriodico();
    }
    public PeriodicoPrototype(String issn, String tipo, int numeroCatalogo, String nome, String status, int edicao, String autor, String editora, int volume, int anoPublicacao, int numPaginas, String origem, String tipoItem, float valorMultaDiaAtraso) {
        super(numeroCatalogo, nome, status, edicao, autor, editora, volume, anoPublicacao, numPaginas, origem, tipoItem, valorMultaDiaAtraso);
        this.issn = issn;
        this.tipoPeriodico = tipo;
    }
    
    @Override
    public PeriodicoPrototype clonar(){
        return new PeriodicoPrototype(this);
    }
    public String getIssn() {
        return issn;
    }

    public String getTipoPeriodico() {
        return tipoPeriodico;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setTipoPeriodico(String tipoPeriodico) {
        this.tipoPeriodico = tipoPeriodico;
    }
}
