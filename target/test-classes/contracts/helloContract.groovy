package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        name("should greet with hello")
        url("/hello") {
            queryParameters {
                parameter("name", value(consumer(anyNonEmptyString()), producer("dhika")))
            }
        }
        method(GET())
    }

    response {
        status(OK())
        async()
        body("Hello dhika")
    }
}
