import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.hamcrest.CoreMatchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class Getandpost {
    @Test
    public void gettest(){
        baseURI= "https://reqres.in/api";
        /*given().get("/users?page=2")
                .then().
                statusCode(200)
               .body("size()", CoreMatchers.is(6))
                .log()
                .all();/*

         */
        given().get("/users")
                .then().
                statusCode(200)
                .body("data.first_name[1]", containsString("j"))
                .log()
                .all();


    }
    @Test
    public void posttest(){

        Map<String, Object> map= new HashMap<String,Object>();
        map.put("Toqa", "Engineer");
        map.put("Randa","beautiful");
        System.out.println(map);
        JSONObject json = new JSONObject();
        json.put("george", "Engineer");
        json.put("Thom","beautiful");
        System.out.println(json);
        baseURI= "https://reqres.in/api";
        given().
                body("").
                when().
                post("/users").
                then();





    }
    @Test
    public void puttest(){


        JSONObject json = new JSONObject();
        json.put("george", "Engineer");
        json.put("Thom","beautiful");
        System.out.println(json);
        baseURI= "https://reqres.in/api";
        given().
                body(json.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all()
                .assertThat();





    }
    @Test
    public void puttesto(){
       /* Map<String, Object> map= new HashMap<String,Object>();
        map.put("\"coursename\"", "\"Engineer\"");
        map.put("\"title\"","\"beautiful\"");
        System.out.println(map);*/


        String json = "{\"id\":90,\"coursename\":\"JUkijit\",\"title\":\"JUnit fromooooscratch\",\"date\":\"08-08-2080\"}";


       RestAssured.given().contentType(ContentType.JSON).body(json).
                when().
                post("http://localhost:3000/courses").
                then().
                statusCode(201);


    }
    @Test
    public void getttesto(){


        RestAssured.get("http://localhost:3000/courses")
                .then().
                statusCode(200).body("coursename[0]", equalTo("postman")).log().all();



    }


    @Test
    public void getempty(){


        RestAssured.get("http://localhost:3000/courses")
                .then().
                statusCode(200).body("size()", is(2)).log().all();




    }

}

