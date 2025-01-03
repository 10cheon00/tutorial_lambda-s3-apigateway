package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleLambdaHandler implements RequestHandler<RequestBody, String> {
    @Override
    public String handleRequest(RequestBody requestBody, Context context) {
        return requestBody.text();
    }
}
