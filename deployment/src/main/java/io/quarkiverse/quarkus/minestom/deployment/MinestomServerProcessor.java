package io.quarkiverse.quarkus.minestom.deployment;

import java.util.List;

import io.quarkiverse.quarkus.minestom.runtime.MinestomServerRecorder;
import io.quarkus.arc.deployment.RecorderBeanInitializedBuildItem;
import io.quarkus.arc.deployment.SyntheticBeansRuntimeInitBuildItem;
import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Consume;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.LaunchModeBuildItem;
import io.quarkus.deployment.builditem.ServiceStartBuildItem;
import io.quarkus.deployment.builditem.ShutdownContextBuildItem;
import io.quarkus.vertx.deployment.VertxBuildItem;

public class MinestomServerProcessor {

    @BuildStep
    @Record(value = ExecutionTime.RUNTIME_INIT)
    @Consume(SyntheticBeansRuntimeInitBuildItem.class)
    ServiceStartBuildItem initializeServer(MinestomServerRecorder recorder,
            ShutdownContextBuildItem shutdown,
            List<RecorderBeanInitializedBuildItem> orderEnforcer,
            LaunchModeBuildItem launchModeBuildItem,
            VertxBuildItem vertx,
            Capabilities capabilities) {
        recorder.initializeMinestomServer(vertx.getVertx(), shutdown, launchModeBuildItem.getLaunchMode());
        return new ServiceStartBuildItem("minestom");
    }
}
