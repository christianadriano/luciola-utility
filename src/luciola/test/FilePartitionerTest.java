package luciola.test;

import static org.junit.Assert.*;

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

}
