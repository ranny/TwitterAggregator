package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Weighting {
	
	//min total term that appear in every tweet | min total tweet that have certain term
	private static int MINTERMAPPEAR = 3;
	private static int MINTWEETOFTERM = 3;
	
	//weighting using TFIDF
	public void countWeightPerTweet(List<String> tweetTerm) {

		List<HashMap<String, Integer>> lHmTF = new ArrayList<HashMap<String,Integer>>();
		HashMap<String, Integer> hmDF = new HashMap<String, Integer>();
		List<HashMap<String, Double>> lHmTFIDF = new ArrayList<HashMap<String,Double>>();
		
		for(String tweet : tweetTerm) {
			//print tweet
			System.out.println(tweet);
			//weighting : TF
			HashMap<String, Integer> hmTF = new HashMap<String, Integer>();
			Scanner scan = new Scanner(tweet);
			String word;
			Integer termFreq;
			Integer termCount;
			while(scan.hasNext()) {
				word = scan.next();
				//count TF
				//check termFreq(value) in hmTF : if term stored in hmTF
				termFreq = hmTF.get(word);
				if(termFreq == null) {
					//if term hasn't stored in hmTF
					hmTF.put(word, 1);
				}
				else {
					hmTF.put(word, termFreq + 1);
				}
			}
			lHmTF.add(hmTF);
			
			scan.close();
			
			//count DF
			for(String t : hmTF.keySet()) {
				termCount = hmDF.get(t);
				if(termCount == null) {
					hmDF.put(t, 1);
				}
				else {
					hmDF.put(t, termCount + 1);
				}
			}
		}
		
		System.out.println();
		
		//count IDF
		HashMap<String, Double> hmIDF = new HashMap<String, Double>();
		String term;
		Integer df;
		double idf;
		int tweetCount = tweetTerm.size();
		for(Map.Entry<String, Integer> me : hmDF.entrySet()) {
			term = me.getKey();
			df = me.getValue();
			if(df >= MINTWEETOFTERM) {
				idf = Math.log(tweetCount/df);
				hmIDF.put(term, idf);
			}
			else {
				hmIDF.put(term, -1.0);
			}
		}
		
		//count tfidf
		String word;
		Integer valueTF;
		Double valueIDF;
		double tfidf;
		for(HashMap<String, Integer> tf : lHmTF) {
			HashMap<String, Double> hmTFIDF = new HashMap<String, Double>();
			for(Map.Entry<String, Integer> meTF : tf.entrySet()) {
				//count TF*IDF
				word = meTF.getKey();
				valueTF = meTF.getValue();
				valueIDF = hmIDF.get(word);
				if(valueIDF != null && valueIDF > 0) {
					tfidf = valueTF * valueIDF;
					hmTFIDF.put(word, tfidf);
				}
			}
			lHmTFIDF.add(hmTFIDF);
		}
		
		//print tfidf
		int numTweet = 1;
		for(HashMap<String, Double> tes : lHmTFIDF) {
			System.out.println("Tweet: " + numTweet);
			for(Map.Entry<String, Double> meTes : tes.entrySet()) {
				System.out.println(meTes.getKey() + " : " + meTes.getValue());
			}
		}
		
	}
	
	//weighting using TFIDF
	public void countWeightPerFeature(List<String> tweetTerm) {

		List<HashMap<String, Integer>> lHmTF = new ArrayList<HashMap<String,Integer>>();
		HashMap<String, Integer> hmDF = new HashMap<String, Integer>();
		HashMap<String, List<Double>> hmWeight = new HashMap<String, List<Double>>();
		/*===new===*/
		HashMap<String, FeatureFrequency> hmWeight2 = new HashMap<String, FeatureFrequency>();
		
		for(String tweet : tweetTerm) {
			//print tweet
			System.out.println(tweet);
			//weighting : TF
			HashMap<String, Integer> hmTF = new HashMap<String, Integer>();
			Scanner scan = new Scanner(tweet);
			String word;
			Integer termFreq;
			Integer termCount;
			while(scan.hasNext()) {
				word = scan.next();
				//count TF
				//check termFreq(value) in hmTF : if term stored in hmTF
				termFreq = hmTF.get(word);
				if(termFreq == null) {
					//if term hasn't stored in hmTF
					hmTF.put(word, 1);
				}
				else {
					hmTF.put(word, termFreq + 1);
				}
			}
			lHmTF.add(hmTF);
			
			scan.close();
			
			//count DF
			for(String t : hmTF.keySet()) {
				termCount = hmDF.get(t);
				if(termCount == null) {
					hmDF.put(t, 1);
				}
				else {
					hmDF.put(t, termCount + 1);
				}
			}
		}
		
		System.out.println();
		
		//count IDF
		HashMap<String, Double> hmIDF = new HashMap<String, Double>();
		String term;
		Integer df;
		double idf;
		int tweetCount = tweetTerm.size();
		for(Map.Entry<String, Integer> me : hmDF.entrySet()) {
			term = me.getKey();
			df = me.getValue();
			if(df >= MINTWEETOFTERM) {
				idf = Math.log(tweetCount/df);
				hmIDF.put(term, idf);
			}
			else {
				hmIDF.put(term, -1.0);
			}
		}
		
		//count tfidf
		String word;
		Integer valueTF;
		Double valueIDF;
		double tfidf;
		Double weight;
		List<Double> lWeight;
		/*===new===*/
		FeatureFrequency featureFreq = new FeatureFrequency();
		for(HashMap<String, Integer> tf : lHmTF) {
			HashMap<String, Double> hmTFIDF = new HashMap<String, Double>();
			for(Map.Entry<String, Integer> meTF : tf.entrySet()) {
				//count TF*IDF
				word = meTF.getKey();
				valueTF = meTF.getValue();
				valueIDF = hmIDF.get(word);
				if(valueIDF != null && valueIDF > 0) {
					List<FeatureFrequency> weightFreq = new ArrayList<FeatureFrequency>();
					List<Double> lWeight2 = new ArrayList<Double>();
					tfidf = valueTF * valueIDF;
					hmTFIDF.put(word, tfidf);
					//put weight in hmWeight
					lWeight = hmWeight.get(word);
					/*===new===*/
					featureFreq = hmWeight2.get(word);
					if(lWeight == null) {
						//put tfidf and freq in lWeight
						weightFreq.add(new FeatureFrequency(tfidf, 1));
						lWeight2.add(tfidf);
						lWeight2.add((double) 1);
						hmWeight.put(word, lWeight2);
					}
					else {
						double w = lWeight.get(0);
						int freq = lWeight.get(1) + 1;
						//weight = (w + tfidf) / freq;
						weight = w + tfidf;
						weightFreq.add(new FeatureFrequency(weight, freq));
						lWeight2.add(weight);
						lWeight2.add(freq);
						hmWeight.put(word, lWeight2);
					}
					/*===new===*/
					if(featureFreq == null) {
						wei
					}
				}
			}
		}
		
		//print weight
		for(Map.Entry<String, List<Double>> coba : hmWeight.entrySet()) {
			double a = coba.getValue().get(0);
			double b = coba.getValue().get(1);
			double hasil = a / b;
			if(b >= MINTERMAPPEAR) {
				System.out.println(coba.getKey() + " : " + hasil + " , " + b);
			}
		}
		
	}
	
	public void addToStopwords() {
		//fitur dengan weight lebih dari 1, di rata ratakan
		//urutkan fitur dari weight terkecil sampai terbesar
		//cek fitur dengan weight kecil dan masukkan ke stopwords
	}

}
