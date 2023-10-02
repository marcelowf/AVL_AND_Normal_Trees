package br.com.arvore.normal;

public class Nomal_BinaryTree {
	private Normal_TreeNode node;

	public void inserir(int valor) {
		Normal_TreeNode novoNo = new Normal_TreeNode(valor);
		insertRec(node, novoNo);
	}

	private void insertRec(Normal_TreeNode currentNode, Normal_TreeNode newNode) {
		// Compara o valor do novo nó com o valor do nó atual.
		if (node == null) {
			node = newNode;
			System.out.println("Arvore Iniciada");
		} else if (newNode.getData() < currentNode.getData()) {
			// Se o valor for menor, insira na subárvore esquerda.
			if (currentNode.getEsquerda() == null) {
				currentNode.setEsquerda(newNode);
				// System.out.println("Valor " + newNode.getData() + " adicionado.");
			} else {
				// Caso contrário, continue a busca na subárvore esquerda.
				insertRec(currentNode.getEsquerda(), newNode);
			}
		} else if (newNode.getData() > currentNode.getData()) {
			// Se o valor for maior, insira na subárvore direita.
			if (currentNode.getDireita() == null) {
				currentNode.setDireita(newNode);
				// System.out.println("Valor " + newNode.getData() + " adicionado.");
			} else {
				// Caso contrário, continue a busca na subárvore direita.
				insertRec(currentNode.getDireita(), newNode);
			}
		}
	}

	public void remover(int valor) {
		node = removerRec(node, valor);
	}

	private Normal_TreeNode removerRec(Normal_TreeNode currentNode, int valor) {
		// Caso base: se a árvore ou subárvore estiver vazia, retorne o próprio nó.
		if (currentNode == null) {
			// System.out.println("Valor não encontrado na árvore.");
			return currentNode;
		}

		if (valor < currentNode.getData()) {
			currentNode.setEsquerda(removerRec(currentNode.getEsquerda(), valor));
		} else if (valor > currentNode.getData()) {
			currentNode.setDireita(removerRec(currentNode.getDireita(), valor));
		} else {
			// Caso 1: Nó com apenas um filho ou nenhum filho.
			if (currentNode.getEsquerda() == null) {
				// System.out.println("Valor " + valor + " removido com sucesso.");
				return currentNode.getDireita();
			} else if (currentNode.getDireita() == null) {
				// System.out.println("Valor " + valor + " removido com sucesso.");
				return currentNode.getEsquerda();
			}

			// Caso 2: Nó com dois filhos, encontre o sucessor (menor valor na subárvore
			// direita).
			currentNode.setData(encontrarMinimoValor(currentNode.getDireita()));

			// Remova o sucessor encontrado na subárvore direita.
			currentNode.setDireita(removerRec(currentNode.getDireita(), currentNode.getData()));
			// System.out.println("Valor " + valor + " removido com sucesso.");
		}

		return currentNode;
	}

	private int encontrarMinimoValor(Normal_TreeNode node) {
		int minValue = node.getData();
		while (node.getEsquerda() != null) {
			minValue = node.getEsquerda().getData();
			node = node.getEsquerda();
		}
		return minValue;
	}

	public Normal_TreeNode buscar(int valor) {
		return buscaRec(node, valor);
	}

	private Normal_TreeNode buscaRec(Normal_TreeNode currentNode, int valor) {
		if (currentNode == null) {
			System.out.println("Valor não consta na arvore");
			return currentNode;
		} else if (currentNode.getData() == valor) {
			System.out.println("Valor " + valor + " encontrado na arvore");
		}
		if (valor < currentNode.getData()) {
			return buscaRec(currentNode.getEsquerda(), valor);
		} else {
			return buscaRec(currentNode.getDireita(), valor);
		}
	}
}