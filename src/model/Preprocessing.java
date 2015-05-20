package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Preprocessing {

	private static String fSynonymSp = "D:\\data\\skripsi\\app\\TwitterAggregator2\\data\\sinonimspesial.txt";
	private static String fSynonym = "D:\\data\\skripsi\\app\\TwitterAggregator2\\data\\sinonim.txt";
	private static String fStopwords = "D:\\data\\skripsi\\app\\TwitterAggregator2\\data\\stopwords.txt";
	
	private HashMap<String, String> hmSynonym = new HashMap<String, String>();
	private HashMap<String, String> hmSynonymSp = new HashMap<String, String>();
	private List<String> lStopwords = new ArrayList<String>();
	private String tweetText = "";
	
	//sementara untuk weighting
	public String result = "";
	
	public void loadSynonymFromFile() {
		BufferedReader br = null;
		String line = "";
		String delimiter = "=";
		
		try {
			br = new BufferedReader(new FileReader(fSynonym));
			while((line = br.readLine()) != null) {
				String[] synonym = line.split(delimiter);
				hmSynonym.put(synonym[0], synonym[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void loadSynonymSpFromFile() {
		BufferedReader br = null;
		String line = "";
		String delimiter = "=";
		
		try {
			br = new BufferedReader(new FileReader(fSynonymSp));
			while((line = br.readLine()) != null) {
				String[] synonym = line.split(delimiter);
				hmSynonymSp.put(synonym[0], synonym[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void loadStopwordsFile() {
		BufferedReader br = null;
		String line = "";
		
		try {
			br = new BufferedReader(new FileReader(fStopwords));
			while((line = br.readLine()) != null) {
				lStopwords.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void removeURL(String tweet) {
		tweetText = tweet.replaceAll("http://[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]", "");
	}
	
	public void removeMention(String tweet) {
		tweetText = tweet.replaceAll("@[\\w|:_]*", "");
	}
	
	public void removeHashtag(String tweet) {
		tweetText = tweet.replaceAll("#[\\w|:_]*", "");
	}
	
	public void removeSymbol(String tweet) {
		tweetText = tweet.replaceAll("[\\W]", " ");
	}
	
	public void removeDuplicateChar(String tweet) {
		tweetText = tweet.replaceAll("([.!?^\\w])\\1{1,}", "$1");
	}
	
	public void removeNumber(String tweet) {
		tweetText = tweet.replaceAll("[\\d]", "");
	}
	
	public void removeSingleChar(String tweet) {
		Scanner scan = new Scanner(tweet);
		String word;
		String result = "";
		while(scan.hasNext()) {
			word = scan.next();
			if(word.length() == 1) {
				continue;
			}
			else {
				result = result + " " + word;
			}
		}
		scan.close();
	}
	
	public void checkSynonymSp(String tweet) {
		//load synonym special list
		//this.loadSynonymSpFromFile();
		
		Scanner scan = new Scanner(tweet);
		
		String word;
		String isSynonym;
		String result = "";
		
		while(scan.hasNext()) {
			//scan per kata
			word = scan.next();
			
			//check if has synonym
			isSynonym = hmSynonymSp.get(word);
			if(isSynonym != null) {
				word = isSynonym;
			}
			
			result = result + " " + word;
		}
		tweetText = result;
		scan.close();
	}
	
	public void checkSynonym(String tweet) {
		//load synonym list
		//this.loadSynonymFromFile();
		
		Scanner scan = new Scanner(tweet);
		
		String word;
		String isSynonym;
		String result = "";
		
		while(scan.hasNext()) {
			//scan per kata
			word = scan.next();
			
			//check if has synonym
			isSynonym = hmSynonym.get(word);
			if(isSynonym != null) {
				word = isSynonym;
			}
			
			result = result + " " + word;
		}
		tweetText = result;
		scan.close();
	}
	
	public void removeStopword(String tweet) {
		Scanner scan = new Scanner(tweet);
		
		String word;
		String result = "";
		
		while(scan.hasNext()) {
			word = scan.next();
			if(lStopwords.contains(word) == true) {
				continue;
			}
			else {
				result = result + " " + word;
			}
			tweetText = result;
		}
		scan.close();
	}
	
	public void doPreprocessing(String tweet) {
		//inisialisasi tweet
		tweetText = tweet;
		
		//check synonym, delete URL, delete mention, delete symbol, delete hashtag, remove duplicate char, delete 1 char
		this.checkSynonymSp(tweetText);
		
		this.removeURL(tweetText);
		this.removeMention(tweetText);
		this.removeSymbol(tweetText);
		this.removeHashtag(tweetText);
		this.removeDuplicateChar(tweetText);
		this.removeSingleChar(tweetText);
		this.checkSynonym(tweetText.toLowerCase());
		this.removeNumber(tweetText);
		this.removeStopword(tweetText);
		
		//String result = tweetText.trim();
		result = tweetText.trim();
		//System.out.println(result);
	}
	
}
