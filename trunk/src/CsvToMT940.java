/*
 * Created on 21.09.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.io.*;
import java.text.*;
import java.util.Date;

import mt940.*;
import mt940.fields.*;

import com.Ostermiller.util.BadDelimiterException;
import com.Ostermiller.util.CSVParser;

/**
 * @author Joscha Feth
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CsvToMT940 {
	private SimpleDateFormat inFormat = new SimpleDateFormat("dd.MM.yyyy");

	private String[][] csvData;

	private char csvDelimiter = ';';

	private CsvToMT940Frame ctmf;

	public CsvToMT940(CsvToMT940Frame ctmf) {
		this.ctmf = ctmf;
	}

	public int getCount() {
		return (this.csvData.length - 1);
	}

	public void loadCSV(File csvfile) {
		FileReader fr = null;
		try {
			fr = new FileReader(csvfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.csvData = CSVParser.parse(fr, this.csvDelimiter);
		} catch (BadDelimiterException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	public void writeMT940(File mt940file) {
		this.createMT940();
	}

	public MT940File createMT940() {
		MT940File m = new MT940File();
		// NumberFormat nf = NumberFormat.getInstance();

		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		DecimalFormat df = new DecimalFormat("#0.00", dfs);
		df.setPositivePrefix("+");
		String checkDate = "";
		MT940Section ms = new MT940Section();
		// m.addSection(ms);
		int statementNumber = 1;

		try {
			double ob = df.parse(csvData[1][3]).doubleValue();
			// System.out.println("Schlusssaldo:"+ob);
			for (int a = 1; a < csvData.length
					&& csvData[1][2].equals(csvData[a][2]); a++) {
				double ab = df.parse(csvData[a][10]).doubleValue();
				// System.out.println("Kontoänderung:"+ab);
				ob -= ab;
			}
			Number openingBalance = new Double(ob);
			// System.out.print(ob);
			TOB5BookingCodeTranslator tob = new TOB5BookingCodeTranslator();

			for (int i = 1; i < this.csvData.length; i++) {
				String accountNumber = csvData[i][0];
				String bankSortingCode = csvData[i][1];
				// Number openingBalance = df.parse(csvData[i][3]);
				Date bookingDate = this.inFormat.parse(csvData[i][5]);
				String balanceCurrency = csvData[i][4];
				Number closingBalance = df.parse(csvData[i][3]);

				if (!checkDate.equals(csvData[i][2])) {
					ms.addField(new TransactionReferenceNumber());
					// ms.addField(new RelatedReferenceNumber());
					ms.addField(new AccountDesignation(accountNumber,
							bankSortingCode));
					// ms.addField(new AccountStatementNumber("" +
					// statementNumber, ""));
					ms.addField(new AccountStatementNumber());
					ms.addField(new OpeningBalance(true, (openingBalance
							.doubleValue() > 0), bookingDate, balanceCurrency,
							openingBalance));
					checkDate = csvData[i][2];
				}
				
				for (; i < this.csvData.length; i++) {

					System.out.println(csvData[i][5]);

					if (!checkDate.equals(csvData[i][2])) {
						i--;
						checkDate = csvData[i][2];
						continue;
					}
				

					Date valueDate = this.inFormat.parse(csvData[i][6]);
					String bookingText = csvData[i][7];
					String bookingCode = tob.getTransactionCode(csvData[i][7]);
					String swiftCode = tob.getSwiftCode(csvData[i][7]);
					String bookingPurpose = csvData[i][8];
					String orderingName = csvData[i][9];
					Number amount = df.parse(csvData[i][10]);
					String amountCurrency = csvData[i][11];
					bookingDate = this.inFormat.parse(csvData[i][5]);

					ms.addField(new TurnOverLine(valueDate, bookingDate,
							(amount.doubleValue() > 0), false, amountCurrency,
							amount, swiftCode, "", ""));
					ms.addField(new MultiPurposeField(bookingCode, bookingText,
							bookingPurpose, orderingName));
				}
				ms.addField(new ClosingBalance(true, (closingBalance
						.doubleValue() > 0), bookingDate, balanceCurrency,
						closingBalance));
				m.addSection(ms);
				ms = new MT940Section();
				statementNumber++;
				openingBalance = closingBalance;
			}
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			aiobe.printStackTrace();
			this.ctmf.addInfo("Keine gültige CSV-Datei! Abbruch...");
			return null;

		} catch (ParseException e) {
			e.printStackTrace();
			this.ctmf.addInfo("Parsing-Fehler! Abbruch...");
			return null;
		}
		return m;
	}
}