package entidade;
//@author igor_

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "Livro")
public class LivroPrototype extends ItemPrototype{
    private String isbn;
    
    public LivroPrototype(){
    }
    public LivroPrototype(LivroPrototype livroPrototype){
        this.isbn = livroPrototype.getIsbn();
    }

    public LivroPrototype(String isbn, int numeroCatalogo, String nome, String status, int edicao, String autor, String editora, int volume, int anoPublicacao, int numPaginas, String origem, String tipoItem, float valorMultaDiaAtraso) {
        super(numeroCatalogo, nome, status, edicao, autor, editora, volume, anoPublicacao, numPaginas, origem, tipoItem, valorMultaDiaAtraso);
        this.isbn = isbn;
    }
    @Override
    public ItemPrototype clonar(){
        return new LivroPrototype (this);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
}
