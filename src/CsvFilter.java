import java.io.File;

/*
 * Created on 21.09.2004
 */

/**
 * @author Joscha Feth
 */
public class CsvFilter extends FileActions {

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		String extension = this.getExtension(f);
		if (extension != null) {
			if (extension.equals("csv") || extension.equals("txt")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public String getDescription() {
		return "CSV (*.csv) und TXT (*.txt) Dateien";
	}

}