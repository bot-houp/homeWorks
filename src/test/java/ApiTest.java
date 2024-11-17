import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class ApiTest {
  final String BASE_URI = "https://postman-echo.com";

  @Test
  public void testGet() {
    given()
        .baseUri(BASE_URI)
        .queryParam("foo1", "bar1")
        .queryParam("foo2", "bar2")
        .contentType("application/json")
        .when()
        .get("/get")
        .then()
        .log().all()
        .statusCode(200)
        .body("args.foo1", equalTo("bar1"))
        .body("args.foo2", equalTo("bar2"));
  }

  @Test
  public void testPostRawText() {
    given()
        .baseUri(BASE_URI)
        .contentType("text/plain")
        .body("This is expected to be sent back as part of response body.")
        .when()
        .post("/post")
        .then()
        .log().all()
        .statusCode(200)
        .body("data", equalTo("This is expected to be sent back as part of response body."));
  }

  @Test
  public void testPostFormData() {
    given()
        .baseUri(BASE_URI)
        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
        .formParam("foo1", "bar1")
        .formParam("foo2", "bar2")
        .when()
        .post("/post")
        .then()
        .log().all()
        .statusCode(200)
        .body("form.foo1", equalTo("bar1"))
        .body("form.foo2", equalTo("bar2"));
  }

  @Test
  public void testPut() {
    given()
        .baseUri(BASE_URI)
        .contentType("text/plain")
        .body("This is expected to be sent back as part of response body.")
        .when()
        .put("/put")
        .then()
        .log().all()
        .statusCode(200)
        .body("data", equalTo("This is expected to be sent back as part of response body."));
  }

  @Test
  public void testPatch() {
    given()
        .baseUri(BASE_URI)
        .contentType("text/plain")
        .body("This is expected to be sent back as part of response body.")
        .when()
        .patch("/patch")
        .then()
        .log().all()
        .statusCode(200)
        .body("data", equalTo("This is expected to be sent back as part of response body."));
  }

  @Test
  public void testDelete() {
    given()
        .baseUri(BASE_URI)
        .contentType("text/plain")
        .body("This is expected to be sent back as part of response body.")
        .when()
        .delete("/delete")
        .then()
        .log().all()
        .statusCode(200)
        .body("data", equalTo("This is expected to be sent back as part of response body."));
  }
}
