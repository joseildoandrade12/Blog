package dao;

import domain.Post;

import java.util.List;

public interface PostDao {
    List<Post> getAllPosts();
    List<Post> getUserPost(String idUser);
    Post getPost(String id);
    void updatePost(Post post);
    void deletePost(Post post);
}
