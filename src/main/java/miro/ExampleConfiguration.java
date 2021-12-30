package miro;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.health.conf.HealthConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ExampleConfiguration extends Configuration {
  @Valid
  @NotNull
  @JsonProperty("health")
  private HealthConfiguration healthConfiguration = new HealthConfiguration();

  public HealthConfiguration getHealthConfiguration() {
    return healthConfiguration;
  }

  public void setHealthConfiguration(final HealthConfiguration healthConfiguration) {
    this.healthConfiguration = healthConfiguration;
  }
}
