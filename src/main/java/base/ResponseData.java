package base;

import io.restassured.response.Response;

public class ResponseData<T> {

    private Response response;
    private T responseBody;

    public ResponseData(Response response, T responseBody) {
        this.response = response;
        this.responseBody = responseBody;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }
}
