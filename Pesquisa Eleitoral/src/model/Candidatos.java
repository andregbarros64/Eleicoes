package model;

public class Candidatos {
	private int id_candidato;
	private int numCandidato;
	private int id_partido_fk;
	private int id_vaga_fk;
	private String nomeCandidato;
	private String estadoCandidato;
	private String cidadeCandidato;
	
	public int getId_Candidato() {
		return id_candidato;
	}
	public void setId_Candidato(int id_candidato) {
		this.id_candidato = id_candidato;
	}
	public int getNumCandidato() {
		return numCandidato;
	}
	public void setNumCandidato(int numCandidato) {
		this.numCandidato = numCandidato;
	}
	public int getId_Partido_fk() {
		return id_partido_fk;
	}
	public void setId_Partido_fk(int id_Partido_fk) {
		this.id_partido_fk = id_partido_fk;
	}
	public int getId_Vaga_fk() {
		return id_vaga_fk;
	}
	public void setId_Vaga_fk(int id_Vaga_fk) {
		this.id_vaga_fk = id_Vaga_fk;
	}
	public String getNomeCandidato() {
		return nomeCandidato;
	}
	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}
	public String getEstadoCandidato() {
		return estadoCandidato;
	}
	public void setEstadoCandidato(String estadoCandidato) {
		this.estadoCandidato = estadoCandidato;
	}
	public String getCidadeCandidato() {
		return cidadeCandidato;
	}
	public void setCidadeCandidato(String cidadeCandidato) {
		this.cidadeCandidato = cidadeCandidato;
	}
	

}
