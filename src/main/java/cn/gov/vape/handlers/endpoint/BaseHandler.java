package cn.gov.vape.handlers.endpoint;

import com.google.gson.JsonObject;

public abstract class BaseHandler {
    public abstract JsonObject handleRequest(String requestMethod,String requestBody);
}
