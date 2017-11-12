package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ansj.vec.domain.Neuron;
import com.ansj.vec.domain.WordNeuron;
import com.ansj.vec.util.MapCount;

public class WordFrequency {
	int wordsCount = 0; //共加载的词的数量
    Map<String,Integer> map = new HashMap<String,Integer>();
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
                		map.put(string, tmp+1);
                	} else {
                		map.put(string, 1);
                	}
                }
            }
        }
        System.out.println("succeed read the word frequecy!");
    }
    
    /**
     * 保存词频信息
     */
    public void saveWordFreq(File file,boolean hasKey) {
        // TODO Auto-generated method stub
    	System.out.println("the entry num: "+ this.map.size());
    	System.out.println("the word num: "+ this.wordsCount);
        try (PrintStream out = new PrintStream(file)) {
        	if (hasKey) {
        		out.println(map.size());
        	}
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
            	if (hasKey) {
            		out.println(entry.getKey()+"  "+entry.getValue());
            	} else {
            		out.println(entry.getValue());
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
			wf.countFreq(new File("library/pku_corpus.txt"));
			wf.saveWordFreq(new File("library/wordFreqSmallonly"), false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
