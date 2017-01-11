package no.webstep.iot.resources;

import com.codahale.metrics.annotation.Timed;
import com.d21s.api.v1.ListThingsResponse;
import no.webstep.iot.api.ThingResponse;
import no.webstep.iot.api.ThingsResponse;
import no.webstep.iot.disruptive.DisruptiveClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/things")
@Produces(MediaType.APPLICATION_JSON)
public class ThingResource {
    private static final String APIKEY = "6310afd33c5a4c7fac0d30b51a5df1d5";
    private final DisruptiveClient client;

    public ThingResource() {
        client = new DisruptiveClient("6310afd33c5a4c7fac0d30b51a5df1d5");
    }


    @GET
    @Timed
    public Response listAllThings() {
        List<ThingResponse> things = new ArrayList<>();
        ThingsResponse thingsResponse = new ThingsResponse();

        ListThingsResponse listThingsResponse = client.listThings();

        listThingsResponse.getThingsList().forEach(thing -> {
            ThingResponse thingResponse = new ThingResponse();

            thingResponse.setId(thing.getId());

            things.add(thingResponse);
        });

        thingsResponse.setThings(things);

        return Response.ok().entity(thingsResponse).build();
    }
}
