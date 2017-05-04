package com.ubb.cms.server;

import com.ubb.cms.generated.*;
import com.ubb.cms.grpccommon.Converter;
import com.ubb.cms.model.User;
import com.ubb.cms.services.EditionService;
import com.ubb.cms.services.UserService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marius Adam
 */
@Service
class CmsServiceImpl extends CmsServiceGrpc.CmsServiceImplBase {
    private UserService userService;
    private EditionService editionService;

    @Autowired
    CmsServiceImpl(UserService userService, EditionService editionService) {
        this.userService = userService;
        this.editionService = editionService;
    }

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getUsers(GetUsersRequest request, StreamObserver<UserDto> responseObserver) {
        try {
            List<User> all = userService.getAll();
            all.forEach(
                    user -> responseObserver.onNext(Converter.toDto(user))
            );
            responseObserver.onCompleted();
        } catch (Exception ex) {
            responseObserver.onError(ex);
        }
    }

    @Override
    public void getEditions(GetEditionsRequest request, StreamObserver<GetEditionsReply> responseObserver) {
        try {
            GetEditionsReply.Builder responseBuilder = GetEditionsReply.newBuilder();
            editionService.getAll().forEach(
                    edition -> responseBuilder.addEdition(Converter.toDto(edition))
            );
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception ex) {
            responseObserver.onError(ex);
        }
    }
}
