package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSet {
	private List<String> names;
	private List<String> lastNames;
	private String FILE_LASTNAME_TXT_PATH = "data/lastname/Names_2010Census.csv";
	private String FILE_NAME_TXT_PATH = "data/name/babynames-clean.csv";
	
	private List<Person> persons;
	public DataSet() throws IOException {
		persons = new ArrayList<Person>();
		names = new ArrayList<String>();
		lastNames = new ArrayList<String>();
		importNames();
		importLastNames();
		
	}
	

	public void addPerson(String name, String lastName, String gender, String dateOfBirth, double height, String nacionality, String profilePhoto) {
		
	}

	public List<Person> getPersons(){
		return this.persons;
	}
	

	public void importNames() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_TXT_PATH));
		String line = br.readLine();
		line = br.readLine();
		while(line != null) {
			String[] parts = line.split("\\,");
			String name = parts[0];
			names.add(name);
			line = br.readLine();
		}
		br.close();
	}
	
	public void importLastNames() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILE_LASTNAME_TXT_PATH));
		String line = br.readLine();
		line = br.readLine();
		while(line != null) {
			String[] parts = line.split("\\,");
			String lastName = parts[0];
			lastNames.add(lastName);
			line = br.readLine();
		}
		br.close();
	}
	
	public String getRandomName() {
		int index = (int)(Math.random()*names.size()-1);
		return names.get(index);
	}
	
	public String getRandomLastName() {
		int index = (int)(Math.random() * lastNames.size()-1);
		return lastNames.get(index);
	}
}
