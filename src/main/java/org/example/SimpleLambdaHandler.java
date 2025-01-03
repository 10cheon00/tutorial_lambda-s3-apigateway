package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleLambdaHandler implements RequestHandler<RequestBody, ResponseBody> {
    @Override
    public ResponseBody handleRequest(RequestBody requestBody, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log(requestBody.text());
        return new ResponseBody(requestBody.text(), 200);
    }
}
