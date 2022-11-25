import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * This class helps test the methods within MarbleSolitaireControllerImpl.
 */
public class MarbleSolitaireControllerImplTest {

  @Test
  public void testPLayGameValid() {
    StringReader read = new StringReader("3 1 3 3 5 2 3 2 q");
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
            + "This calls move(4, 1, 2, 1). \n"
            + "This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls getScore(). \n", modelLog.toString());
  }

  @Test
  public void testPLayGameValid2() {
    StringReader read = new StringReader("4 0 4 2 4 3 4 1 q");
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
            + "This calls move(3, -1, 3, 1). \n"
            + "This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls move(3, 2, 3, 0). \n"
            + "This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls getScore(). \n", modelLog.toString());
  }

  @Test
  public void testPLayGameInvalid() {
    StringReader read = new StringReader("1 1 1 1 2 2 2 2 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n"
            + "This calls renderMessage(Invalid move. Play again. To and from positions are not "
            + "valid\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n"
            + "This calls renderMessage(Invalid move. Play again. To and from positions are not "
            + "valid\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameInvalid2() {
    StringReader read = new StringReader("0 0 0 3 2 4 2 1 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n"
            + "This calls renderMessage(Invalid move. Play again. To and from positions are not "
            + "valid\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n"
            + "This calls renderMessage(Invalid move. Play again. To and from positions are not "
            + "valid\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 32\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameFromRowQ() {
    StringReader read = new StringReader("q 1 1 1 2 2 2 2 q");
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
            + "This calls getScore(). \n", modelLog.toString());
  }


  @Test
  public void testPLayGameFromColQ() {
    StringReader read = new StringReader("1 q 1 1 2 2 2 2 q");
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
            + "This calls getScore(). \n", modelLog.toString());
  }

  @Test
  public void testPLayGameToRowQ() {
    StringReader read = new StringReader("1 1 q 1 2 2 2 2 q");
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
            + "This calls getScore(). \n", modelLog.toString());
  }

  @Test
  public void testPLayGameToColQ() {
    StringReader read = new StringReader("1 1 1 Q 2 2 2 2 q");
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
            + "This calls getScore(). \n", modelLog.toString());
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
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
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
  }

  @Test
  public void testRandomChar() {
    StringReader read = new StringReader("5 6 a 5 4 q");
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
            + "This calls renderMessage(Wrong input. Try again!\n"
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
            + "This calls move(4, 5, 4, 3). \n"
            + "This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls getScore(). \n", modelLog.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testPLayGameNoMoreInputs() {
    StringReader read = new StringReader(" ");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
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

  @Test(expected = IllegalStateException.class)
  public void testNoMoreInputs() {
    StringReader read = new StringReader("");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testBadAppendable() {
    StringReader read = new StringReader("3 2 3 3");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextView(model, new WrongAppendable());
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
  }
}



