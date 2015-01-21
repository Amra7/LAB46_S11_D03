package ba.bitcamp.exercise.Benjo.CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;

public class Main {

	public static void main(String[] args) {
		
		User u = new User("Camper" , 45, true);
		
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(System.out);
//			oos.writeObject(u);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		
		FileInputStream fis;
		FileOutputStream fos;
		File newFile = new File("./Folder/newFile.txt");
		ObjectOutputStream oos;
		ObjectInputStream ois;
	
		if ( newFile.exists()){
			try {
				FileReader fr = new FileReader(newFile);
				if ( fr.read() == -1){
					fos = new FileOutputStream("./Folder/newFile.txt");
					oos = new ObjectOutputStream(fos);
					oos.writeObject(u);
					System.out.println("Usao");
				} else {
					System.out.println("Folder je pun!");
				}
				
				
				String[] line = newFile.list();
				System.out.println(line.toString());
		
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} else {
			System.out.println("Folder ne postoji!");
		}
		
		
	}

}
