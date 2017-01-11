package no.webstep.iot.core;

import com.d21s.api.v1.WatchThingResponse;
import io.grpc.stub.StreamObserver;

/**
 * Created by arne.ostvold on 11.01.2017.
 */
public class PostOfficeStreamObserver implements StreamObserver<WatchThingResponse> {
    @Override
    public void onNext(WatchThingResponse watchThingResponse) {
        boolean objectPresent = watchThingResponse.getStateChanged().getObjectPresent();
        System.out.println("State endret til " + objectPresent);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }
}
