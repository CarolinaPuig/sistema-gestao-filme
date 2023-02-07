//Carolina Goudromihos Puig- 95078

package fiap;
import java.util.*;
import javax.swing.JOptionPane;
import java.sql.*;

public class TesteFilme {
	public static void main(String[] args) {
		String escolha = "sim";
		
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				modificaFilme();
				listaFilme();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
	}
	
	private static void modificaFilme() {
		Connection con = Conexao.abrirConexao();
		
		Filme cb = new Filme();
		FilmeDAO cd = new FilmeDAO(con);
		String aux, codigo, produtora, genero, titulo;
		int opcao;
		try {
			aux = JOptionPane.showInputDialog("Escolha: " + "\n(1)Inserir \n(2)Alterar \n(3)Excluir");
			opcao = Integer.parseInt(aux);
			codigo = JOptionPane.showInputDialog("Cógico: ");
			titulo = JOptionPane.showInputDialog("Título: ");
			genero = JOptionPane.showInputDialog("Gênero: ");
			produtora = JOptionPane.showInputDialog("Produtora: ");
			cb.setCodigo(codigo);
			cb.setTitulo(titulo);
			cb.setGenero(genero);
			cb.setProdutora(produtora);
			
			switch (opcao) {
			case 1:
				System.out.println(cd.inserir(cb));
				break;
			case 2:
				System.out.println(cd.alterar(cb));
				break;
			case 3:
				System.out.println(cd.excluir(cb));
				break;

			default:
				System.out.println("Escolha incorreta");
			}
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Conexao.fecharConexao(con);
	}
	
	private static void listaFilme() {
		Connection con = Conexao.abrirConexao();
		
		FilmeDAO cd = new FilmeDAO(con);
		ArrayList<Filme> lista = cd.listarTodos();
		String dados = "Lista dos filmes:\n\n";
		if (lista != null) {
			for (Filme filme : lista) {
				dados += "Cógigo: " + filme.getCodigo() + "\n";
				dados += "Título: " + filme.getTitulo() + "\n";
				dados += "Gênero: " + filme.getGenero() + "\n";
				dados += "Produtora: " + filme.getProdutora() + "\n";

			}
			JOptionPane.showMessageDialog(null, dados);
		}
		
		Conexao.fecharConexao(con);
	}
	
}