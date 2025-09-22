import module java.net.http;

void main() {
    var request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
            .build();

    HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> response.body())
            .thenAccept(IO::println)
            .join();
}

