package TicTacToe;
import BasicIO.*;

public class TicTacToe {

	private ASCIIDisplayer dis;
	private ASCIIDisplayer mes;
	private ASCIIPrompter in;
	private char[][] board = new char[3][3];
	private int moveN;

	public TicTacToe() {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x] = ' ';
			}
		}

		dis = new ASCIIDisplayer();
		printBoard();
		for (int i = 0; i < 9; i++) {
			moveN = i + 1;
			if (i % 2 == 0) {
				PlayO();
				if (win('O')) {
					dis.writeString("Player 1 wins.");
					dis.close();
					return;
				}
			} else {
				PlayX();
				if (win('X')) {
					dis.writeString("CPU wins.");
					dis.close();
					return;
				}
			}
		}
		dis.writeString("It's a Tie!");
		dis.close();
	}

	private Boolean win(char p) {
		for (int y = 0; y < board.length; y++) {
			if (board[y][0] == p && board[y][1] == p && board[y][2] == p)
				return true;
		}
		for (int x = 0; x < board[0].length; x++) {
			if (board[0][x] == p && board[1][x] == p && board[2][x] == p)
				return true;
		}
		if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
			return true;
		}
		if (board[2][0] == p && board[1][1] == p && board[0][2] == p) {
			return true;
		}
		return false;
	}

	private void printBoard() {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (x == board[y].length - 1)
					dis.writeString(board[y][x] + "");
				else
					dis.writeString("" + board[y][x] + " |");
			}
			dis.newLine();
			if (y != board.length - 1)
				dis.writeString("- + - + -");
			dis.newLine();
		}
		dis.newLine();
		dis.newLine();
	}

	private void PlayO() {
		int x = -1, y = -1;

		in = new ASCIIPrompter();
		in.setLabel("Row:");
		y = in.readInt();
		in.close();

		in = new ASCIIPrompter();
		in.setLabel("Column");
		x = in.readInt();
		in.close();

		try {
			if (board[y - 1][x - 1] != ' ') {
				mes = new ASCIIDisplayer();
				mes.writeString("Row " + y + ", Column " + x + " is already filled.\nTry Again.");
				mes.close();
				PlayO();
			} else
				board[y - 1][x - 1] = 'O';
			printBoard();
		} catch (ArrayIndexOutOfBoundsException e) {
			mes = new ASCIIDisplayer();
			mes.writeString("Row " + (y - 1) + " and Column " + (x - 1) + " does not exist.\nTry Again.");
			mes.close();
			PlayO();
		}
	}

	private void PlayX() {
		int eval, bEval = Integer.MIN_VALUE, Idx = 0, Idy = 0;

		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (board[y][x] == ' ') {

					board[y][x] = 'X';
					eval = Eval(moveN, 1000000000, 'O');
					if (Math.max(bEval, eval) != bEval) {
						bEval = eval;
						Idy = y;
						Idx = x;
					}

					board[y][x] = ' ';
				}
			}
		}
		board[Idy][Idx] = 'X';
		printBoard();
	}

	private int Eval(int move, int weight, char p) {
		int sum = 0;

		if (win('X'))
			return weight;
		else if (win('O'))
			return weight * -1;
		else if (move > 9)
			return 0;
		else {
			for (int y = 0; y < board.length; y++) {
				for (int x = 0; x < board[y].length; x++) {
					if (board[y][x] == ' ') {
						board[y][x] = p;
						if (p == 'X')
							sum += Eval(move + 1, weight / 10, 'O');
						else
							sum += Eval(move + 1, weight / 10, 'X');

						board[y][x] = ' ';

					}
				}
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}
