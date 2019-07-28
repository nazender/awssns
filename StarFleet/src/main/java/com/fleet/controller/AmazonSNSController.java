package com.fleet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSns;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receivemessage")
@EnableSns
public class AmazonSNSController {
	

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

  /*  @NotificationSubscriptionMapping
    public void handleSubscriptionMessage(SnsHelper status) throws IOException {
        //We subscribe to start receive the message
        status.setRequest(request);
        status.setResponse(response);
        status.confirmSubscription();
    }*/

    @NotificationMessageMapping
    public void handleNotificationMessage(@NotificationSubject String subject, @NotificationMessage String message) {
        System.out.println(subject + message);
    }

    /*@NotificationUnsubscribeConfirmationMapping
    public void handleUnsubscribeMessage(SnsHelper status) {
        //e.g. the client has been unsubscribed and we want to "re-subscribe"
        //status.confirmSubscription();

}*/
    
}
