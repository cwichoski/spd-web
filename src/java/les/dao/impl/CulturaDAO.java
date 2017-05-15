package les.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import les.dominio.Cultura;
import les.dominio.Doenca;

import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Funcionario;

public class CulturaDAO extends PostgresDAO{
    public boolean salvar(EntidadeDominio entidade) {
        return false;
    }


    public boolean excluir(EntidadeDominio entidade) {
            // TODO Auto-generated method stub
            return false;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
            ArrayList<EntidadeDominio> culturas = new ArrayList<EntidadeDominio>();			            
            try {
                Connection conn;
                conn = newConnection();
                int doenca_id;
                Statement st = conn.createStatement();


                String sql = "SELECT * FROM CULTURA ;";
                ResultSet rs = st.executeQuery(sql); 


                while (rs.next()) {
                    
                    Cultura cgo = new Cultura();
                    
                    
                    cgo.setId(rs.getInt("ID"));
                    cgo.setDescricao(rs.getString("DESCRICAO").trim());
                    doenca_id = rs.getInt("CULTURA_DOENCA_ID");
                    culturas.add(cgo);
                    
                }


                st.close();
                conn.close();
                return culturas;

            }catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Erro de SQL");
                    return null;
            }

    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}
