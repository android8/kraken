package com.kraken.runtime.docker.env;

import com.kraken.runtime.entity.TaskType;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@Component
class RunChecker implements EnvironmentChecker {

  @Override
  public void accept(final Map<String, String> environment) {
    requireEnv(environment, "KRAKEN_VERSION",
        "KRAKEN_GATLING_SIMULATION",
        "KRAKEN_DESCRIPTION",
        "KRAKEN_TASK_ID",
        "KRAKEN_INFLUXDB_URL",
        "KRAKEN_INFLUXDB_DATABASE",
        "KRAKEN_INFLUXDB_USER",
        "KRAKEN_INFLUXDB_PASSWORD",
        "KRAKEN_RUNTIME_URL",
        "KRAKEN_STORAGE_URL");
  }

  @Override
  public boolean test(final TaskType taskType) {
    return TaskType.RUN == taskType;
  }
}
