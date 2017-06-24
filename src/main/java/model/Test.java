package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 17/06/2017.
 */
@Entity
@Table(name = "de_thi")
@Getter
@Setter
public class Test {
    @Id
    @Column(name = "ma_de_thi")
    private String idT;
    @ManyToOne
    @JoinColumn(name = "chu_de")
    private Subject subject;
    @ManyToMany
    @JoinTable(
            name="dethi_cauhoi",
            joinColumns=@JoinColumn(name="ma_de_thi", referencedColumnName="ma_de_thi"),
            inverseJoinColumns=@JoinColumn(name="ma_cau_hoi", referencedColumnName="ma_cau_hoi"))
    private List<Question> questions;

}
