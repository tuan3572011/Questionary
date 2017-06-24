package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 17/06/2017.
 */
@Entity
@Table(name = "chu_de")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@NamedQueries(
        value = {
                @NamedQuery(name = "Subject.getAll", query = "from Subject"),
                @NamedQuery(name = "Subject.findOne", query = "from Subject s where s.name= :name")
        }
)
public class Subject {

    public static final String GET_ALL_QUERY = "Subject.getAll";
    public static final String FIND_ONE_QUERY = "Subject.findOne";

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
