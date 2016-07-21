package entidade;
//@author igor_

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "livro")
public class LivroPrototype extends ItemPrototype{
    private int isbn;
    
    public LivroPrototype(){
    }
    public LivroPrototype(LivroPrototype livroPrototype){
        this.isbn = livroPrototype.getIsbn();
    }

    public LivroPrototype(int isbn) {
        this.isbn = isbn;
    }

    public LivroPrototype(int isbn, int numeroCatalogo, String nome, String status, int edicao, String autor, String editora, int volume, int anoPublicacao, int numPaginas, String origem, float valorMultaDiaAtraso) {
        super(numeroCatalogo, nome, status, edicao, autor, editora, volume, anoPublicacao, numPaginas, origem, valorMultaDiaAtraso);
        this.isbn = isbn;
    }
    @Override
    public ItemPrototype clonar(){
        return new LivroPrototype (this);
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
}
