## How to Run

I am using postman mock server you can check the mock [here](https://www.getpostman.com/collections/d5252bc1fd1b0b164bc9)

to run the test, simply clone the project and run using command `./gradlew clean test` (for mac) or `gradlew.bat clean test` (for windows)

## Answer for Question (Manual QA Engineer)

### Answer for Question No. 1 : 

<table><tbody><tr><td><strong>ID</strong></td><td><strong>Title</strong></td><td><strong>Description</strong></td></tr><tr><td>1</td><td>Verify update QR Code API return 200 when using valid data</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 200</li><li>Assert response data for description, callback url, and amount to be same with request body</li></ol></td></tr><tr><td>2</td><td>Verify update QR Code API return 404 when using invalid qr code id</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 404</li><li>Assert response data for description and error code</li></ol></td></tr><tr><td>3</td><td>Verify update QR Code API return 422 when using invalid qr code id that still in use</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 422</li><li>Assert response data for description and error code</li></ol></td></tr><tr><td>4</td><td>Verify update QR Code API return 422 when using amount data lower than 1500</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 422</li><li>Assert response data for description and error code</li></ol></td></tr><tr><td>5</td><td>Verify update QR Code API return 422 when using invalid callback url data</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 422</li><li>Assert response data for description and error code</li></ol></td></tr><tr><td>6</td><td>Verify update QR Code API return 422 when using amount data lower than 5000000</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 422</li><li>Assert response data for description and error code</li></ol></td></tr><tr><td>7</td><td>Verify update QR Code API return 400 when using invalid JSON Format</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 400</li><li>Assert response data for description and error code</li></ol></td></tr><tr><td>8</td><td>Verify update QR Code API return 400 when amount data is null</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 400</li><li>Assert response data for description and error code</li></ol></td></tr><tr><td>9</td><td>Verify update QR Code API return 400 when callback url data is null</td><td><p>Assertions :&nbsp;</p><ol><li>Status code to be 400</li><li>Assert response data for description and error code</li></ol></td></tr></tbody></table>

### Answer for Question No. 2 :

Because API on service B internally using API on Service A, so things need to verify :

1.  Make sure all the positive scenarios for API on Service B already passed.
2.  Make sure API on service B able to handle error message from service A (create the test and check the logic).
3.  Make sure all negative scenario on service B are passed.