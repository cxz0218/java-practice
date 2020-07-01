package text2;

import text2.*;

public class Recording extends CatalogItem {

	private String performer;
	private String format;
	/**
	 * @return the performer
	 */
	public String getPerformer() {
		return performer;
	}
	/**
	 * @param performer the performer to set
	 */
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Recording "+ "_" +super.toString() +  performer + "_" + format;
	}
	
	
}
