package luciola.data.wrangling;

import java.util.ArrayList;
import java.util.HashMap;

import luciola.util.ReadWriteFile;

/** 
 * Partitions the files based JavaMethod or Worker profession
 *
 * @author Christian Adriano
 *
 */
public class FilePartitioner {

	public static String FAILING_METHOD ="FailingMethod";
	public static String WORKER_PROFESSION ="Worker.profession";
	
	public HashMap<String, ArrayList<String>> partitionByHeader(String fileName, String headerName){

		HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

		ArrayList<String> lineList = ReadWriteFile.readToBuffer(fileName);

		String[] headerLine = lineList.get(0).split(",");
		int columnNumber=0;
		for(String header:headerLine){
			if(header.matches(headerName))
				break;
			else
				columnNumber++;
		}

		//Skip first line (header)
		lineList.remove(0);
		for(String line:lineList){
			String[] fields = line.split(",");
			String javaMethod = fields[columnNumber];
			ArrayList<String> lines = new ArrayList<String>();
			if(map.containsKey(javaMethod)){
				lines = map.get(javaMethod);
			}
			else{
				lines.add(line);
				map.put(javaMethod, lines);
			}
		}
		return map;
	}
	
	
	
}



