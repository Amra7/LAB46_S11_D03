package ba.bitcamp.exercise.Benjo.CSVBulderPokusaj2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Class User that implements.
 * Class has tree parameters: name , age an boolean is java Programer.
 * @author amrapoprzanovic
 *
 */
public class User implements CSVInterface{

	/**
	 * Parameters.
	 */

	private String name;
	private int age;
	private boolean isJavaProgrammer;

	/**
	 * Constructor for User.
	 * 
	 * @param name
	 *            - name of user.
	 * @param age
	 *            - age of user.
	 * @param iJavaProgrammer
	 *            - true or false
	 */
	public User(String name, int age, boolean iJavaProgrammer) {
		this.name = name;
		this.age = age;
		this.isJavaProgrammer = isJavaProgrammer;
	}
	
	 
		public User() {
			this.name = "";
			this.age = -1;
			this.isJavaProgrammer = false;
		}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the isJavaProgrammer
	 */
	public boolean isJavaProgrammer() {
		return isJavaProgrammer;
	}

	/**
	 * @param isJavaProgrammer
	 *            the isJavaProgrammer to set
	 */
	public void setJavaProgrammer(boolean isJavaProgrammer) {
		this.isJavaProgrammer = isJavaProgrammer;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (isJavaProgrammer ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (isJavaProgrammer != other.isJavaProgrammer)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", isJavaProgrammer="
				+ isJavaProgrammer + "]";
	}

	@Override
	public String objectToCSV() {
		String str="";
		str += "[ "+ name + ", " + age + ", " + isJavaProgrammer+ " ]\n";
		return str;
	}

	@Override
	public void CSVToObject(String csv) {
		String [] parts = csv.split(", ");
		this.name = parts[0];
		this.age =Integer.parseInt(parts[1]) ;
		this.isJavaProgrammer = Boolean.parseBoolean(parts[2]); 
		
	}

}
