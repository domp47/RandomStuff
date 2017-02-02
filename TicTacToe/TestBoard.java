package TicTacToe;
import javax.swing.JFrame;
public class TestBoard {

	public static void main(String[] args) {
		
		char[][] c = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		
		TicTacToeBoard window = new TicTacToeBoard(c);    	
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setTitle("Tic Tac Toe");

	}

}
