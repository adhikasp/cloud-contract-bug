package me.adhikasetyap.cloudcontractbug;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = CloudContractBugApplicationTests.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = "server.port=0"
)
public class ContractTestBase {

  @LocalServerPort
  protected int port;

  @Before
  public void setup() {
    RestAssured.baseURI = "http://localhost:" + port;
  }

}
