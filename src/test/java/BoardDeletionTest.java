import org.testng.annotations.Test;
import pojo.board.BoardDetails;
import utility.BaseTest;

import static utility.TrelloBoardAssertions.*;
import static utility.TrelloRestClient.*;
import io.restassured.response.Response;
import utility.TrelloDataGenerator;

public class BoardDeletionTest extends BaseTest {
    TrelloDataGenerator generator = new TrelloDataGenerator();


    @Test
    public void deleteBoardByValidId(){
        String boardName = generator.generateRandomName();

        BoardDetails board = sendCreateBoardRequest(boardName).as(BoardDetails.class);
        Response response = sendDeleteBoardByIdRequest(board.id);

        assertRequestSuccessful(response);
        assertJRequestSuccessful(response);
    }

    @Test()
    public void deleteBoardByInvalidId(){
        String boardId = generator.generateRandomName();
        Response response = sendDeleteBoardByIdRequest(boardId);

        assertRequestError(response);
        assertJRequestError(response);
    }

}