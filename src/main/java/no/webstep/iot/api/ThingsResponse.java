package no.webstep.iot.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arne.ostvold on 11.01.2017.
 */
public class ThingsResponse {
    private List<ThingResponse> things;

    public List<ThingResponse> getThings() {
        return things;
    }

    public void setThings(List<ThingResponse> things) {
        this.things = things;
    }
}
