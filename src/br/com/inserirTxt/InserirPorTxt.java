package br.com.inserirTxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import br.com.arvore.avl.AVL_BinaryTree;
import br.com.arvore.normal.Nomal_BinaryTree;

public class InserirPorTxt {
	Nomal_BinaryTree normalTree = new Nomal_BinaryTree();
	AVL_BinaryTree avlTree = new AVL_BinaryTree();

	public void InserirPorArquivoTxt(String escolhaArquivo, int arquivoEscolhido) {
		String nomeArquivo = escolhaArquivo;

		try {
			// Cria um objeto
			File arquivo = new File(nomeArquivo);

			// Cria um objeto FileReader para ler o arquivo
			FileReader fileReader = new FileReader(arquivo);

			// Cria um objeto BufferedReader para ler linhas
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String linha;

			// Loop para ler linha
			while ((linha = bufferedReader.readLine()) != null) {

				// Divide a linha em palavras usando espaço como separador
				String[] palavras = linha.split(" ");

				// Loop para processar cada palavra como um inteiro
				for (String palavra : palavras) {
					try {
						int numero = Integer.parseInt(palavra);
						if (arquivoEscolhido == 1) {
							normalTree.inserir(numero);
						} else {
							avlTree.inserir(numero);
						}
					} catch (NumberFormatException e) {
						System.err.println("Erro ao converter " + palavra);
					}
				}
			}
			bufferedReader.close();

		} catch (IOException e) {
			System.out.println("ERRO no arquivo");
			e.printStackTrace();
		}
	}
}
