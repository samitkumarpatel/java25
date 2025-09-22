import module java.net.http;
import com.fasterxml.jackson.databind.*;

void main() {
    IO.println("Script with JAVA!");

    var request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
            .build();

    IO.println("JOSN Placeholder async response::");

    HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> response.body())
            .thenApply(json -> {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    var user = mapper.readValue(json, User.class); // deserialize JSON → record
                    return user;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            })
            .thenAccept(System.out::println)
            .join();

}

record User(int id, String name, String email) {}