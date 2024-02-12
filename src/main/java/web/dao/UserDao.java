package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUser(long id);
   void updateUser(User user);
   void remove(long id);
}
