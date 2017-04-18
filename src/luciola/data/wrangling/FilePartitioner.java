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

	/**
	 * Given a header name (title of column), extract of the all corresponding lines
	 * @param fileName to be read from
	 * @param headerName title of the column from which to make the selection
	 * @return
	 */
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
			lines.add(line);
			map.put(javaMethod, lines);
		}
		return map;
	}

	/**
	 * Each map key correspond to a set of lines which go to one same file.
	 * 
	 * @param path the folder where to write the files. The files names will be the same as the keys from the map
	 * @param map
	 */
	public void writeMapToFiles(String path,HashMap<String, ArrayList<String>>map){

		for(String key:map.keySet()){
			ArrayList<String> lines = map.get(key);
			ReadWriteFile.writeBackToBuffer(lines, path+"\\"+key+".csv");
		}
	}
	

}



