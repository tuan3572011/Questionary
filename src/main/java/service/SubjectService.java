package service;

import model.Question;
import model.Subject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 17/06/2017.
 */
@Stateless
public class SubjectService {
    @PersistenceContext(unitName = "ExamDs")
    private EntityManager en;

    public Subject save(Subject subject) {
        Subject persistSubject = subject.toBuilder().name(subject.getName().toLowerCase()).build();
        en.persist(persistSubject);
        return persistSubject;
    }

    public List<Subject> getAll() {
        return en.createNamedQuery(Subject.GET_ALL_QUERY, Subject.class).getResultList();
    }

    public Optional<Subject> findOne(String name) {
        try {
            Subject subject = en.createNamedQuery(Subject.FIND_ONE_QUERY, Subject.class).getSingleResult();
            subject.getQuestions();
            return Optional.of(subject);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
