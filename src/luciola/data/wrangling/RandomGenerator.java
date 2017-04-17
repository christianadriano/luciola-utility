package luciola.data.wrangling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

/**
 * Generate unique N numbers within a range
 * 
 * @author Christian Adriano
 *
 */
public class RandomGenerator {

	public static ArrayList<Integer>runUnique(int range){

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=range; i++) {
			list.add(new Integer(i));
		}
		Collections.shuffle(list);
		
		return list;
	}
	
	public static Stack<Integer>runUniqueNonContiguous(int size, int range){

		Random generator = new Random(System.currentTimeMillis());
		
		HashMap<Integer,Integer> randomNumbersMap = new HashMap<Integer,Integer>();
		while(randomNumbersMap.size()<size){
			int number = generator.nextInt(range);
			randomNumbersMap.put(number,number);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for(Integer key : randomNumbersMap.keySet()){
			stack.push(key);
		}
		
//		for(Integer number:stack){
//			System.out.print(number+",");
//		}
		
		return stack;
	}
	
	//----------------------------------------------
	public static void main(String[] args){
		runUnique(10);
		runUniqueNonContiguous(10,30);
	}
}
