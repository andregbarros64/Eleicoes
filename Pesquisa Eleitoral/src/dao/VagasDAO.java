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

import model.Vagas;

public class VagasDAO {
	
	private static VagasDAO instance;
	private List<Vagas> listaVagas =  new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();

	
	public static VagasDAO getInstance() {
	
	if (instance == null) {
		instance = new VagasDAO();
	}
	return instance;
	
	}
	
	public void salvar(Vagas vaga) {
		
		try {
			
			String sql = "insert "
					   + "into "
					   + "PesquisasQuestionarios "
					   + "(tipo_vaga) "
					   + "values(?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vaga.getTipoVaga());
			pstmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void atualizar(Vagas vaga) {
		
		try {
			
			String sql = "update Vagas "
					   + "set "
					   + "tipo_vaga = ? "
					   + "where  id_vaga = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vaga.getTipoVaga());
			pstmt.setInt(2, vaga.getId_Vaga());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

	
	public void excluir(int id_vaga) {
		
		try {
			
			String sql = "delete "
					   + "from "
					   + "Vagas"
					   + "where id_vaga = ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id_vaga);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public List<Vagas> listar(){
		List<Vagas> listaVagas = new ArrayList<>();
		
		try {
			
			String sql = "select * from Vagas";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Vagas vg = new Vagas();
				vg.setTipoVaga(rs.getString("tipo_vaga"));
				listaVagas.add(vg);
				
			}	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}	
		
		return listaVagas;
	}
	
	
	

}
