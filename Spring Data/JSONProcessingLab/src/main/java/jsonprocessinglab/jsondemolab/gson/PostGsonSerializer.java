package jsonprocessinglab.jsondemolab.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import jsonprocessinglab.jsondemolab.entities.Post;

import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;

public class PostGsonSerializer implements JsonSerializer<Post> {
    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public JsonElement serialize(Post post, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject postJsonObj = new JsonObject();
        postJsonObj.addProperty("id", post.getId());
        postJsonObj.addProperty("title", post.getTitle());
        postJsonObj.addProperty("content", post.getContent());
        postJsonObj.addProperty("author", post.getAuthor()
                .getFirstName()+" "+ post.getAuthor().getLastName());
        postJsonObj.addProperty("imageUrl", post.getImageUrl());
        postJsonObj.addProperty("created", post.getCreated().format(formatter));
        postJsonObj.addProperty("modified", post.getModified().format(formatter));
        return postJsonObj;
    }
}
