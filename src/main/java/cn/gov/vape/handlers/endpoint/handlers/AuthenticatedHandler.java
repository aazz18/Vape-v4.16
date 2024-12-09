package cn.gov.vape.handlers.endpoint.handlers;

import cn.gov.vape.handlers.endpoint.BaseHandler;
import com.google.gson.JsonObject;

public class AuthenticatedHandler extends BaseHandler {
    @Override
    public JsonObject handleRequest(String requestMethod,String requestBody) {
        JsonObject data = new JsonObject();
        data.addProperty("userId", 1);
        data.addProperty("username", "Cracked by John Xina");
        data.addProperty("accountCreation", "1989-06-04T07:06:21.620+00:00");
        data.addProperty("licensed", true);
        data.addProperty("registered", true);
        data.addProperty("profiles", true);
        data.addProperty("banned", false);

        JsonObject response = new JsonObject();
        response.add("data", data);
        response.add("error", null);
        response.addProperty("successful", true);
        return response;
    }
}
