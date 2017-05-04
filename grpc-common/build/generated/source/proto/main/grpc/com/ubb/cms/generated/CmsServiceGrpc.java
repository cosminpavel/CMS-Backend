package com.ubb.cms.generated;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The motorcycling contest service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: cms.proto")
public final class CmsServiceGrpc {

  private CmsServiceGrpc() {}

  public static final String SERVICE_NAME = "cms.CmsService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.ubb.cms.generated.HelloRequest,
      com.ubb.cms.generated.HelloReply> METHOD_SAY_HELLO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "cms.CmsService", "SayHello"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.ubb.cms.generated.HelloRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.ubb.cms.generated.HelloReply.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.ubb.cms.generated.GetUsersRequest,
      com.ubb.cms.generated.UserDto> METHOD_GET_USERS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "cms.CmsService", "GetUsers"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.ubb.cms.generated.GetUsersRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.ubb.cms.generated.UserDto.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.ubb.cms.generated.GetEditionsRequest,
      com.ubb.cms.generated.GetEditionsReply> METHOD_GET_EDITIONS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "cms.CmsService", "GetEditions"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.ubb.cms.generated.GetEditionsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.ubb.cms.generated.GetEditionsReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CmsServiceStub newStub(io.grpc.Channel channel) {
    return new CmsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CmsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CmsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static CmsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CmsServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The motorcycling contest service definition.
   * </pre>
   */
  public static abstract class CmsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(com.ubb.cms.generated.HelloRequest request,
        io.grpc.stub.StreamObserver<com.ubb.cms.generated.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY_HELLO, responseObserver);
    }

    /**
     * <pre>
     * on method to obtain results is to use a response stream
     * </pre>
     */
    public void getUsers(com.ubb.cms.generated.GetUsersRequest request,
        io.grpc.stub.StreamObserver<com.ubb.cms.generated.UserDto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USERS, responseObserver);
    }

    /**
     * <pre>
     * another method to obtiain results is to use and reply message
     * to wrap a list of objects
     * </pre>
     */
    public void getEditions(com.ubb.cms.generated.GetEditionsRequest request,
        io.grpc.stub.StreamObserver<com.ubb.cms.generated.GetEditionsReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_EDITIONS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAY_HELLO,
            asyncUnaryCall(
              new MethodHandlers<
                com.ubb.cms.generated.HelloRequest,
                com.ubb.cms.generated.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            METHOD_GET_USERS,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ubb.cms.generated.GetUsersRequest,
                com.ubb.cms.generated.UserDto>(
                  this, METHODID_GET_USERS)))
          .addMethod(
            METHOD_GET_EDITIONS,
            asyncUnaryCall(
              new MethodHandlers<
                com.ubb.cms.generated.GetEditionsRequest,
                com.ubb.cms.generated.GetEditionsReply>(
                  this, METHODID_GET_EDITIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * The motorcycling contest service definition.
   * </pre>
   */
  public static final class CmsServiceStub extends io.grpc.stub.AbstractStub<CmsServiceStub> {
    private CmsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CmsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CmsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(com.ubb.cms.generated.HelloRequest request,
        io.grpc.stub.StreamObserver<com.ubb.cms.generated.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAY_HELLO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * on method to obtain results is to use a response stream
     * </pre>
     */
    public void getUsers(com.ubb.cms.generated.GetUsersRequest request,
        io.grpc.stub.StreamObserver<com.ubb.cms.generated.UserDto> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_USERS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * another method to obtiain results is to use and reply message
     * to wrap a list of objects
     * </pre>
     */
    public void getEditions(com.ubb.cms.generated.GetEditionsRequest request,
        io.grpc.stub.StreamObserver<com.ubb.cms.generated.GetEditionsReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_EDITIONS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The motorcycling contest service definition.
   * </pre>
   */
  public static final class CmsServiceBlockingStub extends io.grpc.stub.AbstractStub<CmsServiceBlockingStub> {
    private CmsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CmsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CmsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.ubb.cms.generated.HelloReply sayHello(com.ubb.cms.generated.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAY_HELLO, getCallOptions(), request);
    }

    /**
     * <pre>
     * on method to obtain results is to use a response stream
     * </pre>
     */
    public java.util.Iterator<com.ubb.cms.generated.UserDto> getUsers(
        com.ubb.cms.generated.GetUsersRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_USERS, getCallOptions(), request);
    }

    /**
     * <pre>
     * another method to obtiain results is to use and reply message
     * to wrap a list of objects
     * </pre>
     */
    public com.ubb.cms.generated.GetEditionsReply getEditions(com.ubb.cms.generated.GetEditionsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_EDITIONS, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The motorcycling contest service definition.
   * </pre>
   */
  public static final class CmsServiceFutureStub extends io.grpc.stub.AbstractStub<CmsServiceFutureStub> {
    private CmsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CmsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CmsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ubb.cms.generated.HelloReply> sayHello(
        com.ubb.cms.generated.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAY_HELLO, getCallOptions()), request);
    }

    /**
     * <pre>
     * another method to obtiain results is to use and reply message
     * to wrap a list of objects
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ubb.cms.generated.GetEditionsReply> getEditions(
        com.ubb.cms.generated.GetEditionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_EDITIONS, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_GET_USERS = 1;
  private static final int METHODID_GET_EDITIONS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CmsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CmsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.ubb.cms.generated.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.ubb.cms.generated.HelloReply>) responseObserver);
          break;
        case METHODID_GET_USERS:
          serviceImpl.getUsers((com.ubb.cms.generated.GetUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.ubb.cms.generated.UserDto>) responseObserver);
          break;
        case METHODID_GET_EDITIONS:
          serviceImpl.getEditions((com.ubb.cms.generated.GetEditionsRequest) request,
              (io.grpc.stub.StreamObserver<com.ubb.cms.generated.GetEditionsReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CmsServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ubb.cms.generated.cmsProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CmsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CmsServiceDescriptorSupplier())
              .addMethod(METHOD_SAY_HELLO)
              .addMethod(METHOD_GET_USERS)
              .addMethod(METHOD_GET_EDITIONS)
              .build();
        }
      }
    }
    return result;
  }
}
