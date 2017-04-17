package luciola.data.wrangling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import luciola.entity.Answer;

/**
 * Sample answers to serve as training and testing sets
 * Testing set is also called hold-out set.
 * 
 * @author Christian Adriano
 *
 */
public class AnswerSampler {

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

		ArrayList<TrainingTestingPair> pairList= new ArrayList<TrainingTestingPair>();

		for(int i=0;i<numberOfSamples;i++){

			HashMap<String,Answer> trainingMap = new HashMap<String,Answer>();
			HashMap<String,Answer> testingMap = (HashMap<String, Answer>) loader.answerMap.clone();
			
			Random generator = new Random(System.currentTimeMillis());
			List<Answer> answerList = new ArrayList<Answer>(loader.answerMap.values());
			int j=0;
			while(j<trainingSize){
				j++;
			
				int randomIndex = new Random().nextInt(answerList.size());
				
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

	
	//-----------------------------------------------------
	public static void main(String[] args){

		
		
		
	}

}
