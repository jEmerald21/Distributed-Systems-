package grpc.Joanna.SupportService;

import grpc.Joanna.SupportService.SupportServiceGrpc.SupportServiceImplBase;
import io.grpc.stub.StreamObserver;

// gRPC service implementation for Support service 
public class SupportService extends SupportServiceImplBase {

	// unary gRPC for client to submit a phone support request
	@Override
	public void requestPhoneCall(RequestChatInfo request, StreamObserver<RequestResult> responseObserver) {
		// Console info
		System.out.println("[Server][SupportService] - Received request for support via phone call request from " + request.getUserID()+ " for " + request.getDescription() );
		// generate reply
		RequestResult reply = RequestResult.newBuilder().setSuccess(true).build();
		// send reply
		responseObserver.onNext(reply);
		// terminate reaction
		responseObserver.onCompleted();
	}

	// GRPC method with server side stream. Client enters queue for getting online support via chat. This service handles customers waiting in queue
	@Override
	public void queueUpforChat(QueueUpforChatInfo request, StreamObserver<QueueStatusInfo> responseObserver) {
		//retrieve input
		String userID = request.getUserID();
		// feedback to the console
		System.out.println("[Server][SupportService] - Received user request to queue up for online support chat: " + userID);
		
		// simulate an initial waiting queue rank
		int queueSlot = SupportService.getRandomNumber(2, 8);
		// simulate emptying the queue ahead of the users
		while(queueSlot > 0) {
			
			// give a status update to the client / user
			// generate streaming message
			QueueStatusInfo reply = QueueStatusInfo.newBuilder()
					.setRankInQueue(queueSlot)
					.setUserID(userID)
					.build();
			// send streaming message
			responseObserver.onNext(reply);
			
			// also print update info into console window
			System.out.println("[Server][SupportService] => " + userID + " in waiting queue at slot: " + queueSlot);
			
			// simulate some waiting time until a new support agent can take a new support case 
			int waitTimeInMS = SupportService.getRandomNumber(1000, 5000);
			try {
				Thread.sleep(waitTimeInMS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// decrease the position in the waiting queue
			queueSlot = queueSlot - 1;
		}

		// finished sending updates all. End response stream
		responseObserver.onCompleted();
		System.out.println("[Server][SupportService] => " + userID + " is now exiting waiting queue and entering support chat.");
	}
	
	// integer range random helper function taken from here: https://www.baeldung.com/java-generating-random-numbers-in-range
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	// GRPC method implementation simulated interactive chat with support agent
	@Override
	public StreamObserver<ChatMessage> interactiveChat(StreamObserver<ChatMessage> responseObserver) {
		// client stream handler
		return new StreamObserver<ChatMessage>()  {
			
			// simulating agent replies based on chat messages sent by client / user
			@Override
			public void onNext(ChatMessage clientMessage) {
				String userID = clientMessage.getUserID();
				String message = clientMessage.getMessage();
				System.out.println("[Server][SupportService] - Received new chat message from " + userID + " saying: " + message);
				
				if(message.toLowerCase().contains("hello") || message.toLowerCase().contains("hi")) {
					// pretending that the agent replies to the simple greetings from the client / user
					String replyMessage = "Hello! Thanks for contacting support. Please describe your issue";
					ChatMessage reply = ChatMessage.newBuilder()
							.setMessage(replyMessage)
							.build();
					responseObserver.onNext(reply);
				} 
				else if(message.toLowerCase().contains("thanks")) {
					// another simulated agent reply
					String replyMessage = "You're welcome. Anything else?";
					ChatMessage reply = ChatMessage.newBuilder()
							.setMessage(replyMessage)
							.build();
					responseObserver.onNext(reply);
				}
				else {
					// pretending that the client described the issue and having the simulated agent react to it
					String replyMessage = "Let me look into that. One moment please ...";
					ChatMessage reply = ChatMessage.newBuilder()
							.setMessage(replyMessage)
							.build();
					responseObserver.onNext(reply);
					
					// simulate some waiting time of the agent handling the issue 
					int waitTimeInMS = SupportService.getRandomNumber(1000, 5000);
					try {
						Thread.sleep(waitTimeInMS);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// Send simulated update chat message from the agent 
					String replyMessage2 = "I found the issue and fixed it. You should be good now. Anything else I can help with?";
					ChatMessage reply2 = ChatMessage.newBuilder()
							.setMessage(replyMessage2)
							.build();
					responseObserver.onNext(reply2);
				}
			}

			@Override
			public void onError(Throwable t) {
				// log error
				System.out.println("[Server][SupportService] ==> Error while receiving chat message: " + t.getMessage() );
			}

			@Override
			public void onCompleted() {
				// send completion reply
				ChatMessage reply = ChatMessage.newBuilder()
												.setMessage("Thanks and have a good day! Bye now.")
												.build();
				responseObserver.onNext(reply);
				// complete
				responseObserver.onCompleted();
				// inform in console
				System.out.println("[Server][SupportService] ==> completed chat a user");
				
			}
		};
	}
}



