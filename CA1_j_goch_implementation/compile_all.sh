#!/bin/bash

# delete all generated files first
rm -r ./generated_gRPC_code/java/
rm -r ./generated_gRPC_code/python/

# recreate the folders we need for the protoc output
mkdir ./generated_gRPC_code/java/
mkdir ./generated_gRPC_code/python/

# generate gRPC files for Java and Python
protoc ./proto_files/*.proto --proto_path=./proto_files/ \
		--java_out=./generated_gRPC_code/java/ --python_out=./generated_gRPC_code/python/