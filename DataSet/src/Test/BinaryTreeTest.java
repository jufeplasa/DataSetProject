package Test;

import model.*;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

	private BinaryTree<Person> arbol;

	public void setupScene1() {
	}

	public void setupScene2() {
		arbol = new BinaryTree<Person>();
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "05/08/2003", "photos/1.jpg", "Cali", 166.0,"2GOZO453");
		arbol.addPerson(person1);
	}
	public void setupScene3() {
		arbol = new BinaryTree<Person>();
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "5/8/2003", "photos/1.jpg", "Cali", 166.0, "2GOZO453");
		Person person2 = new Person("Juan", "Felipe", 19, "25/9/2003", "photos/12.jpg", "Cali", 167.0, "2GOZO454");
		Person person3 = new Person("Jorge", "Jojo", 19, "21/4/2003", "photos/24.jpg", "Cali", 162.0, "2GOZO455");
		Person person4 = new Person("Diego", "Juan", 20, "1/4/2002", "photos/22.jpg", "Cali", 167.0, "2GOZO456");
		
		arbol.addPerson(person1);
		arbol.addPerson(person2);
		arbol.addPerson(person3);
		arbol.addPerson(person4);
	}
	
	@Test
	public void testAddPerson() {
		setupScene1();
		arbol = new BinaryTree<Person>();
		assertTrue(arbol.getRoot() == null);
		Person person1 = new Person("Amilcar", "Rodriguez", 18, "05/08/2003", "photos/1.jpg", "Cali", 166.0,"2GOZO453");
		arbol.addPerson(person1);
		assertTrue(arbol.getRoot() != null);
	}
	@Test
	public void testAddToLeftAndRight() {
		setupScene2();
		arbol = new BinaryTree<Person>();
		Person person2 = new Person("Juan", "Felipe", 19, "25/9/2003", "photos/12.jpg", "Cali", 167.0, "2GOZO454");
		Person person3 = new Person("Jorge", "Jojo", 19, "21/4/2003", "photos/24.jpg", "Cali", 162.0, "2GOZO455");
		arbol.addPerson(person2);
		arbol.addPerson(person3);
	}

	@Test
	public void testRemovePerson() {
		setupScene3();
		Person person5 = new Person("Karol", "Natalia", 20, "1/4/2005", "photos/29.jpg", "Cali", 163.0, "2GOZO459");
		arbol.addPerson(person5);
		NodeBinaryTree<Person> p= arbol.searchPerson(new NodeBinaryTree<Person>(person5));
		arbol.removePerson(p);
		assertTrue(arbol.searchPerson(p) == null);
	}
	
	
}
