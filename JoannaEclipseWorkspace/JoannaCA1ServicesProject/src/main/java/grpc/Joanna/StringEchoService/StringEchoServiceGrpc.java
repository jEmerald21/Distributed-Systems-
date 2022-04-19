package grpc.Joanna.StringEchoService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * this is a minimalistic service based on one of the provided examples to make sure the basics work correctly
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: StringEchoService.proto")
public final class StringEchoServiceGrpc {

  private StringEchoServiceGrpc() {}

  public static final String SERVICE_NAME = "StringEchoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.StringEchoService.StringMessage,
      grpc.Joanna.StringEchoService.StringMessage> getEchoStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoString",
      requestType = grpc.Joanna.StringEchoService.StringMessage.class,
      responseType = grpc.Joanna.StringEchoService.StringMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Joanna.StringEchoService.StringMessage,
      grpc.Joanna.StringEchoService.StringMessage> getEchoStringMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.StringEchoService.StringMessage, grpc.Joanna.StringEchoService.StringMessage> getEchoStringMethod;
    if ((getEchoStringMethod = StringEchoServiceGrpc.getEchoStringMethod) == null) {
      synchronized (StringEchoServiceGrpc.class) {
        if ((getEchoStringMethod = StringEchoServiceGrpc.getEchoStringMethod) == null) {
          StringEchoServiceGrpc.getEchoStringMethod = getEchoStringMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.StringEchoService.StringMessage, grpc.Joanna.StringEchoService.StringMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StringEchoService", "EchoString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.StringEchoService.StringMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.StringEchoService.StringMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new StringEchoServiceMethodDescriptorSupplier("EchoString"))
                  .build();
          }
        }
     }
     return getEchoStringMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StringEchoServiceStub newStub(io.grpc.Channel channel) {
    return new StringEchoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StringEchoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StringEchoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StringEchoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StringEchoServiceFutureStub(channel);
  }

  /**
   * <pre>
   * this is a minimalistic service based on one of the provided examples to make sure the basics work correctly
   * </pre>
   */
  public static abstract class StringEchoServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * reflects back the string sent
     * </pre>
     */
    public void echoString(grpc.Joanna.StringEchoService.StringMessage request,
        io.grpc.stub.StreamObserver<grpc.Joanna.StringEchoService.StringMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getEchoStringMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEchoStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Joanna.StringEchoService.StringMessage,
                grpc.Joanna.StringEchoService.StringMessage>(
                  this, METHODID_ECHO_STRING)))
          .build();
    }
  }

  /**
   * <pre>
   * this is a minimalistic service based on one of the provided examples to make sure the basics work correctly
   * </pre>
   */
  public static final class StringEchoServiceStub extends io.grpc.stub.AbstractStub<StringEchoServiceStub> {
    private StringEchoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StringEchoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StringEchoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StringEchoServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * reflects back the string sent
     * </pre>
     */
    public void echoString(grpc.Joanna.StringEchoService.StringMessage request,
        io.grpc.stub.StreamObserver<grpc.Joanna.StringEchoService.StringMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEchoStringMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * this is a minimalistic service based on one of the provided examples to make sure the basics work correctly
   * </pre>
   */
  public static final class StringEchoServiceBlockingStub extends io.grpc.stub.AbstractStub<StringEchoServiceBlockingStub> {
    private StringEchoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StringEchoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StringEchoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StringEchoServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * reflects back the string sent
     * </pre>
     */
    public grpc.Joanna.StringEchoService.StringMessage echoString(grpc.Joanna.StringEchoService.StringMessage request) {
      return blockingUnaryCall(
          getChannel(), getEchoStringMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * this is a minimalistic service based on one of the provided examples to make sure the basics work correctly
   * </pre>
   */
  public static final class StringEchoServiceFutureStub extends io.grpc.stub.AbstractStub<StringEchoServiceFutureStub> {
    private StringEchoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StringEchoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StringEchoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StringEchoServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * reflects back the string sent
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Joanna.StringEchoService.StringMessage> echoString(
        grpc.Joanna.StringEchoService.StringMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getEchoStringMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO_STRING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StringEchoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StringEchoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ECHO_STRING:
          serviceImpl.echoString((grpc.Joanna.StringEchoService.StringMessage) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.StringEchoService.StringMessage>) responseObserver);
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

  private static abstract class StringEchoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StringEchoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Joanna.StringEchoService.StringEchoServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StringEchoService");
    }
  }

  private static final class StringEchoServiceFileDescriptorSupplier
      extends StringEchoServiceBaseDescriptorSupplier {
    StringEchoServiceFileDescriptorSupplier() {}
  }

  private static final class StringEchoServiceMethodDescriptorSupplier
      extends StringEchoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StringEchoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StringEchoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StringEchoServiceFileDescriptorSupplier())
              .addMethod(getEchoStringMethod())
              .build();
        }
      }
    }
    return result;
  }
}
