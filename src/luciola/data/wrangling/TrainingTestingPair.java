package luciola.data.wrangling;

import java.util.HashMap;
import luciola.entity.Answer;

public class TrainingTestingPair {

	public HashMap<String,Answer> trainingMap = new HashMap<String,Answer>();
	public HashMap<String,Answer> testingMap = new HashMap<String,Answer>();

	public HashMap<String,Double> professionAccuracyMap = new HashMap<String,Double>();
	
}

