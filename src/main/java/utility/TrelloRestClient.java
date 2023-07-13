package utility;

import io.restassured.response.Response;
import pojo.board.BoardDetails;

import static io.restassured.RestAssured.given;
import static utility.TrelloConfig.boardPath;
import static utility.TrelloConfig.memberPath;

public class TrelloRestClient {

    public static Response sendCreateBoardRequest(String boardName){
        return  given()
                .queryParam("name", boardName)
                .header("Content-Type","application/json")
                .when()
                .post(boardPath)
                .then().extract().response();
    }

    public static Response sendCreateBoardWithBackgroundRequest(String boardName, String color){
        return  given()
                .queryParam("name", boardName)
                .queryParam("prefs_background", color)
                .header("Content-Type","application/json")
                .when()
                .post(boardPath)
                .then().extract().response();
    }

    public static Response sendDeleteBoardByIdRequest(String boardId){
        return given()
                .basePath(boardPath+boardId)
                .header("Content-Type","application/json")
                .when()
                .delete()
                .then().extract().response();
    }

    public static Response sendUpdateBoardNameByIdRequest(String boardId, String newName){
        return given()
                .basePath(boardPath+boardId)
                .queryParam("name", newName)
                .header("Content-Type","application/json")
                .when()
                .put()
                .then().extract().response();
    }

    public static Response sendGetBoardByIdRequest(String boardId){
        return given()
                .basePath(boardPath+boardId)
                .header("Content-Type","application/json")
                .get()
                .then().extract().response();
    }

    public static Response sendGetCurrentUserDetailsRequest(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .get(memberPath)
                .then().extract().response();
    }

        public static Response sendCreateBoardWithManyFieldsRequest(BoardDetails board){
        return  given()
                .queryParam("name", board.name)
                .queryParam("desc", board.desc)
                .queryParam("pinned", board.pinned)
                .queryParam("prefs_background", board.prefs.background)
                .header("Content-Type","application/json")
                .when()
                .post(boardPath)
                .then().extract().response();
    }



}
