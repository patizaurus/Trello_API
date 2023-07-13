import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.board.BoardDetails;
import utility.BaseTest;
import utility.TrelloDataGenerator;

import static utility.TrelloBoardAssertions.*;
import static utility.TrelloRestClient.*;

public class BoardViewTest extends BaseTest {
    TrelloDataGenerator generator = new TrelloDataGenerator();

    @Test
    public void GetBoardByIncorrectId(){
        String boardId = generator.generateRandomName();

        Response response = sendGetBoardByIdRequest(boardId);

        assertRequestError(response);
        assertJRequestError(response);

    }

    @Test
    public void GetBoardById(){
        String boardName = generator.generateRandomName();

        BoardDetails board = sendCreateBoardRequest(boardName).as(BoardDetails.class);
        Response response = sendGetBoardByIdRequest(board.id);
        BoardDetails obtainedBoard = response.as(BoardDetails.class);

        assertRequestSuccessful(response);
        assertJRequestSuccessful(response);
        assertBoardWasCreatedCorrectly(board.name, obtainedBoard.name);
        assertJBoardWasCreatedCorrectly(board.name, obtainedBoard.name);
        assertBoardWasCreatedCorrectly(board.id, obtainedBoard.id);
        assertBoardWasCreatedCorrectly(board.id, obtainedBoard.id);
    }

}