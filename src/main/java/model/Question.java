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
public abstract class Question {
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
}
