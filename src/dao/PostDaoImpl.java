package dao;

import domain.Post;

import java.util.List;

public class PostDaoImpl implements PostDao {
    @Override
    public List<Post> getAllPosts() {
        return List.of();
    }

    @Override
    public List<Post> getUserPost(String idUser) {
        return List.of();
    }

    @Override
    public Post getPost(String id) {
        return null;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }
}
