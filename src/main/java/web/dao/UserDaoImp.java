package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("from User", User.class).getResultList();
   }

   @Override
   public User getUser(long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

   @Override
   public void remove(long id) {
      entityManager.remove(getUser(id));
   }

}
