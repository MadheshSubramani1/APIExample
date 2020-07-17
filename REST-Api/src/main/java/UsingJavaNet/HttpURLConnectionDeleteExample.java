package UsingJavaNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDeleteExample {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://dummy.restapiexample.com/api/v1/delete/64");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("DELETE");
		
		/*
		 * connection.setRequestProperty("Content-Type", "application/json");
		 * connection.setDoOutput(true);
		 * 
		 * String
		 * jsonBody="{\"name\":\"Subramani\",\"salary\":\"120000\",\"age\":\"15\"}";
		 * 
		 * byte[] inputjson=jsonBody.getBytes();
		 * 
		 * OutputStream outputStream=connection.getOutputStream();
		 * outputStream.write(inputjson);
		 */
		
		int responseCode=connection.getResponseCode();
		System.out.println("Response Code ="+responseCode);
		
		String responseMessage=connection.getResponseMessage();
		System.out.println("Response Message ="+responseMessage);
		
		InputStream inputStream=connection.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		
		String str="";
		
		StringBuffer buffer=new StringBuffer();
		
		while((str=bufferedReader.readLine())!=null) {
			
			buffer.append(str);
		}
		
		System.out.println(buffer);
	}
}