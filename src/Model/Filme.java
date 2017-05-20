/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author faculdade.ads
 */
public class Filme extends Dados {

    String sinopse;

    Filme(String titulo, String classificacao, int tipo, String sinopse) {
        super(titulo, classificacao, tipo, "Filme");
        this.sinopse = sinopse;
    }

}
