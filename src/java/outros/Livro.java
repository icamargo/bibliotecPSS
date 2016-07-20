/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outros;

import outros.Obra;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Pedro
 */
@Entity
@DiscriminatorValue(value = "L")
public class Livro extends Obra{
    
    private int isbn;
    
    public Livro(){
        
    }
    
    /*public Livro(int isbn, long numCatalogo, String status, String nome, int ediçao, String autor, String editora, int volume, int anoPublicaçao, int numPaginas, String origem, float valorMulta) {
        super(numCatalogo, status, nome, ediçao, autor, editora, volume, anoPublicaçao, numPaginas, origem, valorMulta);
        this.isbn = isbn;
    }*/
    
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

}
