package ba.bitcamp.exercise.Benjo.CSVBulderPokusaj2;

import java.io.IOException;

public class TestClass {

	public static void main(String[] args) {
		
		User u = new User("Ibrahim", 78, false);
		try {
			CSVBuilder.saveObject("Users", u);
			CSVBuilder.saveObject("Users", new User("Klark", 78, false));
			CSVBuilder.saveObject("Users", new User("Nikola", 58, false));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] str  ={"Klark", "78", "false"};
		User newUser = CSVBuilder.findObject(str);
	}

}
