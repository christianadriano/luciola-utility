package luciola.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Utility class to read the contents of a file in to an ArrayList of Strings.
 * Also write back to file the content in an ArrayList of Strings.
 * 
 * @author Christian Adriano
 */
public class ReadWriteFile {

	/** 
	 * Load all lines of file into and Array of Strings 
	 * @return ArrayList where each element has the content of a line in the file
	 */
	public static ArrayList<String> readToBuffer(String sourceFileName){

		ArrayList<String> buffer = new ArrayList<String>();

		BufferedReader log;
		try {
			log = new BufferedReader(new FileReader(sourceFileName));
			String line = null;
			while ((line = log.readLine()) != null) {
				buffer.add(line);
			}
			log.close();
			return buffer;
		} 
		catch (Exception e) {
			System.out.println("ERROR while processing file:" +sourceFileName);
			e.printStackTrace();
			return null;
		}
	}
	
	
	/** 
	 * Flush the buffer back to the file
	 * @param destFileName the name of file that will receive the content of the buffer
	 * @param newBuffer
	 * @param destFileName
	 */
	public static void writeBackToBuffer(ArrayList<String> newBuffer, String destFileName){

		BufferedWriter log;
		try {
			log = new BufferedWriter(new FileWriter(destFileName));
			for(String line : newBuffer)
				log.write(line+"\n");
			log.close();
			System.out.println("File written at:"+destFileName);
		} 
		catch (Exception e) {
			System.out.println("ERROR while processing file:" + destFileName);
			e.printStackTrace();
		}
	}
}
