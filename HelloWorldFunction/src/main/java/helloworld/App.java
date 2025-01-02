package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.json.simple.JSONObject;

import java.io.*;

public class Handler implements RequestStreamHandler{
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream,
                              Context context) throws IOException {

        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        obj2.put("Content-Type", "application/json");
        obj.put("statusCode", 200);
        obj.put("headers", obj2);
        obj.put("body", "hello world");

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(obj.toString());
        writer.close();

    }

}