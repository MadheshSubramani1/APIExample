package UsingJavaNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionUpdateExamble {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://dummy.restapiexample.com/api/v1/update/99");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("PUT");
	

		connection.setRequestProperty("Content-Type","application/json");
		connection.setDoOutput(true);

		String jsonBody = "{\"name\":\"sanar\",\"salary\":\"12\",\"age\":\"34\"}";

		byte[] inputjson = jsonBody.getBytes();

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputjson);
		connection.connect();

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code Is " + responseCode);

		String responseMessage = connection.getResponseMessage();
		System.out.println("Response Message is " + responseMessage);

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String str = "";
		StringBuffer buffer = new StringBuffer();

		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		System.out.println(buffer);

	}

}
