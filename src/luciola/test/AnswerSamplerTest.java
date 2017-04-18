package luciola.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import luciola.data.wrangling.AnswerSampler;
import luciola.data.wrangling.AnswerSampler.TrainingTestingPair;

public class AnswerSamplerTest {

	@Test
	public void test() {
		AnswerSampler sampler = new AnswerSampler();
		
		String fileName = "C://Users//chris//OneDrive//Documentos//GitHub//luciola-utility//src//luciola//data//answerList_photinus_data.csv";
		
		int trainingSize = new Double(2579).intValue();
		ArrayList<TrainingTestingPair> pairList = sampler.generateTrainingTestingSets(trainingSize, 2,fileName);
	
		TrainingTestingPair pair_1 = pairList.get(0);
		System.out.println(pair_1.testingMap.size());
		
		TrainingTestingPair pair_2 = pairList.get(1);
		System.out.println(pair_2.trainingMap.size());	
	
		Iterator<String> keys = pair_1.testingMap.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			Assert.assertFalse("Pair 2 contains:"+key,pair_2.testingMap.containsKey(key));
		}
	
	}

}
