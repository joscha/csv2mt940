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
public class MT940Section {
	ArrayList<MT940Field> fields = new ArrayList<MT940Field>();
	
	public void addField(MT940Field f) {
		this.fields.add(f);
	}
	
	public String toString() {
		String temp = "";
		for(int i = 0;i < this.fields.size();i++) {
			temp += this.fields.get(i);
		}
		return temp;		
	}
}
