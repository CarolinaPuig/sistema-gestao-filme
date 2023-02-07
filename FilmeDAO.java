//Carolina Goudromihos Puig- 95078

package fiap;

import java.sql.*;
import java.util.*;

public class FilmeDAO {
	private Connection con;
	
	public FilmeDAO (Connection con) {setCon(con);}
		
	public Connection getCon() {return con;}
	public void setCon(Connection con) {this.con=con;}
	
	public String inserir(Filme filme) {
		String sql = "insert into filme (codigo, titulo ,genero ,produtora) values (?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar (Filme filme) {
		String sql = "update filme set titulo = ?, genero = ?, produtora = ?";
		sql += "where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir (Filme filme) {
		String sql = "delete from filme where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Filme> listarTodos(){
		String sql = "select * from filme ";
		ArrayList<Filme> listaFilme = new ArrayList<Filme>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Filme fi = new Filme();
					fi.setCodigo(rs.getString(1));
					fi.setTitulo(rs.getString(2));
					fi.setGenero(rs.getString(3));
					fi.setProdutora(rs.getString(4));
					listaFilme.add(fi);
				}
				return listaFilme;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
