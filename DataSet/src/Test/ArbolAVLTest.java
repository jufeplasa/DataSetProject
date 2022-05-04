package Test;

import model.*;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class ArbolAVLTest {

	private ArbolAVL<Person> arbol;

	public void setupScene1() {
	}

	public void setupScene2() {
		arbol = new ArbolAVL<Person>();
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "05/08/2003", "photos/1.jpg", "Cali", 166.0,
				"2GOZO453");
		arbol.add(person1, "Amilcar");
	}

	public void setupScene3() {
		arbol = new ArbolAVL<Person>();
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "5/8/2003", "photos/1.jpg", "Cali", 166.0, "2GOZO453");
		Person person2 = new Person("Juan", "Felipe", 19, "25/9/2003", "photos/12.jpg", "Cali", 167.0, "2GOZO454");
		arbol.add(person1, "Rodriguez");
		arbol.add(person2, "Juan");
	}

	public void setupScene4() {
		arbol = new ArbolAVL<Person>();
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "5/8/2003", "photos/1.jpg", "Cali", 166.0, "2GOZO453");
		Person person2 = new Person("Juan", "Felipe", 19, "25/9/2003", "photos/12.jpg", "Cali", 167.0, "2GOZO454");
		Person person3 = new Person("Jorge", "Jojo", 19, "21/4/2003", "photos/24.jpg", "Cali", 162.0, "2GOZO455");

		arbol.add(person1, "Rodriguez");
		arbol.add(person2, "Juan");
		arbol.add(person3, "Jorge");
	}

	public void setupScene5() {
		arbol = new ArbolAVL<Person>();
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "5/8/2003", "photos/1.jpg", "Cali", 166.0, "2GOZO453");
		Person person2 = new Person("Juan", "Felipe", 19, "25/9/2003", "photos/12.jpg", "Cali", 167.0, "2GOZO454");
		Person person3 = new Person("Jorge", "Jojo", 19, "21/4/2003", "photos/24.jpg", "Cali", 162.0, "2GOZO455");
		Person person4 = new Person("Diego", "Juan", 20, "1/4/2002", "photos/22.jpg", "Cali", 167.0, "2GOZO456");

		arbol.add(person1, "Rodriguez");
		arbol.add(person2, "Juan");
		arbol.add(person3, "Jorge");
		arbol.add(person4, "Diego");
	}
	@Test
	public void testAddPerson() {
		setupScene2();
		Person person1 = new Person("Camila", "Rodriguez", 18, "5/8/2003", "photos/1.jpg", "Cali", 166.0, "2GOZO453");
		Person person2 = new Person("Karol", "Natalia", 19, "25/9/2003", "photos/12.jpg", "Cali", 167.0, "2GOZO454");

		assertTrue(arbol.add(person1, "Camila") == true);
		assertTrue(arbol.add(person2, "Karol") == true);
	}

	@Test
	public void testContainsPerson() {
		setupScene2();
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "5/8/2003", "photos/1.jpg", "Cali", 166.0, "2GOZO453");
		Person person2 = new Person("Juan", "Felipe", 19, "25/9/2003", "photos/12.jpg", "Cali", 167.0, "2GOZO454");
		arbol.add(person1, "Amilcar");
		arbol.add(person2, "Juan");

		assertTrue(arbol.contains("Amilcar") == true);
		assertTrue(arbol.contains("Juan") == true);
	}

	@Test
	public void testRemovePerson() {
		setupScene5();
		assertTrue(arbol.remove("Juan")== true);
		assertTrue(arbol.remove("Jorge")== true);
	}
	@Test
	public void testLeftRotation() {
		
		
	}
}


