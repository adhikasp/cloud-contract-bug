# cloud-contract-bug

I stumble to this error when tryin to generate test for reactive/webflux Spring app.

Springboot v2.0.6.RELEASE
spring-cloud-contract v2.0.1.RELEASE

Condition:
- Mark `testMode` configuration as `EXPLICIT`
- Create contract with async response attribute

The generated test will use `RestAssured` but still trying to use `async` method like in mockMVC

Example of generated test:
```java
RequestSpecification request = given()
	.header("Accept", "application/json;charset=UTF-8")
	.header("Content-Type", "application/json;charset=UTF-8")
	.body("SOMETHING")

Response response = given().spec(request)
	.when().async()
	.post("/URL");
```

Which will not run, because `async` method is not found.
