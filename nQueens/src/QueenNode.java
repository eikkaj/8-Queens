
public class QueenNode {

	int row;
	int column;
	QueenNode next;
	
	public QueenNode() {
		
	}
	
	public QueenNode(int r, int c, QueenNode n) {
		row = r;
		column = c;
		next = n;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public QueenNode getNext() {
		return next;
	}

	public void setNext(QueenNode next) {
		this.next = next;
	}
	
	
}
