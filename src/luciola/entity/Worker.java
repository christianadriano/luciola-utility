package luciola.entity;

/** 
 * Represents a worker and her attributes (e.g., profession, age, etc.)
 * @author Christian Adriano
 *
 */
public class Worker {

	String workerID=null;
	String workerScore=null;
	String workerProfession=null;
	String yearsOfExperience=null;
	String age=null;
	String gender=null;
	String whereLearnedToCode=null;
	String country=null;
	String programmingLanguage=null;
	
	public Worker(String workerID, String workerScore, String workerProfession, String yearsOfExperience, String age,
			String gender, String whereLearnedToCode, String country, String programmingLanguage) {
		super();
		this.workerID = workerID;
		this.workerScore = workerScore;
		this.workerProfession = workerProfession;
		this.yearsOfExperience = yearsOfExperience;
		this.age = age;
		this.gender = gender;
		this.whereLearnedToCode = whereLearnedToCode;
		this.country = country;
		this.programmingLanguage = programmingLanguage;
	}

	
}
