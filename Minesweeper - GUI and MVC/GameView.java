//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

     // ADD YOUR INSTANCE VARIABLES HERE
  private GameModel gameModel;
  private GameController gameController;
  public JButton quit;
  public JButton reset;
  public DotButton[][] buttons;
  private JLabel steps;
  private DotInfo[][] info;
  

    /**
     * Constructor used for initializing the Frame
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel gameModel, GameController gameController) {
        
    // ADD YOU CODE HERE
      super("Minesweeper");
      this.gameModel = gameModel;
      this.gameController = gameController;
      quit = new JButton("Quit");
      reset = new JButton("Reset");
      quit.addActionListener(gameController);
      reset.addActionListener(gameController);
      buttons = new DotButton[gameModel.getHeight()][gameModel.getWidth()];
      info = new DotInfo[gameModel.getHeight()][gameModel.getWidth()];
      gameModel.reset();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new GridLayout(0, gameModel.getWidth()));
      for(int i = 0; i < gameModel.getHeight(); i++) {
        for(int j = 0; j < gameModel.getWidth(); j++) {
          buttons[i][j] = new DotButton(i, j, 11);
          buttons[i][j].addActionListener(gameController);
          add(buttons[i][j]);
        }
      }
      steps = new JLabel("Steps: " + gameModel.getNumberOfSteps());
      add(steps);
      add(reset);
      add(quit);
      pack();
      setVisible(true);
      update();
    }

    /**
     * update the status of the board's DotButton instances based 
     * on the current game model, then redraws the view
     */

    public void update(){
        
    // ADD YOU CODE HERE
      steps.setText("Steps: " + gameModel.getNumberOfSteps());
      for(int i = 0; i < buttons.length; i++) {
        for(int j = 0; j < buttons[i].length; j++) {
          buttons[i][j].setIconNumber(this.getIcon(i, j));
          buttons[i][j].setIcon();
        }
      }
    }

    /**
     * returns the icon value that must be used for a given dot 
     * in the game
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the icon to use for the dot at location (i,j)
     */   
    private int getIcon(int i, int j){
        
      // ADD YOU CODE HERE
      if(!(gameModel.isCovered(i, j))) {
        if(gameModel.isMined(i, j)) {
          if(!gameModel.hasBeenClicked(i, j))
            return 9;
          else
            return 10;
        }
        else {
          return gameModel.getNeighbooringMines(i, j);
        }
      }
      else {
        return 11;
      }
    }


}
