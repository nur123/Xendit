package tests;

import base.BaseTest;
import base.ResponseData;
import models.ErrorResponse;
import models.QRCodeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UpdateQRCodeAPITest extends BaseTest {


    @Test
    @DisplayName("Verify update QR Code API return 200 when using valid data")
    @Tag("positive")
    public void updateQRCodeWithValidData() {
        QRCodeData requestBody = new QRCodeData("https://www.linkedin.com/in/muhammad-nur-730065a0/", 1500, "Test Update");
        String qrCodeId = "1234";
        ResponseData<QRCodeData> response = updateQRCodeApi.updatewithValidData(requestBody, qrCodeId);
        Assertions.assertEquals(200, response.getResponse().getStatusCode());
        Assertions.assertEquals(requestBody.getDescription(), response.getResponseBody().getDescription());
        Assertions.assertEquals(requestBody.getCallbackUrl(), response.getResponseBody().getCallbackUrl());
        Assertions.assertEquals(requestBody.getAmount(), response.getResponseBody().getAmount());
    }

    @Test
    @DisplayName("Verify update QR Code API return 404 when using invalid qr code id")
    @Tag("negative")
    public void updateQRCodeWithInvalidQRCodeId() {
        QRCodeData requestBody = new QRCodeData("https://www.linkedin.com/in/muhammad-nur-730065a0/", 1500, "Test Update");
        String qrCodeId = "5555";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidData(requestBody, qrCodeId);
        Assertions.assertEquals(404, response.getResponse().getStatusCode());
        Assertions.assertEquals("QR_CODE_NOT_FOUND_ERROR", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("QR code was not found. Please try again with a valid QR code id.",
                response.getResponseBody().getDescription());
    }

    @Test
    @DisplayName("Verify update QR Code API return 422 when using invalid qr code id that still in use")
    @Tag("negative")
    public void updateQRCodeWithInUseQRCodeID() {
        QRCodeData requestBody = new QRCodeData("https://www.linkedin.com/in/muhammad-nur-730065a0/", 1500, "Test Update");
        String qrCodeId = "1111";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidData(requestBody, qrCodeId);
        Assertions.assertEquals(422, response.getResponse().getStatusCode());
        Assertions.assertEquals("QR_CODE_CODE_IN_USE", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("This QR code has been used. Please use a different QR code.",
                response.getResponseBody().getDescription());
    }

    @Test
    @DisplayName("Verify update QR Code API return 422 when using amount data lower than 1500")
    @Tag("negative")
    public void updateQRCodeWithAmountDataLowerThan1500() {
        QRCodeData requestBody = new QRCodeData("https://www.linkedin.com/in/muhammad-nur-730065a0/", 1499, "Test Update");
        String qrCodeId = "1234";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidData(requestBody, qrCodeId);
        Assertions.assertEquals(422, response.getResponse().getStatusCode());
        Assertions.assertEquals("API_VALIDATION_ERROR", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("Inputs are failing validation. The errors field contains details about which fields are violating validation.",
                response.getResponseBody().getDescription());
    }

    @Test
    @DisplayName("Verify update QR Code API return 422 when using invalid callback url data")
    @Tag("negative")
    public void updateQRCodeWithInvalidCallbackUrlData() {
        QRCodeData requestBody = new QRCodeData("invalid_url", 1500, "Test Update");
        String qrCodeId = "1234";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidData(requestBody, qrCodeId);
        Assertions.assertEquals(422, response.getResponse().getStatusCode());
        Assertions.assertEquals("API_VALIDATION_ERROR", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("Inputs are failing validation. The errors field contains details about which fields are violating validation.",
                response.getResponseBody().getDescription());
    }

    @Test
    @DisplayName("Verify update QR Code API return 422 when using amount data lower than 5000000")
    @Tag("negative")
    public void updateQRCodeWithAmountDataHigherThan5000000() {
        QRCodeData requestBody = new QRCodeData("https://www.linkedin.com/in/muhammad-nur-730065a0/", 5000001, "Test Update");
        String qrCodeId = "1234";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidData(requestBody, qrCodeId);
        Assertions.assertEquals(422, response.getResponse().getStatusCode());
        Assertions.assertEquals("API_VALIDATION_ERROR", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("Inputs are failing validation. The errors field contains details about which fields are violating validation.",
                response.getResponseBody().getDescription());
    }

    @Test
    @DisplayName("Verify update QR Code API return 400 when using invalid JSON Format")
    @Tag("negative")
    public void updateQRCodeWithInvalidJSONFormat() {
        String requestBody = "Invalid Body";
        String qrCodeId = "4321";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidJSONBody(requestBody, qrCodeId);
        Assertions.assertEquals(400, response.getResponse().getStatusCode());
        Assertions.assertEquals("INVALID_JSON_FORMAT", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("The request body is not a valid JSON format. Change your body format to JSON to proceed.",
                response.getResponseBody().getDescription());
    }

    @Test
    @DisplayName("Verify update QR Code API return 400 when amount data is null")
    @Tag("negative")
    public void updateQRCodeWithAmountDataNull() {
        QRCodeData requestBody = new QRCodeData("https://www.linkedin.com/in/muhammad-nur-730065a0/", null, "Test Update");
        String qrCodeId = "1234";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidData(requestBody, qrCodeId);
        Assertions.assertEquals(400, response.getResponse().getStatusCode());
        Assertions.assertEquals("API_VALIDATION_ERROR", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("Inputs are failing validation. The errors field contains details about which fields are violating validation.",
                response.getResponseBody().getDescription());
    }

    @Test
    @DisplayName("Verify update QR Code API return 400 when callback url data is null")
    @Tag("negative")
    public void updateQRCodeWithCallbackUrlDataNull() {
        QRCodeData requestBody = new QRCodeData(null, 1500, "Test Update");
        String qrCodeId = "1234";
        ResponseData<ErrorResponse> response = updateQRCodeApi.updatewithInValidData(requestBody, qrCodeId);
        Assertions.assertEquals(400, response.getResponse().getStatusCode());
        Assertions.assertEquals("API_VALIDATION_ERROR", response.getResponseBody().getErrorCode());
        Assertions.assertEquals("Inputs are failing validation. The errors field contains details about which fields are violating validation.",
                response.getResponseBody().getDescription());
    }

}
