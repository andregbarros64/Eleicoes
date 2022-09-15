package dao;

import java.util.ArrayList;
import java.util.List;
import Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.List;

import model.PesquisasQuestionarios;

public class PesquisasQuestionariosDAO {
	
	private static PesquisasQuestionariosDAO instance;
	private List<PesquisasQuestionarios> listaPesquisasQuestionarios =  new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	public static PesquisasQuestionariosDAO getInstance() {
	
	if (instance == null) {
		instance = new PesquisasQuestionariosDAO();
	}
	return instance;
	
	}
	

	public void atualizar(PesquisasQuestionarios pesquisaQuestionario) {

		try {
			
			String sql = "update PesquisasQuestionarios "
					   + "set "
					   + "id_pesquisa_fk = ?, id_candidato_fk = ?, cpf_eleitor = ?, data_pesquisa = ?)"
					   + "where  id_pesquisaQuestionario = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pesquisaQuestionario.getId_pesquisa_fk());
			pstmt.setInt(2, pesquisaQuestionario.getId_candidato_fk());
			pstmt.setString(3, pesquisaQuestionario.getCpfEleitor());
			pstmt.setDate(4, pesquisaQuestionario.getData_pesquisa());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	

	public void salvar(PesquisasQuestionarios pesquisaQuestionario) {
		
		try {
			
			String sql = "insert "
					   + "into "
					   + "PesquisasQuestionarios "
					   + "(id_pesquisa_fk, id_candidato_fk, cpf_eleitor, data_pesquisa)"
					   + "values(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pesquisaQuestionario.getId_pesquisa_fk());
			pstmt.setInt(2, pesquisaQuestionario.getId_candidato_fk());
			pstmt.setString(3, pesquisaQuestionario.getCpfEleitor());
			pstmt.setDate(4, pesquisaQuestionario.getData_pesquisa());
			pstmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	
	public void excluir(int id_pesquisaQuestionario) {
		
		try {
			
			String sql = "delete "
					   + "from "
					   + "PesquisasQuestionarios"
					   + "where id_pesquisaQuestionario = ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id_pesquisaQuestionario);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public List<PesquisasQuestionarios> listar(){
		List<PesquisasQuestionarios> listaPesquisasQuestionarios = new ArrayList<>();
		
		try {
			
			String sql = "select * from Pesquisas";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				PesquisasQuestionarios pq = new PesquisasQuestionarios();
				pq.setId_pesquisa_fk(rs.getInt("id_pesquisa"));
				pq.setId_candidato_fk(rs.getInt("id_candidato_fk"));
				pq.setCpfEleitor(rs.getString("cpf_eleitor"));
				pq.setData_pesquisa(rs.getDate("data_pesquisa"));
				listaPesquisasQuestionarios.add(pq);
				
			}	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}	
		
		return listaPesquisasQuestionarios;
	}
	

}
