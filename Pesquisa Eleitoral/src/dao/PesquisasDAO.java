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

import model.Pesquisas;

public class PesquisasDAO {
	
	
	private static PesquisasDAO instance;
	private List<Pesquisas> listaPesquisas =  new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	
	public static PesquisasDAO getInstance() {
	
	if (instance == null) {
		instance = new PesquisasDAO();
	}
	return instance;
	
	}
	
	
	public void atualizar(Pesquisas pesquisa) {
		
		try {
			
			String sql = "update Pesquisas "
					   + "set "
					   + "id_vaga_fk = ?, cidade = ?, uf_estado = ?, data_pesquisa = ?)"
					   + "where  id_pesquisa = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pesquisa.getId_Vaga_fk());
			pstmt.setString(2, pesquisa.getCidade());
			pstmt.setString(3, pesquisa.getUfEstado());
			pstmt.setDate(4, pesquisa.getDataPesquisa());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	
	public void salvar(Pesquisas pesquisa) {
		
		try {
			
			String sql = "insert "
					   + "into "
					   + "Pesquisas "
					   + "(id_vaga_fk, cidade, uf_estado, data_pesquisa)"
					   + "values(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pesquisa.getId_Vaga_fk());
			pstmt.setString(2, pesquisa.getCidade());
			pstmt.setString(3, pesquisa.getUfEstado());
			pstmt.setDate(4, pesquisa.getDataPesquisa());
			pstmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	
	public void excluir(int id_pesquisa) {
		
		try {
			
			String sql = "delete "
					   + "from "
					   + "Pesquisas"
					   + "where id_pesquisa = ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id_pesquisa);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public List<Pesquisas> listar(){
		List<Pesquisas> listaPesquisas = new ArrayList<>();
		
		try {
			
			String sql = "select * from Pesquisas";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Pesquisas p = new Pesquisas();
				p.setId_Vaga_fk(rs.getInt("id_vaga_fk"));
				p.setCidade(rs.getString("cidade"));
				p.setUfEstado(rs.getString("uf_estado"));
				p.setDataPesquisa(rs.getDate("data_pesquisa"));
				listaPesquisas.add(p);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}		
		return listaPesquisas;
	}

}
