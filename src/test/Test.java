package test;

import java.io.IOException;

import com.ansj.vec.Word2VEC;

public class Test {
    public static void main(String[] args) throws IOException {
        Word2VEC w1 = new Word2VEC() ;
        //w1.loadJavaModelTxt("library/Skipgram_data") ;
        w1.loadJavaModelTxt("library/SkipgramSmall_data");
        System.out.println("succeed load model!");
        System.out.println(w1.distance("中国"));
        
        System.out.println(w1.distance("改革"));
        
        System.out.println(w1.distance("中心"));
        
        System.out.println(w1.distance("江泽民"));
        
        System.out.println(w1.distance("记者"));
        
    }
}
