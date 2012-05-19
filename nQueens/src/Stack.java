import java.util.*;

public interface Stack {
	
	public int size();
	
	public boolean isEmpty();
	
	public int top() throws EmptyStackException;
	
	public void push (int row, int column);
	
	public QueenNode pop() throws EmptyStackException;
}
