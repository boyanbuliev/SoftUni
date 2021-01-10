package jsonprocessinglab.jsondemolab.gson;


import com.google.gson.*;
import jsonprocessinglab.jsondemolab.entities.Post;
import jsonprocessinglab.jsondemolab.exceptions.InvalidEntityDataException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostGsonDeserializer implements JsonDeserializer<Post> {

    private static final DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public Post deserialize(JsonElement json, Type type,
                            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonId = jsonObject.get("id");
        JsonElement jsonTile = jsonObject.get("title");
        JsonElement jsonContent = jsonObject.get("content");
        JsonElement jsonImageUrl = jsonObject.get("imageUrl");
        JsonElement jsonAuthorId = jsonObject.get("authorId");
        JsonElement jsonCreated = jsonObject.get("created");

        if (jsonTile == null || jsonContent == null || jsonImageUrl == null || jsonAuthorId == null) {
            throw new InvalidEntityDataException("Title, content, and image URL are required.");
        }
        Post post = new Post(jsonTile.getAsString().toUpperCase(), jsonContent.getAsString(),
                jsonImageUrl.getAsString(), jsonAuthorId.getAsLong());
        if (jsonId != null) {
            post.setId(jsonId.getAsLong());
        }
        if (jsonCreated != null) {
            post.setCreated(LocalDateTime.parse(jsonCreated.getAsString(), format));
            post.setCreated(LocalDateTime.parse(jsonCreated.getAsString(), format));
        }
        return post;
    }
}