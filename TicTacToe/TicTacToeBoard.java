package TicTacToe;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TicTacToeBoard extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 7259172984810510487L;
	private Board fr;
	
	public TicTacToeBoard(char[][]c){
		super();
        fr = new Board(c);
        add(fr);
        pack();
        addKeyListener(this);
        repaint();
	}
	
	public void repaint(){
		super.repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		fr.keyPressed(arg0);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
