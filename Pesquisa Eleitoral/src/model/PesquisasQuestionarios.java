package model;

import java.util.Date;

public class PesquisasQuestionarios {

	private int id_pesquisaQuestionario;
	private int id_pesquisa_fk;
	private int id_candidato_fk;
	private String cpfEleitor;
	private java.sql.Date data_pesquisa;
	
	public java.sql.Date getData_pesquisa() {
		return data_pesquisa;
	}
	public void setData_pesquisa(java.sql.Date data_pesquisa) {
		this.data_pesquisa = data_pesquisa;
	}
	public int getId_pesquisaQuestionario() {
		return id_pesquisaQuestionario;
	}
	public void setId_pesquisaQuestionario(int id_pesquisaQuestionario) {
		this.id_pesquisaQuestionario = id_pesquisaQuestionario;
	}
	public int getId_pesquisa_fk() {
		return id_pesquisa_fk;
	}
	public void setId_pesquisa_fk(int id_pesquisa_fk) {
		this.id_pesquisa_fk = id_pesquisa_fk;
	}
	public int getId_candidato_fk() {
		return id_candidato_fk;
	}
	public void setId_candidato_fk(int id_candidato_fk) {
		this.id_candidato_fk = id_candidato_fk;
	}
	public String getCpfEleitor() {
		return cpfEleitor;
	}
	public void setCpfEleitor(String cpfEleitor) {
		this.cpfEleitor = cpfEleitor;
	}
	
	
}
