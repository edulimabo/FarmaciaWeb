package br.com.farmaciaWeb.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

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
	
	public Fornecedor BuscaPorCodigo(Fornecedor f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CODIGO,NOME ");
		sql.append("from fornecedores ");
		sql.append("WHERE codigo= ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, f.getCodigo());
		
		
		ResultSet resultado = comando.executeQuery();
		Fornecedor retorno=null;
		
		if (resultado.next()) {
			retorno= new Fornecedor();
			retorno.setCodigo(resultado.getInt("codigo"));
			retorno.setNome(resultado.getString("nome"));
						
		}
		return retorno;
	}
	
	public ArrayList<Fornecedor> BuscaPorNome(Fornecedor f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CODIGO,NOME,ENDERECO,TELEFONE ");
		sql.append("from fornecedores ");
		sql.append("WHERE nome LIKE  ? ");
		sql.append("order by nome ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%"+  f.getNome() + "%");
		
		
ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		while (resultado.next()) {
			Fornecedor item = new Fornecedor();
			item.setCodigo(resultado.getInt("codigo"));
			item.setNome(resultado.getString("nome"));
			item.setEndereco(resultado.getString("endereco"));
			item.setTelefone(resultado.getString("telefone"));
			
			lista.add(item);
			
		}
		return lista;
	}
	
		
				
		//comando.executeUpdate();
	public ArrayList<Fornecedor> listar () throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CODIGO,NOME,ENDERECO, TELEFONE ");
		sql.append("from fornecedores ");
		sql.append("ORDER BY NOME ASC");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		while (resultado.next()) {
			Fornecedor f = new Fornecedor();
			f.setCodigo(resultado.getInt("codigo"));
			f.setNome(resultado.getString("nome"));
			f.setEndereco(resultado.getString("endereco"));
			f.setTelefone(resultado.getString("telefone"));
			
			lista.add(f);
			
		}
		return lista;
		
		
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

//		Fornecedor f = new Fornecedor();
//		f.setCodigo(3);
//		f.setNome("Luis Eduardo");
//		f.setEndereco("Rua 13 de maio");
//		f.setTelefone("9999-9999");
//		FornecedorDAO fdao = new FornecedorDAO();
//		
//		try {
//			fdao.editar(f);
//
//			System.out.println("editado com Sucesso");
//		} catch (Exception e) {
//			System.out.println("erro ao editar");
//			e.printStackTrace();
//		}
		
//		Fornecedor f = new Fornecedor();
//		f.setCodigo(3);
//		f.setNome("Luis Eduardo");
//		f.setEndereco("Rua 13 de maio");
//		f.setTelefone("9999-9999");
//		FornecedorDAO fdao = new FornecedorDAO();
//		
//		try {
//			fdao.editar(f);
//
//			System.out.println("editado com Sucesso");
//		} catch (Exception e) {
//			System.out.println("erro ao editar");
//			e.printStackTrace();
//		}
		
		

//		Fornecedor f = new Fornecedor();
//		f.setCodigo(3);
//		
//		
//		FornecedorDAO fdao = new FornecedorDAO();
//		
//		try {
//			Fornecedor f1 =fdao.BuscaPorCodigo(f);
//
//			System.out.println("Resultado: "+f1);
//		} catch (Exception e) {
//			System.out.println("erro ao buscar");
//			e.printStackTrace();
//		}
		
		
//		FornecedorDAO fdao = new FornecedorDAO();
//		
//		try {
//			ArrayList<Fornecedor>lista=fdao.listar();
//
//			for (Fornecedor f : lista) {
//				
//			
//			System.out.println("Resultado: "+f);
//			}
//		} catch (Exception e) {
//			System.out.println("erro ao buscar");
//			e.printStackTrace();
//		}
		
Fornecedor f1 = new Fornecedor();
f1.setNome("LO");
FornecedorDAO fdao = new FornecedorDAO();
		
		try {
			ArrayList<Fornecedor>lista=fdao.BuscaPorNome(f1);

			for (Fornecedor f : lista) {
				
			
			System.out.println("Resultado: "+f);
			}
		} catch (Exception e) {
			System.out.println("erro ao buscar");
			e.printStackTrace();
		}
		
	}
}
