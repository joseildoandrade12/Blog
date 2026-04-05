package dao;

import Connection.DBconnection;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection conn;

    public UserDaoImpl() throws SQLException {
        conn = DBconnection.getConnection();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User user = resultDataUser(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuários", e);
        }
        return users;
    }

    private User resultDataUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("username"),
                rs.getDate("date")
        );
    }

    @Override
    public User getUser(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return resultDataUser(rs);
            } else {
                throw new RuntimeException("usuário não encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Usuário não cadastrado", e);
        }
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO users (email, username, id, password, date) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getId());
            ps.setString(4, user.getpassword());
            ps.setDate(5, user.getDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel criar o usuário", e);
        }
    }

    @Override
    public String searchEmail(String email) {
        String sql = "SELECT email FROM users WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getString("email");
            } else {
                throw new RuntimeException("Email não encontrado");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET email = ?, username = ?, password = ? WHERE id = ?";
        try( PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getpassword());
            ps.setString(4, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUser(User user) {
        String sql = "DELETE FROM users WHERE id = ?";
        try( PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
