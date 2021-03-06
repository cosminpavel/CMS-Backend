package com.ubb.cms.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Marius Adam
 */
@Component
public class CmsServerMain {
    private static final Logger logger = Logger.getLogger(CmsServerMain.class.getName());

    private Server server;
    private CmsServiceImpl serviceImpl;

    /* The port on which the server should run */
    private int port = 50051;

    @Autowired
    public CmsServerMain(CmsServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(serviceImpl)
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            CmsServerMain.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-server.xml");
        final CmsServerMain server = applicationContext.getBean(CmsServerMain.class);

        if (args.length > 0) {
            server.port = Integer.parseInt(args[0]);
        }

        server.start();
        server.blockUntilShutdown();
    }
}
