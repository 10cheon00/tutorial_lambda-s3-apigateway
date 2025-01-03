package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleLambdaHandler implements RequestHandler<RequestBody, ResponseBody> {
    @Override
    public ResponseBody handleRequest(RequestBody requestBody, Context context) {
        // Lambda logger를 활용해 로그 작성
        LambdaLogger logger = context.getLogger();

        // 요청 데이터 확인
        if (requestBody == null) {
            logger.log("Received null requestBody!");
            return new ResponseBody("Invalid input", 400);
        }

        // 요청 처리 로직
        String text = requestBody.getText();
        String lang = requestBody.getLang();
        logger.log("Received text: " + text + ", lang: " + lang);

        // 예제: 텍스트를 대문자로 변환하여 반환
        String responseText = "Hello, " + text.toUpperCase() + "!";
        return new ResponseBody(responseText, 200);
    }
}
