package me.adhikasetyap.cloudcontractbug;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import me.adhikasetyap.cloudcontractbug.ContractTestBase;
import org.junit.Test;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.RestAssured.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;

public class ContractVerifierTest extends ContractTestBase {

	@Test
	public void validate_should_greet_with_hello() throws Exception {
		// given:
			RequestSpecification request = given();

		// when:
			Response response = given().spec(request)
					.queryParam("name","dhika")
					.when()
					.get("/hello");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("Hello dhika");
	}

}
