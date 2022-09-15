package model;

import java.sql.Date;

public class Pesquisas {
	
	private int id_pesquisa;
	private int id_vaga_fk; 
	private String cidade;
	private String ufEstado;
	private Date dataPesquisa;
	
	public int getId_Pesquisa() {
		return id_pesquisa;
	}
	public void id_pesquisa(int id_Pesquisa) {
		this.id_pesquisa = id_pesquisa;
	}
	public int getId_Vaga_fk() {
		return id_vaga_fk;
	}
	public void setId_Vaga_fk(int id_Vaga_fk) {
		this.id_vaga_fk = id_vaga_fk;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUfEstado() {
		return ufEstado;
	}
	public void setUfEstado(String ufEstado) {
		this.ufEstado = ufEstado;
	}
	public Date getDataPesquisa() {
		return dataPesquisa;
	}
	public void setDataPesquisa(Date string) {
		this.dataPesquisa = string;
	}
	public void setDataPesquisa(String text) {
		// TODO Auto-generated method stub
		
	}
	

}
