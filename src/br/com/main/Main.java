package br.com.main;

import java.util.Scanner;
import br.com.arvore.avl.AVL_BinaryTree;
import br.com.arvore.normal.Nomal_BinaryTree;
import br.com.inserirTxt.InserirPorTxt;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String ArquivoEscolhido;

	public static void main(String[] args) {
		AVL_BinaryTree avlTree = new AVL_BinaryTree();
		Nomal_BinaryTree normalTree = new Nomal_BinaryTree();
		InserirPorTxt insertPorTxt = new InserirPorTxt();

		int escolhaMenu = 0;
		int escolhaTarefas = 0;

		do {
			System.out.print("1: Trabalhar com Árvore Binária Normal\n2: Trabalhar com Árvore Binária AVL\nEscolha: ");
			escolhaMenu = scanner.nextInt();

			if (escolhaMenu == 1 || escolhaMenu == 2) {
				do {
					System.out.print(
							"1: Inserir um valor\n2: Remover um valor\n3: Buscar por um valor\n4: Inserir valores de arquivo de texto\n5: Voltar\nEscolha: ");
					escolhaTarefas = scanner.nextInt();

					if (escolhaTarefas == 1) {
						System.out.print("Digite o valor a ser inserido: ");
						int valor = scanner.nextInt();
						if (escolhaMenu == 1) {
							normalTree.inserir(valor);
						} else {
							avlTree.inserir(valor);
						}
					} else if (escolhaTarefas == 2) {
						System.out.print("Digite o valor a ser removido: ");
						int valor = scanner.nextInt();
						if (escolhaMenu == 1) {
							normalTree.remover(valor);
						} else {
							avlTree.remover(valor);
						}
					} else if (escolhaTarefas == 3) {
						System.out.print("Digite o valor a ser buscado: ");
						int valor = scanner.nextInt();
						if (escolhaMenu == 1) {
							normalTree.buscar(valor);
						} else {
							avlTree.buscar(valor);
						}
					} else if (escolhaTarefas == 4) {
						inserirNumerosPorMeioDeArquivo();
						if (escolhaMenu == 1) {
							insertPorTxt.InserirPorArquivoTxt(ArquivoEscolhido, 1);
						} else {
							insertPorTxt.InserirPorArquivoTxt(ArquivoEscolhido, 2);
						}
					} else if (escolhaTarefas != 5) {
						System.out.println("Escolha Inválida");
					}

				} while (escolhaTarefas != 5);
			} else if (escolhaMenu != 3) {
				System.out.println("Escolha Inválida");
			}
		} while (escolhaMenu != 3);
		scanner.close();
	}

	private static void inserirNumerosPorMeioDeArquivo() {
		int escolhaDeTamanhoDeArquivoTXT;
		do {
			System.out.println("1: Utilizar arquivo de 100 numeros\n2: Utilizar arquivo de 500 numeros\n"
					+ "3: Utilizar arquivo de 1000 numeros\n4: Utilizar arquivo de 10000 numeros\n"
					+ "5: Utilizar arquivo de 20000 numeros\n6: Voltar");
			escolhaDeTamanhoDeArquivoTXT = scanner.nextInt();
			if (escolhaDeTamanhoDeArquivoTXT == 1) {
				ArquivoEscolhido = "src/Numeros/Elementos-100.txt";
				break;
			} else if (escolhaDeTamanhoDeArquivoTXT == 2) {
				ArquivoEscolhido = "src/Numeros/Elementos-500.txt";
				break;
			} else if (escolhaDeTamanhoDeArquivoTXT == 3) {
				ArquivoEscolhido = "src/Numeros/Elementos-1000.txt";
				break;
			} else if (escolhaDeTamanhoDeArquivoTXT == 4) {
				ArquivoEscolhido = "src/Numeros/Elementos-10000.txt";
				break;
			} else if (escolhaDeTamanhoDeArquivoTXT == 5) {
				ArquivoEscolhido = "src/Numeros/Elementos-20000.txt";
				break;
			} else if (escolhaDeTamanhoDeArquivoTXT != 6) {
				System.out.println("Escolha Inválida");
			}
		} while (escolhaDeTamanhoDeArquivoTXT != 6);
	}
}