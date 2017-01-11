package no.webstep.iot.resources;

import com.codahale.metrics.annotation.Timed;
import com.d21s.api.v1.ListThingsResponse;
import com.d21s.api.v1.Thing;
import no.webstep.iot.api.Mailer;
import no.webstep.iot.disruptive.DisruptiveClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String APIKEY = "6310afd33c5a4c7fac0d30b51a5df1d5";
    private final DisruptiveClient client;

    public HelloWorldResource() {
       client = new DisruptiveClient("6310afd33c5a4c7fac0d30b51a5df1d5");
    }

    @GET
    @Timed
    public Response sayHello() {
        DisruptiveClient client = new DisruptiveClient("6310afd33c5a4c7fac0d30b51a5df1d5");
        Map<String,Thing> ting = new HashMap<>();

        // henter alle sensorer, og husker de
        ListThingsResponse listThingsResponse = client.listThings();
        for (Thing thing : listThingsResponse.getThingsList()) {

            if(thing.getName().equals("N-0c543203")){
                ting.put(thing.getType().getId(),thing);
                Mailer test = new Mailer();
                test.doSendMail("wsiothackathon", "makeItawesome", "eirikbroen@gmail.com",
                        "you got mail", "You have mail " + thing.getName(), null);
                logger.info("Fikk thing {},{}",thing.getName(),thing.getType().getId());
            }
        }


        return Response.ok().build();
    }
}