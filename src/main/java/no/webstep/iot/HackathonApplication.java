package no.webstep.iot;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import no.webstep.iot.core.ThingListener;
import no.webstep.iot.resources.HelloWorldResource;
import no.webstep.iot.resources.ThingResource;

public class HackathonApplication extends Application<HackathonConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HackathonApplication().run(args);
    }

    @Override
    public String getName() {
        return "hackathon";
    }

    @Override
    public void initialize(final Bootstrap<HackathonConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/static", "index.html"));
    }

    @Override
    public void run(final HackathonConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloWorldResource());
        environment.jersey().register(new ThingResource());
        environment.jersey().register(new ThingListener());
    }

}
