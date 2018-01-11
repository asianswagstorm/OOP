import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Comp 352 Assignment 3 Tree and Tree Node Class
 * Author Andy Nguyen 27333870
 * @param <E>
 */


public class Tree<E>  {

	protected TreeNode<E> root;
	private int size;

	/**
	 * Default Constructor
	 */
	public Tree()
	{
		root=null;
		size=0;
	}
	/**
	 * Constructor that takes in parameter Tree<E> of type E its a generic 
	 * @param tree
	 */
	public Tree(Tree<E> tree){
		root=clone(tree.root);
		size=tree.size;
	}

	/**
	 * Method that creates a new Node. 
	 * @param data - The Element that the node holds.
	 * @param parent - The link to parent node.
	 * @param left - The link to the left node.
	 * @param right - The link to the right Node.
	 * @return - Returns the newly created Node
	 */
	protected TreeNode<E> createNewNode(E data , TreeNode<E> parent , TreeNode<E> left , TreeNode<E> right) 
	{
		return new TreeNode<E> (data, parent ,left, right);
	}
	/**
	 * Root Method that returns the position of the node
	 * @return - Returns the root
	 */
	public TreeNode<E> root() //returns the position of the root of the tree
	{
		return root;
	}
	/**
	 * Parent Method that returns the position of the parent node
	 * @param p - The Tree Node Object itself
	 * @return  - Returns the parent 
	 */
	public TreeNode<E>  parent(TreeNode<E> p) //parent(p) returns the position of the right child of p null if p is root
	{ 
		TreeNode node= (TreeNode<E>)p;
		if (node.getParent()==null)//if null return null
			return null;

		return node.getParent();
	}
	/**
	 * Iterable Method that returns the children of the Specific Parent Node through a collection Data Type
	 * The Data Type that will be used is an Array List, that will hold up to two elements. 
	 * @param p the Tree Node that will get the Children.
	 * @return - Returns that collection of children of the Parent Node p.
	 */
	public Iterable <TreeNode<E>>  children(TreeNode <E> p) //returns an iterable collection containing the children of position p
	{
		List<TreeNode<E>> childList = new ArrayList<>(2); // Max of two children
		if(left(p) !=null)
			childList.add(left(p));  // if doesnt have left child add one
		if(right(p) != null)
			childList.add(right(p)); // if doesnt have right child add one
		return childList; // return both children
	}
/**
 * Integer method that returns the number of children that a node has.
 * @param p - The node that will show the number of children it has.
 * @return - Return the number of children.
 */
	public int  numChildren(TreeNode <E> p) //returns the number of children of position p.
	{
		int i=0;
		if(left(p) !=null)//If the node has a left child
			i++; 	//increment i 
		if(right(p)!= null)//If the node thas a right child
			i++;	//increment i 
		return i; //return i
	}
/**
 * Method that returns the left child
 * @param p - The node 
 * @return - Return the left child
 */
	public TreeNode<E> left (TreeNode <E> p)//left(p) returns the position of the left child of p
	{
		TreeNode node = (TreeNode<E>)p;
		return node.getLeft();
	}
/**
 * Method that returns the right child
 * @param p - The node 
 * @return - Return the right child
 */
	public TreeNode<E> right(TreeNode <E> p)//right(p) returns the position of the right child of p
	{
		TreeNode node= (TreeNode<E>)p;
		return node.getRight();
	}
/**
 * 
 * @param p
 * @return
 */
	public TreeNode<E> siblings(TreeNode <E> p)//siblings(p): returns the position of the siblings of p
	{
		TreeNode <E> parent = parent(p);
		if(parent.equals(null)) 
			return null;
		if(p.equals(right(parent)))
			return left(parent);
		else
			return right(parent);
	}
/**
 * 	Boolean method that checks if the node is an Internal node, If it has children
 * @param p - The node 
 * @return - Return boolean value 
 */
	public boolean isInternal(TreeNode<E> p)//isInternal(p): returns true if position p has at least one child
	{
		return numChildren(p)>0;
	}
/**
 *	Boolean method that checks if the node is an External node, If it does not have children
 * @param p - The node 
 * @return - Return boolean value 
 */
	public boolean isExternal(TreeNode<E> p)//: returns true if position p does not have any children
	{
		return numChildren(p) == 0;
	}
/**
 * Boolean method to check if the node is a root 
 * @param p - The node
 * @return - Return the boolean expression
 */
	public boolean isRoot(TreeNode <E> p)//isRoot(p): returns true if position p is the root of the tree
	{
		return p == root;
	}
/**
 * Integer method that returns the size
 * @return - Returns the size of the Tree
 */
	public int size()//size( ): returns the number of positions that are contained in the tree
	{
		return size;
	}	
/**
 * Boolean Method to check if the tree is empty 
 * returns true if the tree does not contain any positions
 * @return - The boolean Expression
 */
	public boolean isEmpty()
	{
		return size() == 0;	
	}
/**
 * Integer method that gets the height of the root.
 * @param p - The node
 * @return - Return the height
 */
	public int height( TreeNode<E> p )//: recursive method that returns the height of a binary tree
	{
		int height = 0;
		for(TreeNode<E> c : children(p))
			height= Math.max(height,1+height(c)); //height(c) recursive???
		return height;
	}

