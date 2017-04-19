package les.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import les.dao.IDAO;
import les.dominio.Cargo;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Funcionario;
import les.dominio.Grupo;
import les.dominio.ICommand;

public class FuncionarioDAO extends PostgresDAO{
	public boolean salvar(EntidadeDominio entidade) {
	Funcionario func = (Funcionario)entidade;
        
        try {
			Connection conn, conn2;
			conn = newConnection();
                        conn2 = newConnection();
			String sql = " INSERT INTO FUNCIONARIO (";
			sql = sql+"nome,";
			sql = sql+"dt_nasc,";
			sql = sql+"cpf, ";
                        sql = sql+"cargo_id,";
                        sql = sql+"grupo_id)";
			sql = sql+"VALUES (";
                        sql = sql+"'"+func.getNome()+"', ";
                        sql = sql+"'"+func.getDt_nasc()+"', ";
                        sql = sql+"'"+func.getCpf()+"',";
                        sql = sql+"'"+func.getCargo_id()+"', '"
                                     + func.getGrupo_id() +"');";
                        String sql2 = " SELECT max(id) as id FROM funcionario;";
                        
			Statement st = conn.createStatement();
                        Statement st2 = conn2.createStatement();
                        st.executeUpdate(sql);
                        ResultSet rs = st2.executeQuery(sql2);
                        int id = 0;
                        
                        while (rs.next()) {
                            
                            id = rs.getInt("id");
                         }
                        
                        sql2 = "";
                        
                        for (int i = 0; func.getPropriedades_id().size() > i; i++){
                            sql2 = sql2 + " INSERT INTO FUNCIONARIO_PROPRIEDADE VALUES ( " + id + ", " + func.getPropriedades_id().get(i)+") ;";
                        }
                       st.executeUpdate(sql2);
                        
			st.close();
                        st2.close();
			conn.close();
                        conn2.close();
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
                    Connection conn2;
                    Connection conn3;
                    conn = newConnection();
                    conn2 = newConnection();
                    conn3 = newConnection();
                    Statement st = conn.createStatement();
                    Statement st2 = conn.createStatement();
                    Statement st3 = conn.createStatement();
                    String sql = "UPDATE funcionario" +
                                 "   SET nome='"+func.getNome()+"', cpf='"+func.getCpf()+"', dt_nasc='"+func.getDt_nasc()+"', " +
                                 "cargo_id = "+func.getCargo_id()+", grupo_id = " + func.getGrupo_id()+
                                 " WHERE id='"+func.getId()+"';";
                    
                    String sql2 = "DELETE FROM FUNCIONARIO_PROPRIEDADE WHERE FUNCIONARIO_ID = "+ func.getId();
                    String sql3 = "";
                    for (int i = 0; func.getPropriedades_id().size() > i; i++){
                        sql3 = sql3 + " INSERT INTO FUNCIONARIO_PROPRIEDADE VALUES ( " + func.getId() + ", " + func.getPropriedades_id().get(i)+") ;";
                    }
                    
                    IDAO func_end = new Funcionario_EnderecoDAO(); 
                    Endereco end = func.getEnd();
                    end.setId(func.getId());
                    
                    func_end.alterar(end);
                    st.executeUpdate(sql);
                    st2.executeUpdate(sql2);
                    st3.executeUpdate(sql3);
                    st.close();
                    st2.close();
                    st3.close();
                    conn.close();
                    conn2.close();
                    conn3.close();
                    
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
                    String sql2 = "DELETE FROM FUNCIONARIO_ENDERECO  WHERE FUNCIONARIO_ID = ?;";
                    String sql3 = "DELETE FROM FUNCIONARIO_PROPRIEDADE WHERE FUNCIONARIO_ID = ?;";
                    String sql = "DELETE FROM FUNCIONARIO WHERE ID = ?;";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql2);
                    preparedStatement.setInt(1, func.getId());
                    preparedStatement.executeUpdate();

                    preparedStatement = conn.prepareStatement(sql3);
                    preparedStatement.setInt(1, func.getId());
                    preparedStatement.executeUpdate();

                    
                    preparedStatement = conn.prepareStatement(sql);
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
                        Statement st2 = conn.createStatement();
                        List<EntidadeDominio> funcionarios = new ArrayList<EntidadeDominio>();	
                        List<EntidadeDominio> cargos = new ArrayList<EntidadeDominio>();
                        List<EntidadeDominio> grupos = new ArrayList<EntidadeDominio>();
                        List<EntidadeDominio> propriedades = new ArrayList<EntidadeDominio>();	
                        // Verfica se tem um ID, para que posso efetuar uma consulta especifica se = 0, traz todos
                        if (func.getId() == 0){
				String sql = "SELECT * FROM FUNCIONARIO"; 
				       sql = sql+" JOIN FUNCIONARIO_ENDERECO ON FUNCIONARIO_ID = FUNCIONARIO.ID ORDER BY 1";
				ResultSet rs = st.executeQuery(sql);
				String msg = null;
                                // Caso novo precisa trazer propriedades
                                if(!rs.next()){
                                    Funcionario fun = new Funcionario();
                                    Endereco end = new Endereco();

                                    fun.setId(0);
                                    fun.setNome(null);
                                    fun.setCpf(null);
                                    fun.setDt_nasc(null);
                                    fun.setCargo_id(0);
                                    fun.setGrupo_id(0);

                                    end.setRua(null);
                                    end.setCidade(null);
                                    end.setCep(null);
                                    
                                    IDAO cg = new CargoDAO(); 
                                    IDAO gp = new GrupoDAO(); 
                                    IDAO pp = new PropriedadeDAO(); 

                                    cargos = cg.consultar(entidade);
                                    grupos = gp.consultar(entidade);
                                    propriedades = pp.consultar(entidade);
                                    
                                    fun.setCargos(cargos);
                                    fun.setGrupos(grupos);
                                    fun.setPropiedades(propriedades);
                                    funcionarios.add(fun);


                                }
                                while (rs.next()) {
                                    Funcionario fun = new Funcionario();
                                    Endereco end = new Endereco();

                                    fun.setId(rs.getInt("ID"));
                                    fun.setNome(rs.getString("NOME").trim());
                                    fun.setCpf(rs.getString("CPF").trim());
                                    fun.setDt_nasc(rs.getDate("DT_NASC"));
                                    fun.setCargo_id(rs.getInt("CARGO_ID"));
                                    fun.setGrupo_id(rs.getInt("GRUPO_ID"));

                                    end.setRua(rs.getString("RUA").trim());
                                    end.setCidade(rs.getString("CIDADE").trim());
                                    end.setCep(rs.getString("CEP").trim());
                                  
                                    IDAO cg = new CargoDAO(); 
                                    IDAO gp = new GrupoDAO(); 
                                    IDAO pp = new PropriedadeDAO(); 

                                    cargos = cg.consultar(entidade);
                                    grupos = gp.consultar(entidade);
                                    propriedades = pp.consultar(entidade);
                                    
                                    fun.setCargos(cargos);
                                    fun.setGrupos(grupos);
                                    fun.setPropiedades(propriedades);
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
                                String sql2 = "SELECT PROPRIEDADE_ID"
                                    + " FROM FUNCIONARIO_PROPRIEDADE"
                                    + " WHERE FUNCIONARIO_ID = "+ func.getId()+";";


				ResultSet rs = st.executeQuery(sql);
                                ResultSet rs2 = st2.executeQuery(sql2);
				while (rs.next()) {
                                    Funcionario fun = new Funcionario();
                                    Endereco end = new Endereco();
                                    
                                        
                                    fun.setId(rs.getInt("ID"));
                                    fun.setNome(rs.getString("NOME").trim());
                                    fun.setCpf(rs.getString("CPF").trim());
                                    fun.setDt_nasc(rs.getDate("DT_NASC"));
                                    fun.setCargo_id(rs.getInt("CARGO_ID"));
                                    fun.setGrupo_id(rs.getInt("GRUPO_ID"));
                                    end.setRua(rs.getString("RUA").trim());
                                    end.setCidade(rs.getString("CIDADE").trim());
                                    end.setCep(rs.getString("CEP").trim());
                                    
                                    
                                    while (rs2.next()){
                                        fun.setPropriedades_id(rs2.getInt("PROPRIEDADE_ID"));
                                    }
  
                                    
                                    fun.setEnd(end);
                                    
                                    IDAO cg = new CargoDAO(); 
                                    IDAO gp = new GrupoDAO(); 
                                    IDAO pp = new PropriedadeDAO(); 

                                    cargos = cg.consultar(entidade);
                                    grupos = gp.consultar(entidade);
                                    propriedades = pp.consultar(entidade);
                                    
                                    fun.setCargos(cargos);
                                    fun.setGrupos(grupos);
                                    fun.setPropiedades(propriedades);
                                    
                                    funcionarios.add(fun);
					
				}
                                                                  
                                rs2.close();
                                st2.close();
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

