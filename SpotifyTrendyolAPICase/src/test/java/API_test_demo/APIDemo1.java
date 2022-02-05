package API_test_demo;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class APIDemo1 {

    @Test
    void get_demo1()throws IOException, InterruptedException{

        given()
                .header("Content-Type","application/josn")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Tobias", "Michael"))
                .log().all();

    }

    @Test
    void post_demo1()throws IOException, InterruptedException{

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Reyhaneh");
//        map.put("job", "Tester");
//        System.out.println(map);

        JSONObject req = new JSONObject();
        req.put("name", "Reyhaneh");
        req.put("job", "Tester");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    void put_demo1()throws IOException, InterruptedException{

        JSONObject req = new JSONObject();
        req.put("name", "Reyhaneh");
        req.put("job", "Tester");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void patch_demo1()throws IOException, InterruptedException{

        JSONObject req = new JSONObject();
        req.put("name", "Reyhaneh");
        req.put("job", "Tester");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void delete_demo1()throws IOException, InterruptedException{

        when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();

     
    	
	//html report
	ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/report/Html_Report.Html");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	System.out.println("API Test");
	ExtentTest logger =	extent.createTest("API Test");
	logger.log(Status.INFO, "QA Task");
	logger.log(Status.PASS, "All Test Steps    Passed");
	extent.flush();


}
}














