package service;

import model.Question;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Administrator on 17/06/2017.
 */
@Stateless
public class QuestionService {
    @PersistenceContext(unitName = "ExamDs")
    private EntityManager en;

    public Question save(Question question){
        en.persist(question);
        return question;
    }

    public List<Question> getAll() {
        return en.createNamedQuery(Question.GET_ALL_QUERY, Question.class).getResultList();
    }
}
