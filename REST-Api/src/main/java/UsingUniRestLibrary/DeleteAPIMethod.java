package UsingUniRestLibrary;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class DeleteAPIMethod {

	public static void main(String[] args) throws UnirestException {
		HttpResponse<JsonNode> jsonResponse = Unirest.delete("http://dummy.restapiexample.com/api/v1/delete/35")
				.asJson();
		System.out.println("Response Code " + jsonResponse.getStatus());
		System.out.println("Response Message " + jsonResponse.getStatusText());
		System.out.println("Respons Body " + jsonResponse.getBody());
	}

}
