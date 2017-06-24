package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created by Administrator on 24/06/2017.
 */
@AllArgsConstructor
@Getter
public enum  QuestionType {
    YES_NO("Yes/No"),ONE_CHOICE("One choice"), MULTIPLE_CHOICES("Multiple choices") ;
    private String render;
}
