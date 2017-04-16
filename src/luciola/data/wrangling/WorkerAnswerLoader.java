/**
 * 
 */
package luciola.data.wrangling;

import luciola.entity.Answer;
import luciola.entity.Worker;
import luciola.entity.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Loads answers from workers that are stored in CSV File
 * 
 * @author Christian Adriano
 *
 */
public class WorkerAnswerLoader {

	/** Map of answers. The key is a unique identifier corresponding to a sequential counter) */
	public HashMap<String,Answer> answerMap = new HashMap<String,Answer>();

	/** Map of workers. The key is a unique identifier of the worker */
	public HashMap<String,Worker> workerMap = new HashMap<String,Worker>();
	
	/**Map of tasks. The key is a unique identifier of the task */
	public HashMap<String, Question> questionMap = new HashMap<String, Question>();
	

	/** 
	 * Load all lines of file into and Array of Strings 
	 * @return ArrayList where each element has the content of a line in the file
	 */
	public  ArrayList<String> readToBuffer(String path, String sourceFileName){

		ArrayList<String> buffer = new ArrayList<String>();

		BufferedReader log;
		try {
			log = new BufferedReader(new FileReader(path +sourceFileName));
			String line = null;
			while ((line = log.readLine()) != null) {
				buffer.add(line);
			}
			log.close();
			return buffer;
		} 
		catch (Exception e) {
			System.out.println("ERROR while processing file:" + path+sourceFileName);
			e.printStackTrace();
			return null;
		}
	}


	private void run() {

		ArrayList<String> lineList = this.readToBuffer("C://firefly//","answerList_data.csv");	
		for(String line: lineList){
			String[] tokenized = line.split(",");
			String counterStr=tokenized[0];
			String sessionID=tokenized[1];
			String javaMethod=tokenized[2];
			String questionID=tokenized[3];
			String durationStr=tokenized[4];
			String timestampStr=tokenized[5];
			String confidence=tokenized[6];
			String difficulty=tokenized[7];
			String TP=tokenized[8];
			String TN=tokenized[9];
			String FN=tokenized[10];
			String FP=tokenized[11];
			String answerOption=tokenized[12];
			String answerOrder=tokenized[13];
			String explanation=tokenized[14];
			String loc=tokenized[15];
			String complexity=tokenized[16];

			String workerID=tokenized[17];
			Worker worker=null;
			
			if(!workerMap.containsKey(workerID)){
				
				String workerScore=tokenized[18];
				String workerProfession=tokenized[19];
				String yearsOfExperience=tokenized[20];
				String age=tokenized[21];
				String gender=tokenized[22];
				String whereLearnedToCode=tokenized[23];
				String country=tokenized[24];
				String programmingLanguage = tokenized[25];
				worker = new Worker(workerID, workerScore, workerProfession, yearsOfExperience,age,
						gender,  whereLearnedToCode, country, programmingLanguage);
				workerMap.put(workerID, worker);
			}
			else{
				worker = this.workerMap.get(workerID);
			}
			
			Answer answer = new Answer(answerOption, new Integer(confidence), explanation, workerID, 
					durationStr, timestampStr, new Integer(difficulty), new Integer(answerOrder), sessionID, 
					worker);

			answerMap.put(counterStr,answer);

			Question question=null;
			if(!questionMap.containsKey(questionID)){
				question =  new Question(questionID, javaMethod, new Integer(loc), new Integer(complexity));
				questionMap.put(questionID, question);
			}
			
		}

	}



	public static void main(String[] args){
		WorkerAnswerLoader loader = new WorkerAnswerLoader();
		loader.run();
	}


}
