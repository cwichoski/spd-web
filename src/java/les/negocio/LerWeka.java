/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import les.dominio.Arquivo;
import les.dominio.EntidadeDominio;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;

/**
 *
 * @author giter
 */
public class LerWeka implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        Arquivo arq = (Arquivo)entidade;
        String path = "/home/gustavo/Documents/weka/";
        String full_path = path + arq.getNomeDoArquivo();
        List<String> nm_att = new ArrayList<String>();
        int qt_att = 0;
        
        String s = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                new FileReader(full_path)
            );
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ArffReader arff = null;
        try {
            arff = new ArffReader(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Instances data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
        int num_atributos = data.numAttributes() - 1;
        
        for(int i= 3; i< num_atributos; i++){
        // o indice começa no três, pois os atributos anteriores são fixados pelo sistema
            if(data.attribute(i).isNominal()){
                qt_att++;
                nm_att.add(data.attribute(i).name().toString());
                
            }
        }
        
        arq.setAtributos_weka(nm_att);
        arq.setQt_perguntas(qt_att);
        
        return null;
    }
    
    
}
