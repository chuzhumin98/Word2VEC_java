package test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Result {
	public double mode1; //模1
	public double mode2; //模2
	public double similar; //相似度
	public Result(double mode1, double mode2, double similar) {
		this.mode1 = mode1;
		this.mode2 = mode2;
		this.similar = similar;
	}
	public String toString() {
		String tmp = "mode1:"+this.mode1+" mode2:"+this.mode2+" similar:"+this.similar;
		return tmp;
	}
}
public class CompareResult {
	Map<String,Result> maps = new HashMap<String,Result>();
	public void compareResult(File file1, File file2) {
		try {
			Scanner input1 = new Scanner(file1);
			Scanner input2 = new Scanner(file2);
			int words = input1.nextInt();
			int size = input1.nextInt();
			size = input2.nextInt();
			size = input2.nextInt();
			double vector = 0;

			String key = null;
			double[] value = null;
			for (int i = 0; i < words; i++) {
				double len1 = 0;
				input1.nextLine(); //空行			
				key = input1.nextLine();
				double[] vec1 = new double [size];
				//System.out.println(key);
				for (int j = 0; j < size; j++) {
					vector = input1.nextDouble();
					vec1[j] = vector;
					len1 += vector * vector;
				}
				len1 = Math.sqrt(len1);
				
				double len2 = 0;
				input2.nextLine(); //空行			
				key = input2.nextLine();
				double[] vec2 = new double [size];
				//System.out.println(key);
				for (int j = 0; j < size; j++) {
					vector = input2.nextDouble();
					vec2[j] = vector;
					len2 += vector * vector;
				}
				len2 = Math.sqrt(len2);
				
				double theta = 0;
				for (int j = 0; j < size; j++) {
					theta += vec1[j] * vec2[j];
				}
				theta = theta / len1 / len2;
				Result result = new Result(len1, len2, theta);
				this.maps.put(key, result);
			}

		} catch (Exception e){
			System.out.println("some error happened!");
		}
		System.out.println("complete create hashmap!");
	}
	
	public static void main(String[] args) {
		CompareResult cr = new CompareResult();
		cr.compareResult(new File("library/Cbow_data"), new File("library/CbowNew_data"));
		System.out.println(cr.maps.get("穆里尼奥"));
		System.out.println(cr.maps.get("封建王朝"));
		System.out.println(cr.maps.get("张飞"));
		System.out.println(cr.maps.get("巴塞罗那"));
		System.out.println(cr.maps.get("数学"));
		System.out.println(cr.maps.get("北京"));
	}
}
