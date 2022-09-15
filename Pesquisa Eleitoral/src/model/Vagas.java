package model;

public class Vagas {
	
	private int id_vaga;
	private String tipoVaga; // armazena o tipo de vaga (Presidente, Governador...)
	
	public int getId_Vaga() {
		return id_vaga;
	}
	public void setId_Vaga(int id_vaga) {
		this.id_vaga = id_vaga;
	}
	public String getTipoVaga() {
		return tipoVaga;
	}
	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}
	
}
