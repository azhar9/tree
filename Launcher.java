public class Launcher
{
	public static void main(String[] args) {
		Tree tree =  new Tree();
		for(int i=1;i<=8;i++)
			tree.add(i);
		Tree.levelOrderTraversal(tree.root);
		/*
		Tree.preOrderTraversal(tree.root);
		System.out.println();
		Tree.inOrderTraversal(tree.root);
		System.out.println();
		Tree.postOrderTraversal(tree.root);
		System.out.println();
	
		System.out.println(tree.max());

		System.out.println(tree.size());

		Tree.levelOrderReverseTraversal(tree.root);

		System.out.println(Tree.height(tree.root));
		
		System.out.println(tree.height());

		System.out.println(tree.deepestNode().data);
		
		System.out.println(tree.delete(8));
		Tree.levelOrderTraversal(tree.root);

		System.out.println(tree.leafNodes());
		System.out.println(tree.fullNodes());

		System.out.println(tree.halfNodes());

		System.out.println(Tree.structurullySameTrees(tree.root,tree1.root));

		*/
		


	}
}