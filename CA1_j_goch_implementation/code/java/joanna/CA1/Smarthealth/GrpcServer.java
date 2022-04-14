package joanna.CA1.Smarthealth;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
          .forPort(8080)
          .addService(new DataService())
          // .addService(new TechnicalSupportService())
          .build();

        server.start();
        server.awaitTermination();
    }

}