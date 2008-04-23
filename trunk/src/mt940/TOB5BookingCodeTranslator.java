package mt940;
import java.util.Hashtable;

/*
 * Created on 21.09.2004
 */

/**
 * @author Joscha Feth
 */
public class TOB5BookingCodeTranslator {
	private Hashtable<String, String> codes = new Hashtable<String, String>();
	private Hashtable<String, String> swift = new Hashtable<String, String>();
	public TOB5BookingCodeTranslator() {
		this.codes.put("LASTSCHR.","005");
		this.swift.put("LASTSCHR.","005");
		
		this.codes.put("D-AUFTRAG","008");
		this.swift.put("D-AUFTRAG","019");
//		this.swift.put("D-AUFTRAG","STO");
		
		this.codes.put("SB-AUSZAHL","083");
		//~ also other codes found, like "024"
		this.swift.put("SB-AUSZAHL","033");
		
		this.codes.put("E-CASH","005");
		this.swift.put("E-CASH","025");
		
		this.codes.put("ÜBERWEISG","020");
		this.swift.put("ÜBERWEISG","040");
		
		this.codes.put("GUTSCHRIFT","051");
		this.swift.put("GUTSCHRIFT","051");
		
		this.codes.put("DA-GUTSCHR","052");
		this.swift.put("DA-GUTSCHR","052");
		
		this.codes.put("AUSLD.ZAHL","065");
		this.swift.put("AUSLD.ZAHL","062");
		
		this.codes.put("ÜBERTRAG","820");
//		this.swift.put("ÜBERTRAG","065");
		this.swift.put("ÜBERTRAG","TRF");
		
		this.codes.put("DIVIDENDE","835");
//		this.swift.put("DIVIDENDE","091");
		this.swift.put("DIVIDENDE","DIV");
		
		this.codes.put("EINZAHLUNG","082");
		this.swift.put("EINZAHLUNG","080");
		
		this.codes.put("ABSCHLUSS","805");
//		this.swift.put("ABSCHLUSS","070");
		this.swift.put("ABSCHLUSS","INT");
		
		
		//~ not sure on the following
		this.codes.put("AUSZAHLUNG","084");
//		this.swift.put("AUSZAHLUNG","084");
		
		this.codes.put("SCHECKS","070");
		this.swift.put("SCHECKS","CHK");
		
		this.codes.put("DEPOTVERWAHRG", "803");
//		this.swift.put("DEPOTVERWAHRG", "803");		
	}
	
	public String getTransactionCode(String TOB5BookingString) {
		String ret = "999";
		if(this.codes.containsKey(TOB5BookingString)) {
			ret = this.codes.get(TOB5BookingString).toString();
		}
		else {
			System.out.println("not found: "+TOB5BookingString);
		}
		return ret;
	}
	
	public String getSwiftCode(String TOB5BookingString) {
		String ret = "MSC";
		if(this.swift.containsKey(TOB5BookingString)) {
			ret = this.swift.get(TOB5BookingString).toString();
		}
		else {
			System.out.println("not found: "+TOB5BookingString);
		}
		return ret;		
	}
}
