package bean.helper;

import lombok.Data;
import model.*;

/**
 * Created by Administrator on 24/06/2017.
 */
@Data
public class QuestionCreator {
    private QuestionType type = QuestionType.YES_NO;
    private Question question;

    public Question getQuestion() {
        if (question == null) {
            if (this.isYesNo()) {
                this.question = new YesNoQuestion();
            }
            if (this.isOneChoice()) {
                this.question = new OneChoiceQuestion();
            }
            if (this.isMultipleChoices()) {
                this.question = new MultipleChoicesQuestion();
            }
        }
        return question;
    }

    public boolean isYesNo(){
        return this.type == QuestionType.YES_NO;
    }

    public boolean isOneChoice(){
        return this.type == QuestionType.ONE_CHOICE;
    }

    public boolean isMultipleChoices(){
        return  this.type == QuestionType.MULTIPLE_CHOICES;
    }
}
