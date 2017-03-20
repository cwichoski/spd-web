package les.main;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import les.controle.Controle;
import les.dao.IDAO;
import les.dao.impl.FuncionarioDAO;
import les.dominio.EntidadeDominio;

public class ViewConsole {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String args[]) throws IOException{
		int opt = 0;
                boolean x = true;
		String[] parans = new String[10];
		Controle ctrl = new Controle();
		while (x){
                    do {
                            opt = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Funcionario\n"
                            + "Escolha uma das opções seguintes:\n"
                            + "1 - Novo Funcionario\n"
                            + "2 - Excluir Funcionario\n"
                            + "3 - Listar Funcionario\n"
                            + "4 - Alterar Funcionario\n"
                            + "5 - Sair\nEscolha uma opção:"));

                    } while (opt > 6 || opt < 0);
		
                    switch (opt) {
                            // Novo
                            case 1:
                                    Scanner sc = new Scanner(System.in);

                                    parans[0] = JOptionPane.showInputDialog("Nome: ");
                                    parans[1] = JOptionPane.showInputDialog("CPF: ");
                                    parans[2] = JOptionPane.showInputDialog("Data de Nascimento: (DD/MM/AAAA)");
                                    parans[3] = JOptionPane.showInputDialog("Rua: ");
                                    parans[4] = JOptionPane.showInputDialog("CEP: ");
                                    parans[5] = JOptionPane.showInputDialog("Cidade: ");



                                    ctrl.processar(parans, "SALVAR");
                                    opt = 0;
                                    break;
                            // Excluir 
                            case 2:
                                parans[1] = JOptionPane.showInputDialog("Excluir Funcionarios\n"
                                + "Insira o CPF:\n");
                                ctrl.processar(parans, "EXCLUIR");
                                opt= 0;
                                break;

                            // Consultar
                            case 3:
                                do {
                                    opt = Integer.parseInt(JOptionPane.showInputDialog("Listagem de Funcionarios\n"
                                    + "Escolha uma das opções seguintes:\n"
                                    + "1 - Listagem Simples\n"
                                    + "2 - Listagem por ID\n"
                                    + "3 - Sair\nEscolha uma opção:"));

                                }while (opt > 4 || opt < 0);
                                switch (opt){
                                        case 1:// Consulta Simples
                                            parans[0] = null;
                                            ctrl.processar(parans, "CONSULTAR");
                                            opt= 0;
                                            break;

                                        case 2:// Consulta esipicifica
                                            parans[0] = JOptionPane.showInputDialog("Insira o ID: ");
                                            ctrl.processar(parans, "CONSULTAR");
                                            opt= 0;
                                            break;
                                }
                                break;
                            // Alterar
                            case 4:
                                // Lista todos para selecionar 1
                                
                                parans[9] = JOptionPane.showInputDialog("Alterar Funcionarios\n"
                                + "Insira o id:\n");
                                parans[0] = parans[9];
                                ctrl.processar(parans, "CONSULTAR");


                                parans[0] = JOptionPane.showInputDialog("Nome: ");
                                parans[1] = JOptionPane.showInputDialog("CPF: ");
                                parans[2] = JOptionPane.showInputDialog("Data de Nascimento: (DD/MM/AAAA)");
                                parans[3] = JOptionPane.showInputDialog("Rua: ");
                                parans[4] = JOptionPane.showInputDialog("CEP: ");
                                parans[5] = JOptionPane.showInputDialog("Cidade: ");
                                ctrl.processar(parans, "ALTERAR");
                                
                                break;
                            case 5:
                                x = false;
                                break;
                                
                    }
                }
		
				
	}

}
