package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This method starts the game.
 */
public final class MarbleSolitaire {
  /**
   * This is the constructor which allows you to start the game.
   *
   * @param args this is an array of strings
   */
  public static void main(String[] args) {
    String str = "";
    int row = 0;
    int col = 0;
    int size = 0;

    MarbleSolitaireView view = null;
    MarbleSolitaireModel model = null;
    MarbleSolitaireControllerImpl controller;

    if (args[0].equals("english") || args[0].equals("european")) {
      str = args[0];
      row = 3;
      col = 3;
      size = 3;
    } else if (args[0].equals("triangular")) {
      str = args[0];
      row = 0;
      col = 0;
      size = 5;
    }

    switch (args[0]) {
      case "european":
        System.out.println("european");
        model = new EuropeanSolitaireModel();
        view = new MarbleSolitaireTextView(model, System.out);

        break;
      case "english":
        System.out.println("english");
        model = new EnglishSolitaireModel();
        view = new MarbleSolitaireTextView(model, System.out);

        break;
      case "triangular":
        System.out.println("triangular");
        model = new TriangleSolitaireModel();
        view = new TriangleSolitaireTextView(model);

        break;
      default:
        break;
    }
    controller =
            new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
    controller.playGame();
  }
}
