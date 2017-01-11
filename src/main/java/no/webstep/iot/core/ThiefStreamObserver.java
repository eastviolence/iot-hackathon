package no.webstep.iot.core;

import com.d21s.api.v1.WatchThingResponse;
import com.github.sarxos.webcam.Webcam;
import io.grpc.stub.StreamObserver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by arne.ostvold on 11.01.2017.
 */
public class ThiefStreamObserver implements StreamObserver<WatchThingResponse> {
    @Override
    public void onNext(WatchThingResponse watchThingResponse) {
        boolean objectPresent = watchThingResponse.getStateChanged().getObjectPresent();

        if(!objectPresent){
            takePicture();
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }

    private void takePicture() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        try {
            ImageIO.write(webcam.getImage(), "PNG", new File(""+LocalDateTime.now().toString()+".png"));
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            webcam.close();
        }
    }
}
