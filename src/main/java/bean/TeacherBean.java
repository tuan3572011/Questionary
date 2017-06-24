package bean;

import bean.helper.QuestionCreator;
import lombok.Data;
import model.Question;
import service.QuestionService;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "teacher")
@ViewScoped
@Data
public class TeacherBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    @Inject
    private QuestionService questionService;


    private List<Question> allQuestion;
    private boolean shouldShowAddQuestionView;
    private QuestionCreator questionCreator = new QuestionCreator();

    public void showAllQuestion(){
            allQuestion = questionService.getAll();
    }

    public void showAddQuestionView(){
        this.shouldShowAddQuestionView = true;
    }
}
