import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JOptionPane;

public class TicTacToeViewController implements MouseListener{
	
	TicTacToeView view;
	TicTacToeModel model;
	Color oColor=Color.BLUE, xColor=Color.RED;
	
	public TicTacToeViewController(TicTacToeView view, TicTacToeModel model) { 
		//TODO: complete this Constructor
	}
	
	/** Ask the model what's the next move.
	 */
	public void play(int xpos, int ypos) {
		model.printBoard();
		if (model.isEmpty(xpos,ypos)) {
			//TODO: Fulfill these two requirements:
			//TODO: user plays
			//TODO: computer plays
			drawBoard();
			view.repaint();
		}
		if() //TODO: Fill this in to check whether X won.
			JOptionPane.showMessageDialog(null,"X Wins","Winner", JOptionPane.INFORMATION_MESSAGE);
		else if (model.didWin('O'))
			JOptionPane.showMessageDialog(null,"O Wins","Winner",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/** Control the drawing of O and X.
	 * This looks at the model to see where there are Xs and Os and draws two diagonal
	 * lines or a circle (an Ellipse, actually) in the positions given.
	 */
	public void drawBoard() {
		Graphics2D g2d = (Graphics2D)view.board.getGraphics();
		
		for (int i=0; i<3; ++i) 
			for(int j=0; j<3;j++) {
				model.computePos(j,i,view.board.getHeight(),view.board.getWidth());
				double xpos = model.xpos;
				double xr = model.xr;
				double ypos = model.ypos;
				double yr = model.yr;
				// TODO: Complete the expressions within the if statements as follows:
				// if the array that represents the board has a O in position i, j... else,
				// if it has an X...
				if ( ) {
					//TODO: Add the ellipse to the list of shapes that the view has to draw.
					new Ellipse2D.Double(xpos-xr, ypos-yr, xr*2, yr*2);
				}
				else if ( ) {
				  view.shapes.add(new Line2D.Double(xpos-xr, ypos-yr, xpos+xr, ypos+yr));
				  view.shapes.add(new Line2D.Double(xpos-xr, ypos+yr, xpos+xr, ypos-yr));
				}
				System.out.println("Coords: xpos:"+xpos+", ypos:"+ypos+", xr"+xr+", yr"+yr);
		}
	}
	
	/** MouseListener event
	 * Converts the coordinates of the mouse into the corresponding row and column of the cell
	 */
	public void mouseClicked(MouseEvent e) {
      int xpos=e.getX()*3/view.getWidth();
      int ypos=e.getY()*3/view.getHeight();
      System.out.println("Play "+xpos+","+ypos);
      play(xpos,ypos);
    }

    /** Ignore other mouse events*/
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
