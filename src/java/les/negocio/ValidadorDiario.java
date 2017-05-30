package les.negocio;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import les.dao.impl.HistoricoDAO;
import les.dao.impl.MeteorologiaDAO;
import les.dao.impl.TalhaoDAO;
import les.dominio.*;
import les.util.FormataString;import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
;

public class ValidadorDiario implements IStrategy{
	public String processar(EntidadeDominio entidade) {
		Diario diario = (Diario)entidade;
            try {
                
                HistoricoDAO hs = new HistoricoDAO();
                
                Historico hist = new Historico();
                hist = proecessarWeka(diario);
                hs.salvar(hist);
                
            } catch (Exception ex) {
                Logger.getLogger(ValidadorDiario.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
		return null;
	}
        
        public Historico proecessarWeka(EntidadeDominio entidade) throws Exception {
            Diario diario = (Diario)entidade;
            
            Talhao talhao = diario.getTalhao();
            TalhaoDAO tlhDAO = new TalhaoDAO();
            List<EntidadeDominio> talhoes = tlhDAO.consultar(talhao);
            Talhao tlh = (Talhao)talhoes.get(0);
            
            Cultura cultura = tlh.getCultura();
            ArrayList<Doenca> doencas = cultura.getDoencas();
            
            String filePath = "/home/gustavo/Documents/weka/";
            int y =0;
            //perguntas por doenca
            for(Doenca dd: doencas){
                dd.setRespostas(talhao.getCultura().getDoencas().get(y).getRespostas());
                
                // caminho do arquivo
                ConverterUtils.DataSource ds = new ConverterUtils.DataSource(filePath + dd.getArquivo());
                Instances ins = ds.getDataSet();
                
                String chuva = null;
                NumberFormat nf = new DecimalFormat("#.####");
                List<EntidadeDominio> mets = new ArrayList<EntidadeDominio>();
                MeteorologiaDAO metDAO = new MeteorologiaDAO();
                Meteorologia met = new Meteorologia();
                int totalCol = dd.perguntasDoencas().size() + 3;
                
                met.setId(talhao.getId());
                mets = metDAO.consultar(met);
                met = (Meteorologia)mets.get(0);
                
                if(met.getMm_chuva() > 0){
                    chuva = "Sim";
                }else{
                    chuva="Nao";
                }
                
                ins.setClassIndex(totalCol);
                Double d = met.getTemperatura();
                //temperatura
                String temp = nf.format(d);
                NaiveBayes nb = new NaiveBayes();
                nb.buildClassifier(ins);
                Instance novo = new DenseInstance(totalCol + 1);
                novo.setDataset(ins);
                // temperatura
                novo.setValue(0, temp);
                //umidade
                novo.setValue(1, Integer.toString(met.getUmidade()));
                //chuva
                novo.setValue(3, chuva);
                //perguntas user
                int i = 4;
                for(String pp: dd.getRespostas()){
                    novo.setValue(i, pp);
                    i++;        
                }

                double probabilidade[] = nb.distributionForInstance(novo);

                Date date = new Date();

                //hist.setData(date);
                int pct = (int) Math.round(probabilidade[0] * 100);
                dd.setPct_doenca(pct);
                

                //Talhao tlh = hist.getTalhao();
                //tlh.setId(diario.getId());

                //hist.setTalhao(tlh);
                y++;
            }
            diario.getTalhao().getCultura().setDoencas(doencas);
            Date date = new Date();
            Historico hist = new Historico();
            hist.setTalhao(tlh);
            hist.setData(date);


  
            
            return hist;
            
        }
        

}
