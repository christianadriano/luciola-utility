package luciola.entity;

public class Question {

	Integer loc;
	Integer complexity; //Cyclomatic Complexity
	
	String JavaMethod;
	String ID;
	public Question(String iD, String javaMethod, Integer loc, Integer complexity) {
		
		this.loc = loc;
		this.complexity = complexity;
		JavaMethod = javaMethod;
		ID = iD;
	}
	
	
}
