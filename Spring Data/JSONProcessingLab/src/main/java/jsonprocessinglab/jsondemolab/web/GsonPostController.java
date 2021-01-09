package jsonprocessinglab.jsondemolab.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jsonprocessinglab.jsondemolab.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class GsonPostController {
    @Autowired
    private PostService postService;
    private Gson gson = new GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting().create();

    @GetMapping
    public String getPosts() {
        return gson.toJson(postService.getAllPosts());
    }
}
