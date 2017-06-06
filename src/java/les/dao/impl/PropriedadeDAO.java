/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import les.dominio.Cargo;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Propriedade;

/**
 *
 * @author gustavo
 */
public class PropriedadeDAO extends PostgresDAO{
    public boolean salvar(EntidadeDominio entidade) {
        return false;
    }


    public boolean excluir(EntidadeDominio entidade) {
            // TODO Auto-generated method stub
            return false;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
            ArrayList<EntidadeDominio> propriedades = new ArrayList<EntidadeDominio>();			            
            try {
                Connection conn;
                conn = newConnection();

                Statement st = conn.createStatement();


                String sql = "SELECT * FROM PROPRIEDADE ;";
                ResultSet rs = st.executeQuery(sql); 
              

                while (rs.next()) {
                    Propriedade prop = new Propriedade();
                    Endereco end = new Endereco();
                    
                    prop.setId(rs.getInt("ID"));
                    prop.setDescricao(rs.getString("DESCRICAO").trim());
                    end.setRua(rs.getString("RUA").trim());
                    end.setCidade(rs.getString("CIDADE").trim());
                    end.setCep(rs.getString("CEP").trim());
                    prop.setEstado(rs.getString("ESTADO").trim());
                    prop.setNumero(rs.getInt("NUMERO"));
                    prop.setEnd(end);
                    propriedades.add(prop);

                } 


                st.close();
                conn.close();
                return propriedades;

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
