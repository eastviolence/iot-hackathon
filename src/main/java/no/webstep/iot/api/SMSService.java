package no.webstep.iot.api;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * Created by arne.ostvold on 11.01.2017.
 */
public class SMSService {
    private static final String ACCOUNT_SID = "ACf11b9b87387843d4677a7451f7b887c9";
    private static final String AUTH_TOKEN = "4de917d3881e298996ff97838f9a703f";
    private static final String FROM_NR = "+46769449190";

    public SMSService() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSMS(String toNr, String msg) {
        System.out.println(String.format("Sending sms %s", msg));
/*        Message message = Message.creator(
                new PhoneNumber(toNr),
                new PhoneNumber(FROM_NR), msg)
                .create();

        System.out.println(message);*/
    }
}
