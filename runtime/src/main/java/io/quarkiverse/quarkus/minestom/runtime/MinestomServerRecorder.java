package io.quarkiverse.quarkus.minestom.runtime;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.ShutdownContext;
import io.quarkus.runtime.annotations.Recorder;
import io.vertx.core.Vertx;

@Recorder
public class MinestomServerRecorder {

    public void initializeMinestomServer(RuntimeValue<Vertx> vertxSupplier,
            ShutdownContext shutdown,
            LaunchMode launchMode) {
        Vertx vertx = vertxSupplier.getValue();
        MinestomServer server = new MinestomServer();

        if (launchMode == LaunchMode.NORMAL) {
            //shutdown.addShutdownTask(server::stop);
        }

        vertx.deployVerticle(new MinestomVerticle(server));
    }
}
