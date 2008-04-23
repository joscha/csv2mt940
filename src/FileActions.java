import java.io.File;
import javax.swing.filechooser.FileFilter;

/*
 * Created on 22.09.2004
 */

/**
 * @author Joscha Feth
 */
public abstract class FileActions extends FileFilter {

	public String getExtension(File f) {
		if (f != null) {
			String filename = f.getName();
			int i = filename.lastIndexOf('.');
			if (i > 0 && i < filename.length() - 1) {
				return filename.substring(i + 1).toLowerCase();
			}
		}
		return null;
	}

}
