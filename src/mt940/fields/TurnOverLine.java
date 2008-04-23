/*
 * Created on 21.09.2004
 */
package mt940.fields;

import mt940.MT940Field;

/**
 * @author Joscha Feth
 */
public class TurnOverLine extends MT940Field {
	public final int fieldOrder = 6;
	private String emptyRef = "0000000000000000";
	
	/**
	 * 
	 * @param valueDate
	 * @param bookingDate
	 * @param isCredit
	 * @param isCancelled
	 * @param currency
	 * @param amount
	 * @param bookingCode
	 * @param customerRef
	 * @param bankRef
	 */
	public TurnOverLine(java.util.Date valueDate,java.util.Date bookingDate,boolean isCredit,boolean isCancelled,String currency,Number amount,String swiftCode,String customerRef,String bankRef) {
		this.setFieldNumber(61);
		String temp = MT940Field.lFormat.format(valueDate)+MT940Field.sFormat.format(bookingDate);
		if(isCancelled) {
			temp += "R";
		}			
		if(isCredit) {
			temp += "C";
		} else {
			// is debit
			temp += "D";
		}
		temp += currency.charAt(2)+MT940Field.dFormat.format(amount.floatValue())+"N"+swiftCode;
		if(customerRef.equals("")) {
			temp += this.emptyRef;
		} else {
			temp += customerRef;
		}
		temp += "//";
		if(bankRef.equals("")) {
			temp += this.emptyRef;
		} else {
			temp += bankRef;
		}
		//~ SUB FIELD 9 MISSING
		this.setFieldValue(temp);		
	}
}
