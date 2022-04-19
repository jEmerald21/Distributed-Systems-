package grpc.Joanna.PermissionService;

// Java
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

// GRPC
import io.grpc.Server;
import io.grpc.ServerBuilder;
// jmDNS
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class AppPermissionServiceServer
{
	// logging
	private static Logger _log = Logger.getLogger(AppPermissionServiceServer.class.getName());
	
	////////////////////////////////////////////////////////////////////////////
	// program main routine
	public static void main(String[] args) throws IOException
	{
		// service config
		String serviceName = "PermissionService";
		int port = 9092;
		String serviceType = "_grpc._tcp.local";
		String serviceDescription = "Service for managing permissions and access logs";
		
		// display startup message
		System.out.println("App initialisation for [" + serviceName + "] ...");

		// create app
		AppPermissionServiceServer._log.setLevel(Level.ALL);
		AppPermissionServiceServer serverApp = new AppPermissionServiceServer();
		
		// Register Service with jmDNS
		serverApp.registerWithJmDNS(serviceType, serviceName, port, serviceDescription);
		
		// Start and run the gRPC service until termination
		serverApp.startRPCServer(port);
	}
	
	////////////////////////////////////////////////////////////////////////////
	// running the gRPC server
	private void startRPCServer(int port)
	{
		System.out.println("Starting Joanna's gRPC Server on port " + port + " ...");
		
		try
		{
			Server server;
			server = ServerBuilder
							.forPort(port)
							.addService(new PermissionService())
							.build()
							.start();
			
			System.out.println("... running ...");
			server.awaitTermination();
			
		}
		catch (Exception e) 
		{
			// displaying any server exceptions that may happen  
			System.out.println("Exception occured in gRPC service server: " + e.toString());
			e.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////////////////////////
	// Register JmDNS
	private void registerWithJmDNS(String serviceType, String serviceName, int port, String serviceDescription)
	{
        try
        {
        	System.out.print("JmDNS ... ");
            // Register the service with jmDNS
        	JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, serviceDescription);
            jmdns.registerService(serviceInfo);
            System.out.println(" registered the service: " + serviceName + " at " + port + " as " + serviceType);
        } 
        catch (Exception e)
        {
        	_log.warning("Failed to register the service with jmDNS: " + e.getMessage());
        }
	}
}
