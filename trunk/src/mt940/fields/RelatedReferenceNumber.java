/*
 * Created on 21.09.2004
 */
package mt940.fields;

import mt940.MT940Field;

/**
 * @author Joscha Feth
 */
public class RelatedReferenceNumber extends MT940Field {
	public final int fieldOrder = 2;
	public RelatedReferenceNumber(String value) {
		this.setFieldNumber(21);
		this.setFieldValue(value);
	}
	public RelatedReferenceNumber() {
		this.setFieldNumber(21);
		this.setFieldValue("");
	}	
}