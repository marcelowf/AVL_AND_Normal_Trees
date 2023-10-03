package br.com.arvore.avl;

public class AVL_TreeNode {
	private int data;
	private AVL_TreeNode esquerda;
	private AVL_TreeNode direita;
	private int altura;

	public AVL_TreeNode(int data) {
		this.data = data;
		this.esquerda = null;
		this.direita = null;
		this.altura = 1;
	}

	public int getData() {
		return data;
	}

	public int getAltura() {
		return altura;
	}

	public AVL_TreeNode getEsquerda() {
		return esquerda;
	}

	public AVL_TreeNode getDireita() {
		return direita;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setEsquerda(AVL_TreeNode esquerda) {
		this.esquerda = esquerda;
	}

	public void setDireita(AVL_TreeNode direita) {
		this.direita = direita;
	}
}