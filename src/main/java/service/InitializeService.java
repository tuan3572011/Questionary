package service;

import model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 17/06/2017.
 */
@Singleton
@Startup
public class InitializeService {
    @Inject
    private QuestionService questionService;
    @Inject
    private AnswerService answerService;
    @Inject
    private LoginService loginService;
    @PostConstruct
    public void initQuestion(){
        YesNoQuestion yesNoQuestion = new YesNoQuestion(Boolean.TRUE);
        yesNoQuestion.setContent("Meo la dong vat");
        yesNoQuestion.setLevel(Level.EASY);

        List<Answer> answersOneChoiceQuestion = new ArrayList<>();
        answersOneChoiceQuestion.add(Answer.builder().content("Dong vat co vu").isTrue(Boolean.TRUE).build());
        answersOneChoiceQuestion.add(Answer.builder().content("Dong vat mau lanh").isTrue(Boolean.FALSE).build());
        answersOneChoiceQuestion.add(Answer.builder().content("Thuc vat").isTrue(Boolean.FALSE).build());
        answersOneChoiceQuestion.add(Answer.builder().content("Thuoc ho").isTrue(Boolean.FALSE).build());

        OneChoiceQuestion oneChoiceQuestion = new OneChoiceQuestion();
        oneChoiceQuestion.setLevel(Level.EASY);
        oneChoiceQuestion.setContent("Meo la");
        oneChoiceQuestion.setAnswers(answersOneChoiceQuestion);

        List<Answer> answersMuiltple = new ArrayList<>();
        answersMuiltple.add(Answer.builder().content("Dong vat co xuong song").isTrue(Boolean.TRUE).build());
        answersMuiltple.add(Answer.builder().content("Dong vat song tren can").isTrue(Boolean.TRUE).build());
        answersMuiltple.add(Answer.builder().content("Dong vat mau lanh").isTrue(Boolean.FALSE).build());
        answersMuiltple.add(Answer.builder().content("Dong vat an co").isTrue(Boolean.FALSE).build());

        MultipleChoicesQuestion multipleChoicesQuestion = new MultipleChoicesQuestion();
        multipleChoicesQuestion.setLevel(Level.EASY);
        multipleChoicesQuestion.setContent("Meo la");
        multipleChoicesQuestion.setAnswers(answersMuiltple);


        questionService.save(yesNoQuestion);
        questionService.save(oneChoiceQuestion);
        questionService.save(multipleChoicesQuestion);

        User teacher = User.builder().userName("teacher").password("teacher").role(Role.TEACHER).build();
        User student = User.builder().userName("student").password("student").role(Role.STUDENT).build();
        loginService.save(Arrays.asList(teacher,student));
    }
}
