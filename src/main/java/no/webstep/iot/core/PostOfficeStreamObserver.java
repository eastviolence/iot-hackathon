package no.webstep.iot.core;

import com.d21s.api.v1.WatchThingResponse;
import com.github.sarxos.webcam.Webcam;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import no.webstep.iot.api.SMSService;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by arne.ostvold on 11.01.2017.
 */
public class PostOfficeStreamObserver implements StreamObserver<WatchThingResponse> {
    private final SMSService smsService;

    public PostOfficeStreamObserver() {
        smsService = new SMSService();
    }

    @Override
    public void onNext(WatchThingResponse watchThingResponse) {
        boolean objectPresent = watchThingResponse.getStateChanged().getObjectPresent();
        float temperature = watchThingResponse.getStateChanged().getTemperature();
        Date received = new Date(watchThingResponse.getTimestamp().getSeconds() * 1000);

        System.out.println("Temperatur er " + temperature);
        System.out.println("State endret til " + objectPresent);

        if(objectPresent){
            smsService.sendSMS("+4795948929", generateSMSText(temperature, received));
        }

    }

    private String generateSMSText(float temperature, Date received) {
        return String.format("En pakke til deg ankom kl %s.%s. Pakken lagres på %s grader celsius", received.getHours(), received.getMinutes(), temperature);
    }



    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }
}
