package grpc.Joanna.SupportService;

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
 *&#47;/////////////////////////////////////////////////////////////////////////////////
 * The greeter service definition. Defining it's remote methods
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SupportService.proto")
public final class SupportServiceGrpc {

  private SupportServiceGrpc() {}

  public static final String SERVICE_NAME = "SupportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.SupportService.RequestChatInfo,
      grpc.Joanna.SupportService.RequestResult> getRequestPhoneCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestPhoneCall",
      requestType = grpc.Joanna.SupportService.RequestChatInfo.class,
      responseType = grpc.Joanna.SupportService.RequestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Joanna.SupportService.RequestChatInfo,
      grpc.Joanna.SupportService.RequestResult> getRequestPhoneCallMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.SupportService.RequestChatInfo, grpc.Joanna.SupportService.RequestResult> getRequestPhoneCallMethod;
    if ((getRequestPhoneCallMethod = SupportServiceGrpc.getRequestPhoneCallMethod) == null) {
      synchronized (SupportServiceGrpc.class) {
        if ((getRequestPhoneCallMethod = SupportServiceGrpc.getRequestPhoneCallMethod) == null) {
          SupportServiceGrpc.getRequestPhoneCallMethod = getRequestPhoneCallMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.SupportService.RequestChatInfo, grpc.Joanna.SupportService.RequestResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SupportService", "RequestPhoneCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.SupportService.RequestChatInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.SupportService.RequestResult.getDefaultInstance()))
                  .setSchemaDescriptor(new SupportServiceMethodDescriptorSupplier("RequestPhoneCall"))
                  .build();
          }
        }
     }
     return getRequestPhoneCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.SupportService.QueueUpforChatInfo,
      grpc.Joanna.SupportService.QueueStatusInfo> getQueueUpforChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueueUpforChat",
      requestType = grpc.Joanna.SupportService.QueueUpforChatInfo.class,
      responseType = grpc.Joanna.SupportService.QueueStatusInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Joanna.SupportService.QueueUpforChatInfo,
      grpc.Joanna.SupportService.QueueStatusInfo> getQueueUpforChatMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.SupportService.QueueUpforChatInfo, grpc.Joanna.SupportService.QueueStatusInfo> getQueueUpforChatMethod;
    if ((getQueueUpforChatMethod = SupportServiceGrpc.getQueueUpforChatMethod) == null) {
      synchronized (SupportServiceGrpc.class) {
        if ((getQueueUpforChatMethod = SupportServiceGrpc.getQueueUpforChatMethod) == null) {
          SupportServiceGrpc.getQueueUpforChatMethod = getQueueUpforChatMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.SupportService.QueueUpforChatInfo, grpc.Joanna.SupportService.QueueStatusInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SupportService", "QueueUpforChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.SupportService.QueueUpforChatInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.SupportService.QueueStatusInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new SupportServiceMethodDescriptorSupplier("QueueUpforChat"))
                  .build();
          }
        }
     }
     return getQueueUpforChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.SupportService.ChatMessage,
      grpc.Joanna.SupportService.ChatMessage> getInteractiveChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InteractiveChat",
      requestType = grpc.Joanna.SupportService.ChatMessage.class,
      responseType = grpc.Joanna.SupportService.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Joanna.SupportService.ChatMessage,
      grpc.Joanna.SupportService.ChatMessage> getInteractiveChatMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.SupportService.ChatMessage, grpc.Joanna.SupportService.ChatMessage> getInteractiveChatMethod;
    if ((getInteractiveChatMethod = SupportServiceGrpc.getInteractiveChatMethod) == null) {
      synchronized (SupportServiceGrpc.class) {
        if ((getInteractiveChatMethod = SupportServiceGrpc.getInteractiveChatMethod) == null) {
          SupportServiceGrpc.getInteractiveChatMethod = getInteractiveChatMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.SupportService.ChatMessage, grpc.Joanna.SupportService.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SupportService", "InteractiveChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.SupportService.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.SupportService.ChatMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new SupportServiceMethodDescriptorSupplier("InteractiveChat"))
                  .build();
          }
        }
     }
     return getInteractiveChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SupportServiceStub newStub(io.grpc.Channel channel) {
    return new SupportServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SupportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SupportServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SupportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SupportServiceFutureStub(channel);
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static abstract class SupportServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestPhoneCall(grpc.Joanna.SupportService.RequestChatInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.RequestResult> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestPhoneCallMethod(), responseObserver);
    }

    /**
     */
    public void queueUpforChat(grpc.Joanna.SupportService.QueueUpforChatInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.QueueStatusInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getQueueUpforChatMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.ChatMessage> interactiveChat(
        io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.ChatMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getInteractiveChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestPhoneCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Joanna.SupportService.RequestChatInfo,
                grpc.Joanna.SupportService.RequestResult>(
                  this, METHODID_REQUEST_PHONE_CALL)))
          .addMethod(
            getQueueUpforChatMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.Joanna.SupportService.QueueUpforChatInfo,
                grpc.Joanna.SupportService.QueueStatusInfo>(
                  this, METHODID_QUEUE_UPFOR_CHAT)))
          .addMethod(
            getInteractiveChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.Joanna.SupportService.ChatMessage,
                grpc.Joanna.SupportService.ChatMessage>(
                  this, METHODID_INTERACTIVE_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static final class SupportServiceStub extends io.grpc.stub.AbstractStub<SupportServiceStub> {
    private SupportServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SupportServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SupportServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestPhoneCall(grpc.Joanna.SupportService.RequestChatInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.RequestResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestPhoneCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queueUpforChat(grpc.Joanna.SupportService.QueueUpforChatInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.QueueStatusInfo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getQueueUpforChatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.ChatMessage> interactiveChat(
        io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.ChatMessage> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getInteractiveChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static final class SupportServiceBlockingStub extends io.grpc.stub.AbstractStub<SupportServiceBlockingStub> {
    private SupportServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SupportServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SupportServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Joanna.SupportService.RequestResult requestPhoneCall(grpc.Joanna.SupportService.RequestChatInfo request) {
      return blockingUnaryCall(
          getChannel(), getRequestPhoneCallMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.Joanna.SupportService.QueueStatusInfo> queueUpforChat(
        grpc.Joanna.SupportService.QueueUpforChatInfo request) {
      return blockingServerStreamingCall(
          getChannel(), getQueueUpforChatMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static final class SupportServiceFutureStub extends io.grpc.stub.AbstractStub<SupportServiceFutureStub> {
    private SupportServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SupportServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SupportServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Joanna.SupportService.RequestResult> requestPhoneCall(
        grpc.Joanna.SupportService.RequestChatInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestPhoneCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_PHONE_CALL = 0;
  private static final int METHODID_QUEUE_UPFOR_CHAT = 1;
  private static final int METHODID_INTERACTIVE_CHAT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SupportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SupportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_PHONE_CALL:
          serviceImpl.requestPhoneCall((grpc.Joanna.SupportService.RequestChatInfo) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.RequestResult>) responseObserver);
          break;
        case METHODID_QUEUE_UPFOR_CHAT:
          serviceImpl.queueUpforChat((grpc.Joanna.SupportService.QueueUpforChatInfo) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.QueueStatusInfo>) responseObserver);
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
        case METHODID_INTERACTIVE_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.interactiveChat(
              (io.grpc.stub.StreamObserver<grpc.Joanna.SupportService.ChatMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SupportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SupportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Joanna.SupportService.SupportServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SupportService");
    }
  }

  private static final class SupportServiceFileDescriptorSupplier
      extends SupportServiceBaseDescriptorSupplier {
    SupportServiceFileDescriptorSupplier() {}
  }

  private static final class SupportServiceMethodDescriptorSupplier
      extends SupportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SupportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SupportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SupportServiceFileDescriptorSupplier())
              .addMethod(getRequestPhoneCallMethod())
              .addMethod(getQueueUpforChatMethod())
              .addMethod(getInteractiveChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
