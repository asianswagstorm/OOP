import java.util.ArrayList;
import java.util.List;
/**
 * Comp 352 Assignment 3 Driver Class
 * @author Andy Nguyen 27333870
 *
 */

public class Driver {

	public static void main ( String [] args)
	{
		Tree<Character> tree1 = new Tree<Character>();
		
		tree1.addRoot('+');

		TreeNode p1 = tree1.root();
		System.out.println("p1 Root: " + p1.getElement());

		tree1.addLeft(p1,'*');
		TreeNode p2 = tree1.left(p1);
		System.out.println("p2 Left:" + p2.getElement());

		tree1.addRight(p1,'*');
		TreeNode p3 = tree1.right(p1);
		System.out.println("p3 Right: " +p3.getElement());

		tree1.addLeft(p2, '2');
		TreeNode p4 =tree1.left(p2);
		System.out.println("p4 Left of " +p2.getElement()+ " is " + p4.getElement());

		tree1.addRight(p2, '-');
		TreeNode p5 = tree1.right(p2);
		System.out.println("p5 Right of " +p2.getElement()+ " is " + p5.getElement());

		tree1.addLeft(p3, '3');
		TreeNode p6 = tree1.left(p3);
		System.out.println("p6 Left of " + p3.getElement() + " is " + p6.getElement());

		tree1.addRight(p3, 'b');
		TreeNode p7 = tree1.right(p3);
		System.out.println("p7 Right of " + p3.getElement() + " is " + p7.getElement());

		tree1.addLeft(p5, 'a');
		TreeNode p8 = tree1.left(p5);
		System.out.println("p8 Left of " + p5.getElement() + " is " + p8.getElement());

		tree1.addRight(p5, '1');
		TreeNode p9 = tree1.right(p5);
		System.out.println("p9 Right of " + p5.getElement() + " is " + p9.getElement());


		System.out.println(" ---------------------  Test Cases --------------------------");
		System.out.println(Driver.toString(tree1,p1));

		System.out.println(tree1.numChildren(p1) + " Children");
		
		System.out.println("Tree Original:  InOrder Sequence " + tree1.iterator() + " size is: " + tree1.size());
		
		Tree<Character> tree2 = tree1.clone();
		List<TreeNode<Character>> newList = tree2.positions();
		tree2.addLeft(newList.get(6), '6');
		
		System.out.println("Tree Clone: InOrder Sequence " + tree2.iterator() + " size is: " + tree2.size());
		
		System.out.println("Tree Original: InOrder Sequence " + tree1.iterator() + " size is: " + tree1.size());
		
	System.out.println("Children of p3 "+  (tree1.children(p3)));
		System.out.println("Size of tree contains : " + tree1.size() + " nodes");

		System.out.println("Height of tree is : " + tree1.height());
		System.out.println("Tree has "+ tree1.numleaf() + " leaves");
		System.out.println(tree1.siblings(p6));
		
	
	}

	public static String toString(Tree tree ,TreeNode SomeNode)
	{String s = " "; String t = " "; String z = " ";
	if(tree.isRoot(SomeNode)== true)
		s= SomeNode.getElement() + " is the root";

	else if(tree.isRoot(SomeNode)== false)
		s= SomeNode.getElement() + " is not the root ";

	if(tree.isEmpty()== true)
		t= " this tree is empty";

	else if ( tree.isEmpty()== false)
		t=" this tree is not empty";

	if(tree.isExternal(SomeNode)==true)
		z=SomeNode.getElement() + " is an External Node";

	else if (tree.isExternal(SomeNode)==false && tree.isInternal(SomeNode))
		z=SomeNode.getElement() + " is an Internal Node";

	return s + " and " + t + " and " + z;
	}


}
