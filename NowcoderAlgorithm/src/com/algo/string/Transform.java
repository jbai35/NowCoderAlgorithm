package com.algo.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.text.html.parser.Entity;

//对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
//给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
//测试样例：
//"abc",3,"bca",3
//返回：true

public class Transform {
    public static boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
    	if(A == null || B == null || lena != lenb){
    		return false;
    	}
    	char[] charA = A.toCharArray();
    	char[] charB = B.toCharArray();
    	HashMap<Character, Integer> hashMapA = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> hashMapB = new HashMap<Character, Integer>();
    	for(char c : charA){
    		if(!hashMapA.containsKey(c)){
    			hashMapA.put(c, 1);
    		}else{
    			hashMapA.put(c, hashMapA.get(c)+1);
    		}
    	}
    	for(char c : charB){
    		if(!hashMapB.containsKey(c)){
    			hashMapB.put(c, 1);
    		}else{
    			hashMapB.put(c, hashMapB.get(c)+1);
    		}
    	}
    	System.out.println(hashMapA);
    	System.out.println(hashMapB);
    	
    	if(hashMapA.size()!=hashMapB.size()){
    		return false;
    	}
    	Iterator<Entry<Character, Integer>> iterator = hashMapA.entrySet().iterator();
    	while(iterator.hasNext()){
    		Entry<Character, Integer> entity = iterator.next();
    		char c = entity.getKey();
    		int val = entity.getValue();
    		if(val != hashMapB.get(c)){
    			return false;
    		}
    	}
    	return true;
    }
    public static void main(String[] args){
    	String aString = "DHJSKTQHEIXDEOE";
    	String bString = "XHIHOQSDTDEEJEK";
    	System.out.println(chkTransform(aString, 15, bString, 15));
    }
}
