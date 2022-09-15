package dao;

import java.util.ArrayList;
import java.util.List;
import Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Candidatos;

public class CandidatosDAO {
	
	private static CandidatosDAO instance;
	private List<Candidatos> listaCandidatos =  new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	
	
	
	public static CandidatosDAO getInstance() {
	
	if (instance == null) {
		instance = new CandidatosDAO();
	}
	return instance;
	
	}
	
	public void atualizar(Candidatos candidato) {
			
		try {
			
			String sql = "update Candidatos "
					   + "set "
					   + "id_partido_fk = ?, "
					   + "id_vaga_fk = ?, "
					   + "nome_candidato = ?, "
					   + "cidade_candidato = ?, "
					   + "estado_candidato = ?) "
					   + "where id_candidato = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, candidato.getId_Partido_fk());
			pstmt.setInt(2, candidato.getId_Vaga_fk());
			pstmt.setString(3, candidato.getNomeCandidato());
			pstmt.setString(4, candidato.getCidadeCandidato());
			pstmt.setString(5, candidato.getEstadoCandidato());
			pstmt.setInt(6, candidato.getId_Candidato());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

	public void salvar(Candidatos candidato) {
		
		try {
			
			String sql = "insert "
					   + "into "
					   + "Candidatos "
					   + "(id_partido_fk, id_vaga_fk, nome_candidato, cidade_candidato, estado_candidato)"
					   + "values(?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, candidato.getId_Partido_fk());
			pstmt.setInt(2, candidato.getId_Vaga_fk());
			pstmt.setString(3, candidato.getNomeCandidato());
			pstmt.setString(4, candidato.getCidadeCandidato());
			pstmt.setString(5, candidato.getEstadoCandidato());
			pstmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	public void excluir(int id_candidato) {
		
		try {
			
			String sql = "delete "
					   + "from "
					   + "Candidatos "
					   + "where id_candidato = ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id_candidato);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public List<Candidatos> listar(){
		List<Candidatos> listaCandidatos = new ArrayList<>();
		
		try {
			
			String sql = "select * from Candidatos";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Candidatos c = new Candidatos();
				c.setId_Candidato(rs.getInt("id_candidato"));
				c.setId_Partido_fk(rs.getInt("id_partido"));
				c.setId_Vaga_fk(rs.getInt("id_vaga"));
				c.setNomeCandidato(rs.getString("nome_candidato"));
				c.setCidadeCandidato(rs.getString("cidade_candidato"));
				c.setEstadoCandidato(rs.getString("estado_candidato"));
				listaCandidatos.add(c);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return listaCandidatos;		

	}
	
	
}
