package com.parking.sensor.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: parking.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ParkingSensorServiceGrpc {

  private ParkingSensorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "parking.ParkingSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.parking.sensor.grpc.SensorRequest,
      com.parking.sensor.grpc.SpotUpdate> getStreamSpotStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamSpotStatus",
      requestType = com.parking.sensor.grpc.SensorRequest.class,
      responseType = com.parking.sensor.grpc.SpotUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.parking.sensor.grpc.SensorRequest,
      com.parking.sensor.grpc.SpotUpdate> getStreamSpotStatusMethod() {
    io.grpc.MethodDescriptor<com.parking.sensor.grpc.SensorRequest, com.parking.sensor.grpc.SpotUpdate> getStreamSpotStatusMethod;
    if ((getStreamSpotStatusMethod = ParkingSensorServiceGrpc.getStreamSpotStatusMethod) == null) {
      synchronized (ParkingSensorServiceGrpc.class) {
        if ((getStreamSpotStatusMethod = ParkingSensorServiceGrpc.getStreamSpotStatusMethod) == null) {
          ParkingSensorServiceGrpc.getStreamSpotStatusMethod = getStreamSpotStatusMethod =
              io.grpc.MethodDescriptor.<com.parking.sensor.grpc.SensorRequest, com.parking.sensor.grpc.SpotUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamSpotStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.parking.sensor.grpc.SensorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.parking.sensor.grpc.SpotUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new ParkingSensorServiceMethodDescriptorSupplier("streamSpotStatus"))
              .build();
        }
      }
    }
    return getStreamSpotStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ParkingSensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParkingSensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ParkingSensorServiceStub>() {
        @java.lang.Override
        public ParkingSensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ParkingSensorServiceStub(channel, callOptions);
        }
      };
    return ParkingSensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ParkingSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParkingSensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ParkingSensorServiceBlockingStub>() {
        @java.lang.Override
        public ParkingSensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ParkingSensorServiceBlockingStub(channel, callOptions);
        }
      };
    return ParkingSensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ParkingSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParkingSensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ParkingSensorServiceFutureStub>() {
        @java.lang.Override
        public ParkingSensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ParkingSensorServiceFutureStub(channel, callOptions);
        }
      };
    return ParkingSensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void streamSpotStatus(com.parking.sensor.grpc.SensorRequest request,
        io.grpc.stub.StreamObserver<com.parking.sensor.grpc.SpotUpdate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamSpotStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ParkingSensorService.
   */
  public static abstract class ParkingSensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ParkingSensorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ParkingSensorService.
   */
  public static final class ParkingSensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ParkingSensorServiceStub> {
    private ParkingSensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParkingSensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParkingSensorServiceStub(channel, callOptions);
    }

    /**
     */
    public void streamSpotStatus(com.parking.sensor.grpc.SensorRequest request,
        io.grpc.stub.StreamObserver<com.parking.sensor.grpc.SpotUpdate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamSpotStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ParkingSensorService.
   */
  public static final class ParkingSensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ParkingSensorServiceBlockingStub> {
    private ParkingSensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParkingSensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParkingSensorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.parking.sensor.grpc.SpotUpdate> streamSpotStatus(
        com.parking.sensor.grpc.SensorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamSpotStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ParkingSensorService.
   */
  public static final class ParkingSensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ParkingSensorServiceFutureStub> {
    private ParkingSensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParkingSensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParkingSensorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_SPOT_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_SPOT_STATUS:
          serviceImpl.streamSpotStatus((com.parking.sensor.grpc.SensorRequest) request,
              (io.grpc.stub.StreamObserver<com.parking.sensor.grpc.SpotUpdate>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStreamSpotStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.parking.sensor.grpc.SensorRequest,
              com.parking.sensor.grpc.SpotUpdate>(
                service, METHODID_STREAM_SPOT_STATUS)))
        .build();
  }

  private static abstract class ParkingSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ParkingSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.parking.sensor.grpc.ParkingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ParkingSensorService");
    }
  }

  private static final class ParkingSensorServiceFileDescriptorSupplier
      extends ParkingSensorServiceBaseDescriptorSupplier {
    ParkingSensorServiceFileDescriptorSupplier() {}
  }

  private static final class ParkingSensorServiceMethodDescriptorSupplier
      extends ParkingSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ParkingSensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ParkingSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ParkingSensorServiceFileDescriptorSupplier())
              .addMethod(getStreamSpotStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
