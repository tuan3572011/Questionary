package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 17/06/2017.
 */
@Entity
@Table(name = "cau_hoi_dung_sai")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YesNoQuestion extends Question {

    @Column(name = "dap_an")
    private Boolean answer;
}
