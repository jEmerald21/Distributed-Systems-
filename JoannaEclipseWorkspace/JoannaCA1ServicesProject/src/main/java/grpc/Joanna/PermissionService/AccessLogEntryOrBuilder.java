// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PermissionService.proto

package grpc.Joanna.PermissionService;

public interface AccessLogEntryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AccessLogEntry)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Timestamp date = 1;</code>
   */
  boolean hasDate();
  /**
   * <code>.google.protobuf.Timestamp date = 1;</code>
   */
  com.google.protobuf.Timestamp getDate();
  /**
   * <code>.google.protobuf.Timestamp date = 1;</code>
   */
  com.google.protobuf.TimestampOrBuilder getDateOrBuilder();

  /**
   * <code>string accessType = 2;</code>
   */
  java.lang.String getAccessType();
  /**
   * <code>string accessType = 2;</code>
   */
  com.google.protobuf.ByteString
      getAccessTypeBytes();

  /**
   * <code>string operationType = 3;</code>
   */
  java.lang.String getOperationType();
  /**
   * <code>string operationType = 3;</code>
   */
  com.google.protobuf.ByteString
      getOperationTypeBytes();
}