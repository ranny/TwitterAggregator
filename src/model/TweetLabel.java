package model;

import java.sql.SQLException;

public class TweetLabel {

	private int labelId;
	private String label;
	
	public TweetLabel(int labelId, String label) throws SQLException, Exception {
		this.labelId = labelId;
		this.label = label;
	}
	
	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
