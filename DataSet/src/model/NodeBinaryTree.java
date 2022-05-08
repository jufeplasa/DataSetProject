package model;

public class NodeBinaryTree<T> {
	
	private Person person;
    private NodeBinaryTree<T> left;
    private NodeBinaryTree<T> right;
    private NodeBinaryTree<T> up;
	

    public NodeBinaryTree(Person object) {
        this.person = object;
    }

	public NodeBinaryTree<T> getLeft() {
		return left;
	}

	public void setLeft(NodeBinaryTree<T> left) {
		this.left = left;
	}

	public NodeBinaryTree<T> getRight() {
		return right;
	}

	public void setRight(NodeBinaryTree<T> right) {
		this.right = right;
	}

	public NodeBinaryTree<T> getUp() {
		return up;
	}

	public void setUp(NodeBinaryTree<T> up) {
		this.up = up;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person object) {
		this.person = object;
	}
    
    
}
