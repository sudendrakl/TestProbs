import java.io.*;
import java.util.*;

/*
 * Binary tree
 * InOrderTraversal
 * PreOrderTraversal
 * PostOrderTraversal
 * 
 * input:--->
 * a:34 b:12 c:41 d:81 e:39 f:61 d:19
 * 
 */
public class BinaryTree {

	private Node rootNode;

	public static void main(String args[]) throws IOException {
		System.out.println("Enter array for binary tree insertion");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		BinaryTree binaryTree = new BinaryTree();
		for (String s : line.split("\\s+")) {
			String[] split = s.split(":");
			binaryTree.addNode(split[0], Integer.parseInt(split[1]));
		}

		System.out.println("\ninOrderTraverse()");
		binaryTree.inOrderTraverse(binaryTree.rootNode);

		System.out.println("\n\npreOrderTraverse");
		binaryTree.preOrderTraverse(binaryTree.rootNode);

		System.out.println("\n\npostOrderTraverse");
		binaryTree.postOrderTraverse(binaryTree.rootNode);

		System.out.println("\n\nEnter Search node key");
		String search = br.readLine();
		System.out.print("Found -->" + binaryTree.find(Integer.parseInt(search)));
	}

	private void addNode(String name, int key) {
		Node newNode = new Node(key, name);

		if (rootNode == null) {
			rootNode = newNode;
		} else {
			Node focusNode = rootNode;
			Node parentNode;
			while (true) {
				parentNode = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.left;
					if (focusNode == null) {
						parentNode.left = newNode;
						return;
					}
				} else {
					focusNode = focusNode.right;
					if (focusNode == null) {
						parentNode.right = newNode;
						return;
					}
				}
			}
		}

	}

	private void inOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverse(focusNode.left);
			System.out.print(focusNode + " ");
			inOrderTraverse(focusNode.right);
		}
	}

	private void preOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			System.out.print(focusNode + " ");
			preOrderTraverse(focusNode.left);
			preOrderTraverse(focusNode.right);
		}
	}

	private void postOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverse(focusNode.left);
			postOrderTraverse(focusNode.right);
			System.out.print(focusNode + " ");
		}
	}

	private Node find(int key) {
		Node focusNode = rootNode;
		while (focusNode != null) {
			if (key < focusNode.key) {
				focusNode = focusNode.left;
			} else if (key > focusNode.key) {
				focusNode = focusNode.right;
			} else if (key == focusNode.key) {
				return focusNode;
			}
		}
		return null;
	}

	class Node {
		int key;
		String name;
		Node left, right;

		Node(int key, String name) {
			this.key = key;
			this.name = name;
		}

		@Override
		public String toString() {
			return name + ":" + key;
		}
	}
}
