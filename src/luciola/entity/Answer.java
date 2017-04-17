package luciola.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** 
 * Answer provided by a worker
 * @author Christian Adriano
 *
 */
public class Answer {
	
	public String ID; //unique identifier (produced by a sequence counter while uploading the file)
	public String option;
	public int confidenceOption;
	public String explanation;
	public String workerId;
	public String elapsedTime; // duration of the answer in milliseconds
	public String timeStamp;
	public int difficulty;
	public int orderInWorkerSession; //1=first, 2=second, 3=third
	public String sessionID; //the session in which the answer was produced (3 answers per session)
	public Date timeStampDate;

	public String TP;
	public String TN;
	public String FN;
	public String FP;
	
	public Worker worker; //worker who produced the answer 

	public Answer(String ID, String option, int confidenceOption, String explanation, String workerId, 
			String elapsedTime, String timeStamp, int difficulty, int orderInWorkerSession, 
			String sessionID, Worker worker, String TP, String TN, String FN, String FP){
		
		this.ID = ID;
		this.option = option;
		this.confidenceOption = confidenceOption;
		this.explanation = explanation;
		this.workerId = workerId;
		this.elapsedTime = elapsedTime;
		this.timeStamp = timeStamp;
		this.difficulty = difficulty;
		this.orderInWorkerSession = orderInWorkerSession;
		this.sessionID = sessionID; //So we know from which session this answer came (3 answers per session)
		
		this.TP = TP;
		this.TN = TN;
		this.FN = FN;
		this.FP = FP;
		
		this.timeStampDate = convertDateTime(timeStamp);
		if(timeStampDate!=null)
			this.timeStamp = timeStamp;
	}

	private Date convertDateTime(String tStamp){
		
		Date dateStamp= null;
		if(tStamp!=null && tStamp.length()>0){

//			System.out.println(tStamp);

			DateFormat format = new SimpleDateFormat("EEE yyyy MMM dd HH:mm:ss.S", Locale.ENGLISH);
			try {
				dateStamp = format.parse(tStamp);
				//System.out.println("converted:"+ format.format(dateStamp));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dateStamp;
	}

}
