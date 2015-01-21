package ba.bitcamp.lecture.Emir.CopyFile;


import java.io.File;
import java.io.IOException;

public class TestFiles {

	public static void main(String[] args) {

		File myFile = new File("./Files/input.txt");
		try {
			Utility.fileToSysout(myFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File myFile2 = new File("./Files/output.txt");
		try {
			Utility.copyFile(myFile, myFile2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
