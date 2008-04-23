/*
 * Created on 21.09.2004
 */
package mt940;

import java.util.ArrayList;

/**
 * @author Joscha Feth
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MT940File {
	
	ArrayList<MT940Section> sections 			= new ArrayList<MT940Section>();
	String sectionDelimiter 	= "-\r\n";
	
	
	
	public MT940File() {
	}
	
	public void addSection(MT940Section s) {
		this.sections.add(s);
	}
	
	public String toString() {
		String file = "";
		for(int i = 0;i < this.sections.size();i++) {
			file += this.sections.get(i)+this.sectionDelimiter;
		}
		return file;
	}
}
