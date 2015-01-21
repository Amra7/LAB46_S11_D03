package ba.bitcamp.exercise.Benjo.CSVBulderPokusaj2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class CSVBuilder {

	private static FileOutputStream fos;
	private static FileInputStream fis;
	private static InputStream is;
	private static OutputStream os;
	private static String basePath = "." + File.separator + "Base"
			+ File.separator;
	private static String currentOpenFile = null;

	public static <T extends CSVInterface> void saveObject(String fileName,
			T objectToSave) throws IOException {

		if (fileName.equals(currentOpenFile)) {
			os.write(objectToSave.objectToCSV().getBytes());

		} else {
			fos = new FileOutputStream(basePath + fileName + ".csv", true);
			os = new DataOutputStream(fos);
			currentOpenFile = fileName;
			os.write(objectToSave.objectToCSV().getBytes());
		}
		System.out.println(basePath);
		os.flush();

		System.out.println(objectToSave.objectToCSV());
	}
	
	public static <T extends CSVInterface> T findObject( String [] str){
		StringBuilder  sb = new StringBuilder();
		for ( int i=0; i < str.length-1; i++){
			sb.append(str[i]);
			
		}
		sb.append(str.length -1);
		
//		InputStreamReader isr  =new InputStreamReader(is);
		BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
		String line = "";
		try {
			String search = sb.toString();
			while ( (line = bis.readLine()) != null){
				if (line.equals(search)){
					@SuppressWarnings("unchecked")
					T newT = (T) new Object();
					newT.CSVToObject(line);
					return newT;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
