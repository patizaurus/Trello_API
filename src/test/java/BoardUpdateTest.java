import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.board.BoardDetails;
import utility.BaseTest;
import utility.TrelloDataGenerator;

import static utility.TrelloBoardAssertions.*;
import static utility.TrelloRestClient.*;

public class BoardUpdateTest  extends BaseTest {
    TrelloDataGenerator generator = new TrelloDataGenerator();

    @Test
    public void UpdateBoardName() {
        String boardName = generator.generateRandomName();
        String newBoardName = generator.generateRandomName();

        BoardDetails board = sendCreateBoardRequest(boardName).as(BoardDetails.class);
        BoardDetails updatedBoard = sendUpdateBoardNameByIdRequest(board.id, newBoardName).as(BoardDetails.class);

        assertBoardWasCreatedCorrectly(updatedBoard.name, newBoardName);
        assertJBoardWasCreatedCorrectly(updatedBoard.name, newBoardName);
    }

    @Test
    public void UpdateBoardNameToInvalidName() {
        String boardName = generator.generateRandomName();
        String newBoardName = "";

        BoardDetails board = sendCreateBoardRequest(boardName).as(BoardDetails.class);
        Response response = sendUpdateBoardNameByIdRequest(board.id, newBoardName);

        assertRequestError(response);
        assertJRequestError(response);
    }

}
