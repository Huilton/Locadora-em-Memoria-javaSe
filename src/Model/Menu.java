/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author faculdade.ads
 */
public class Menu {

    static Scanner teclado = new Scanner(System.in);
    static Locadora locadora = new Locadora();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        while (true) {

            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Locadora"
                    + "\n1 - Cadastrar Acervo"
                    + "\n2 - Excluir Cadastro"
                    + "\n3 - Visualizar estoque"
                    + "\n4 - Alugar"
                    + "\n5 - Devolver"
                    + "\n0 - Sair"));

            switch (opcao) {
                case 0:
                    int aux;
                    aux = JOptionPane.showConfirmDialog(null, " Deseja Sair Do Software",
                            "Informativo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (JOptionPane.YES_OPTION == aux) {
                        JOptionPane.showMessageDialog(null, " Volte Sempre!! ", " Aviso!! ", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(aux);
                    } else {
                        aux = 7;
                    }
                    break;
                case 1:
                    try {
                        cadastrar();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "!! Erro Caracter Invalido !!\n" + nfe);
                    }
                    break;
                case 2:
                    try {
                        excluirCadastro();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "!! Erro Caracter Invalido !!\n" + nfe);
                    }

                    break;
                case 3:
                    try {
                        visualizarEstoque();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "!! Erro Caracter Invalido !!\n" + nfe);
                    }
                    break;
                case 4:
                    try {
                        alugar();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "!! Erro Caracter Invalido !!\n" + nfe);
                    }
                    break;
                case 5:
                    try {
                        devolver();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "!! Erro Caracter Invalido !!\n" + nfe);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha uma opção entre 0 e 5", "  INFORMATIVO  ", JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }

    private static void cadastrar() {
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Escolha "
                + "\n1 - Filmes:"
                + "\n2 - Games:"));
        String titulo = JOptionPane.showInputDialog("Digite o nome do titulo: ");
        String classificacao = JOptionPane.showInputDialog("Digite a classificação: ");

        if (tipo == 1) {
            String sinopse = JOptionPane.showInputDialog("Sinopse do filme: ");
            boolean cadastrar = locadora.cadastrarFilme(titulo, classificacao, tipo, sinopse);
            if (cadastrar == true) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, " Cadastro não efetuado ", "!!ERRO !!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String plataforma = JOptionPane.showInputDialog("Plataforma do jogo: ");
            boolean cadastrar = locadora.cadastrarDvd(titulo, classificacao, tipo, plataforma);
            if (cadastrar == true) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, " Cadastro não efetuado ", "!!ERRO !!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private static void visualizarEstoque() {
        boolean visualizarEstoque = locadora.visualizarEstoque();
        if (visualizarEstoque == true) {
            for (int i = 0; i < Dados.estoque.length; i++) {
                if (Dados.estoque[i] != null) {
                    JOptionPane.showMessageDialog(null, "\nCodigo: " + Dados.estoque[i].codigo
                            + "\nNome do filme: " + Dados.estoque[i].titulo
                            + "\nclassificação: " + Dados.estoque[i].classificacao + "\n");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Estoque vazio!");
        }
    }

    private static void excluirCadastro() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe O codigo a ser excluido"));
        boolean excluirCadastro = locadora.excluirCadastro(codigo);
        if (excluirCadastro == true) {
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, " Não possuimos este codigo ", "!!ERRO !!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void alugar() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo do Acervo"));
        boolean alugar = locadora.alugar(codigo);
        if (alugar == true) {
            JOptionPane.showMessageDialog(null, "Acervo locado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Acervo já esta alugado ", "!!ALERTA !!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void devolver() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo do Acervo"));
        boolean devolver = locadora.devolver(codigo);
        if (devolver == true) {
            JOptionPane.showMessageDialog(null, "Acervo Devolvido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Este acervo nao esta Locado \n         Verifique o codigo!! ", "!!INFORMATIVO !!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
