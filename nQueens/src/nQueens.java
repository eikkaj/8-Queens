import java.util.*;
import java.lang.Math;


public class nQueens implements Stack {

	/**
	 * Solve the n-queens problem using a stack
	 * @param args
	 */
	
	private static QueenNode head;
	private static int size;
	private static boolean success = false;
	
	private static nQueens queens = new nQueens();
	
	public nQueens() {
		head = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(int row, int column) {
		//always pushes to the top
		QueenNode v = new QueenNode();
		v.setColumn(column);
		v.setRow(row);
		
		if (isEmpty()) {
			head = v;
		} else {
			v.setNext(head);
			head = v;
		}
		System.out.println("Pushing to " + row + ", " + column);
		size++;
	}
	
	public int top() throws EmptyStackException {
		//prints head node
		if (isEmpty()) throw new EmptyStackException();
		System.out.println(head.getRow() + ", " + head.getColumn());
		return head.getColumn();
	}
	
	public QueenNode pop() throws EmptyStackException {
		//take off head node
		if (isEmpty()) throw new EmptyStackException();
		
		head = head.getNext();
		size--;
		return head;
	}
	
	public void viewPieces() {
		//print entire stack
		QueenNode temp = head;
		System.out.println();
		while (temp != null) {
			System.out.println(temp.getRow() + ", " + temp.getColumn());
			System.out.println();
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	
	//problem because it only checks the first and second nodes in the stack!!
	public static boolean diagonal(QueenNode a, QueenNode b) {
		while (a != null && b!= null) {
			if (Math.abs((a.getRow() - b.getRow())) == Math.abs((a.getColumn() - b.getColumn()))) {
				return true; // there is a problem
			}
			else {
				b = b.getNext();
			}
		}
		return false; //no diagonal problems
	}
	
	public static boolean conflictCheck() {
		//check for conflicts between head and all other nodes in the stack
		QueenNode a = head;
		QueenNode b = head.getNext();
		while (b!=null) {
			if (a.getRow() == b.getRow() || a.getColumn() == b.getColumn() || 
					Math.abs((a.getRow() - b.getRow())) == Math.abs((a.getColumn() - b.getColumn()))) {
				return true;
			} 
			b = b.getNext();
		}	
		return false;
	}
	
	public static void playChess() {
		//Keep looping until the board is full
		while(!success) {
			//if there is a conflict, pop stack until stack is empty or head is not in column 8
			//if stack is now not empty, increase column of top choice by 1
			//if no conflict and stack isn't full, push new queen at row size+1, column 1
			//solve until successful
			if (conflictCheck()) {
				System.out.println("There is a conflict");
				if (head.getColumn() == 8) {
					queens.pop();
					if (head.getColumn()!= 8 ) {
						head.setColumn(head.getColumn()+1);
					} else {
						queens.pop();
						head.setColumn(head.getColumn()+1);
					}
					
					System.out.println("Head is at 8, popping and adjusting new head");
				} else if (!queens.isEmpty() && head.getColumn() !=8) {
					System.out.println("Adjusting head to " + head.getRow() +", " + (head.getColumn()+1));

					head.setColumn(head.getColumn()+1);
				}
			} else if (queens.size() < 8) {
				System.out.println("Stack isn't full yet");
				queens.push(queens.size() + 1,1);
			} else {
				System.out.println("Success");
				queens.viewPieces();
				success = true;
			}
		}
		queens.viewPieces();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queens.push(1,1);
		playChess();
	}

}
