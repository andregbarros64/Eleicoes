package controller;
import java.util.List;
import dao.CandidatosDAO;
import model.Candidatos;

public class CandidatosController {
	
	public void salvar(Candidatos candidato) throws Exception{
		if (candidato.getNomeCandidato() == null || candidato.getNomeCandidato().length() < 3) {
			throw new Exception("Nome do candidato não encontrado");
		}
		CandidatosDAO.getInstance().salvar(candidato);
	}
	
	public void atualizar(Candidatos candidato) throws Exception{
		if (candidato.getNomeCandidato() == null || candidato.getNomeCandidato().length() < 3) {
			throw new Exception("Candidato não identificado");
		}	
		CandidatosDAO.getInstance().atualizar(candidato);
		
	}
	
	public void excluir(int id_candidato) throws Exception{
		if (id_candidato == 0) {
			throw new Exception("Candidato não identificado");
		}
		CandidatosDAO.getInstance().excluir(id_candidato);
	}
	
	public List<Candidatos> listar(){
		return CandidatosDAO.getInstance().listar();
	}
	

}
