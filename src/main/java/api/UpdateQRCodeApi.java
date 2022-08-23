package api;

import base.BaseRequest;
import base.ResponseData;
import io.restassured.response.Response;
import models.ErrorResponse;
import models.QRCodeData;

import static constants.ServiceConstants.ENDPOINT_UPDATE_QR_CODE;

public class UpdateQRCodeApi extends BaseRequest {

    public ResponseData<QRCodeData> updatewithValidData(QRCodeData qrCodeData, String qrCodeId) {
        Response response = base()
                .body(qrCodeData)
                .pathParam("qr_code_id", qrCodeId)
                .patch(ENDPOINT_UPDATE_QR_CODE);

        response.then().log().all();
        QRCodeData responseBody = response.as(QRCodeData.class);
        return new ResponseData<>(response, responseBody);

    }

    public ResponseData<ErrorResponse> updatewithInValidData(QRCodeData qrCodeData, String qrCodeId) {
        Response response = base()
                .body(qrCodeData)
                .pathParam("qr_code_id", qrCodeId)
                .patch(ENDPOINT_UPDATE_QR_CODE);

        response.then().log().all();
        ErrorResponse responseBody = response.as(ErrorResponse.class);
        return new ResponseData<>(response, responseBody);

    }

    public ResponseData<ErrorResponse> updatewithInValidJSONBody(String qrCodeData, String qrCodeId) {
        Response response = base()
                .removeHeader("Content-Type")
                .removeHeader("x-mock-match-request-body")
                .body(qrCodeData)
                .pathParam("qr_code_id", qrCodeId)
                .patch(ENDPOINT_UPDATE_QR_CODE);

        response.then().log().all();
        ErrorResponse responseBody = response.as(ErrorResponse.class);
        return new ResponseData<>(response, responseBody);

    }

}
