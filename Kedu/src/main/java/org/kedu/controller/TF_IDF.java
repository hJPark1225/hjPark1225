package org.kedu.controller;

import java.util.ArrayList;
import java.util.HashMap;

public class TF_IDF {

	   	int numOfWords;
	    double[] idfVector;
	    double[][] tfIdfMatrix;
	    double[][] tfMatrix;
	    String[] wordVector;
	    int docLength[];
	    
	    
	    // scan all words and count the number of different words
	    public TF_IDF(ArrayList<String> docs) {
	 
	        HashMap<String, Integer> mapWordToIdx = new HashMap<>();
	        int nextIdx = 0;
	        for (String doc : docs) {
	            for (String word : doc.split(" ")) {
	                if (!mapWordToIdx.containsKey(word)) {
	                    mapWordToIdx.put(word, nextIdx);
	                    nextIdx++;
	                }
	            }
	        }
	 
	        numOfWords = mapWordToIdx.size();
	 
	        // create word vector where wordVector[i] is the actual word
	        wordVector = new String[numOfWords];
	        for (String word : mapWordToIdx.keySet()) {
	            int wordIdx = mapWordToIdx.get(word);
	            wordVector[wordIdx] = word;
	        }
	 
	        /*
	         * create doc word vector where docCountVector[i] is number of docs
	         * containing word of index i and doc length vector
	        */
	        
	        int[] docCountVector = new int[numOfWords];
	        docLength = new int[docs.size()];
	        
	        /* 
	         * lastDocWordVector is auxiliary vector keeping track of last doc index
	         * containing the word
	         */
	        int[] lastDocWordVector = new int[numOfWords];
	        for (int wordIdx = 0; wordIdx < numOfWords; wordIdx++) {
	            lastDocWordVector[wordIdx] = -1;
	        }
	        for (int docIdx = 0; docIdx < docs.size(); docIdx++) {
	            String doc = docs.get(docIdx);
	            String[] words = doc.split(" ");
	            for (String word : words) {
	                docLength[docIdx] = words.length;
	                int wordIdx = mapWordToIdx.get(word);
	                if (lastDocWordVector[wordIdx] < docIdx) {
	                    lastDocWordVector[wordIdx] = docIdx;
	                    docCountVector[wordIdx]++;
	                }
	            }
	        }
	 
	        // compute IDF vector based on docCountVector
	        idfVector = new double[numOfWords];
	        for (int wordIdx = 0; wordIdx < numOfWords; wordIdx++) {
	            idfVector[wordIdx] = Math.log10(1 + (double) docs.size() / (docCountVector[wordIdx]));
	        }
	 
	        // compute term frequency matrix, tfMatrix[docIdx][wordIdx]
	        tfMatrix = new double[docs.size()][];
	        for (int docIdx = 0; docIdx < docs.size(); docIdx++) {
	            tfMatrix[docIdx] = new double[numOfWords];
	        }
	        for (int docIdx = 0; docIdx < docs.size(); docIdx++) {
	            String doc = docs.get(docIdx);
	            for (String word : doc.split(" ")) {
	                int wordIdx = mapWordToIdx.get(word);
	                tfMatrix[docIdx][wordIdx] = tfMatrix[docIdx][wordIdx] + 1;
	            }
	        }
	        // normalize idfMatrix by dividing corresponding doc length
	        for (int docIdx = 0; docIdx < docs.size(); docIdx++) {
	            for (int wordIdx = 0; wordIdx < numOfWords; wordIdx++) {
	                tfMatrix[docIdx][wordIdx] = tfMatrix[docIdx][wordIdx] / docLength[docIdx];
	            }
	        }
	 
	        /*
	         * compute final TF-IDF matrix
	         * tfIdfMatrix[docIdx][wordIdx] = tfMatrix[docIdx][wordIdx] * idfVector[wordIdx]
	         */
	         
	        tfIdfMatrix = new double[docs.size()][];
	        for (int docIdx = 0; docIdx < docs.size(); docIdx++) {
	            tfIdfMatrix[docIdx] = new double[numOfWords];
	        }
	 
	        for (int docIdx = 0; docIdx < docs.size(); docIdx++) {
	            for (int wordIdx = 0; wordIdx < numOfWords; wordIdx++) {
	                tfIdfMatrix[docIdx][wordIdx] = tfMatrix[docIdx][wordIdx] * idfVector[wordIdx];
	            }
	        }
	 
	    }
	 
	    public double[][] getTF_IDFMatrix() {
	        return tfIdfMatrix;
	    }
	 
	    public String[] getWordVector() {
	        return wordVector;
	    }
	    
}
