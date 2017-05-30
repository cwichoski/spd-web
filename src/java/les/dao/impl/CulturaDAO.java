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
            Cultura cultura = (Cultura)entidade;

            try {
                Connection conn;
                Connection conn2;
                conn = newConnection();
                conn2 = newConnection();
                int doenca_id;
                Statement st = conn.createStatement();
                Statement st2 = conn2.createStatement();
                String sql = null;
                String sql2 = null;
                
                
                DoencaDAO doencaDAO = new DoencaDAO();
                ArrayList<Doenca> doencas = new ArrayList<Doenca>();

                
                if(cultura.getId() != 0){
                    sql = "SELECT * FROM CULTURA WHERE ID = "+cultura.getId() +";";
                    sql2 = "SELECT DOENCA.ID FROM CULTURA_DOENCA JOIN DOENCA ON DOENCA.ID = CULTURA_DOENCA.DOENCA_ID WHERE CULTURA_DOENCA.CULTURA_ID = "+cultura.getId() +";";
                }else{
                    sql = "SELECT * FROM CULTURA ;";
                    sql2 = "SELECT DOENCA.ID FROM CULTURA_DOENCA JOIN DOENCA ON DOENCA.ID = CULTURA_DOENCA.DOENCA_ID";
                }
                
                ResultSet rs = st.executeQuery(sql); 
                ResultSet rs2 = st2.executeQuery(sql2); 

                while (rs.next()) {
                    int i = 0;
                    Cultura cgo = new Cultura();
                    

                    cgo.setId(rs.getInt("ID"));
                    cgo.setDescricao(rs.getString("DESCRICAO").trim());
                    //if(cultura.getId() != 0){
                        while (rs2.next()) {
                            
                            Doenca doenca = new Doenca();
                            List<EntidadeDominio> dncas = new ArrayList<EntidadeDominio>();
                            if(cultura.getDoencas() != null){
                                doenca = cultura.getDoencas().get(0);
                            }
                            doenca.setId(rs2.getInt("ID"));
                            dncas = doencaDAO.consultar(doenca);
                            doencas.add((Doenca)dncas.get(0));
                            
                        }
                        cgo.setDoencas(doencas);
                    //}
                    doenca_id = rs.getInt("CULTURA_DOENCA_ID");
                    culturas.add(cgo);
                    
                }


                st.close();
                st2.close();
                conn.close();
                conn2.close();
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
