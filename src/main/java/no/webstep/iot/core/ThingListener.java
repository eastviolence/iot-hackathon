package no.webstep.iot.core;

import no.webstep.iot.disruptive.DisruptiveClient;

/**
 * Created by arne.ostvold on 11.01.2017.
 */
public class ThingListener {
    private final DisruptiveClient client;

    public ThingListener() {
        client = new DisruptiveClient("6310afd33c5a4c7fac0d30b51a5df1d5");

        client.watchThing("206844419", new PostOfficeStreamObserver());
        client.watchThing("206844419", new ThiefStreamObserver());
    }
}
