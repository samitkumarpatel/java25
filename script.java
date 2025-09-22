import java.sql.Date;
import module java.net.http;
import com.fasterxml.jackson.databind.*;

void main() {
    IO.println("Hello World!");

    var fruits = List.of("apple", "orange", "banana", "kiwi");
    fruits.stream().map(String::toUpperCase).forEach(IO::println);

    var currentDate = Date.valueOf(LocalDate.now());
    IO.println("Current Date :: %s".formatted(currentDate));

    fetchData();
}

void fetchData() {
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
                    //use user object what ever you want for 
                    return user;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            })
            .thenAccept(System.out::println)
            .join();
}
