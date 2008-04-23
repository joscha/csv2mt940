/*
 * Created on 22.09.2004
 */
package mt940;

/**
 * @author Joscha Feth
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SplitToMT940Fields {
	private static String startChar = "?";
	private static String lineDelim = "\r\n";

	public static String split(String toSplit,int startWith,int size) {
		String temp = "";
		int pos = 0;
		while(toSplit.length() > pos) {
			pos += getCount(toSplit,pos);
			temp += startChar+startWith+toSplit.substring(pos,Math.min(pos+=size,toSplit.length()));
			if(toSplit.length() > pos) {
				temp += lineDelim;
			}
			startWith++;
		}
		return temp;
	}
	
	public static int getCount(String s,int offset) {
		int ret = 0;
		while(s.charAt(offset) == ' ') {
			offset++;
			ret++;
		}		
		return ret;
	}

}
