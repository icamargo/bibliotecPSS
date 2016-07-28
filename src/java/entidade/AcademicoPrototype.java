package entidade;
//@author igor_

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "Academico")
public class AcademicoPrototype extends ItemPrototype{
    private String modalidade;
    
    public AcademicoPrototype(){
    }
    public AcademicoPrototype (AcademicoPrototype academicoPrototype){
        this.modalidade = academicoPrototype.getModalidade();
    }

    public AcademicoPrototype(String modalidade, int numeroCatalogo, String nome, String status, int edicao, String autor, String editora, int volume, int anoPublicacao, int numPaginas, String origem, String tipoItem, float valorMultaDiaAtraso) {
        super(numeroCatalogo, nome, status, edicao, autor, editora, volume, anoPublicacao, numPaginas, origem, tipoItem, valorMultaDiaAtraso);
        this.modalidade = modalidade;
    }
    @Override
    public ItemPrototype clonar(){
        return new AcademicoPrototype (this);
    }
    public String getModalidade() {
        return modalidade;
    }
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }    
}
