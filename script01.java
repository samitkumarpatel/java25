import module java.net.http;
import com.fasterxml.jackson.databind.*;

void main() {
    IO.println("Scripting with JAVA!");

    var request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
            .build();

    IO.println("JOSN Placeholder async response::");

    try {
        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        
        var json = response.body();
        IO.println(json);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        var user = mapper.readValue(json, User.class);
        //Do what ever you want with the user object
        IO.println(user);
    } catch (Exception _) {IO.println("Error Occured ");}
    
}

record User(int id, String name, String email) {}