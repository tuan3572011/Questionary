package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 17/06/2017.
 */
@Entity
@Table(name = "chu_de")
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_chu_de")
    private Long id;

    @Column(name = "ten_chu_de",nullable = false,unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name="chude_cauhoi",
            joinColumns=@JoinColumn(name="id_chu_de", referencedColumnName="ma_chu_de"),
            inverseJoinColumns=@JoinColumn(name="ma_cau_hoi", referencedColumnName="ma_cau_hoi"))
    private List<Question> questions;

}
