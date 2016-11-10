package com.uepb.evento.model;

public enum TipoTributacao {

	TRIBUTAVEL("Tributavel"), 
	SUBSTITUICAO_TRIBUTARIA("Substituição"), 
	ISENTO("Isento");
	
	private String descricao;
	
	TipoTributacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
