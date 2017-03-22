package les.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import les.dao.IDAO;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Funcionario;

public class FuncionarioDAO extends PostgresDAO{
	public boolean salvar(EntidadeDominio entidade) {
	Funcionario func = (Funcionario)entidade;
        
        try {
			Connection conn;
			conn = newConnection();
			String sql = " INSERT INTO FUNCIONARIO (";
			sql = sql+"nome,";
			sql = sql+"dt_nasc,";
			sql = sql+"cpf)";
			sql = sql+"VALUES (";
                        sql = sql+"'"+func.getNome()+"', ";
                        sql = sql+"'"+func.getDt_nasc()+"', ";
                        sql = sql+"'"+func.getCpf()+"');";
			Statement st = conn.createStatement();
			st.executeUpdate( sql );
			st.close();
			conn.close();
			IDAO func_end = new Funcionario_EnderecoDAO(); 
			return func_end.salvar(func.getEnd());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return false;
		}
	}


	public boolean alterar(EntidadeDominio entidade) {
                Funcionario func = (Funcionario)entidade;
		try {
			
                    Connection conn;
                    conn = newConnection();
                    Statement st = conn.createStatement();
                    String sql = "UPDATE funcionario" +
                                 "   SET nome='"+func.getNome()+"', cpf='"+func.getCpf()+"', dt_nasc='"+func.getDt_nasc()+"'" +
                                 " WHERE cpf='"+func.getCpf()+"';";
                    String sql2 = "SELECT id FROM funcionario WHERE cpf='"+func.getCpf()+"';";
                    ResultSet rs = st.executeQuery(sql2);
                    IDAO func_end = new Funcionario_EnderecoDAO(); 
                    Endereco end = func.getEnd();
                    while (rs.next()) {
                        end.setId(rs.getInt("ID"));
                     }
                    
                    func_end.alterar(end);
                    st.executeUpdate(sql);
                    st.close();
                    conn.close();
                    
	            return true;
                        
                } catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return false;
		}
	}


	public boolean excluir(EntidadeDominio entidade) {
		Funcionario func = (Funcionario)entidade;
		
		try {
			
                    Connection conn;
                    conn = newConnection();
                    Statement st = conn.createStatement();
                    String sql = "DELETE FROM FUNCIONARIO_ENDERECO WHERE FUNCIONARIO_ID = ?;";
                    String sql2 = "DELETE FROM FUNCIONARIO WHERE ID = ?;";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, func.getId());
                    preparedStatement.executeUpdate();
                    
                    preparedStatement = conn.prepareStatement(sql2);
                    preparedStatement.setInt(1, func.getId());
                    preparedStatement.executeUpdate();
                    
                    st.close();
                    conn.close();
                    return true;
                        
                } catch (SQLException e) {
			System.out.println(e.getMessage());
                        System.out.println(e.getCause());
			if (e.getCause() == null){
                            return true;
                        }
                        System.out.println("Erro de SQL");
			return false;
		}
	}


	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		Funcionario func = (Funcionario)entidade;
		
		try {
			Connection conn;
			conn = newConnection();
			Statement st = conn.createStatement();
                        List<EntidadeDominio> funcionarios = new ArrayList<EntidadeDominio>();			
                        // Verfica se tem um ID, para que posso efetuar uma consulta especifica se = 0, traz todos
                        if (func.getId() == 0){
				String sql = "SELECT * FROM FUNCIONARIO"; 
				       sql = sql+" JOIN FUNCIONARIO_ENDERECO ON FUNCIONARIO_ID = FUNCIONARIO.ID";
				ResultSet rs = st.executeQuery(sql);
				String msg = null;
                                while (rs.next()) {
                                    Funcionario fun = new Funcionario();
                                    Endereco end = new Endereco();

                                    fun.setId(rs.getInt("ID"));
                                    fun.setNome(rs.getString("NOME").trim());
                                    fun.setCpf(rs.getString("CPF").trim());
                                    fun.setDt_nasc(rs.getString("DT_NASC").trim());

                                    end.setRua(rs.getString("RUA").trim());
                                    end.setCidade(rs.getString("CIDADE").trim());
                                    end.setCep(rs.getString("CEP").trim());

                                    fun.setEnd(end);
                                    funcionarios.add(fun);
                                        					
				}
                                rs.close();
				st.close();
				conn.close();
				return funcionarios;
			}else{// consulta específica
				String sql = "SELECT * FROM FUNCIONARIO"; 
				sql = sql+" JOIN FUNCIONARIO_ENDERECO ON FUNCIONARIO_ID = FUNCIONARIO.ID";
			    sql = sql+" WHERE funcionario.id ="+func.getId();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
                                    Funcionario fun = new Funcionario();
                                    Endereco end = new Endereco();

                                    fun.setId(rs.getInt("ID"));
                                    fun.setNome(rs.getString("NOME").trim());
                                    fun.setCpf(rs.getString("CPF").trim());
                                    fun.setDt_nasc(rs.getString("DT_NASC").trim());

                                    end.setRua(rs.getString("RUA").trim());
                                    end.setCidade(rs.getString("CIDADE").trim());
                                    end.setCep(rs.getString("CEP").trim());

                                    fun.setEnd(end);
                                    funcionarios.add(fun);
					
				}
				rs.close();
				st.close();
				conn.close();
				return funcionarios;
			} 
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return null;
		}
	}
}

