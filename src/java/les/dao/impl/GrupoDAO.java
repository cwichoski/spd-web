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
import les.dominio.EntidadeDominio;
import les.dominio.Grupo;

/**
 *
 * @author gustavo
 */
public class GrupoDAO extends PostgresDAO{
        public boolean salvar(EntidadeDominio entidade) {
        return false;
    }


    public boolean excluir(EntidadeDominio entidade) {
            // TODO Auto-generated method stub
            return false;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
            ArrayList<EntidadeDominio> grupos = new ArrayList<EntidadeDominio>();			            
            try {
                Connection conn;
                conn = newConnection();

                Statement st = conn.createStatement();


                String sql = "SELECT * FROM GRUPO ;";
                ResultSet rs = st.executeQuery(sql); 


                while (rs.next()) {
                    Grupo gp = new Grupo();

                    gp.setId(rs.getInt("ID"));
                    gp.setDescricao(rs.getString("DESCRICAO").trim());
                    grupos.add(gp);

                }


                st.close();
                conn.close();
                return grupos;

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
