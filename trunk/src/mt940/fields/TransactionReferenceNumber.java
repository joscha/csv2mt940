/*
 * Created on 21.09.2004
 */
package mt940.fields;

import mt940.MT940Field;

/**
 * @author Joscha Feth
 */
public class TransactionReferenceNumber extends MT940Field {
	public final int fieldOrder = 1;	
	public TransactionReferenceNumber(String value) {
		this.setFieldNumber(20);
		this.setFieldValue(value);
	}
	public TransactionReferenceNumber() {
		this.setFieldNumber(20);
		this.setFieldValue("");
	}	
}
