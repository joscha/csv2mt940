/*
 * Created on 21.09.2004
 */
package mt940;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;

/**
 * @author Joscha Feth
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class MT940Field {
	private char fieldDelimiter 						= ':';
	protected String endField 							= "\r\n";
	private String fieldNumber;
	private String fieldValue;
	protected static final SimpleDateFormat lFormat 	= new SimpleDateFormat("yyMMdd");
	protected static final SimpleDateFormat sFormat 	= new SimpleDateFormat("MMdd");
	protected static final DecimalFormatSymbols dfs 	= new DecimalFormatSymbols();
	protected static final DecimalFormat dFormat		= new DecimalFormat("#0.00",dfs);

	public MT940Field() {
		dfs.setDecimalSeparator(',');
		dFormat.setNegativePrefix("");	
	}
	
	@Override
	public String toString() {
		return this.fieldDelimiter+this.fieldNumber+this.fieldDelimiter+this.fieldValue+this.endField;
	}
	
	protected void setFieldNumber(int number) {
		this.setFieldNumber(""+number);
	}
	protected void setFieldNumber(String number) {
		this.fieldNumber = number;
	}	
	
	protected void setFieldValue(String value) {
		this.fieldValue = value;
	}
	protected void setFieldValue(int value) {
		this.setFieldValue(""+value);
	}	
}
