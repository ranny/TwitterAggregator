package model;

public class FeatureFrequency {

	private double tfidf;
	private int freq;
	
	public FeatureFrequency(double tfidf, int freq) {
		this.tfidf = tfidf;
		this.freq = freq;
	}
	
	public FeatureFrequency() {
		
	}

	public double getTfidf() {
		return tfidf;
	}

	public void setTfidf(double tfidf) {
		this.tfidf = tfidf;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}
	
}
