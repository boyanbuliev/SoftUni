package jsonprocessinglab.jsondemolab.services;

import jsonprocessinglab.jsondemolab.entities.Post;

import java.util.List;


public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post addPost(Post post);

    Post updatePost(Post post);

    Post deletePost(Long id);

    long getPostsCount();
}
