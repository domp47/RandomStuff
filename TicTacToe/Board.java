package TicTacToe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class Board extends JPanel {


	private static final long serialVersionUID = -6422497006934716806L;
	private int x = 500, y = 500;
	private char[][] c;
	private char pl;
	private int count = 1;

	public Board(char[][] c) {
		setPreferredSize(new Dimension(x, y));
		this.c = c;
	}

	public void drawGrid(Graphics g) {

		clear(g);
		
		for (int i = 0; i < 3; i++) {
			g.drawLine(x * i / 3, 0, x * i / 3, y);
			g.drawLine(0, y * i / 3, x, y * i / 3);
		}
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	public void drawMarkers(Graphics g) {
		for (int y = 0; y < c.length; y++) {
			for (int x = 0; x < c[y].length; x++) {

				if (c[y][x] == 'X') {
					g.drawLine(this.x * x / 3 + 35, this.y * y / 3 + 35, this.x * x / 3 + 135, this.y * y / 3 + 135);
					g.drawLine(this.x * x / 3 + 135, this.y * y / 3 + 35, this.x * x / 3 + 35, this.y * y / 3 + 135);
				} else if (c[y][x] == 'O') {
					g.drawOval(this.x * x / 3 + 35, this.y * y / 3 + 35, 100, 100);
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		drawGrid(g);
		drawMarkers(g);
		
		if(win('X',g)){
			count = 10;
			float f = 80.0f;
			g.setFont(getFont().deriveFont(f));
			g.drawString("CPU Wins.", 70, (int) (f+197));
			return;
		}
		else if(win('O',g)){
			count = 10;
			float f = 60.0f;
			g.setFont(getFont().deriveFont(f));
			g.drawString("Player 1 Wins.", 75, (int) (f+210));
			return;
		}
		else if(count>9){
			float f = 80.0f;
			g.setFont(getFont().deriveFont(f));
			g.drawString("It's a Tie.", 107, (int) (f+197));
		}
		
		if(count%2==0&&count<=9){
			PlayX();
			count++;
			drawGrid(g);
			drawMarkers(g);
			if(win('X',g)){
				count=10;
				float f = 80.0f;
				g.setFont(getFont().deriveFont(f));
				g.drawString("CPU Wins.", 70, (int) (f+197));
				return;
			}
		}
	}

	private Boolean win(char p,Graphics g) {
		for (int y = 0; y < c.length; y++) {
			if (c[y][0] == p && c[y][1] == p && c[y][2] == p){
				g.setColor(Color.red);
				g.drawLine(50, 86+500*y/3, 450, 86+500*y/3);
				g.setColor(Color.black);
				return true;
			}
		}
		for (int x = 0; x < c[0].length; x++) {
			if (c[0][x] == p && c[1][x] == p && c[2][x] == p){
				g.setColor(Color.red);
				g.drawLine(86+500*x/3,50 , 86+500*x/3,450 );
				g.setColor(Color.black);
				return true;
			}
		}
		if (c[0][0] == p && c[1][1] == p && c[2][2] == p) {
			g.setColor(Color.red);
			g.drawLine(35,35,500*2/3+135,500*2/3+135);
			g.setColor(Color.black);
			return true;
			
		}
		if (c[2][0] == p && c[1][1] == p && c[0][2] == p) {
			g.setColor(Color.red);
			g.drawLine(35,500*2/3+135, 500*2/3+135,35 );
			g.setColor(Color.black);
			return true;
		}
		return false;
	}

	private Boolean win(char p) {
		for (int y = 0; y < c.length; y++) {
			if (c[y][0] == p && c[y][1] == p && c[y][2] == p)
				return true;
		}
		for (int x = 0; x < c[0].length; x++) {
			if (c[0][x] == p && c[1][x] == p && c[2][x] == p)
				return true;
		}
		if (c[0][0] == p && c[1][1] == p && c[2][2] == p) {
			return true;
		}
		if (c[2][0] == p && c[1][1] == p && c[0][2] == p) {
			return true;
		}
		return false;
	}
	
	public void clear(Graphics g) {
		g.clearRect(0, 0, x, y);
	}
	public void clear(Graphics g,int x1,int width,int y1,int height){
		g.clearRect(x1, y1, width, height);
	}

	public void keyPressed(KeyEvent e) {
		if (count <= 9) {

			if (count % 2 == 0)
				pl = 'X';
			else
				pl = 'O';

			switch (e.getKeyChar()) {
			case '7':
				if(c[0][0]==' '){
				c[0][0] = pl;
				count++;
				break;
				}
				else{
					break;
				}
			case '8':
				if(c[0][1]==' '){
				c[0][1] = pl;
				count++;
				break;
				}
				else{
					break;
				}
			case '9':
				if(c[0][2]==' '){
				c[0][2] = pl;
				count++;
				break;
				}
				else{
					break;
				}
			case '4':
				if(c[1][0]==' '){
					c[1][0] = pl;
					count++;
					break;
					}
					else{
						
						break;
					}
			case '5':
				if(c[1][1]==' '){
					c[1][1] = pl;
					count++;
					break;
					}
					else{
												break;
					}
			case '6':
				if(c[1][2]==' '){
					c[1][2] = pl;
					count++;
					break;
					}
					else{
						
						break;
					}
			case '1':
				if(c[2][0]==' '){
					c[2][0] = pl;
					count++;
					break;
					}
					else{
						
						break;
					}
			case '2':
				if(c[2][1]==' '){
					c[2][1] = pl;
					count++;
					break;
					}
					else{
						
						break;
					}
			case '3':
				if(c[2][2]==' '){
					c[2][2] = pl;
					count++;
					break;
					}
					else{
						break;
					}
			}
		}
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
			for (int y = 0; y < c.length; y++) {
				for (int x = 0; x < c[y].length; x++) {
					if (c[y][x] == ' ') {
						c[y][x] = p;
						if (p == 'X')
							sum += Eval(move + 1, weight / 10, 'O');
						else
							sum += Eval(move + 1, weight / 10, 'X');

						c[y][x] = ' ';

					}
				}
			}
			return sum;
		}
	}

	private void PlayX() {
		int eval, bEval = Integer.MIN_VALUE, Idx = 0, Idy = 0;

		for (int y = 0; y < c.length; y++) {
			for (int x = 0; x < c[y].length; x++) {
				if (c[y][x] == ' ') {

					c[y][x] = 'X';
					eval = Eval(count, 1000000000, 'O');
					if (Math.max(bEval, eval) != bEval) {
						bEval = eval;
						Idy = y;
						Idx = x;
					}

					c[y][x] = ' ';
				}
			}
		}
		c[Idy][Idx] = 'X';
	}
}
