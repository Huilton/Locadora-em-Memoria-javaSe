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
public class Games extends Dados {

    String plataforma;

    Games(String titulo, String classificacao, int tipo, String plataforma) {
        super(titulo, classificacao, tipo, "Game");
        this.plataforma = plataforma;
    }

}
