// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PatientDataService.proto

package grpc.Joanna.PatientDataService;

/**
 * <pre>
 * // parameters needed to retrieve prescription
 * </pre>
 *
 * Protobuf type {@code GetPrescriptionInfo}
 */
public  final class GetPrescriptionInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetPrescriptionInfo)
    GetPrescriptionInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetPrescriptionInfo.newBuilder() to construct.
  private GetPrescriptionInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetPrescriptionInfo() {
    patientID_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetPrescriptionInfo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            patientID_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.Joanna.PatientDataService.PatientDataServiceImpl.internal_static_GetPrescriptionInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.Joanna.PatientDataService.PatientDataServiceImpl.internal_static_GetPrescriptionInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.Joanna.PatientDataService.GetPrescriptionInfo.class, grpc.Joanna.PatientDataService.GetPrescriptionInfo.Builder.class);
  }

  public static final int PATIENTID_FIELD_NUMBER = 1;
  private volatile java.lang.Object patientID_;
  /**
   * <code>string patientID = 1;</code>
   */
  public java.lang.String getPatientID() {
    java.lang.Object ref = patientID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      patientID_ = s;
      return s;
    }
  }
  /**
   * <code>string patientID = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPatientIDBytes() {
    java.lang.Object ref = patientID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      patientID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPatientIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, patientID_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPatientIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, patientID_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.Joanna.PatientDataService.GetPrescriptionInfo)) {
      return super.equals(obj);
    }
    grpc.Joanna.PatientDataService.GetPrescriptionInfo other = (grpc.Joanna.PatientDataService.GetPrescriptionInfo) obj;

    boolean result = true;
    result = result && getPatientID()
        .equals(other.getPatientID());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PATIENTID_FIELD_NUMBER;
    hash = (53 * hash) + getPatientID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.Joanna.PatientDataService.GetPrescriptionInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * // parameters needed to retrieve prescription
   * </pre>
   *
   * Protobuf type {@code GetPrescriptionInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetPrescriptionInfo)
      grpc.Joanna.PatientDataService.GetPrescriptionInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.Joanna.PatientDataService.PatientDataServiceImpl.internal_static_GetPrescriptionInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.Joanna.PatientDataService.PatientDataServiceImpl.internal_static_GetPrescriptionInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.Joanna.PatientDataService.GetPrescriptionInfo.class, grpc.Joanna.PatientDataService.GetPrescriptionInfo.Builder.class);
    }

    // Construct using grpc.Joanna.PatientDataService.GetPrescriptionInfo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      patientID_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.Joanna.PatientDataService.PatientDataServiceImpl.internal_static_GetPrescriptionInfo_descriptor;
    }

    @java.lang.Override
    public grpc.Joanna.PatientDataService.GetPrescriptionInfo getDefaultInstanceForType() {
      return grpc.Joanna.PatientDataService.GetPrescriptionInfo.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.Joanna.PatientDataService.GetPrescriptionInfo build() {
      grpc.Joanna.PatientDataService.GetPrescriptionInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.Joanna.PatientDataService.GetPrescriptionInfo buildPartial() {
      grpc.Joanna.PatientDataService.GetPrescriptionInfo result = new grpc.Joanna.PatientDataService.GetPrescriptionInfo(this);
      result.patientID_ = patientID_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.Joanna.PatientDataService.GetPrescriptionInfo) {
        return mergeFrom((grpc.Joanna.PatientDataService.GetPrescriptionInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.Joanna.PatientDataService.GetPrescriptionInfo other) {
      if (other == grpc.Joanna.PatientDataService.GetPrescriptionInfo.getDefaultInstance()) return this;
      if (!other.getPatientID().isEmpty()) {
        patientID_ = other.patientID_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.Joanna.PatientDataService.GetPrescriptionInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.Joanna.PatientDataService.GetPrescriptionInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object patientID_ = "";
    /**
     * <code>string patientID = 1;</code>
     */
    public java.lang.String getPatientID() {
      java.lang.Object ref = patientID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        patientID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string patientID = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPatientIDBytes() {
      java.lang.Object ref = patientID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        patientID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string patientID = 1;</code>
     */
    public Builder setPatientID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      patientID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string patientID = 1;</code>
     */
    public Builder clearPatientID() {
      
      patientID_ = getDefaultInstance().getPatientID();
      onChanged();
      return this;
    }
    /**
     * <code>string patientID = 1;</code>
     */
    public Builder setPatientIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      patientID_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:GetPrescriptionInfo)
  }

  // @@protoc_insertion_point(class_scope:GetPrescriptionInfo)
  private static final grpc.Joanna.PatientDataService.GetPrescriptionInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.Joanna.PatientDataService.GetPrescriptionInfo();
  }

  public static grpc.Joanna.PatientDataService.GetPrescriptionInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetPrescriptionInfo>
      PARSER = new com.google.protobuf.AbstractParser<GetPrescriptionInfo>() {
    @java.lang.Override
    public GetPrescriptionInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetPrescriptionInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetPrescriptionInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetPrescriptionInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.Joanna.PatientDataService.GetPrescriptionInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

