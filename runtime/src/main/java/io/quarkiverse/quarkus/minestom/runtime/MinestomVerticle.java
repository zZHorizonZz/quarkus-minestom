package io.quarkiverse.quarkus.minestom.runtime;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class MinestomVerticle extends AbstractVerticle {

    private final MinestomServer server;

    public MinestomVerticle(MinestomServer server) {
        this.server = server;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        server.start();

        startPromise.complete();
    }
}
