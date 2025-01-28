package com.one.portfoilo.board;

import com.one.portfoilo.ApiTest;
import com.one.portfoilo.domain.board.*;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardApiTest extends ApiTest {

    @Test
    void 게시물등록()
    {
        final var request = 게시물등록요청생성();

        // API 요청
        final var response = 게시물등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());


    }

    private static ExtractableResponse<Response> 게시물등록요청(AddBoardRequest request) {
        return RestAssured.given().log().all()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/board")
                .then()
                .log()
                .all().extract();
    }

    private static AddBoardRequest 게시물등록요청생성()
    {
        final String title= "게시물 제목";
        final int price = 1000;
        return new AddBoardRequest(title, price);
    }
}
