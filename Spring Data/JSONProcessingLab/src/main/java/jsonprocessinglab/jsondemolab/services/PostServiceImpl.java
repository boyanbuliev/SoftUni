package jsonprocessinglab.jsondemolab.services;


import jsonprocessinglab.jsondemolab.entities.Post;
import jsonprocessinglab.jsondemolab.exceptions.InvalidEntityDataException;
import jsonprocessinglab.jsondemolab.exceptions.NonExistingEntity;
import jsonprocessinglab.jsondemolab.repositories.PostRepository;
import jsonprocessinglab.jsondemolab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntity(String.format("Post with id=%s does not exist", id)));
    }

    @Override
    public Post addPost(Post post) {
        post.setId(null);
        if (post.getAuthor() == null) {
            if (post.getAuthorId() == null) {
                throw new InvalidEntityDataException("Post author is required");
            }
            post.setAuthor(userRepository.findById(post.getAuthorId()).orElseThrow(()->
                    new InvalidEntityDataException(
                            String.format("Post author with ID:%s does not exist.",post.getAuthorId()))));
        }
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        getPostById(post.getId());
        return postRepository.save(post);
    }

    @Override
    public Post deletePost(Long id) {
        Post post = getPostById(id);
        postRepository.deleteById(id);
        return post;
    }

    @Override
    public long getPostsCount() {
        return postRepository.count();
    }
}
