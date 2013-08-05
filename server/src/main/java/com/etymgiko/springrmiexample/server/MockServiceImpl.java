package com.etymgiko.springrmiexample.server;


/**
 * @author Liel.Ran
 */
public class MockServiceImpl implements HelloService {


    public HelloResponse sayHello(HelloMessage message) {
        String messageText = message.getText();
        System.out.println(("MOCK !!!!!!  - sayHello() is called, message text: " + messageText));
        HelloResponse response = new HelloResponse();
        String text = "Hello from server, your message:  this is Fucking Mock " + messageText;
        response.setText(text);
        return response;
    }

}