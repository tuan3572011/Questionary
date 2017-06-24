package service;

import model.Answer;
import model.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Administrator on 17/06/2017.
 */
@Stateless
public class AnswerService {
    @PersistenceContext(unitName = "ExamDs")
    private EntityManager en;

    public List<Answer> save(List<Answer> answers){
        en.persist(answers);
        return answers;
    }
}
