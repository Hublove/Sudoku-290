package SudokuGame;

import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.sun.glass.events.MouseEvent;

public class PanelController implements MouseListener{
	

		
		
		private Board game;
		public void SudokuPanelAction(Game game){
	          setGame(game);
		}
		
		
		public Game getGame() {
			return game;
		}


		public void setGame(Game game) {
			this.game = game;
		}

	      public void mouseClicked(MouseEvent e){
	    	  JPanel panel = (JPanel)e.getSource();
	
	     
	              if (e.getButton() == MouseEvent.BUTTON1 {
	            	  int number = game.getNumber(); //To be implemented
	              
	                  game.setNumber(number);
	                  
	              }
	              
	              
	          }


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	      }



		
