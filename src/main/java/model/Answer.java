package model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Administrator on 24/06/2017.
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Answer
{
    @Column(name = "noi_dung")
    private String content;
    @Column(name = "dap_an")
    private boolean isTrue;
}
