public class TicTacToeModel {
	
	double xpos,ypos,xr,yr;
	char[][] position = {{' ',' ',' '},
						 {' ',' ',' '},
						 {' ',' ',' '}};
						 
	/**
	 * Turns row, col into the center of the cells of a screen of resolution h by w.
	 * This is ideal for the view.
	 */
	public void computePos(int row, int col, int h, int w){
		System.out.println("row:"+row+", col:"+col+", h:"+h+", w:"+w);
		xpos=(col+0.5)*w/3.0;
		ypos=(row+0.5)*h/3.0;
		xr=w/8.0;
		yr=h/8.0;
		System.out.println(xpos+","+ypos+","+xr+","+yr);
	}
	
	/**
	 * returns true if the cell at xpos ypos is blank
	 */
	public boolean isEmpty(int xpos, int ypos){
		int pos=xpos+3*ypos;
		boolean isPosWithinRange = pos>=0 && pos<9 ;
		return isPosWithinRange && //TODO: check that the board is empty at position xpos, ypos;
	}
	
	public void placeO(int xpos, int ypos) {
		// TODO: Place the O in the representation of the board.
	}
	
	/**
	 * Really dumb strategy for the computer to play tic-tac-toe
	 */
	public int putX(){
		for(int i=0; i<3;i++)
			for(int j = 0;j<3;j++) {
				if(position[i][j]==' ') {
					position[i][j]='X';
					return 0;
				}
			}
		return -1; //some error occurred. This is odd. No cells were free.
	}
	
	/**
	 * Check wheather player has won
	 */
	public boolean didWin(char player) {
		//TODO: Check whether a player won.
	}
	
	public void printBoard(){
		for(int i=0;i<3;i++)
			System.out.println(position[i][0]+"|"+position[i][1]+"|"+position[i][2]);
	}
}
