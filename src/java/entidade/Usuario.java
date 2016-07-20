/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Igor
 */
//feito por igor
@Entity
@DiscriminatorValue(value = "user")
public class Usuario extends Pessoa{
    
    private String situaçao = "normal";
    private int tipo = 1;

    public Usuario() {
    }

    public Usuario(String situaçao, long id, String nome, String cpf, String rg, String sexo, String endereço, String dtNasc, String email, String telefone, String senha, int tipo) {
        super(id, nome, cpf, rg, sexo, endereço, dtNasc, email, telefone, senha);
        this.situaçao = situaçao;
        this.tipo = tipo;
    }

    public String getSituaçao() {
        return situaçao;
    }

    public void setSituaçao(String situaçao) {
        this.situaçao = situaçao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
