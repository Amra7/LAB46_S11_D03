package ba.bitcamp.lecture.Emir.CopyFile;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class Utility {

/**
 * Method that prints the chosen file to sysout print;
 * @param fileToOut
 */
	public static void fileToSysout(File fileToOut) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileToOut);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} finally {
			fis.close();
		}
	}
/**
 * Method that copies the chosen file to the 2nd chosen file;
 * @param fileToOut
 */
	public static void copyFile(File fileToCopy, File fileToCopyOn)
			throws IOException {
		FileInputStream fis = new FileInputStream(fileToCopy);
		FileOutputStream fos = new FileOutputStream(fileToCopyOn);
		try {

			int b = 0;
			OutputStreamWriter os = new OutputStreamWriter(fos);
			while ((b = fis.read()) > 0) {
				fos.write(b);
			}

		} finally {
			fos.close(); // automatski poziva flush()!
			fis.close();
		}
	}
	
/**
 * Method that copies the chosen file to the 2nd chosen file; With an array of bytes;
 * @param fileToOut
 */
		public static void copyFile(File fileToCopy, File fileToCopyOn, int numberOfBytes) throws IOException {
			FileInputStream fis = new FileInputStream(fileToCopy);
			FileOutputStream fos = new FileOutputStream(fileToCopyOn);
			try {

				byte[] buff = new byte[numberOfBytes];
				int read ;
				OutputStreamWriter os = new OutputStreamWriter(fos);
				while ((read = fis.read(buff)) > 0) {
					fos.write(buff, 0, read);
				}

			} finally {
				fos.close(); // automatski poziva flush()!
				fis.close();
			}
		}
}
