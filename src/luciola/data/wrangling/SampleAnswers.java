package luciola.data.wrangling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import luciola.entity.Answer;

/**
 * Sample answers to serve as training and testing sets
 * Testing set is also called hold-out set.
 * 
 * @author Christian Adriano
 *
 */
public class SampleAnswers {

	public class TrainingTestingPair{
		
		public HashMap<String,Answer> trainingMap = new HashMap<String,Answer>();
		public HashMap<String,Answer> testingMap = new HashMap<String,Answer>();
	
	}
	
	
	/** 
	 * Generate pairs of samples corresponding to training and testing sets.  
	 * @param partitionSize Size of the training set. The testing set is just the remaining of the items 
	 * are not part of the training set.
	 * @param numberOfSamples how many pairs of training and testing sets.
	 */
	public ArrayList<TrainingTestingPair> generateTrainingTestingSets(int trainingSize, int numberOfSamples){
	
		WorkerAnswerLoader loader = new WorkerAnswerLoader();
		loader.run();
		
		if(trainingSize>loader.answerMap.size())
			return null;
		
		Random generator = new Random();
		Answer[] answerList = (Answer[]) loader.answerMap.keySet()().toArray();
		
		Answer randomAnswer = answerList[generator.nextInt(values.length)];
		
	}
	
}
