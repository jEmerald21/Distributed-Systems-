# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: Shared.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x0cShared.proto\x12\x0bSmarthealth\"8\n\rRequestResult\x12\x0f\n\x07success\x18\x01 \x01(\x08\x12\x16\n\x0enonSuccessHint\x18\x02 \x01(\tB\x1a\n\x16joanna.CA1.SmarthealthP\x01\x62\x06proto3')



_REQUESTRESULT = DESCRIPTOR.message_types_by_name['RequestResult']
RequestResult = _reflection.GeneratedProtocolMessageType('RequestResult', (_message.Message,), {
  'DESCRIPTOR' : _REQUESTRESULT,
  '__module__' : 'Shared_pb2'
  # @@protoc_insertion_point(class_scope:Smarthealth.RequestResult)
  })
_sym_db.RegisterMessage(RequestResult)

if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\026joanna.CA1.SmarthealthP\001'
  _REQUESTRESULT._serialized_start=29
  _REQUESTRESULT._serialized_end=85
# @@protoc_insertion_point(module_scope)