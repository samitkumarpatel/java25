import module java.base;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

enum FileType { FILE, DIRECTORY; }

@JsonInclude(JsonInclude.Include.NON_NULL)
record Explorer(String name, FileType type, List<Explorer> children) {
    // Convenience constructor for files (no children)
    Explorer(String name, FileType type) {
        this(name, type, null);
    }
}

Explorer buildTree(Path path) {
    var name = path.getFileName() != null ? path.getFileName().toString() : path.toString();
    if (Files.isDirectory(path)) {
        var children = new ArrayList<Explorer>();
        try (var entries = Files.list(path)) {
            entries.sorted().forEach(child -> children.add(buildTree(child)));
        } catch (IOException e) {
            IO.println("Warn: " + e.getMessage());
        }
        return new Explorer(name, FileType.DIRECTORY, children);
    }
    return new Explorer(name, FileType.FILE);
}

void main() {
    var path = Path.of("/location/of/the/folder/PD2");
    //find if the path exists , If exists it a file or directory.
    var mapper = new ObjectMapper()
            .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    try {
        var tree = buildTree(path);
        IO.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree));
    } catch (Exception e) {
        IO.println("Error: " + e.getMessage());
    }
}
