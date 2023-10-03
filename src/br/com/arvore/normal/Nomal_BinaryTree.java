package br.com.arvore.normal;

public class Nomal_BinaryTree {
	private Normal_TreeNode node;

	public void inserir(int valor) {
		Normal_TreeNode novoNo = new Normal_TreeNode(valor);
		insertRec(node, novoNo);
	}

	private void insertRec(Normal_TreeNode currentNode, Normal_TreeNode newNode) {
		if (node == null) {
			node = newNode;
			System.out.println("Arvore Iniciada");
		} else if (newNode.getData() < currentNode.getData()) {
			if (currentNode.getEsquerda() == null) {
				currentNode.setEsquerda(newNode);
			} else {
				insertRec(currentNode.getEsquerda(), newNode);
			}
		} else if (newNode.getData() > currentNode.getData()) {
			if (currentNode.getDireita() == null) {
				currentNode.setDireita(newNode);
			} else {
				insertRec(currentNode.getDireita(), newNode);
			}
		}
	}

	public void remover(int valor) {
		node = removerRec(node, valor);
	}

	private Normal_TreeNode removerRec(Normal_TreeNode currentNode, int valor) {
		if (currentNode == null) {
			return currentNode;
		}

		if (valor < currentNode.getData()) {
			currentNode.setEsquerda(removerRec(currentNode.getEsquerda(), valor));
		} else if (valor > currentNode.getData()) {
			currentNode.setDireita(removerRec(currentNode.getDireita(), valor));
		} else {
			if (currentNode.getEsquerda() == null) {
				return currentNode.getDireita();
			} else if (currentNode.getDireita() == null) {
				return currentNode.getEsquerda();
			}
			currentNode.setData(encontrarMinimoValor(currentNode.getDireita()));
			currentNode.setDireita(removerRec(currentNode.getDireita(), currentNode.getData()));
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