package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    RequestSpecification requestSpecification;
    String baseUrl= "https://api.spotify.com/v1";
    public static String AUTH_TOKEN="BQD6jlP6tQoB96cNp6xJIpbJZ526YBROl9SrL2JeNyTuOIbF6TmS3Q5casEzR0GMwVVcwkP_rEe9KYwftlS-SCwrVzAN-bVv0ja-9WNOgzg5_Q3BD1uZE-dAPfXSetLpLBr8cmoeeMs4VJlafSxQANV_QrcmuIDSxWx1S7uxnfaB-bPRGQgxJcaOxwHjZAScs56PffzkyFWgysemRjv7NNX6suSKYQdRm0mo8qa-S6XD3kFaBTe3nO5gYLmZbOQ3Bz5EfOFk4NEONlcdH7ATXwPVQUjuRA";
    public RequestSpec(String baseUrl){
        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + AUTH_TOKEN)
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
