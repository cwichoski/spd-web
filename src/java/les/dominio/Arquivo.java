/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class Arquivo extends EntidadeDominio{
    private int doenca_id;
    private int qt_perguntas;
    private String nomeDoArquivo;
    private List<String> atributos_weka = new ArrayList<String>();
    
    public List<String> getAtributos_weka() {
        return atributos_weka;
    }

    public void setAtributos_weka(List<String> atributos_weka) {
        this.atributos_weka = atributos_weka;
    }


    public int getQt_perguntas() {
        return qt_perguntas;
    }

    public void setQt_perguntas(int qt_perguntas) {
        this.qt_perguntas = qt_perguntas;
    }
    
    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public int getDoenca_id() {
        return doenca_id;
    }

    public void setDoenca_id(int doenca_id) {
        this.doenca_id = doenca_id;
    }
    
    public void upload(String pasta, String nomeDoArquivo,
        InputStream arquivoCarregado) throws FileNotFoundException {
        String caminhoArquivo = pasta + "/" + nomeDoArquivo;
        File novoArquivo = new File(caminhoArquivo);
        FileOutputStream saida = new FileOutputStream(novoArquivo);
        copiar(arquivoCarregado, saida);
    }
    
    private void copiar(InputStream origem, OutputStream destino){
        int bite = 0;
        byte[] tamanhoMaximo = new byte[1024 * 500]; // 500KB
        try {
            // enquanto bytes forem sendo lidos
            while((bite = origem.read(tamanhoMaximo)) >= 0) {
            // pegue o byte lido e escreva no destino
            destino.write(tamanhoMaximo, 0, bite);
           }
        }
        catch(IOException e) {
           // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
