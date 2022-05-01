package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSet {
	private List<String> names;
	private List<String> lastNames;
	private List<Person> persons;
	private String FILE_LASTNAME_TXT_PATH = "data/lastname/Names_2010Census.csv";
	private String FILE_NAME_TXT_PATH = "data/name/babynames-clean.csv";
	private ArbolAVL<Person> nameTree;
	private ArbolAVL<Person> lastNameTree;
	private ArbolAVL<Person> fullNameTree;
	private ArbolAVL<Person> codeTree;
	
	public DataSet() throws IOException {
		persons = new ArrayList<Person>();
		names = new ArrayList<String>();
		lastNames = new ArrayList<String>();
		importNames();
		importLastNames();
		nameTree=new ArbolAVL<Person>();
		lastNameTree=new ArbolAVL<Person>();
		fullNameTree=new ArbolAVL<Person>();
		codeTree=new ArbolAVL<Person>();
	}
	

	public void addPerson() {
		int age=generateAge();
		String date=getRandomDate(age) ;
		String name=getRandomName();
		String lastName=getRandomLastName();
		Person newP=new Person(name,lastName,age,date,getRandomImage());
		nameTree.add(newP,name);
		//lastNameTree.add(newP,lastName);
		//fullNameTree.add(newP,name+" "+lastName);
		//codeTree.add(newP,"");
		//persons.add(newP);
	}
	
	public void addPeopletoShow(String key) {
		persons.clear();
		nameTree.getListObject().clear();;
		nameTree.addPeopletoList(key, nameTree.getRaiz());
		if(nameTree.getListObject()!=null) {
			persons=nameTree.getListObject();
		}
	}

	public List<Person> getPersons(){
		return this.persons;
		
	}
	
	public String getRandomImage() {
		String raiz="src/photos/";
		String base=".jpg";
		int index = (int)(Math.random()*101+1);
		String photo=raiz+index+base;
		return photo;
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
	
	public int generateAge() {
		int index = (int)(Math.random()*101+1);
		int age;
		if(index<=19) {
			age= (int)(Math.random()*15);
		}
		else if(index>=20 && index<=32){
			age= (int)(Math.random()*(24-15+1)+15);
		}
		else if(index>=33 && index<=71){
			age= (int)(Math.random()*(54-25+1)+25);
		}
		else if(index>=72 && index<=84){
			age= (int)(Math.random()*(64-55+1)+55);
		}
		else {
			age= (int)(Math.random()*(99-65+1)+65);
		}
		return age;
	}
	
	public String getRandomDate(int age) {
		String date="";
		int year=2022-age; 
		int month=(int)(Math.random()*13+1);
		int day;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			day=(int)(Math.random()*32+1);
		}
		else {
			day=(int)(Math.random()*31+1);
		}
		date=day+"/"+month+"/"+year;
		return date;
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
