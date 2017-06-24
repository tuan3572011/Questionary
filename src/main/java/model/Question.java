package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Administrator on 17/06/2017.
 */

@Entity
@Table(name = "cau_hoi")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NamedQueries(@NamedQuery(name = "Question.getAll",query = "from Question"))
public abstract class Question {
    public static final String GET_ALL_QUERY = "Question.getAll";
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cau_hoi")
    @Id
    private Long id;
    @Column(name = "noi_dung",length = 512)
    @Lob
    private String content;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "do_kho")
    private Level level;

    public String getType(){
        if(this instanceof YesNoQuestion){
            return QuestionType.YES_NO.getRender();
        }
        if(this instanceof OneChoiceQuestion){
            return QuestionType.ONE_CHOICE.getRender();
        }
        if(this instanceof MultipleChoicesQuestion){
            return QuestionType.MULTIPLE_CHOICES.getRender();
        }
        return "N/A";
    }
}
