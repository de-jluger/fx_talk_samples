package de.jluger.jugn_vortrag.sample008;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map.Entry;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Sample008 extends Application {
	private static HttpServer server;

	public Sample008() {
	}


	@Override
    public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen.fxml"));
		loader.setController(new Sample008Controller());
		Parent root = loader.load();
		Scene scene = new Scene(root, 700, 475);
		stage.setTitle("Browser");
        stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) throws IOException {
		server = HttpServer.create(new InetSocketAddress(8001), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
		launch(args);
	}
	
	@Override
	public void stop() throws Exception {
		server.stop(0);
		super.stop();
	}
	
	static class MyHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exch) throws IOException {
			System.out.println("Got request");
			Headers requestHeaders = exch.getRequestHeaders();
			StringBuilder responseBuilder = new StringBuilder();
			responseBuilder.append("<!doctype html><html><head></head><body>Request Headers:<br>");
			for(Entry<String, List<String>> headerEntry:requestHeaders.entrySet()) {
				responseBuilder.append(headerEntry.getKey());
				responseBuilder.append(" : ");
				responseBuilder.append(headerEntry.getValue().toString());
				responseBuilder.append("<br>");
			}
			responseBuilder.append("</body></html>");
			//responseBuilder.delete(0, responseBuilder.length());
			//responseBuilder.append("");
			byte[] response = responseBuilder.toString().getBytes();
			System.out.println(responseBuilder.toString());
			exch.sendResponseHeaders(200, 0);//response.length
			OutputStream responseBody = exch.getResponseBody();
			responseBody.write(response);
			responseBody.flush();
			responseBody.close();
			System.out.println("Wrote response");
		}
		
	}
}
