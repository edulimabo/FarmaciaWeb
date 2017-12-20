package br.com.farmaciaWeb.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import br.com.farmaciaWeb.domain.Fornecedor;
import br.com.farmaciaWeb.factory.ConexaoFactory;


//import com.mysql.jdbc.PreparedStatement;

public class FornecedorDAO {
	
	public void salvar(Fornecedor f) throws SQLException {

		Connection conexao = ConexaoFactory.conectar();

	
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(nome, endereco, telefone) ");
		sql.append("VALUES (?, ?, ?)");
		PreparedStatement comando =  conexao.prepareStatement(sql.toString());
		
		comando.setString(1,f.getNome());
		comando.setString(2, f.getEndereco());
		comando.setString(3, f.getTelefone());
		comando.executeUpdate();
		

	}
	
	public void excluir(Fornecedor f) throws SQLException {

		Connection conexao = ConexaoFactory.conectar();

	
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");
		
		PreparedStatement comando =  conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
		

	}
	
	public void editar (Fornecedor f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET nome = ?, endereco = ?, telefone = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getNome());
		comando.setString(2, f.getEndereco());
		comando.setString(3, f.getTelefone());
		comando.setInt(4, f.getCodigo());
		
			
		comando.executeUpdate();
		
	}
	
	

	public static void main(String[] args) {
//		Fornecedor f1 = new Fornecedor();
//		f1.setNome("Rafael Lima");
//		f1.setEndereco("rua da 3 lagoas");
//		f1.setTelefone("996258586");
//
//		FornecedorDAO fdao = new FornecedorDAO();
//		try {
//			fdao.salvar(f1);
//
//			System.out.println("salvo com sucesso");
//		} catch (Exception e) {
//			System.out.println("erro ao salvar");
//			e.printStackTrace();
//		}
		
//		Fornecedor f1 = new Fornecedor();
//		f1.setCodigo(2l);
//		FornecedorDAO fdao = new FornecedorDAO();
//		try {
//			fdao.excluir(f1);
//
//			System.out.println("Deletado com Sucesso");
//		} catch (Exception e) {
//			System.out.println("erro ao deletar");
//			e.printStackTrace();
//		}

		Fornecedor f = new Fornecedor();
		f.setCodigo(1);
		f.setNome("Luis fernando");
		f.setEndereco("Rua 13 de agosto");
		f.setTelefone("88788217");
		FornecedorDAO fdao = new FornecedorDAO();
		
		try {
			fdao.editar(f);

			System.out.println("editado com Sucesso");
		} catch (Exception e) {
			System.out.println("erro ao editar");
			e.printStackTrace();
		}
		
		
	}
}
