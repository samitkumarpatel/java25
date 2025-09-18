import java.sql.Date;
import module java.net.http;

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

    IO.println("JOSN Placeholder response::");
    HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> response.body())
            .thenAccept(System.out::println)
            .join();
}