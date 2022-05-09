package model;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree <T>{
	private NodeBinaryTree<T> root;
	private List<Person> listObject;
	
	public BinaryTree() {
		listObject = new ArrayList<Person>();
	}
	
	public NodeBinaryTree<T> getRoot() {
		return this.root;
	}
	
	
	public void setRoot(NodeBinaryTree<T> root) {
		this.root = root;
	}

	public void addPerson(Person newP) {
		NodeBinaryTree<T> node = new NodeBinaryTree<T>(newP);
		NodeBinaryTree<T> root = this.getRoot();
		if(root==null) {
			this.root = node;
			root=node;
		}else {
			addPerson(root, node);
		}
	}
	
	
	private void addPerson(NodeBinaryTree<T> current, NodeBinaryTree<T> newPerson) {
		if(newPerson.getPerson().getName().compareTo(current.getPerson().getName()) <= 0) {
			if(current.getLeft()==null) {
				current.setLeft(newPerson);
				newPerson.setUp(current);
			}else {
				addPerson(current.getLeft(), newPerson);
			}
		}else {
			if(current.getRight()==null) {
				current.setRight(newPerson);
				newPerson.setUp(current);
			}else {
				addPerson(current.getRight(), newPerson);
			}
		}
	}
	
	public NodeBinaryTree<T> searchPerson(NodeBinaryTree<T> person) {
		if(root==null) {
			return null;
		}else {
			return searchPerson(root, person);
		}
	}

	private NodeBinaryTree<T> searchPerson(NodeBinaryTree<T> current, NodeBinaryTree<T> personToSearch) {
		NodeBinaryTree<T> found = null;
		while(current!=null && found==null) {
			if(current.getPerson()==personToSearch.getPerson()) {
				found = current;
			}else if(personToSearch.getPerson().getName().compareTo(current.getPerson().getName()) <= 0) {
				current = current.getLeft();
			}else {
				current = current.getRight();
			}
		}
		return found;
	}
	
	
	public void removePerson(NodeBinaryTree<T> personToRemove) {
		if(personToRemove != null) { 
			if(personToRemove.getLeft() == null && personToRemove.getRight() == null) {
				//System.out.println("sin  hijo: "+personToRemove.getPerson().getFullName());
				//System.out.println("padre: "+personToRemove.getUp().getPerson().getFullName());
				
				if(personToRemove == this.getRoot()) { 
					root = null;
				}else if(personToRemove == personToRemove.getUp().getLeft()) {
					personToRemove.getUp().setLeft(null);
				}else {
					personToRemove.getUp().setRight(null);
				}
				
			}else if(personToRemove.getLeft()==null || personToRemove.getRight()==null) {
				NodeBinaryTree<T> child;
				
				//System.out.println("con un hijo: "+personToRemove.getPerson().getFullName());
				//System.out.println("padre: "+personToRemove.getUp().getPerson().getFullName());
				if(personToRemove.getLeft()!=null) { 
					child = personToRemove.getLeft();
				}else {
					child = personToRemove.getRight();
				}
				child.setUp(personToRemove.getUp());
				if(personToRemove==root) {
					root = child;
				}else if(personToRemove==personToRemove.getUp().getLeft()) { 
					personToRemove.getUp().setLeft(child); 
				}else {
					personToRemove.getUp().setRight(child); 
				}
			}
			
			//CASE 3: EL NODO A ELIMINAR TIENE 2 HIJOS:
			else {
				//System.out.println("dos hijos: "+personToRemove.getPerson().getFullName());
				//System.out.println("padre: "+personToRemove.getUp().getPerson().getFullName());
				NodeBinaryTree<T> succesor = min(personToRemove.getRight());
				personToRemove.setPerson(succesor.getPerson());
				removePerson(succesor);
			}
		}
	}
	
	public void addPeopletoList(String key,NodeBinaryTree<T> raizTmp) {
		NodeBinaryTree<T> currentnode = raizTmp;

		if (currentnode != null && currentnode.getPerson().getName().toUpperCase().startsWith(key.toUpperCase())) {
			listObject.add(currentnode.getPerson());
			if (currentnode.getRight() != null) {
				addPeopletoList(key, currentnode.getRight());
			}
			if (currentnode.getLeft() != null) {
				addPeopletoList(key, currentnode.getLeft());
			}
		} 
		else {
			if (currentnode.getRight() != null) {
				addPeopletoList(key, currentnode.getRight());
			}
			if (currentnode.getLeft() != null) {
				addPeopletoList(key, currentnode.getLeft());
			}
		}

	}
	
	public List<Person> getListObject() {
		return listObject;
	}
	
	public NodeBinaryTree<T> min(NodeBinaryTree<T> current) {
		if(current.getLeft()==null) {
			return current;
		}else {
			return min(current.getLeft());
		}
	}
	
}