	public int height()
	{
		return height(root);
	}
/**
 * Method of type int that returns the number of leaves in this specific Tree.
 * Reminder A leaf is a node that has no children. I.E its an external Node.
 * @param p - The node
 * @return - The number of leaves
 */
	public int numleaf(TreeNode<E> p )//recursive method that returns a count of the number of leaf nodes in a binary tree
	{
		if(p==null)
			return 0;
		if(p.getLeft() == null && p.getRight()==null)
			return 1;
		else
			return numleaf(p.getLeft()) + numleaf(p.getRight());
	}
/**
 * Method of type int that returns the number of leaves in this specific Tree.
 * Reminder A leaf is a node that has no children. I.E its an external Node.
 * @return - Return the number of leaves of the Tree.
 */
	public int numleaf()
	{
		return numleaf(root);
	}
/**
 * A calling method for the recursive Clone method.
 */
	public Tree<E> clone()
	{
		return new Tree<E>(this);
	}
	//recursive method
	/**
	 * The Clone Method written recursively
	 * Recursive method that returns a clone (complete copy) a binary tree.
	 * @param p - A node
	 * @return Returns the clone of the Tree.
	 */
	public TreeNode<E> clone(TreeNode<E>p)
	{
		TreeNode<E> parentNode = new TreeNode<E>(p.getElement(), p.getParent(), p.getLeft(), p.getRight());
		
		TreeNode<E> rightNode = (TreeNode<E>)p;
		TreeNode<E> leftNode = (TreeNode<E>)p;

		if(parentNode.getLeft() !=null){
			leftNode = (TreeNode<E>)clone(left(p));
			parentNode.setLeft(leftNode);
			leftNode.setParent(parentNode);
		}

		if(parentNode.getRight() !=null){
			rightNode = (TreeNode<E>)clone(right(p));
			parentNode.setRight(rightNode);
			rightNode.setParent(parentNode);
		}

		return parentNode;

	}
/**
 * Method to add a root to the tree
 * @param e - The object 
 * @return - Return the new added root of the tree
 * @throws IllegalStateException
 */
	public TreeNode <E> addRoot(E e) throws IllegalStateException
	{
		if(!isEmpty())throw new IllegalStateException("Non Empty tree");
		root = createNewNode(e,null,null,null);
		size=1;

		return root;
	}
	
	public TreeNode<E> addLeft(TreeNode<E> p, E e)throws IllegalArgumentException 
	{ 
		TreeNode<E> parent = (TreeNode<E>)p;
		if (parent.getLeft( ) != null)
			throw new IllegalArgumentException("p already has a left child");
		TreeNode<E> child = createNewNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	public TreeNode<E> addRight(TreeNode<E> p, E e)throws IllegalArgumentException 
	{ 
		TreeNode<E> parent = (TreeNode<E>)p;

		if (parent.getRight( ) != null)
			throw new IllegalArgumentException("p already has a right child");
		TreeNode<E> child = createNewNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	public E set(TreeNode<E> p, E e) throws IllegalArgumentException 
	{  TreeNode<E> node = (TreeNode<E>)p;
	E temp = node.getElement( );
	node.setElement(e);
	return temp;
	}

	public void iterator(TreeNode<E> p, List<E> inorderList){
		if(left(p)!= null)
			iterator(left(p), inorderList); // recursive
		inorderList.add(p.getElement());
		if(right(p)!=null)
			iterator(right(p), inorderList);
	}

	public List<E> iterator() {
		List<E> newlist = new ArrayList<E>();
		iterator(root , newlist);
		return newlist;
	}
	//returns the nodes I.E the adresses
	
	public List<TreeNode<E>> positions() {
		List<TreeNode<E>> ioList = new ArrayList<TreeNode<E>>();
		if(!isEmpty())
			inOrderPosition(root(), ioList); 
		return ioList;

	}

	public void inOrderPosition(TreeNode<E> p , List<TreeNode<E>> OrderedList)
	{
		if(left(p)!= null)
			inOrderPosition(left(p), OrderedList); // recursive
		OrderedList.add(p);
		if(right(p)!=null)
			inOrderPosition(right(p), OrderedList);
	}
}
/**
 * Class Node
 * @author Andy
 * This Class contains everything that is related to the node of the Tree itself.
 * @param <E> Type <E> means it can be of any type 
 */
class TreeNode<E> { 

	private E data;
	private TreeNode<E> parent; // upper pointer of node
	private TreeNode<E> leftlink; // left pointer of node
	private TreeNode<E> rightlink; // right pointer of node
/**
 * Default constructor
 */
	public TreeNode()
	{
		data = null;
		parent = null;
		leftlink = null;
		rightlink = null;
	}
/**
 * Constructor that takes in parameters
 * @param data - The element of the node
 * @param parent - The parent link
 * @param left	- The left link
 * @param right - The right link
 */
	public TreeNode(E data,TreeNode<E> parent, TreeNode<E> left,TreeNode<E> right )
	{
		this.data=data;
		this.parent=parent;
		leftlink= left;
		rightlink=right;
	}
	//accessors

	public E getElement() // return element at this position
	{
		return data;
	}

	public TreeNode<E> getParent()
	{
		return parent;
	}

	public TreeNode<E> getLeft()
	{
		return leftlink;
	}

	public TreeNode<E> getRight()
	{
		return rightlink;
	}
	// mutators
	
	public void setElement(E e)
	{
		data = e;
	}

	public void setParent(TreeNode<E> parentNode)
	{
		parent=parentNode;
	}

	public void setLeft(TreeNode<E> leftChild)
	{
		leftlink= leftChild;
	}

	public void setRight(TreeNode<E> rightChild)
	{
		rightlink = rightChild;
	}

	public String toString()
	{
		return data + "";
	}

}




