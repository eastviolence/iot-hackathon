package no.webstep.iot;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import no.webstep.iot.resources.HelloWorldResource;

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
        // TODO: application initialization
    }

    @Override
    public void run(final HackathonConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloWorldResource());
    }

}
