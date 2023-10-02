package br.com.arvore.normal;

public class Normal_TreeNode {
	private int data;
	private Normal_TreeNode esquerda;
	private Normal_TreeNode direita;

	public Normal_TreeNode(int data) {
		this.data = data;
		this.esquerda = null;
		this.direita = null;
	}

	public int getData() {
		return data;
	}

	public Normal_TreeNode getEsquerda() {
		return esquerda;
	}

	public Normal_TreeNode getDireita() {
		return direita;
	}

	public void setEsquerda(Normal_TreeNode esquerda) {
		this.esquerda = esquerda;
	}

	public void setDireita(Normal_TreeNode direita) {
		this.direita = direita;
	}

	public void setData(int data) {
		this.data = data;
	}
}
