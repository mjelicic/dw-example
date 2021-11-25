package miro;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "Example";
    }

    @Override
    public void initialize(final Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
                                .enableAutoConfig(getClass().getPackage().getName())
                                .build());
    }

    @Override
    public void run(final ExampleConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
