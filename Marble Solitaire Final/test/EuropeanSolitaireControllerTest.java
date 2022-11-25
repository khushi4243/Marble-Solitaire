import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * This tests the EuropeanSolitare controller.
 */
public class EuropeanSolitaireControllerTest {

  @Test
  public void testPLayGameValid() {
    StringReader read = new StringReader("3 1 3 3 q");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n", viewLog.toString());

    assertEquals("This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls move(2, 0, 2, 2). \n"
            + "This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls getScore(). \n", modelLog.toString());
  }

  @Test
  public void testPLayGameInvalid() {
    StringReader read = new StringReader("1 1 1 1 2 2 2 2 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderMessage(Invalid move. Play again. To and from positions are not "
            + "valid\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderMessage(Invalid move. Play again. The to position is not empty\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameFromRowQ() {
    StringReader read = new StringReader("q 1 1 1 2 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameFromColQ() {
    StringReader read = new StringReader("1 q 1 1 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameToRowQ() {
    StringReader read = new StringReader("1 1 q 1 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameToColQ() {
    StringReader read = new StringReader("1 1 1 q 3 3 3 3 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n", viewLog.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testPLayGameNoMoreInputs() {
    StringReader read = new StringReader(" ");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testNoMoreInputs() {
    StringReader read = new StringReader("");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testBadAppendable() {
    StringReader read = new StringReader("3 2 3 3");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextView(model, new WrongAppendable());
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullRead() {
    StringReader read = null;
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    StringReader read = new StringReader(" ");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = null;
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    StringReader read = new StringReader(" ");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = null;
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
  }

  @Test
  public void testPLayEntireGame() {
    StringReader read = new StringReader("6 4 4 4\n"
            + "5 6 5 4\n"
            + "7 5 5 5\n"
            + "7 3 7 5\n"
            + "4 5 6 5\n"
            + "7 5 5 5\n"
            + "2 5 4 5\n"
            + "3 7 3 5\n"
            + "5 7 3 7\n"
            + "3 4 3 6\n"
            + "3 7 3 5\n"
            + "3 2 3 4\n"
            + "1 3 3 3\n"
            + "1 5 1 3\n"
            + "4 3 2 3\n"
            + "1 3 3 3\n"
            + "6 3 4 3\n"
            + "5 1 5 3\n"
            + "3 1 5 1\n"
            + "5 4 5 2\n"
            + "5 1 5 3\n"
            + "3 4 3 2\n"
            + "3 2 5 2\n"
            + "5 2 5 4\n"
            + "5 4 5 6\n"
            + "5 6 3 6\n"
            + "3 6 3 4\n"
            + "4 4 4 6\n"
            + "2 4 4 4\n"
            + "4 3 4 5\n"
            + "4 6 4 4 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 36\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 35\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 34\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 33\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 31\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 30\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 29\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 28\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 27\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 26\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 25\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 24\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 23\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 22\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 21\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 20\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 19\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 18\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 17\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 16\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 15\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 13\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 12\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 11\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 10\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 9\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 8\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 7\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 6\n"
            + "). \n"
            + "This calls renderMessage(Game over!\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 5\n"
            + "). \n", viewLog.toString());
  }
}