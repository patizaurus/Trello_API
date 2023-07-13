import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.board.BoardDetails;
import utility.BaseTest;
import utility.TrelloDataGenerator;


import static utility.TrelloBoardAssertions.*;
import static utility.TrelloRestClient.*;


public class BoardCreationTest extends BaseTest {
    TrelloDataGenerator generator = new TrelloDataGenerator();

    @DataProvider(name = "random-board-names-and-colors")
    public Object[][] generateRandomNamesAndColors() {
        int numberOfBoards = 3;
        Object[][] data = new Object[numberOfBoards][2];

        for (int i = 0; i < numberOfBoards; i++) {
            data[i][0] = generator.generateRandomName();
            data[i][1] = generator.generateRandomColor();
        }
        return data;
    }

    @DataProvider(name = "invalid-board-colors")
    public Object[][] generateInvalidColors() {
        return new Object[][]{
                {""},
                {generator.generateRandomName()}
        };
    }

    @Test
    public void createBoardWithValidName(){
        String boardName = generator.generateRandomName();

        Response response = sendCreateBoardRequest(boardName);
        BoardDetails board = response.as(BoardDetails.class);

        assertRequestSuccessful(response);
        assertJRequestSuccessful(response);
        assertBoardWasCreatedCorrectly(board.getName(), boardName);
        assertJBoardWasCreatedCorrectly(board.getName(), boardName);
    }

    @Test
    public void createBoardWithInvalidName(){
        Response response = sendCreateBoardRequest("");

        assertRequestError(response);
        assertJRequestError(response);
    }

    @Test
    public void createBoardWithTooLongName(){
        String boardName = generator.generateTooLongName();

        Response response = sendCreateBoardRequest(boardName);

        assertTooLongRequestError(response);
        assertJTooLongRequestError(response);
    }

    @Test(dataProvider = "random-board-names-and-colors")
    public void createBoardWithValidColor(String boardName, String color){
        Response response = sendCreateBoardWithBackgroundRequest(boardName, color);
        BoardDetails board = response.as(BoardDetails.class);

        assertRequestSuccessful(response);
        assertJRequestSuccessful(response);
        assertBoardWasCreatedCorrectly(board.getPrefs().background, color);
        assertJBoardWasCreatedCorrectly(board.getPrefs().background, color);
    }

    @Test(dataProvider = "invalid-board-colors")
    public void createBoardWithInvalidColor(String color){
        String boardName = generator.generateRandomName();

        Response response = sendCreateBoardWithBackgroundRequest(boardName, color);

        assertServerError(response);
        assertJServerError(response);
    }

    @Test
    public void createBoardWithManyFields(){
        BoardDetails board_initial = generator.generateRandomBoard();

        Response response = sendCreateBoardWithManyFieldsRequest(board_initial);
        BoardDetails board_result = response.as(BoardDetails.class);

        assertRequestSuccessful(response);
        assertJRequestSuccessful(response);
        assertBoardWasCreatedCorrectly(board_initial, board_result);
        assertJBoardWasCreatedCorrectly(board_initial, board_result);
    }

}
