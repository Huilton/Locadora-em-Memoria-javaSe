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
public class Locadora {

    boolean cadastrarFilme(String titulo, String classificacao, int tipo, String sinopse) {
        for (int i = 0; i < Dados.estoque.length; i++) {
            if (Dados.estoque[i] == null) {

                Dados.estoque[i] = new Filme(titulo, classificacao, tipo, sinopse);
                return true;
            }
        }
        return false;
    }

    boolean cadastrarDvd(String titulo, String classificacao, int tipo, String plataforma) {
        for (int i = 0; i < Dados.estoque.length; i++) {
            if (Dados.estoque[i] == null) {
                //dvd
                Dados.estoque[i] = new Games(titulo, classificacao, tipo, plataforma);
                return true;
            }
        }
        return false;
    }

    boolean visualizarEstoque() {
        for (int i = 0; i < Dados.estoque.length; i++) {
            if (Dados.estoque[i] != null) {
                return true;
            }
        }
        return false;
    }

    boolean excluirCadastro(int codigo) {
        for (int i = 0; i < Dados.estoque.length; i++) {
            if (Dados.estoque[i] != null && Dados.estoque[i].codigo == codigo) {
                Dados.estoque[i] = null;
                return true;
            }
        }
        return false;
    }

    boolean alugar(int codigo) {
        for (int i = 0; i < Dados.estoque.length; i++) {
            if (Dados.estoque[i] != null && Dados.estoque[i].codigo == codigo && Dados.estoque[i].acervoSistema == null) {
                Dados.estoque[i].acervoSistema = "Locado";
                return true;
            }
        }
        return false;
    }

    boolean devolver(int codigo) {
        for (int i = 0; i < Dados.estoque.length; i++) {
            if (Dados.estoque[i] != null && Dados.estoque[i].codigo == codigo && Dados.estoque[i].acervoSistema.equals("Locado")) {
                Dados.estoque[i].acervoSistema = null;
                return true;
            }
        }
        return false;
    }
}
