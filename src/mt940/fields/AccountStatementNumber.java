/*
 * Created on 21.09.2004
 */
package mt940.fields;

import mt940.MT940Field;

/**
 * @author Joscha Feth
 */
public class AccountStatementNumber extends MT940Field {
	public final int fieldOrder = 4;
	/**
	 * 
	 * @param accountStatementNumber
	 * @param pageNumber	starts with 1
	 */
	public AccountStatementNumber(String accountStatementNumber, String pageNumber) {
		this.setFieldNumber("28C");
		String temp = accountStatementNumber;
		if(!pageNumber.equals("")) {
			temp += "/"+pageNumber;
		}
		this.setFieldValue(temp);
	}
	public AccountStatementNumber() {
		this.setFieldNumber("28C");
		this.setFieldValue(0);
	}
}
