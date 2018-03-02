//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;


/**
 * The class <b>GameController</b> is the controller of the game. It is a listener
 * of the view, and has a method <b>play</b> which computes the next
 * step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

    // ADD YOUR INSTANCE VARIABLES HERE
  private int width, height, numberOfMines;
  private GameModel model;
  private GameView view;

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param width
     *            the width of the board on which the game will be played
     * @param height
     *            the height of the board on which the game will be played
     * @param numberOfMines
     *            the number of mines hidden in the board
     */
    public GameController(int width, int height, int numberOfMines) {

    // ADD YOU CODE HERE
      this.width = width;
      this.height = height;
      this.numberOfMines = numberOfMines;
      model = new GameModel(width, height, numberOfMines);
      view = new GameView(model, this);
    }


    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */
    
    public void actionPerformed(ActionEvent e) {
      
      // ADD YOU CODE HERE
      for(int i = 0; i < model.getHeight(); i++) {
        for(int j = 0; j < model.getWidth(); j++) {
          if(e.getSource() == view.buttons[i][j]) {
            model.click(i, j);
            this.play(j, i);
            view.update();
          }
        }
      }
      
      if(e.getSource() == view.quit) {
        System.exit(0);
      }
      if(e.getSource() == view.reset) {
        this.reset();
      }
    }

    /**
     * resets the game
     */
    private void reset(){

    // ADD YOU CODE HERE
      model.reset();
      view.update();

    }

    /**
     * <b>play</b> is the method called when the user clicks on a square.
     * If that square is not already clicked, then it applies the logic
     * of the game to uncover that square, and possibly end the game if
     * that square was mined, or possibly uncover some other squares. 
     * It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives to options: start a new game, or exit
     * @param width
     *            the selected column
     * @param heigth
     *            the selected line
     */
    private void play(int width, int height){

    // ADD YOU CODE HERE
      int option = 2;
      JFrame frame = new JFrame("Game Over");
      String[] options = {"Quit", "Play Again"};
      if(model.isCovered(height, width)) {
        model.uncover(height, width);
        model.step();
        //if(model.isBlank(height, width) && !model.isMined(height, width)) 
          //clearZone(model.get(height, width));
        view.update();
        if(model.get(height, width).isMined()) {
          for(int i = 0; i < model.getHeight(); i++) {
            for(int j = 0; j < model.getWidth(); j++) {
              if(model.isMined(i, j))
                model.uncover(i, j);
            }
          }
          view.update();
          option = JOptionPane.showOptionDialog(frame, "You lost in " + model.getNumberOfSteps() + " steps! Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
        else if(model.isFinished()) {
          option = JOptionPane.showOptionDialog(frame, "You won in " + model.getNumberOfSteps() + " steps! Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
      }
      //if(model.isFinished())
        //option = JOptionPane.showOptionDialog(frame, "You won in " + model.getNumberOfSteps() + " steps! Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
      if(option == 0) {
        System.exit(0);
      }
      else if(option == 1) {
        reset();
      }
    }

   /**
     * <b>clearZone</b> is the method that computes which new dots should be ``uncovered'' 
     * when a new square with no mine in its neighborood has been selected
     * @param initialDot
     *      the DotInfo object corresponding to the selected DotButton that
     * had zero neighbouring mines
     */
    private void clearZone(DotInfo initialDot) {


    // ADD YOU CODE HERE
      GenericArrayStack<DotInfo> stack = new GenericArrayStack<DotInfo>(model.getHeight() * model.getWidth());
      stack.push(initialDot);
      while(!(stack.isEmpty())) {
        DotInfo d = stack.pop();
        for(int i = 0; i < model.getHeight(); i++) {
          for(int j = 0; j < model.getWidth(); j++) {
            if(model.get(i, j).isCovered()) {
              model.uncover(i, j);
              if(model.isBlank(i, j)) {
                stack.push(model.get(i, j));
              }
            }
          }
        }
      }
    }



}
