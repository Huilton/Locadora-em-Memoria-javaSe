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
public abstract class Dados {

    String titulo;
    String classificacao;
    int tipo;
    String modeloArquivo;
    static int codigoAux = 1;
    int codigo;
    String acervoSistema;
    static Dados estoque[] = new Dados[100];

    public Dados(String titulo, String classificacao, int tipo, String modeloArquivo) {
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.tipo = tipo;
        this.modeloArquivo = modeloArquivo;
        codigo = codigoAux;
        codigoAux++;
    }

}
