package dao;

import java.util.ArrayList;
import java.util.List;
import Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Partidos;

public class PartidosDAO {
	
	
		private static PartidosDAO instance;
		private List<Partidos> listaPartidos =  new ArrayList<>();
		private Connection con = ConnectionUtil.getConnection();
		
		public static PartidosDAO getInstance() {
		
		if (instance == null) {
			instance = new PartidosDAO();
		}
		return instance;
		
		}
		
		public void atualizar(Partidos partido) {
			
			try {
				
				String sql = "update Partidos "
						   + "set "
						   + "id_partido = ?,  nome_partido = ?, num_partido = ?) "
						   + "where  id_candidato = ?";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, partido.getId_Partido());
				pstmt.setString(2, partido.getNomePartido());
				pstmt.setInt(3, partido.getNumPartido());
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}

		public void salvar(Partidos partido) {
			
			try {
				
				String sql = "insert "
						   + "into "
						   + "Partidos "
						   + "(id_partido, nome_partido, num_partido) "
						   + "values(?,?,?)";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, partido.getId_Partido());
				pstmt.setString(2, partido.getNomePartido());
				pstmt.setInt(3, partido.getNumPartido());
				pstmt.execute();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
		
		public void excluir(int id_Partido) {
			
			try {
				
				String sql = "delete "
						   + "from "
						   + "Partidos "
						   + "where id_partido = ?)";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id_Partido);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
		public List<Partidos> listar(){
			List<Partidos> listaPartidos = new ArrayList<>();
			
			try {
				
				String sql = "select * from Candidatos";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					
					Partidos c = new Partidos();
					c.setId_Partido(rs.getInt("id_partido"));
					c.setNomePartido(rs.getNString("nome_partido"));
					c.setNumPartido(rs.getInt("num_partido"));
					listaPartidos.add(c);
					
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
			return listaPartidos;
		}
		
		
	}

