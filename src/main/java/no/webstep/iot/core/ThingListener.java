package no.webstep.iot.core;

import com.d21s.api.v1.Thing;
import com.d21s.api.v1.WatchResponse;
import com.d21s.api.v1.WatchThingResponse;
import com.d21s.api.v1.events.ThingStateChangeEvent;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import no.webstep.iot.disruptive.DisruptiveClient;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by arne.ostvold on 11.01.2017.
 */
public class ThingListener {
    private final DisruptiveClient client;

    public ThingListener() {
        client = new DisruptiveClient("6310afd33c5a4c7fac0d30b51a5df1d5");

        client.watchThing("206844419", new StreamObserver<WatchThingResponse>() {
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
        });
    }
}
