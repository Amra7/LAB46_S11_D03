package ba.bitcamp.exercise.Benjo.CSV;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Class User that implements interface Serializable.
 * Class has tree parameters: name , age an boolean is java Programer.
 * @author amrapoprzanovic
 *
 */
public class User implements Serializable {

	/**
	 * Parameters.
	 */
	private static final long serialVersionUID = 8116679193855491592L;
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

	/**
	 * Method for writing object.
	 * 
	 * @param stream
	 * @throws IOException
	 */
	public void writeObject(ObjectOutputStream stream) throws IOException {
		stream.writeObject(name);
		;
		stream.writeByte(age);
		stream.writeBoolean(isJavaProgrammer);
	}

	/**
	 * Method for reading Object.
	 * 
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		this.name = (String) stream.readObject();
		this.age = stream.readInt();
		this.isJavaProgrammer = stream.readBoolean();
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

}
