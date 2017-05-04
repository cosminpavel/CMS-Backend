package com.ubb.cms.client;

import com.google.common.collect.Lists;
import com.ubb.cms.generated.*;
import com.ubb.cms.grpccommon.Converter;
import com.ubb.cms.model.Edition;
import com.ubb.cms.model.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Marius Adam
 */
@Service
public class CmsServiceClient {
    private static final Logger logger = Logger.getLogger(CmsServiceClient.class.getName());

    private final ManagedChannel channel;

    private final CmsServiceGrpc.CmsServiceBlockingStub blockingStub;
    private final CmsServiceGrpc.CmsServiceStub asyncStub;
    /**
     * Construct client connecting to CmsService server at {@code host:port}.
     */
    @Autowired
    public CmsServiceClient(
            @Value("${server.host}") String host,
            @Value("${server.port}") int port
    ) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true));
    }

    /**
     * Construct client for accessing RouteGuide server using the existing channel.
     */
    CmsServiceClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = CmsServiceGrpc.newBlockingStub(channel);
        asyncStub = CmsServiceGrpc.newStub(channel);
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public void greet(String name) {
        logger.info("Will try to greet " + name + " ...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e);
            return;
        }
        logger.info("Greeting: " + response.getMessage());
    }

    public List<User> getUsers() {
        GetUsersRequest request = GetUsersRequest.newBuilder().build();
        Iterator<UserDto> it = blockingStub.getUsers(request);

        return Lists.newArrayList(it).stream()
                .map(Converter::toPojo)
                .collect(Collectors.toList());
    }

    public CountDownLatch getUsersAsync(Consumer<User> userConsumer) {
        GetUsersRequest request = GetUsersRequest.newBuilder().build();
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<UserDto> responseObserver = new StreamObserver<UserDto>() {
            @Override
            public void onNext(UserDto value) {
                userConsumer.accept(Converter.toPojo(value));
            }

            @Override
            public void onError(Throwable t) {
                finishLatch.countDown();
                throw new RuntimeException(t);
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
                System.out.println("Finished retrieving users asynchronously");
            }
        };
        asyncStub.getUsers(request, responseObserver);

        return finishLatch;
    }

    public List<Edition> getEditions() {
        GetEditionsRequest request = GetEditionsRequest.newBuilder().build();
        GetEditionsReply reply = blockingStub.getEditions(request);

        return reply.getEditionList().stream()
                .map(Converter::toPojo)
                .collect(Collectors.toList());
    }
}

