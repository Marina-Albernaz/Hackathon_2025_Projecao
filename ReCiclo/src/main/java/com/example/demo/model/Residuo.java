package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Residuo {
	
	private int id;
	private String titulo;
	private String categoriaMaterial;
	private String descricao;
	private double peso;
	private String localDeRecolhimento;
	private List<String> imagens = new ArrayList<>();
	private String datetime;
	private String email;
	
	public Residuo() {
		
	}
	
	public Residuo(int id, String titulo, String descricao, String categoriaMaterial, String email, List<String> imagens, String endereco, double peso, String datahora) {
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCategoriaMaterial() {
		return categoriaMaterial;
	}
	public void setCategoriaMaterial(String categoriaMaterial) {
		this.categoriaMaterial = categoriaMaterial;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getLocalDeRecolhimento() {
		return localDeRecolhimento;
	}
	public void setLocalDeRecolhimento(String localDeRecolhimento) {
		this.localDeRecolhimento = localDeRecolhimento;
	}
	
	public String getImagens() {
		String imagesResult = "";
		for(int i = 0; i < imagens.size(); i++) {
			imagesResult += imagens.get(i);
		}
		return imagesResult;
	}
	public void addImagem(String imagem) {
		imagens.add(imagem);
	}
	
	public void removerImagem(int index) {
		imagens.remove(index);
	}
	
	public String getIndexedImagem(int index) {
		return imagens.get(index);
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
