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
            ConverterUtils.DataSource ds = new ConverterUtils.DataSource("/home/gustavo/teste-doenca-weka.arff");
            Instances ins = ds.getDataSet();
            String mancha;
            String chuva;
            Historico hist = new Historico();
            
            NumberFormat nf = new DecimalFormat("#.####");
            List<EntidadeDominio> mets = new ArrayList<EntidadeDominio>();
            MeteorologiaDAO metDAO = new MeteorologiaDAO();
            Meteorologia met = new Meteorologia();
            met.setId(diario.getTalhao().getId());
            mets = metDAO.consultar(met);
            met = (Meteorologia)mets.get(0);
            ins.setClassIndex(4);
            
            if(diario.isApresenta_mancha()){
                mancha = "Nao";
            }else{
                mancha = "Sim";
            }
            
            if(met.getMm_chuva() > 0){
                chuva = "Sim";
            }else{
                chuva="Nao";
            }
            Double d = met.getTemperatura();
            String temp = nf.format(d);
            
            NaiveBayes nb = new NaiveBayes();
            nb.buildClassifier(ins);

            Instance novo = new DenseInstance(5);
            novo.setDataset(ins);
            // temperatura
            novo.setValue(0, temp);
            //umidade
            novo.setValue(1, Integer.toString(met.getUmidade()));
            //manchas
            novo.setValue(2, mancha);
            //chuva
            novo.setValue(3, chuva);
            double probabilidade[] = nb.distributionForInstance(novo);
            
            Date date = new Date();
            
            hist.setData(date);
            hist.setPct_doenca((int) Math.round(probabilidade[0] * 100));
            
            Talhao tlh = hist.getTalhao();
            tlh.setId(diario.getId());
            
            hist.setTalhao(tlh);
            
            return hist;
            
        }
        

}
