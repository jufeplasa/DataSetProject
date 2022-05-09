package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DataSet {
	private List<String> names;
	private List<String> lastNames;
	private List<String> countries;
	private String FILE_LASTNAME_TXT_PATH = "data/lastname/Names_2010Census.csv";
	private String FILE_NAME_TXT_PATH = "data/name/babynames-clean.csv";
	private String FILE_NACIONALITY_TXT_PATH = "data/nacionality/population_by_country_2020.csv";
	private List<Person> persons;
	private BinaryTree <Person> nameTree2;
	//private ArbolAVL<Person> nameTree;
	private ArbolRyN<Person, String> lastNameTree2;
	private ArbolAVL<Person> lastNameTree;
	private ArbolAVL<Person> fullNameTree;
	private ArbolAVL<Person> codeTree;
	private Date date;
	private ZoneId timeZone;
	private LocalDate getLocalDate;

	public DataSet() throws IOException {
		persons = new ArrayList<Person>();
		names = new ArrayList<String>();
		lastNames = new ArrayList<String>();
		countries = new ArrayList<String>();
		importNames();
		importLastNames();
		importCountries();
		nameTree2=new BinaryTree <Person>();
		//nameTree=new ArbolAVL<Person>();
		lastNameTree=new ArbolAVL<Person>();
		fullNameTree=new ArbolAVL<Person>();
		lastNameTree2=new ArbolRyN<Person,String>();
		codeTree=new ArbolAVL<Person>();
		date = new Date();
		timeZone = ZoneId.systemDefault();
		getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();

	}

	public void addPerson() {
		int age=generateAge();
		String date=getRandomDate(age) ;
		String name=getRandomName();
		String lastName=getRandomLastName();
		String country=getRandomCountry();
		double height=getRandomHeight();
		String code=getRandomCode();
		Person newP=new Person(name,lastName,age,date,getRandomImage(),country, height, code);
		nameTree2.addPerson(newP);
		//nameTree.add(newP,name);
		lastNameTree.add(newP,lastName);
		lastNameTree2.add(newP,lastName);
		fullNameTree.add(newP,name+" "+lastName);
		codeTree.add(newP,code);
	}


	public void editPerson(Person oldP,String name, String lastName,String dateOfBirth,String profilePhoto, String nacionality, String strHeight, String code) {
		String [] parts=dateOfBirth.split("/");
		int currentYear=getLocalDate.getYear();
		int bornYear=Integer.parseInt(parts[2]);
		int age=currentYear-bornYear;
		double height=Double.parseDouble(strHeight);
		Person setPerson=new Person(name,lastName,age,dateOfBirth,profilePhoto,nacionality,height,code);
		removeFromTrees(oldP);
		addFromTrees(setPerson);
	}

	
	public void editPerson(String name, String lastName,String dateOfBirth,String profilePhoto, String nacionality, String height) {
		
	}
	

	public void addPeopletoShow(String key, int tree) {
		persons.clear();
		nameTree2.getListObject().clear();
		lastNameTree.getListObject().clear();
		fullNameTree.getListObject().clear();
		codeTree.getListObject().clear();

		if(tree==1) {
			nameTree2.addPeopletoList(key, nameTree2.getRoot());
			if(nameTree2.getListObject()!=null) {
				for(int i=0;i<nameTree2.getListObject().size();i++) {
					nameTree2.getListObject().get(i).setComparatorValue(nameTree2.getListObject().get(i).getName());
				}
				persons=nameTree2.getListObject();
			}
		}
		else if(tree==2) {
			lastNameTree.addPeopletoList(key, lastNameTree.getRaiz());
			if(lastNameTree.getListObject()!=null) {
				for(int i=0;i<lastNameTree.getListObject().size();i++) {
					lastNameTree.getListObject().get(i).setComparatorValue(lastNameTree.getListObject().get(i).getLastName());
				}
				persons=lastNameTree.getListObject();
			}
		}
		else if(tree==3) {
			fullNameTree.addPeopletoList(key, fullNameTree.getRaiz());
			if(fullNameTree.getListObject()!=null) {
				for(int i=0;i<fullNameTree.getListObject().size();i++) {
					fullNameTree.getListObject().get(i).setComparatorValue(fullNameTree.getListObject().get(i).getFullName());
				}
				persons=fullNameTree.getListObject();
			}
		}
		else if(tree==4) {
			codeTree.addPeopletoList(key, codeTree.getRaiz());
			if(codeTree.getListObject()!=null) {
				for(int i=0;i<codeTree.getListObject().size();i++) {
					codeTree.getListObject().get(i).setComparatorValue(codeTree.getListObject().get(i).getCode());
				}
				persons=codeTree.getListObject();
			}
		}
	}

	public void addFromTrees(Person newP) {

		nameTree2.addPerson(newP);
		lastNameTree.add(newP,newP.getLastName());
		lastNameTree2.add(newP,newP.getLastName());
		fullNameTree.add(newP,newP.getFullName());
		codeTree.add(newP,newP.getCode());
	}

	public void removeFromTrees(Person pRemove) {
		NodeBinaryTree<Person> rNode= nameTree2.searchPerson(new NodeBinaryTree<Person>(pRemove));
		System.out.println(rNode.getPerson().getFullName());
		Nodo<Person> rNode2= lastNameTree.searchPerson(new Nodo<Person>(pRemove,pRemove.getLastName()));
		Nodo<Person> rNode3= codeTree.searchPerson(new Nodo<Person>(pRemove,pRemove.getCode()));
		Nodo<Person> rNode4= fullNameTree.searchPerson(new Nodo<Person>(pRemove,pRemove.getFullName()));
		nameTree2.removePerson(rNode);
		System.out.println("elimino nombre");
		lastNameTree.remove(rNode2);
		System.out.println("elimino apellido");
		codeTree.remove(rNode3);
		System.out.println("elimino codigo ");
		fullNameTree.remove(rNode4);
		System.out.println("elimino full nombre");
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

		String Strdate="";
		int currentYear=getLocalDate.getYear();
		int year=currentYear-age; 
		int month=(int)(Math.random()*13+1);
		int day;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			day=(int)(Math.random()*32+1);
		}
		else {
			day=(int)(Math.random()*31+1);
		}
		Strdate=day+"/"+month+"/"+year;
		return Strdate;
	}

	public String getRandomName() {
		int index = (int)(Math.random()*names.size()-1);
		return names.get(index);
	}

	public String getRandomLastName() {
		int index = (int)(Math.random() * lastNames.size()-1);
		return lastNames.get(index);
	}

	public int getRandomHeight() {
		int min_val = 120;
		int max_val = 210;
		Random random = new Random();
		int randomNum = min_val + random.nextInt((max_val - min_val) + 1);
		return  randomNum;
	}

	public void importCountries() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILE_NACIONALITY_TXT_PATH));
		String line = br.readLine();
		line = br.readLine();
		while(line != null) {
			String[] parts = line.split("\\,");
			String country = parts[0];
			countries.add(country);
			line = br.readLine();
		}
		br.close();
	}

	public String getRandomCountry() {
		int index = (int)(Math.random()*countries.size()-1);
		return countries.get(index);
	}

	public String getRandomCode() {
		int tam = 8;
		String alphaNumericS;
		StringBuilder stringBuilder;
		alphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		stringBuilder = new StringBuilder(tam);

		for (int i = 0; i < tam; i++) {
			// generate numeric
			int myindex = (int) (alphaNumericS.length() * Math.random());
			// add the characters
			stringBuilder.append(alphaNumericS.charAt(myindex));
		}
		return stringBuilder.toString();
	}

}
