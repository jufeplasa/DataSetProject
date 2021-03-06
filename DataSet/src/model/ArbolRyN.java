package model;

import java.util.ArrayList;
import java.util.List;

public class ArbolRyN<K extends Comparable<K>, V>{
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node {
		public K key;
		public V value;
		public Node left, right;
		public boolean color;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			color = RED;
		}
		
	}
	
	private Node root;
	private int size;
	private List<K> listObject;
	
	public ArbolRyN() {
		setListObject(new ArrayList<K>());
		root = null;
		size = 0;
	}

	public Node getRoot() {
		return root;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private Node rotarALaIzquierda(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}
	
	private Node rotarALaDerecha(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}
	
	private void cambiarColores(Node node) {
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}
	
	private boolean esRojo(Node node) {
		if (node == null)
			return BLACK;
		return node.color;
	}
	
	public void add(K key, V value) {
		root = add(root, key, value);
		root.color = BLACK;
	}
	
	private Node add(Node node, K key, V value) {
		if (node == null) {
			size++;
			return new Node(key, value);
		}
		if(key.compareTo(node.key) < 0)
			node.left = add(node.left, key, value);
		else if(key.compareTo(node.key) > 0) 
			node.right = add(node.right, key, value);
		else
			node.value = value;
		
		if(esRojo(node.right) && !esRojo(node.left))
			node = rotarALaIzquierda(node);
		if(esRojo(node.left) && !esRojo(node.left.left))
			node = rotarALaDerecha(node);
		if(esRojo(node.left) && esRojo(node.right))
			cambiarColores(node);
		return node;
	}
	
	private Node getNode(Node node, K key) {
		if (node == null)
			return null;
		if(key.equals((node.key))) {
			return node;
		}
		else if(key.compareTo(key) < 0) {
			return getNode(node.left, key) ;
		}
		else {
			return getNode(node.right, key);
		}
	}
	
	public boolean contiene(K key) {
		return getNode(root, key) != null;
	}
	
	public V get(K key) {
		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}
	
	public void set(K key, V newValue) {
		Node node = getNode(root, key);
		if(node == null)
			throw new IllegalArgumentException(key + "?No existe!");
		node.value = newValue;
	}
	
	private Node minimo(Node node) {
		if(node.left == null)
			return node;
		return minimo(node.left);
	}
	
	private Node elimiarMin(Node node) {
		if (node.left == null) {
			Node nodoDerecho = node.right;
			node.right = null;
			size--;
			return nodoDerecho;
		}
		node.left = elimiarMin(node.left);
		return node;
	}
	
	public V eliminar(K key) {
		Node node = getNode(root, key);
		if(node != null) {
			root = eliminar(root, key);
			return node.value;
		}
		return null;
	}
	
	private Node eliminar(Node node, K key) {
		if(node == null)
			return null;
		if(key.compareTo(node.key) < 0) {
			node.left = eliminar(node.left, key);
			return node;
		} else if(key.compareTo(node.key) > 0) {
			node.right = eliminar(node.right, key);
			return node;
		} else {
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			
			Node successor = minimo(node.right);
			successor.right = elimiarMin(node.right);
			successor.left = node.left;
			
			node.left = node.right = null;
			
			return successor;
		}
	}
	
	/**public void addPeopletoList(String key, Node raizTmp) {
		Nodo<T> currentnode = raizTmp;

		if (currentnode.getDato() != null && currentnode.getComparador().toUpperCase().startsWith(key.toUpperCase())) {
			System.out.println(currentnode.getComparador());
			listObject.add(raizTmp.getDato());
			if (currentnode.getDerecha() != null) {
				addPeopletoList(key, currentnode.getDerecha());
			}
			if (currentnode.getIzquierda() != null) {
				addPeopletoList(key, currentnode.getIzquierda());
			}
		} 
		else {
			System.out.println("no entro");
			if(currentnode.getDerecha()!=null) {
				addPeopletoList( key,currentnode.getDerecha());
			}
			if (currentnode.getIzquierda() != null) {
				addPeopletoList(key, currentnode.getIzquierda());
			}
		}

	}**/

	public List<K> getListObject() {
		return listObject;
	}

	public void setListObject(List<K> listObject) {
		this.listObject = listObject;
	}
	
	
}
