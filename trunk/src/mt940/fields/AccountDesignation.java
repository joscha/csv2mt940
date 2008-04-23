/*
 * Created on 21.09.2004
 */
package mt940.fields;

import mt940.MT940Field;

/**
 * @author Joscha Feth
 */
public class AccountDesignation extends MT940Field {
	public final int fieldOrder = 3;
	public AccountDesignation(String accountNumber, String bankSortingCode) {
		this.setFieldNumber(25);
		this.setFieldValue(bankSortingCode+"/"+accountNumber);
	}
}
