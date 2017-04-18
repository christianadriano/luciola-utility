package luciola.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import luciola.data.wrangling.FilePartitioner;

public class FilePartitionerTest {

	@Test
	public void testFailingMethodMap() {

		String fileName = "C://Users//chris//OneDrive//Documentos//GitHub//luciola-utility//src//luciola//data//answerList_photinus_data.csv";

		FilePartitioner partitioner =  new FilePartitioner();
		HashMap<String, ArrayList<String>> map = partitioner.partitionByHeader(fileName, FilePartitioner.FAILING_METHOD);

		Assert.assertTrue("Size expected=8, actual size="+map.size(),map.size()==8);
	}

	@Test
	public void testWorkerProfessiondMap() {

		String fileName = "C://Users//chris//OneDrive//Documentos//GitHub//luciola-utility//src//luciola//data//answerList_photinus_data.csv";

		FilePartitioner partitioner =  new FilePartitioner();
		HashMap<String, ArrayList<String>> map = partitioner.partitionByHeader(fileName, FilePartitioner.WORKER_PROFESSION);

		Assert.assertTrue("Size expected=5, actual size="+map.size(),map.size()==5);
	}

	@Test
	public void testWriteMapToFilesExist() {

		String path ="C://Users//chris//OneDrive//Documentos//GitHub//luciola-utility//src//luciola//data//";

		String fileName = "answerList_photinus_data.csv";

		FilePartitioner partitioner =  new FilePartitioner();
		HashMap<String, ArrayList<String>> map = partitioner.partitionByHeader(path+fileName, FilePartitioner.WORKER_PROFESSION);
		partitioner.writeMapToFiles(path, map);

		String[] professionList ={"Professional_Developer","Graduate_Student","Undergraduate_Student","Hobbyist","Other"};

		for(String profession:professionList){
			String name = path+profession+".csv";
			File f = new File(name);
			Assert.assertTrue("File "+ name+" not found",f.exists() && !f.isDirectory());
		}
		
	}
	
	 

}
