import java.util.*;
public class Tree
{
	public Node root = null;

	public void add(int data)
	{
		if(root == null)
		{
			Node node = new Node(data);
			root = node;		
		}
		else
		{
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			while(queue.peek()!=null)
			{
				Node node = queue.remove();

					if(node.left == null)
					{
						node.left = new Node(data);
						return;
					}
					else{
						queue.add(node.left);
					}

				    if(node.right == null)
					{
						node.right = new Node(data);
						return;
					}
					else
					{
						queue.add(node.right);
					}
				

			}

		}
	}

	public static void levelOrderTraversal(Node root)
	{
		if(root!=null)
		{
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			while(queue.peek()!=null)
			{
				Node node = queue.remove();
				if(node !=null)
				{
					System.out.print(node.data+", ");

					if(node.left != null)
						queue.add(node.left);
					if(node.right != null)
						queue.add(node.right);
				}

			}
			System.out.println();
		}
	}

	public static void preOrderTraversal(Node root)
	{
		if(root!=null)
		{
			System.out.print(root.data+", ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);

		}
	}

	public static void inOrderTraversal(Node root)
	{
		if(root!=null)
		{
			inOrderTraversal(root.left);
			System.out.print(root.data+", ");
			inOrderTraversal(root.right);

		}
	}

	public static void postOrderTraversal(Node root)
	{
		if(root!=null)
		{
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data+", ");

		}
	}

	public int max()
	{
		int max = Integer.MIN_VALUE;
		if(root!=null)
		{
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			while(queue.peek() != null)
			{
				Node node = queue.remove();
				if(max < node.data)
					max = node.data;
				if(node.left !=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}

			

		}
		return max;
	}

	public int size()
	{
		int count = 0;
		if(root!=null)
		{
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			while(queue.peek() != null)
			{
				count++;
				Node node = queue.remove();
				if(node.left !=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}

			

		}
		return count;

	}

	public static void levelOrderReverseTraversal(Node root)
	{
		if(root!=null){
		Stack<Integer> stack = new Stack<Integer>();
		Deque<Node> queue = new ArrayDeque<Node>();
		queue.add(root);

		while(queue.peek() != null)
		{
			Node node = queue.remove();
			stack.push(node.data);

			if(node.right!=null)
				queue.add(node.right);
			if(node.left!=null)
				queue.add(node.left);
		}

		while(stack.size()!=0)
		{
			System.out.print(stack.pop()+", ");
		}
	}
	}
/*
	public static int height(Node root)
	{
		int height = 0;
		if(root == null)
			return height;
		else{
			int left = height(root.left);
			int right = height(root.right);

			return (left>right)?left+1:right+1;
		}
	}
	*/

	public int height()
	{
		int height = 0;
		if(root!=null)
		{
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			queue.add(new Node());

			while(queue.peek()!=null)
			{
				Node node = queue.remove();

				if(node.left == null && node.right == null && node.data == Integer.MIN_VALUE)
				{
					if(queue.peek()!=null)
						queue.add(new Node());
					height++;
				}
				else
				{
					if(node.left!=null)
						queue.add(node.left);
					if(node.right != null)
						queue.add(node.right);
				}
			}
	    }
	    return height;
	}

	public Node deepestNode()
	{
		Node deepestNode = null;
		if(root!=null)
		{
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			while (queue.peek() != null) {

				deepestNode = queue.remove();
				if(deepestNode.left != null)
					queue.add(deepestNode.left);
				if(deepestNode.right != null)
					queue.add(deepestNode.right);	
			}
		}
		return deepestNode;
	}

	public boolean delete(int data)
	{
		if(root!=null)
		{
			Node dataNode = null;
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);

			while(queue.peek() != null)
			{
				Node temp = queue.remove();
				if(temp.data == data){
					dataNode = temp;
					break;
				}
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}

			if(dataNode!=null)
			{
				Node ances = null;
				int c = 0;
				Node deepestNode = null;

			    queue = new ArrayDeque<Node>();
				queue.add(root);
				while(queue.peek() != null)
				{
					deepestNode = queue.remove();
					if(deepestNode.left != null){
						queue.add(deepestNode.left);
						ances = deepestNode;
						c = 0;
					}
					if(deepestNode.right != null){
						queue.add(deepestNode.right);
						ances = deepestNode;
						c = 1;
					}
				}

				dataNode.data = deepestNode.data;

				if(c==0)
					ances.left = null;
				else
					ances.right = null;

				return true;
			}
			else
				return false;

		}
		return false;
	}

	public int leafNodes()
	{
		int leafNodesCounter = 0;
		if(root!=null)
		{
			Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			while(queue.peek() != null)
			{
				Node node = queue.remove();

				if(node.left == null && node.right == null)
				{
					leafNodesCounter++;
				}
				else{
					if(node.left!=null)
					   queue.add(node.left);
				    if(node.right!=null)
					   queue.add(node.right);
				}

			}

			return leafNodesCounter;
		}
		return leafNodesCounter;
	}

	public int fullNodes()
	{

		return size() - leafNodes();
	}

	public int halfNodes()
	{
		int halfNodesCounter = 0;

		if(root!=null)
		{
			Deque<Node> queue =  new ArrayDeque<Node>();
			queue.add(root);
			while(queue.peek() != null)
			{
				Node node = queue.remove();
				if((node.left == null && node.right != null) ||
					(node.left!=null && node.right == null))
				{
					halfNodesCounter++;
				}
				
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}

			return halfNodesCounter;
		}
		return halfNodesCounter;
	}

	public static boolean structurullySameTrees(Node root1,Node root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;

		return (root1.data == root2.data && structurullySameTrees(root1.left,root2.left) 
			&& structurullySameTrees(root1.right,root2.right));
		
	}

	
}