package les.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Funcionario;

public class Funcionario_EnderecoDAO extends PostgresDAO{
	public boolean salvar(EntidadeDominio entidade) {
	Endereco end = (Endereco)entidade;
        
        try {
			Connection conn;
			conn = newConnection();
			String sql = " INSERT INTO funcionario_endereco (";
			sql = sql+"funcionario_id,";
			sql = sql+"rua,";
			sql = sql+"cep,";
			sql = sql+"cidade)";
			sql = sql+"VALUES (";
						sql = sql+"(SELECT id FROM funcionario order by 1 desc limit 1), ";
                        sql = sql+"'"+end.getRua()+"', ";
                        sql = sql+"'"+end.getCep()+"', ";
                        sql = sql+"'"+end.getCidade()+"');";
                        
			Statement st = conn.createStatement();
			st.executeUpdate( sql );
			st.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return false;
		}
	}


	public boolean alterar(EntidadeDominio entidade) {
            try {
            
                Endereco end = (Endereco)entidade;
                Connection conn;
                conn = newConnection();

                String sql = "UPDATE funcionario_endereco" +
                             "   SET ceṕ='"+end.getCep()+"', cidade='"+end.getCidade()+"', rua='"+end.getRua()+"'" +
                             " WHERE funcionario_id="+end.getId()+";";

                Statement st = conn.createStatement();
                st.executeUpdate( sql );
                st.close();
                conn.close();
            } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Erro de SQL");
                    return false;
            }
            return false;
	}


	public boolean excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return false;
	}


	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
                return null;
	}




}
