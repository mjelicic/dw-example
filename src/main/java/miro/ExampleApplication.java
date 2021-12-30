package miro;

import io.dropwizard.Application;
import io.dropwizard.health.conf.HealthConfiguration;
import io.dropwizard.health.core.HealthCheckBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.exporter.MetricsServlet;
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

        bootstrap.addBundle(new HealthCheckBundle<ExampleConfiguration>() {
            @Override
            protected HealthConfiguration getHealthConfiguration(final ExampleConfiguration configuration) {
                return configuration.getHealthConfiguration();
            }
        });

    }

    @Override
    public void run(final ExampleConfiguration configuration,
                    final Environment environment) {
        registerMetrics(environment);
    }

    private void registerMetrics(Environment environment) {
        CollectorRegistry collectorRegistry = new CollectorRegistry();
        collectorRegistry.register(new DropwizardExports(environment.metrics()));
        environment
            .servlets()
            .addServlet("metrics", new MetricsServlet(collectorRegistry))
            .addMapping("/metrics");
    }

}
