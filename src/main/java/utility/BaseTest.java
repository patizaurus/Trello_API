package utility;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pojo.user.User;

import static utility.TrelloConfig.*;
import static utility.TrelloRestClient.*;

public abstract class BaseTest {

    @BeforeClass
    public static void setup(){

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addQueryParam("token", token)
                .addQueryParam("key", key)
                .addHeader("Accept", "application/json")
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
//                .expectStatusCode(200)
                .build();
    }

@AfterClass
    public void cleanWorkspace(){

        User user = sendGetCurrentUserDetailsRequest().as(User.class);

        while(user.idBoards.size()>1){
            sendDeleteBoardByIdRequest(user.idBoards.get(1));
            user.idBoards.remove(1);
        }
        user = null;
    }

}
