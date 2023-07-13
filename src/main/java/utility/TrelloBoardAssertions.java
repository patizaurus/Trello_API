package utility;

import io.restassured.response.Response;
import pojo.board.BoardDetails;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class TrelloBoardAssertions {

    public static void assertBoardWasCreatedCorrectly(String expectedValue, String actualValue){
        assertEquals(expectedValue, actualValue);
    }

    public static void assertJBoardWasCreatedCorrectly(String expectedValue, String actualValue){
        assertThat(expectedValue).isEqualTo(actualValue);
    }

    public static void assertBoardWasCreatedCorrectly(BoardDetails board_initial, BoardDetails board_result){
        assertEquals(board_initial.name, board_result.name);
        assertEquals(board_initial.desc, board_result.desc);
        assertEquals(board_initial.prefs.background, board_result.prefs.background);

    }

    public static void assertJBoardWasCreatedCorrectly(BoardDetails board_initial, BoardDetails board_result){
        assertThat(board_initial.name).isEqualTo(board_result.name);
        assertThat(board_initial.desc).isEqualTo(board_result.desc);
        assertThat(board_initial.prefs.background).isEqualTo(board_result.prefs.background);

    }

    public static void assertRequestSuccessful(Response response){
        assertEquals(response.getStatusCode(), 200);

    }

    public static void assertJRequestSuccessful(Response response){
        assertEquals(response.getStatusCode(), 200);

    }

    public static void assertRequestError(Response response){
        assertEquals(response.getStatusCode(), 400);
    }

    public static void assertJRequestError(Response response){
        assertThat(response.getStatusCode()).isEqualTo(400);
    }

    public static void assertTooLongRequestError(Response response){
        assertEquals(response.getStatusCode(), 414);
    }

    public static void assertJTooLongRequestError(Response response){
        assertThat(response.getStatusCode()).isEqualTo(414);
    }
    public static void assertServerError(Response response){
        assertEquals(response.getStatusCode(), 500);
    }

    public static void assertJServerError(Response response){
        assertThat(response.getStatusCode()).isEqualTo(500);
    }

}
