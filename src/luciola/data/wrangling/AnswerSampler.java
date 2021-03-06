package luciola.data.wrangling;

import luciola.data.wrangling.TrainingTestingPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import luciola.entity.Answer;
import luciola.util.RandomGenerator;

/**
 * Sample answers to serve as training and testing sets
 * Testing set is also called hold-out set.
 * 
 * @author Christian Adriano
 *
 */
public class AnswerSampler {

	


	/** 
	 * Generate pairs of samples corresponding to training and testing sets.  
	 * @param partitionSize Size of the training set. The testing set is just the remaining of the items 
	 * are not part of the training set.
	 * @param numberOfSamples how many pairs of training and testing sets.
	 */
	public ArrayList<TrainingTestingPair> generateTrainingTestingSets(int trainingSize, int numberOfSamples, String fileName){

		WorkerAnswerLoader loader = new WorkerAnswerLoader();
		loader.run(fileName);

		if(trainingSize>loader.answerMap.size())
			return null;

		ArrayList<TrainingTestingPair> pairList= new ArrayList<TrainingTestingPair>();

		for(int i=0;i<numberOfSamples;i++){

			HashMap<String,Answer> trainingMap = new HashMap<String,Answer>();
			HashMap<String,Answer> testingMap = (HashMap<String, Answer>) loader.answerMap.clone();
			
			List<Answer> answerList = new ArrayList<Answer>(loader.answerMap.values());
			
			Stack<Integer> stack = RandomGenerator.runUniqueNonContiguous(trainingSize, loader.answerMap.size());
			
			for(Integer randomIndex:stack){
				
				Answer randomAnswer = answerList.get(randomIndex);
				trainingMap.put(randomAnswer.ID, randomAnswer);
				
				testingMap.remove(randomAnswer.ID);
				System.out.println("randomAnswerRemoved="+randomAnswer.ID);
			}

			TrainingTestingPair pair = new TrainingTestingPair();
			pair.testingMap=(HashMap<String, Answer>) testingMap.clone();
			pair.trainingMap=(HashMap<String, Answer>) trainingMap.clone();

			pairList.add(pair);
		}
		return pairList;
	}

	
	

}
