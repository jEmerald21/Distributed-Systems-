package grpc.Joanna.PermissionService;

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
 * The permission service definition. Defining it's remote methods
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PermissionService.proto")
public final class PermissionServiceGrpc {

  private PermissionServiceGrpc() {}

  public static final String SERVICE_NAME = "PermissionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.AccessInfo,
      grpc.Joanna.PermissionService.RequestResult> getGiveDataAccessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GiveDataAccess",
      requestType = grpc.Joanna.PermissionService.AccessInfo.class,
      responseType = grpc.Joanna.PermissionService.RequestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.AccessInfo,
      grpc.Joanna.PermissionService.RequestResult> getGiveDataAccessMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.AccessInfo, grpc.Joanna.PermissionService.RequestResult> getGiveDataAccessMethod;
    if ((getGiveDataAccessMethod = PermissionServiceGrpc.getGiveDataAccessMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getGiveDataAccessMethod = PermissionServiceGrpc.getGiveDataAccessMethod) == null) {
          PermissionServiceGrpc.getGiveDataAccessMethod = getGiveDataAccessMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.PermissionService.AccessInfo, grpc.Joanna.PermissionService.RequestResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PermissionService", "GiveDataAccess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PermissionService.AccessInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PermissionService.RequestResult.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("GiveDataAccess"))
                  .build();
          }
        }
     }
     return getGiveDataAccessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.AccessInfo,
      grpc.Joanna.PermissionService.RequestResult> getRemoveDataAcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveDataAcess",
      requestType = grpc.Joanna.PermissionService.AccessInfo.class,
      responseType = grpc.Joanna.PermissionService.RequestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.AccessInfo,
      grpc.Joanna.PermissionService.RequestResult> getRemoveDataAcessMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.AccessInfo, grpc.Joanna.PermissionService.RequestResult> getRemoveDataAcessMethod;
    if ((getRemoveDataAcessMethod = PermissionServiceGrpc.getRemoveDataAcessMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getRemoveDataAcessMethod = PermissionServiceGrpc.getRemoveDataAcessMethod) == null) {
          PermissionServiceGrpc.getRemoveDataAcessMethod = getRemoveDataAcessMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.PermissionService.AccessInfo, grpc.Joanna.PermissionService.RequestResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PermissionService", "RemoveDataAcess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PermissionService.AccessInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PermissionService.RequestResult.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("RemoveDataAcess"))
                  .build();
          }
        }
     }
     return getRemoveDataAcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.RequestLogHistoryInfo,
      grpc.Joanna.PermissionService.AccessLogEntry> getGetAccessHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessHistory",
      requestType = grpc.Joanna.PermissionService.RequestLogHistoryInfo.class,
      responseType = grpc.Joanna.PermissionService.AccessLogEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.RequestLogHistoryInfo,
      grpc.Joanna.PermissionService.AccessLogEntry> getGetAccessHistoryMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.PermissionService.RequestLogHistoryInfo, grpc.Joanna.PermissionService.AccessLogEntry> getGetAccessHistoryMethod;
    if ((getGetAccessHistoryMethod = PermissionServiceGrpc.getGetAccessHistoryMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getGetAccessHistoryMethod = PermissionServiceGrpc.getGetAccessHistoryMethod) == null) {
          PermissionServiceGrpc.getGetAccessHistoryMethod = getGetAccessHistoryMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.PermissionService.RequestLogHistoryInfo, grpc.Joanna.PermissionService.AccessLogEntry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PermissionService", "GetAccessHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PermissionService.RequestLogHistoryInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PermissionService.AccessLogEntry.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("GetAccessHistory"))
                  .build();
          }
        }
     }
     return getGetAccessHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PermissionServiceStub newStub(io.grpc.Channel channel) {
    return new PermissionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PermissionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PermissionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PermissionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PermissionServiceFutureStub(channel);
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The permission service definition. Defining it's remote methods
   * </pre>
   */
  public static abstract class PermissionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveDataAccess(grpc.Joanna.PermissionService.AccessInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.RequestResult> responseObserver) {
      asyncUnimplementedUnaryCall(getGiveDataAccessMethod(), responseObserver);
    }

    /**
     */
    public void removeDataAcess(grpc.Joanna.PermissionService.AccessInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.RequestResult> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveDataAcessMethod(), responseObserver);
    }

    /**
     */
    public void getAccessHistory(grpc.Joanna.PermissionService.RequestLogHistoryInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.AccessLogEntry> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccessHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveDataAccessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Joanna.PermissionService.AccessInfo,
                grpc.Joanna.PermissionService.RequestResult>(
                  this, METHODID_GIVE_DATA_ACCESS)))
          .addMethod(
            getRemoveDataAcessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Joanna.PermissionService.AccessInfo,
                grpc.Joanna.PermissionService.RequestResult>(
                  this, METHODID_REMOVE_DATA_ACESS)))
          .addMethod(
            getGetAccessHistoryMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.Joanna.PermissionService.RequestLogHistoryInfo,
                grpc.Joanna.PermissionService.AccessLogEntry>(
                  this, METHODID_GET_ACCESS_HISTORY)))
          .build();
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The permission service definition. Defining it's remote methods
   * </pre>
   */
  public static final class PermissionServiceStub extends io.grpc.stub.AbstractStub<PermissionServiceStub> {
    private PermissionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PermissionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PermissionServiceStub(channel, callOptions);
    }

    /**
     */
    public void giveDataAccess(grpc.Joanna.PermissionService.AccessInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.RequestResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGiveDataAccessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeDataAcess(grpc.Joanna.PermissionService.AccessInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.RequestResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveDataAcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccessHistory(grpc.Joanna.PermissionService.RequestLogHistoryInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.AccessLogEntry> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAccessHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The permission service definition. Defining it's remote methods
   * </pre>
   */
  public static final class PermissionServiceBlockingStub extends io.grpc.stub.AbstractStub<PermissionServiceBlockingStub> {
    private PermissionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PermissionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PermissionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Joanna.PermissionService.RequestResult giveDataAccess(grpc.Joanna.PermissionService.AccessInfo request) {
      return blockingUnaryCall(
          getChannel(), getGiveDataAccessMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Joanna.PermissionService.RequestResult removeDataAcess(grpc.Joanna.PermissionService.AccessInfo request) {
      return blockingUnaryCall(
          getChannel(), getRemoveDataAcessMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.Joanna.PermissionService.AccessLogEntry> getAccessHistory(
        grpc.Joanna.PermissionService.RequestLogHistoryInfo request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAccessHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The permission service definition. Defining it's remote methods
   * </pre>
   */
  public static final class PermissionServiceFutureStub extends io.grpc.stub.AbstractStub<PermissionServiceFutureStub> {
    private PermissionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PermissionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PermissionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Joanna.PermissionService.RequestResult> giveDataAccess(
        grpc.Joanna.PermissionService.AccessInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getGiveDataAccessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Joanna.PermissionService.RequestResult> removeDataAcess(
        grpc.Joanna.PermissionService.AccessInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveDataAcessMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_DATA_ACCESS = 0;
  private static final int METHODID_REMOVE_DATA_ACESS = 1;
  private static final int METHODID_GET_ACCESS_HISTORY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PermissionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PermissionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_DATA_ACCESS:
          serviceImpl.giveDataAccess((grpc.Joanna.PermissionService.AccessInfo) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.RequestResult>) responseObserver);
          break;
        case METHODID_REMOVE_DATA_ACESS:
          serviceImpl.removeDataAcess((grpc.Joanna.PermissionService.AccessInfo) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.RequestResult>) responseObserver);
          break;
        case METHODID_GET_ACCESS_HISTORY:
          serviceImpl.getAccessHistory((grpc.Joanna.PermissionService.RequestLogHistoryInfo) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.PermissionService.AccessLogEntry>) responseObserver);
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

  private static abstract class PermissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PermissionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Joanna.PermissionService.PermissionsServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PermissionService");
    }
  }

  private static final class PermissionServiceFileDescriptorSupplier
      extends PermissionServiceBaseDescriptorSupplier {
    PermissionServiceFileDescriptorSupplier() {}
  }

  private static final class PermissionServiceMethodDescriptorSupplier
      extends PermissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PermissionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PermissionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PermissionServiceFileDescriptorSupplier())
              .addMethod(getGiveDataAccessMethod())
              .addMethod(getRemoveDataAcessMethod())
              .addMethod(getGetAccessHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
