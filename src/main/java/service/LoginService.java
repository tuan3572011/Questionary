package service;

import model.Answer;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 17/06/2017.
 */
@Stateless
public class LoginService {
    @PersistenceContext(unitName = "ExamDs")
    private EntityManager en;

    public Optional<User> isValid(String userName, String password){
        try{
            User user =  this.en.createNamedQuery(User.CHECK_USER,User.class)
                    .setParameter("userName",userName)
                    .setParameter("password",password)
                    .getSingleResult();
            return Optional.of(user);
        }catch (Exception e){
            return Optional.empty();
        }

    }

    public List<User> save(List<User> users){
        List<User> persistUsers =  users.stream()
                .map(user->user.toBuilder().userName(user.getUserName().toLowerCase()).build())
                .collect(Collectors.toList());
        persistUsers.forEach(this.en::persist);
        return persistUsers;
    }
}
