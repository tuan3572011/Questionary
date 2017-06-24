package bean;

import lombok.Data;
import model.QuestionType;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 24/06/2017.
 */
@ManagedBean(name = "metaData")
@ApplicationScoped
@Data
public class MetaDataBean {
    private List<QuestionType> questionTypes = Arrays.asList(QuestionType.values());
}
