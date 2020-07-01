package Assignment;

import java.util.Date;

public class Recording extends CatalogItem {
 
	
	private String performer;
	private String format;
	

	//@return the performer
	public String getPerformer() {
		return performer;
	}


	//@param performer the performer to set
	public void setPerformer(String performer) {
		this.performer = performer;
	}

 //@return the format
	public String getFormat() {
		return format;
	}

	 // @param format the format to set
	public void setFormat(String format) {
		this.format = format;
	}



	@Override
	public String toString() {
		return "Recoding_"+super.toString() + "_"+getPerformer()+"_"+getFormat()+'\n';
	}

	
}
