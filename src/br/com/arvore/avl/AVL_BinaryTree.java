package br.com.arvore.avl;

public class AVL_BinaryTree {
	private AVL_TreeNode raiz;

	public AVL_BinaryTree() {
		this.raiz = null;
	}

	public void inserir(int data) {
		this.raiz = inserirRec(this.raiz, data);
	}

	private AVL_TreeNode inserirRec(AVL_TreeNode node, int data) {
		if (node == null) {
			return new AVL_TreeNode(data);
		}
		if (data < node.getData()) {
			node.setEsquerda(inserirRec(node.getEsquerda(), data));
		} else if (data > node.getData()) {
			node.setDireita(inserirRec(node.getDireita(), data));
		} else {
			return node;
		}

		// Atualiza a altura do nó atual
		node.setAltura(1 + Math.max(getAltura(node.getEsquerda()), getAltura(node.getDireita())));

		// Verifica o fator de equilíbrio e realiza as rotações, se necessário
		int fatorEquilibrio = getFatorEquilibrio(node);

		// Caso de rotação à esquerda
		if (fatorEquilibrio > 1 && data < node.getEsquerda().getData()) {
			return rotacaoDireita(node);
		}

		// Caso de rotação à direita
		if (fatorEquilibrio < -1 && data > node.getDireita().getData()) {
			return rotacaoEsquerda(node);
		}

		// Caso de rotação esquerda-direita
		if (fatorEquilibrio > 1 && data > node.getEsquerda().getData()) {
			node.setEsquerda(rotacaoEsquerda(node.getEsquerda()));
			return rotacaoDireita(node);
		}

		// Caso de rotação direita-esquerda
		if (fatorEquilibrio < -1 && data < node.getDireita().getData()) {
			node.setDireita(rotacaoDireita(node.getDireita()));
			return rotacaoEsquerda(node);
		}

		return node;
	}

	public void remover(int data) {
		this.raiz = removerRec(this.raiz, data);
	}

	private AVL_TreeNode removerRec(AVL_TreeNode node, int data) {
		if (node == null) {
			return node;
		}

		if (data < node.getData()) {
			node.setEsquerda(removerRec(node.getEsquerda(), data));
		} else if (data > node.getData()) {
			node.setDireita(removerRec(node.getDireita(), data));
		} else {
			if (node.getEsquerda() == null) {
				return node.getDireita();
			} else if (node.getDireita() == null) {
				return node.getEsquerda();
			}
			AVL_TreeNode temp = minValueNode(node.getDireita());
			node.setData(temp.getData());
			node.setDireita(removerRec(node.getDireita(), temp.getData()));
		}

		// Atualiza a altura do nó atual
		node.setAltura(1 + Math.max(getAltura(node.getEsquerda()), getAltura(node.getDireita())));

		// Verifica o fator de equilíbrio e realiza as rotações, se necessário
		int fatorEquilibrio = getFatorEquilibrio(node);

		// Caso de rotação à esquerda
		if (fatorEquilibrio > 1 && getFatorEquilibrio(node.getEsquerda()) >= 0) {
			return rotacaoDireita(node);
		}

		// Caso de rotação à direita
		if (fatorEquilibrio < -1 && getFatorEquilibrio(node.getDireita()) <= 0) {
			return rotacaoEsquerda(node);
		}

		// Caso de rotação esquerda-direita
		if (fatorEquilibrio > 1 && getFatorEquilibrio(node.getEsquerda()) < 0) {
			node.setEsquerda(rotacaoEsquerda(node.getEsquerda()));
			return rotacaoDireita(node);
		}

		// Caso de rotação direita-esquerda
		if (fatorEquilibrio < -1 && getFatorEquilibrio(node.getDireita()) > 0) {
			node.setDireita(rotacaoDireita(node.getDireita()));
			return rotacaoEsquerda(node);
		}

		return node;
	}

	public void buscar(int data) {
		buscarRec(this.raiz, data);
	}

	private boolean buscarRec(AVL_TreeNode node, int data) {
		if (node == null) {
			return false;
		}

		if (data == node.getData()) {
			return true;
		}

		if (data < node.getData()) {
			return buscarRec(node.getEsquerda(), data);
		} else {
			return buscarRec(node.getDireita(), data);
		}
	}

	private AVL_TreeNode rotacaoDireita(AVL_TreeNode y) {
		AVL_TreeNode x = y.getEsquerda();
		AVL_TreeNode T2 = x.getDireita();

		x.setDireita(y);
		y.setEsquerda(T2);
		y.setAltura(1 + Math.max(getAltura(y.getEsquerda()), getAltura(y.getDireita())));
		x.setAltura(1 + Math.max(getAltura(x.getEsquerda()), getAltura(x.getDireita())));
		return x;
	}

	private AVL_TreeNode rotacaoEsquerda(AVL_TreeNode x) {
		AVL_TreeNode y = x.getDireita();
		AVL_TreeNode T2 = y.getEsquerda();

		y.setEsquerda(x);
		x.setDireita(T2);
		x.setAltura(1 + Math.max(getAltura(x.getEsquerda()), getAltura(x.getDireita())));
		y.setAltura(1 + Math.max(getAltura(y.getEsquerda()), getAltura(y.getDireita())));
		return y;
	}

	private int getAltura(AVL_TreeNode node) {
		if (node == null) {
			return 0;
		}
		return node.getAltura();
	}

	private int getFatorEquilibrio(AVL_TreeNode node) {
		if (node == null) {
			return 0;
		}
		return getAltura(node.getEsquerda()) - getAltura(node.getDireita());
	}

	private AVL_TreeNode minValueNode(AVL_TreeNode node) {
		AVL_TreeNode atual = node;
		while (atual.getEsquerda() != null) {
			atual = atual.getEsquerda();
		}
		return atual;
	}
}
