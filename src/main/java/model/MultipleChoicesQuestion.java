package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 17/06/2017.
 */
@Entity
@Table(name = "cau_hoi_nhieu_dap_an")
@Data
@NoArgsConstructor
public class MultipleChoicesQuestion extends Question{

    @ElementCollection
    @CollectionTable(
            name="cauhoinhieudapan_traloi",
            joinColumns=@JoinColumn(name="id_cau_hoi", referencedColumnName="ma_cau_hoi"))
    private List<Answer> answers;

}
