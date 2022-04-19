// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PatientDataService.proto

package joanna.CA1.Smarthealth;

/**
 * <pre>
 * single prescriptions for a patient
 * </pre>
 *
 * Protobuf type {@code Smarthealth.Prescription}
 */
public final class Prescription extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Smarthealth.Prescription)
    PrescriptionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Prescription.newBuilder() to construct.
  private Prescription(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Prescription() {
    doctorID_ = "";
    patientID_ = "";
    prescriptionText_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Prescription();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Prescription(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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

            doctorID_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            patientID_ = s;
            break;
          }
          case 26: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (date_ != null) {
              subBuilder = date_.toBuilder();
            }
            date_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(date_);
              date_ = subBuilder.buildPartial();
            }

            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            prescriptionText_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
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
    return joanna.CA1.Smarthealth.PatientDataServiceImplBase.internal_static_Smarthealth_Prescription_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return joanna.CA1.Smarthealth.PatientDataServiceImplBase.internal_static_Smarthealth_Prescription_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            joanna.CA1.Smarthealth.Prescription.class, joanna.CA1.Smarthealth.Prescription.Builder.class);
  }

  public static final int DOCTORID_FIELD_NUMBER = 1;
  private volatile java.lang.Object doctorID_;
  /**
   * <code>string doctorID = 1;</code>
   * @return The doctorID.
   */
  @java.lang.Override
  public java.lang.String getDoctorID() {
    java.lang.Object ref = doctorID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      doctorID_ = s;
      return s;
    }
  }
  /**
   * <code>string doctorID = 1;</code>
   * @return The bytes for doctorID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDoctorIDBytes() {
    java.lang.Object ref = doctorID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      doctorID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PATIENTID_FIELD_NUMBER = 2;
  private volatile java.lang.Object patientID_;
  /**
   * <code>string patientID = 2;</code>
   * @return The patientID.
   */
  @java.lang.Override
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
   * <code>string patientID = 2;</code>
   * @return The bytes for patientID.
   */
  @java.lang.Override
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

  public static final int DATE_FIELD_NUMBER = 3;
  private com.google.protobuf.Timestamp date_;
  /**
   * <code>.google.protobuf.Timestamp date = 3;</code>
   * @return Whether the date field is set.
   */
  @java.lang.Override
  public boolean hasDate() {
    return date_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp date = 3;</code>
   * @return The date.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getDate() {
    return date_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : date_;
  }
  /**
   * <code>.google.protobuf.Timestamp date = 3;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getDateOrBuilder() {
    return getDate();
  }

  public static final int PRESCRIPTIONTEXT_FIELD_NUMBER = 4;
  private volatile java.lang.Object prescriptionText_;
  /**
   * <code>string prescriptionText = 4;</code>
   * @return The prescriptionText.
   */
  @java.lang.Override
  public java.lang.String getPrescriptionText() {
    java.lang.Object ref = prescriptionText_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      prescriptionText_ = s;
      return s;
    }
  }
  /**
   * <code>string prescriptionText = 4;</code>
   * @return The bytes for prescriptionText.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPrescriptionTextBytes() {
    java.lang.Object ref = prescriptionText_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      prescriptionText_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(doctorID_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, doctorID_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(patientID_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, patientID_);
    }
    if (date_ != null) {
      output.writeMessage(3, getDate());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(prescriptionText_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, prescriptionText_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(doctorID_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, doctorID_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(patientID_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, patientID_);
    }
    if (date_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getDate());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(prescriptionText_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, prescriptionText_);
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
    if (!(obj instanceof joanna.CA1.Smarthealth.Prescription)) {
      return super.equals(obj);
    }
    joanna.CA1.Smarthealth.Prescription other = (joanna.CA1.Smarthealth.Prescription) obj;

    if (!getDoctorID()
        .equals(other.getDoctorID())) return false;
    if (!getPatientID()
        .equals(other.getPatientID())) return false;
    if (hasDate() != other.hasDate()) return false;
    if (hasDate()) {
      if (!getDate()
          .equals(other.getDate())) return false;
    }
    if (!getPrescriptionText()
        .equals(other.getPrescriptionText())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DOCTORID_FIELD_NUMBER;
    hash = (53 * hash) + getDoctorID().hashCode();
    hash = (37 * hash) + PATIENTID_FIELD_NUMBER;
    hash = (53 * hash) + getPatientID().hashCode();
    if (hasDate()) {
      hash = (37 * hash) + DATE_FIELD_NUMBER;
      hash = (53 * hash) + getDate().hashCode();
    }
    hash = (37 * hash) + PRESCRIPTIONTEXT_FIELD_NUMBER;
    hash = (53 * hash) + getPrescriptionText().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static joanna.CA1.Smarthealth.Prescription parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static joanna.CA1.Smarthealth.Prescription parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static joanna.CA1.Smarthealth.Prescription parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static joanna.CA1.Smarthealth.Prescription parseFrom(
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
  public static Builder newBuilder(joanna.CA1.Smarthealth.Prescription prototype) {
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
   * single prescriptions for a patient
   * </pre>
   *
   * Protobuf type {@code Smarthealth.Prescription}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Smarthealth.Prescription)
      joanna.CA1.Smarthealth.PrescriptionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return joanna.CA1.Smarthealth.PatientDataServiceImplBase.internal_static_Smarthealth_Prescription_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return joanna.CA1.Smarthealth.PatientDataServiceImplBase.internal_static_Smarthealth_Prescription_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              joanna.CA1.Smarthealth.Prescription.class, joanna.CA1.Smarthealth.Prescription.Builder.class);
    }

    // Construct using joanna.CA1.Smarthealth.Prescription.newBuilder()
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
      doctorID_ = "";

      patientID_ = "";

      if (dateBuilder_ == null) {
        date_ = null;
      } else {
        date_ = null;
        dateBuilder_ = null;
      }
      prescriptionText_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return joanna.CA1.Smarthealth.PatientDataServiceImplBase.internal_static_Smarthealth_Prescription_descriptor;
    }

    @java.lang.Override
    public joanna.CA1.Smarthealth.Prescription getDefaultInstanceForType() {
      return joanna.CA1.Smarthealth.Prescription.getDefaultInstance();
    }

    @java.lang.Override
    public joanna.CA1.Smarthealth.Prescription build() {
      joanna.CA1.Smarthealth.Prescription result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public joanna.CA1.Smarthealth.Prescription buildPartial() {
      joanna.CA1.Smarthealth.Prescription result = new joanna.CA1.Smarthealth.Prescription(this);
      result.doctorID_ = doctorID_;
      result.patientID_ = patientID_;
      if (dateBuilder_ == null) {
        result.date_ = date_;
      } else {
        result.date_ = dateBuilder_.build();
      }
      result.prescriptionText_ = prescriptionText_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof joanna.CA1.Smarthealth.Prescription) {
        return mergeFrom((joanna.CA1.Smarthealth.Prescription)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(joanna.CA1.Smarthealth.Prescription other) {
      if (other == joanna.CA1.Smarthealth.Prescription.getDefaultInstance()) return this;
      if (!other.getDoctorID().isEmpty()) {
        doctorID_ = other.doctorID_;
        onChanged();
      }
      if (!other.getPatientID().isEmpty()) {
        patientID_ = other.patientID_;
        onChanged();
      }
      if (other.hasDate()) {
        mergeDate(other.getDate());
      }
      if (!other.getPrescriptionText().isEmpty()) {
        prescriptionText_ = other.prescriptionText_;
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
      joanna.CA1.Smarthealth.Prescription parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (joanna.CA1.Smarthealth.Prescription) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object doctorID_ = "";
    /**
     * <code>string doctorID = 1;</code>
     * @return The doctorID.
     */
    public java.lang.String getDoctorID() {
      java.lang.Object ref = doctorID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        doctorID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string doctorID = 1;</code>
     * @return The bytes for doctorID.
     */
    public com.google.protobuf.ByteString
        getDoctorIDBytes() {
      java.lang.Object ref = doctorID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        doctorID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string doctorID = 1;</code>
     * @param value The doctorID to set.
     * @return This builder for chaining.
     */
    public Builder setDoctorID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      doctorID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string doctorID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDoctorID() {
      
      doctorID_ = getDefaultInstance().getDoctorID();
      onChanged();
      return this;
    }
    /**
     * <code>string doctorID = 1;</code>
     * @param value The bytes for doctorID to set.
     * @return This builder for chaining.
     */
    public Builder setDoctorIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      doctorID_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object patientID_ = "";
    /**
     * <code>string patientID = 2;</code>
     * @return The patientID.
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
     * <code>string patientID = 2;</code>
     * @return The bytes for patientID.
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
     * <code>string patientID = 2;</code>
     * @param value The patientID to set.
     * @return This builder for chaining.
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
     * <code>string patientID = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPatientID() {
      
      patientID_ = getDefaultInstance().getPatientID();
      onChanged();
      return this;
    }
    /**
     * <code>string patientID = 2;</code>
     * @param value The bytes for patientID to set.
     * @return This builder for chaining.
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

    private com.google.protobuf.Timestamp date_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> dateBuilder_;
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     * @return Whether the date field is set.
     */
    public boolean hasDate() {
      return dateBuilder_ != null || date_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     * @return The date.
     */
    public com.google.protobuf.Timestamp getDate() {
      if (dateBuilder_ == null) {
        return date_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : date_;
      } else {
        return dateBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     */
    public Builder setDate(com.google.protobuf.Timestamp value) {
      if (dateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        date_ = value;
        onChanged();
      } else {
        dateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     */
    public Builder setDate(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (dateBuilder_ == null) {
        date_ = builderForValue.build();
        onChanged();
      } else {
        dateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     */
    public Builder mergeDate(com.google.protobuf.Timestamp value) {
      if (dateBuilder_ == null) {
        if (date_ != null) {
          date_ =
            com.google.protobuf.Timestamp.newBuilder(date_).mergeFrom(value).buildPartial();
        } else {
          date_ = value;
        }
        onChanged();
      } else {
        dateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     */
    public Builder clearDate() {
      if (dateBuilder_ == null) {
        date_ = null;
        onChanged();
      } else {
        date_ = null;
        dateBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     */
    public com.google.protobuf.Timestamp.Builder getDateBuilder() {
      
      onChanged();
      return getDateFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getDateOrBuilder() {
      if (dateBuilder_ != null) {
        return dateBuilder_.getMessageOrBuilder();
      } else {
        return date_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : date_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp date = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getDateFieldBuilder() {
      if (dateBuilder_ == null) {
        dateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getDate(),
                getParentForChildren(),
                isClean());
        date_ = null;
      }
      return dateBuilder_;
    }

    private java.lang.Object prescriptionText_ = "";
    /**
     * <code>string prescriptionText = 4;</code>
     * @return The prescriptionText.
     */
    public java.lang.String getPrescriptionText() {
      java.lang.Object ref = prescriptionText_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        prescriptionText_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string prescriptionText = 4;</code>
     * @return The bytes for prescriptionText.
     */
    public com.google.protobuf.ByteString
        getPrescriptionTextBytes() {
      java.lang.Object ref = prescriptionText_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        prescriptionText_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string prescriptionText = 4;</code>
     * @param value The prescriptionText to set.
     * @return This builder for chaining.
     */
    public Builder setPrescriptionText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      prescriptionText_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string prescriptionText = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrescriptionText() {
      
      prescriptionText_ = getDefaultInstance().getPrescriptionText();
      onChanged();
      return this;
    }
    /**
     * <code>string prescriptionText = 4;</code>
     * @param value The bytes for prescriptionText to set.
     * @return This builder for chaining.
     */
    public Builder setPrescriptionTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      prescriptionText_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Smarthealth.Prescription)
  }

  // @@protoc_insertion_point(class_scope:Smarthealth.Prescription)
  private static final joanna.CA1.Smarthealth.Prescription DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new joanna.CA1.Smarthealth.Prescription();
  }

  public static joanna.CA1.Smarthealth.Prescription getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Prescription>
      PARSER = new com.google.protobuf.AbstractParser<Prescription>() {
    @java.lang.Override
    public Prescription parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Prescription(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Prescription> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Prescription> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public joanna.CA1.Smarthealth.Prescription getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

