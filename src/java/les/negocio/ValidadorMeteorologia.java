package les.negocio;

import les.dao.impl.MeteorologiaDAO;
import les.dominio.*;
import les.util.FormataString;import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
;

public class ValidadorMeteorologia implements IStrategy{
	public String processar(EntidadeDominio entidade) {
		Diario diario = (Diario)entidade;
		
                
                
		return null;
	}
        
        public int proecessarWeka() throws Exception {
            
            ConverterUtils.DataSource ds = new ConverterUtils.DataSource("src/teste/teste-doenca-weka.arff");
            Instances ins = ds.getDataSet();
            MeteorologiaDAO metDAO = new MeteorologiaDAO();
            
            

            ins.setClassIndex(4);

            NaiveBayes nb = new NaiveBayes();
            nb.buildClassifier(ins);

            Instance novo = new DenseInstance(5);
            novo.setDataset(ins);
            // temperatura
            novo.setValue(0, "25");
            //umidade
            novo.setValue(1, "91");
            //manchas
            novo.setValue(2, "Nao");
            //chuva
            novo.setValue(3, "Nao");

            
            double probabilidade[] = nb.distributionForInstance(novo);
            return (int) Math.round(probabilidade[0] * 100);
        }
        

}
