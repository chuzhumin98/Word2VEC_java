package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.ansj.vec.domain.Neuron;
import com.ansj.vec.domain.WordNeuron;
import com.ansj.vec.util.MapCount;

public class WordFrequency {
	int wordsCount = 0; //共加载的词的数量
    Map<String,Integer> map = new HashMap<String,Integer>();
    Map<String,Double> modeMap = new HashMap<String,Double>();
    public void countFreq(File file) throws IOException {    	
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(file)))) {
            String temp = null;
            while ((temp = br.readLine()) != null) {
                String[] split = temp.split(" ");
                //System.out.println(split[0]);
                wordsCount += split.length;
                for (String string : split) {
                	if (map.containsKey(string)) {
                		int tmp = map.get(string)+1;
                		map.put(string, tmp);
                	} else {
                		map.put(string, 1);
                	}
                }
            }
        }
        System.out.println("succeed read the word frequecy!");
    }
     // 计算向量的模长
	public void loadVectorMode(File file) throws IOException {
		try (Scanner input = new Scanner(file)) {
			
			int words = input.nextInt();
			int size = input.nextInt();
			double vector = 0;

			String key = null;
			double[] value = null;
			for (int i = 0; i < words; i++) {
				double len = 0;
				input.nextLine(); //空行			
				key = input.nextLine();
				//System.out.println(key);
				for (int j = 0; j < size; j++) {
					vector = input.nextDouble();
					//System.out.println(vector);
					len += vector * vector;
				}

				len = Math.sqrt(len);
				modeMap.put(key, len);
			}

		}
	}
    
    /**
     * 保存词频信息
     */
    public void saveWordFreq(File file,boolean hasKey, boolean hasMode) {
        // TODO Auto-generated method stub
    	System.out.println("the entry num: "+ this.map.size());
    	System.out.println("the word num: "+ this.wordsCount);
        try (PrintStream out = new PrintStream(file)) {
        	if (hasKey) {
        		out.println(map.size());
        	}
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
            	//if (entry.getValue() <= 1000 || entry.getValue() >= 5000) {
            	//	continue;
            	//}
            	if (hasKey) {
            		if (hasMode) {
            			out.println(entry.getKey()+"  "+entry.getValue()+"  "+modeMap.get(entry.getKey()));
            		} else {
            			out.println(entry.getKey()+"  "+entry.getValue());
            		}
            	} else {
            		if (hasMode) {
            			out.println(entry.getValue()+"  "+modeMap.get(entry.getKey()));
            		} else {
            			out.println(entry.getValue());
            		}
            	}
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		WordFrequency wf = new WordFrequency();
		try {
			wf.countFreq(new File("library/zhwiki-20150301.txt"));
			wf.loadVectorMode(new File("library/Skipgram_data"));
			wf.saveWordFreq(new File("library/wordFreqBigwithMode_Skipgram"), true, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
