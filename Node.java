public class Node
{
	public Node left;
	public Node right;
	public int data;

	//using this constructor for null
	public Node()
	{
		left = null;
		right = null;
		data = Integer.MIN_VALUE;
	}
	public Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	public Node(Node left,Node right,int data)
	{
		this.left = left;
		this.right = right;
		this.data = data;
	}
}