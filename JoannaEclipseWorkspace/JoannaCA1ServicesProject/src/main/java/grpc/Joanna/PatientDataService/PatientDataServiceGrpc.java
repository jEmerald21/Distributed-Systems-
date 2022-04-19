package grpc.Joanna.PatientDataService;

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
    comments = "Source: PatientDataService.proto")
public final class PatientDataServiceGrpc {

  private PatientDataServiceGrpc() {}

  public static final String SERVICE_NAME = "PatientDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.Prescription,
      grpc.Joanna.PatientDataService.RequestResult> getAddPrescriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPrescription",
      requestType = grpc.Joanna.PatientDataService.Prescription.class,
      responseType = grpc.Joanna.PatientDataService.RequestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.Prescription,
      grpc.Joanna.PatientDataService.RequestResult> getAddPrescriptionMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.Prescription, grpc.Joanna.PatientDataService.RequestResult> getAddPrescriptionMethod;
    if ((getAddPrescriptionMethod = PatientDataServiceGrpc.getAddPrescriptionMethod) == null) {
      synchronized (PatientDataServiceGrpc.class) {
        if ((getAddPrescriptionMethod = PatientDataServiceGrpc.getAddPrescriptionMethod) == null) {
          PatientDataServiceGrpc.getAddPrescriptionMethod = getAddPrescriptionMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.PatientDataService.Prescription, grpc.Joanna.PatientDataService.RequestResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PatientDataService", "AddPrescription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.Prescription.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.RequestResult.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientDataServiceMethodDescriptorSupplier("AddPrescription"))
                  .build();
          }
        }
     }
     return getAddPrescriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.GetPrescriptionInfo,
      grpc.Joanna.PatientDataService.Prescription> getGetPrescriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrescriptions",
      requestType = grpc.Joanna.PatientDataService.GetPrescriptionInfo.class,
      responseType = grpc.Joanna.PatientDataService.Prescription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.GetPrescriptionInfo,
      grpc.Joanna.PatientDataService.Prescription> getGetPrescriptionsMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.GetPrescriptionInfo, grpc.Joanna.PatientDataService.Prescription> getGetPrescriptionsMethod;
    if ((getGetPrescriptionsMethod = PatientDataServiceGrpc.getGetPrescriptionsMethod) == null) {
      synchronized (PatientDataServiceGrpc.class) {
        if ((getGetPrescriptionsMethod = PatientDataServiceGrpc.getGetPrescriptionsMethod) == null) {
          PatientDataServiceGrpc.getGetPrescriptionsMethod = getGetPrescriptionsMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.PatientDataService.GetPrescriptionInfo, grpc.Joanna.PatientDataService.Prescription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PatientDataService", "GetPrescriptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.GetPrescriptionInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.Prescription.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientDataServiceMethodDescriptorSupplier("GetPrescriptions"))
                  .build();
          }
        }
     }
     return getGetPrescriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.LabResult,
      grpc.Joanna.PatientDataService.RequestResult> getAddLabResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLabResults",
      requestType = grpc.Joanna.PatientDataService.LabResult.class,
      responseType = grpc.Joanna.PatientDataService.RequestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.LabResult,
      grpc.Joanna.PatientDataService.RequestResult> getAddLabResultsMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.LabResult, grpc.Joanna.PatientDataService.RequestResult> getAddLabResultsMethod;
    if ((getAddLabResultsMethod = PatientDataServiceGrpc.getAddLabResultsMethod) == null) {
      synchronized (PatientDataServiceGrpc.class) {
        if ((getAddLabResultsMethod = PatientDataServiceGrpc.getAddLabResultsMethod) == null) {
          PatientDataServiceGrpc.getAddLabResultsMethod = getAddLabResultsMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.PatientDataService.LabResult, grpc.Joanna.PatientDataService.RequestResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PatientDataService", "AddLabResults"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.LabResult.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.RequestResult.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientDataServiceMethodDescriptorSupplier("AddLabResults"))
                  .build();
          }
        }
     }
     return getAddLabResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.DoctorNote,
      grpc.Joanna.PatientDataService.RequestResult> getAddDoctorNotesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDoctorNotes",
      requestType = grpc.Joanna.PatientDataService.DoctorNote.class,
      responseType = grpc.Joanna.PatientDataService.RequestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.DoctorNote,
      grpc.Joanna.PatientDataService.RequestResult> getAddDoctorNotesMethod() {
    io.grpc.MethodDescriptor<grpc.Joanna.PatientDataService.DoctorNote, grpc.Joanna.PatientDataService.RequestResult> getAddDoctorNotesMethod;
    if ((getAddDoctorNotesMethod = PatientDataServiceGrpc.getAddDoctorNotesMethod) == null) {
      synchronized (PatientDataServiceGrpc.class) {
        if ((getAddDoctorNotesMethod = PatientDataServiceGrpc.getAddDoctorNotesMethod) == null) {
          PatientDataServiceGrpc.getAddDoctorNotesMethod = getAddDoctorNotesMethod = 
              io.grpc.MethodDescriptor.<grpc.Joanna.PatientDataService.DoctorNote, grpc.Joanna.PatientDataService.RequestResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PatientDataService", "AddDoctorNotes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.DoctorNote.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Joanna.PatientDataService.RequestResult.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientDataServiceMethodDescriptorSupplier("AddDoctorNotes"))
                  .build();
          }
        }
     }
     return getAddDoctorNotesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientDataServiceStub newStub(io.grpc.Channel channel) {
    return new PatientDataServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientDataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientDataServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientDataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientDataServiceFutureStub(channel);
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static abstract class PatientDataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addPrescription(grpc.Joanna.PatientDataService.Prescription request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult> responseObserver) {
      asyncUnimplementedUnaryCall(getAddPrescriptionMethod(), responseObserver);
    }

    /**
     */
    public void getPrescriptions(grpc.Joanna.PatientDataService.GetPrescriptionInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.Prescription> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPrescriptionsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.LabResult> addLabResults(
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddLabResultsMethod(), responseObserver);
    }

    /**
     */
    public void addDoctorNotes(grpc.Joanna.PatientDataService.DoctorNote request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult> responseObserver) {
      asyncUnimplementedUnaryCall(getAddDoctorNotesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddPrescriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Joanna.PatientDataService.Prescription,
                grpc.Joanna.PatientDataService.RequestResult>(
                  this, METHODID_ADD_PRESCRIPTION)))
          .addMethod(
            getGetPrescriptionsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.Joanna.PatientDataService.GetPrescriptionInfo,
                grpc.Joanna.PatientDataService.Prescription>(
                  this, METHODID_GET_PRESCRIPTIONS)))
          .addMethod(
            getAddLabResultsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.Joanna.PatientDataService.LabResult,
                grpc.Joanna.PatientDataService.RequestResult>(
                  this, METHODID_ADD_LAB_RESULTS)))
          .addMethod(
            getAddDoctorNotesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Joanna.PatientDataService.DoctorNote,
                grpc.Joanna.PatientDataService.RequestResult>(
                  this, METHODID_ADD_DOCTOR_NOTES)))
          .build();
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static final class PatientDataServiceStub extends io.grpc.stub.AbstractStub<PatientDataServiceStub> {
    private PatientDataServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientDataServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientDataServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientDataServiceStub(channel, callOptions);
    }

    /**
     */
    public void addPrescription(grpc.Joanna.PatientDataService.Prescription request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddPrescriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPrescriptions(grpc.Joanna.PatientDataService.GetPrescriptionInfo request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.Prescription> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetPrescriptionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.LabResult> addLabResults(
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAddLabResultsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void addDoctorNotes(grpc.Joanna.PatientDataService.DoctorNote request,
        io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddDoctorNotesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static final class PatientDataServiceBlockingStub extends io.grpc.stub.AbstractStub<PatientDataServiceBlockingStub> {
    private PatientDataServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientDataServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientDataServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientDataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Joanna.PatientDataService.RequestResult addPrescription(grpc.Joanna.PatientDataService.Prescription request) {
      return blockingUnaryCall(
          getChannel(), getAddPrescriptionMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.Joanna.PatientDataService.Prescription> getPrescriptions(
        grpc.Joanna.PatientDataService.GetPrescriptionInfo request) {
      return blockingServerStreamingCall(
          getChannel(), getGetPrescriptionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Joanna.PatientDataService.RequestResult addDoctorNotes(grpc.Joanna.PatientDataService.DoctorNote request) {
      return blockingUnaryCall(
          getChannel(), getAddDoctorNotesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////////////////////////////////////////
   * The greeter service definition. Defining it's remote methods
   * </pre>
   */
  public static final class PatientDataServiceFutureStub extends io.grpc.stub.AbstractStub<PatientDataServiceFutureStub> {
    private PatientDataServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientDataServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientDataServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientDataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Joanna.PatientDataService.RequestResult> addPrescription(
        grpc.Joanna.PatientDataService.Prescription request) {
      return futureUnaryCall(
          getChannel().newCall(getAddPrescriptionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Joanna.PatientDataService.RequestResult> addDoctorNotes(
        grpc.Joanna.PatientDataService.DoctorNote request) {
      return futureUnaryCall(
          getChannel().newCall(getAddDoctorNotesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRESCRIPTION = 0;
  private static final int METHODID_GET_PRESCRIPTIONS = 1;
  private static final int METHODID_ADD_DOCTOR_NOTES = 2;
  private static final int METHODID_ADD_LAB_RESULTS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientDataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientDataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRESCRIPTION:
          serviceImpl.addPrescription((grpc.Joanna.PatientDataService.Prescription) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult>) responseObserver);
          break;
        case METHODID_GET_PRESCRIPTIONS:
          serviceImpl.getPrescriptions((grpc.Joanna.PatientDataService.GetPrescriptionInfo) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.Prescription>) responseObserver);
          break;
        case METHODID_ADD_DOCTOR_NOTES:
          serviceImpl.addDoctorNotes((grpc.Joanna.PatientDataService.DoctorNote) request,
              (io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult>) responseObserver);
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
        case METHODID_ADD_LAB_RESULTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addLabResults(
              (io.grpc.stub.StreamObserver<grpc.Joanna.PatientDataService.RequestResult>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PatientDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Joanna.PatientDataService.PatientDataServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientDataService");
    }
  }

  private static final class PatientDataServiceFileDescriptorSupplier
      extends PatientDataServiceBaseDescriptorSupplier {
    PatientDataServiceFileDescriptorSupplier() {}
  }

  private static final class PatientDataServiceMethodDescriptorSupplier
      extends PatientDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PatientDataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PatientDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientDataServiceFileDescriptorSupplier())
              .addMethod(getAddPrescriptionMethod())
              .addMethod(getGetPrescriptionsMethod())
              .addMethod(getAddLabResultsMethod())
              .addMethod(getAddDoctorNotesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
