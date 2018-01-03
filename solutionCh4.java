import java.util.*;
class solutionCh4{

	public static boolean childSumProperty(TreeNode root){
		if(root==null||(root.right==null && root.left==null)){
			return true;
		}
		int right = root.right!=null? root.right.val : 0;
		int left = root.left!=null? root.left.val:0;
		if(root.val!=right+left)
			return false;
		return (childSumProperty(root.right) && childSumProperty(root.left));
	}

	public static void printTreeInSpiral(TreeNode root){
		boolean ltr=false;
		int h= height(root);
		for(int i=1;i<=h;i++){
			ltr=true^ltr;
			spiralHelp( root,  i, ltr);
		}
	}

	public static void spiralHelp(TreeNode root, int level,boolean ltr){
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.val+" ");
		else{
			if(ltr){
				spiralHelp(root.left,level-1,ltr);
				spiralHelp(root.right,level-1,ltr);
			}
			else{
				spiralHelp(root.right,level-1,ltr);	
				spiralHelp(root.left,level-1,ltr);
			}
		}
	}

	public static TreeNode mirrorOfTree(TreeNode root){
		if(root == null)
			return root;
		TreeNode left = mirrorOfTree(root.left);
		TreeNode right = mirrorOfTree(root.right);

		root.left= right;
		root.right=left;
		return root;
	}

	public static void printAGivenLevel(TreeNode root, int level){
		if(root==null)
			return;

		if(level==1){
			System.out.print(root.val+" ");
		}
		else{
			printAGivenLevel(root.left,level-1);
			printAGivenLevel(root.right,level-1);
		}
	}

	public static TreeNode convertArrToTree(int[] arr){
		return convertHelper(arr,0, arr.length-1);
	}

	public static TreeNode convertHelper(int[] arr, int start, int end){
		TreeNode tn =null;
		if(start<=end){
		int median = (start+end)/2;
		tn =new TreeNode(arr[median]);
		tn.left=convertHelper(arr, start, median-1);
		tn.right=convertHelper(arr, median +1,end);

		//return tn;
	}
	return tn;
	}

	public static void printMirror(TreeNode root){
		if(root !=null){
			printMirror(root.right);
			System.out.print(root.val+" ");
			printMirror(root.left);
		}
	}
	public static void printInOrder(TreeNode root){
		if(root !=null){
			printInOrder(root.left);
			System.out.print(root.val+" ");
			printInOrder(root.right);
		}
	}
	public static void postOrder(TreeNode root){
		if(root !=null){
			printInOrder(root.left);
			printInOrder(root.right);
			System.out.print(root.val+" ");
		}
	}

	public static void preOrder(TreeNode root){
		if(root !=null){
			System.out.print(root.val+" ");
			printInOrder(root.left);
			printInOrder(root.right);
			
		}
	}

	public static int maxOf(int a, int b){
		if(a>b) return a;
		return b;
	}

	public static int height(TreeNode root){
		if(root != null){
			return maxOf(height(root.left)+1,height(root.right)+1);
		}
		return 0;
	}

	public static void printLevelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode tn = queue.poll();
			if(tn.left != null) queue.add(tn.left);
			if(tn.right != null)queue.add(tn.right);
			System.out.print(tn.val+" ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		for (int i=0;i<arr.length ;i++ ) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		TreeNode root = convertArrToTree(arr);

		System.out.print("Inorder Traversal : ");
		printInOrder(root);
		System.out.println();
		System.out.print("preorder Traversal : ");
		preOrder(root);
		System.out.println();
		System.out.print("post order Traversal : ");
		postOrder(root);
		System.out.println();

		System.out.println("Height of the tree is : "+height(root));
		System.out.print("level order Traversal : ");
		printLevelOrder(root);
		System.out.println();
		
		System.out.print("Tree in spiral : ");
		printTreeInSpiral(root);
		System.out.println();

		System.out.println("childSumProperty : "+childSumProperty(root));	

		int[] arr1={1,1,3,2,2};
		TreeNode root1 = convertArrToTree(arr1);	
		System.out.println("childSumProperty : "+childSumProperty(root1));

		System.out.print("print level 3 : ");
		printAGivenLevel(root,3);
		System.out.println();

		System.out.print("print Mirror : ");
		printMirror(root);
		System.out.println();
		System.out.print("Mirror the tree : ");
		root = mirrorOfTree(root);
		printInOrder(root);
		System.out.println();

	}
}