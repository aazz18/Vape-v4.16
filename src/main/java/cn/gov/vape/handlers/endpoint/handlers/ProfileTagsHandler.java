package cn.gov.vape.handlers.endpoint.handlers;

import cn.gov.vape.handlers.endpoint.BaseHandler;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public class ProfileTagsHandler extends BaseHandler {
    @Override
    public JsonObject handleRequest(String requestMethod,String requestBody) {
        JsonArray data = new JsonArray();
        data.add(new JsonPrimitive("default"));

        JsonObject response = new JsonObject();
        response.add("data", data);
        response.add("error", JsonNull.INSTANCE);
        response.addProperty("successful", true);
        return response;
    }
}
