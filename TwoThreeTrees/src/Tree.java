import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tree {
	private Node root;
	public void insert(int x) {
		if(root == null) {
			root = new Node();
		}
		root.addValue(x);
	}
	public int size() {
		int sizee = root.traverse();
		return sizee;
	}
	public int size(Node newNode) {
		int sizee = newNode.traverse();
		return sizee;
	}
	
	public int size(int value) {
		Node found = root.find(value);
		if(found == null) {
			return 0;
		}
		return found.traverse();
	}
	
	public int get(int x) {
		return get(x, root);
	}
	public int get(int x, Node newNode) {
		int smallestElement = x;
		int index = 0;
		int childToStepInto = 0;
		int childrenSize =newNode.children.size();
		if(childrenSize<1) {
			return newNode.vals.get(x);
		}
		for(int i=0; i< childrenSize-1;i++) {
			// it only calls size once or twice per level. with childrensize-1 it shouldnt run more than twice 
			int childSize = size(newNode.children.get(i));
			index += childSize;
			if(index == smallestElement) {
				if(childToStepInto>0) {
					return newNode.vals.get(1);
				}
				return newNode.vals.get(0);
			}
			if(index > smallestElement) {
				index-=childSize;
				return get(smallestElement-index, newNode.children.get(childToStepInto));
			}
			index+=1;
			childToStepInto+=1;
		}
		//goes to last child
		return get(smallestElement-index, newNode.children.get(childToStepInto));
	}
	class Node {
		private Node parent;
		private ArrayList<Node> children = new ArrayList<Node>();
		private ArrayList<Integer> vals = new ArrayList<Integer>();
		public Node() {
			parent = null;
		}
		public Node(int value, Node newParent) {
			vals.add(value);
			parent = newParent;
		}
		private void sortChildren() {
			Collections.sort(children, new CompareChildren());
		}
		
		public void addValueDirectly(int val) {
			vals.add(val);
			Collections.sort(vals); 
		}
		
		public void setParent(Node newParent) {
			parent= newParent;
		}	
		private int traverse() {
//			System.out.println(newNode.vals);
//			System.out.print(newNode.vals);
//			
//			if(newNode.children.size() > 0) {
//				System.out.print(" 's children are ");
//				for(int i=0; i<newNode.children.size();i++) {
//					System.out.print(newNode.children.get(i).vals+" ");
//				}
//				System.out.println();
//			}else {
//				System.out.println(" has no children.");
//			}
			
			if(children.size() == 0) {
				return vals.size();
			}
			int size = vals.size();
			for(int i=0; i<children.size();i++) {
				size += children.get(i).traverse();
			}
			return size;
		}
		
		private Node find(int value) {
			if(vals.contains(value)) {
				return this;
			}
			if(children.size() == 0) {
				return null;
			}
			int i=0;
			while( i< vals.size() &&  value > vals.get(i)) {
				i+=1;
			}
			return children.get(i).find(value);
		}
		
		private Node searchChildren(int val) {
			for(int i=0; i<vals.size();i++) {
				if(val < vals.get(i)) {
					return children.get(i);
				}
			}
			return children.get(children.size()-1);
		}
		private void addValue(int val) {
			if(vals.contains(val)) {
				return;
			}
			if(children.size() < 2) {
				addValueDirectly(val);
			}else {
				searchChildren(val).addValue(val);
			}
			//this is a parent node
			
			checkIfFull();
		}
		private void split() {
			if(parent == null) {
				Node newParent = new Node(vals.get(1),null);
				root= newParent;
				newParent.children.add(new Node(vals.get(0),root));
				newParent.children.add(new Node(vals.get(2),root));
				vals.remove(2);
				vals.remove(0);
			}else {
				parent.addValueDirectly(vals.get(1));
				Node parentRight = new Node(vals.get(2),parent);
				parent.children.add(parentRight);
				vals.remove(1);
				vals.remove(1);
				parent.sortChildren();
				parent.checkIfFull();
			}
		}
		private void splitOverFullNode() {
			if(parent == null) {
				
				Node newParent = new Node(vals.get(1),null);
				root = newParent;
				Node parentLeft = new Node(vals.get(0),newParent);
				Node parentRight = new Node(vals.get(2),newParent);
				for(int i=0; i < 4;i++) {
					if(i<2) {
						parentLeft.children.add(children.get(i));
						parentLeft.children.get(i).setParent(parentLeft);
					}else {
						parentRight.children.add(children.get(i));
						parentRight.children.get(parentRight.children.size()-1).setParent(parentRight);
					}
				}
				
				newParent.children.add(parentLeft);
				newParent.children.add(parentRight);
				
			}else {
				parent.addValueDirectly(vals.get(1));
				
				Node parentRight = new Node(vals.get(2),parent);
				parentRight.children.add(children.get(2));
				parentRight.children.add(children.get(3));
				parentRight.children.get(0).setParent(parentRight);
				parentRight.children.get(1).setParent(parentRight);
				parentRight.sortChildren();
				sortChildren();
				children.remove(2);
				children.remove(2);
				parent.children.add(parentRight);
				vals.remove(1);
				vals.remove(1);
				parent.sortChildren();
				parent.checkIfFull();
			}
		}
		private void checkIfFull() {
//			System.out.print("vals : ");
//			System.out.println(vals);
//			
//			System.out.print("parent children : ");
//			if(parent != null) {
//				for(int i=0; i<parent.children.size();i++) {
//					System.out.println(parent.children.get(i).vals);
//				}
//			}

			if(vals.size()==3 && children.size()==4) {
				splitOverFullNode();
			}else if (vals.size()==3) {
				split();
			}
		}
	}	
	public class CompareChildren implements Comparator<Node> {
	    @Override
	    public int compare(Node n1, Node n2) {
	        return n1.vals.get(0).compareTo(n2.vals.get(0));
	    }
	}
}



