package grpc.Joanna.StringEchoService;

import grpc.Joanna.StringEchoService.StringEchoServiceGrpc.StringEchoServiceImplBase;
import io.grpc.stub.StreamObserver;

// this is a simple string echo service to help making sure all the basics work 
public class StringEchoService extends StringEchoServiceImplBase {
	
	@Override
	public void echoString(StringMessage request, StreamObserver<StringMessage> responseObserver) {

		// retrieve input
		String input = request.getData();
		// Console info
		System.out.println("[Server][StringEchoService] - Received string: " + input);
		// generate output
		String output = "Echo for: " + input;
		// create reply
		StringMessage reply = StringMessage.newBuilder().setData(output).build();
		// send reply
		responseObserver.onNext(reply);
		// terminate reaction
		responseObserver.onCompleted();
	}
}