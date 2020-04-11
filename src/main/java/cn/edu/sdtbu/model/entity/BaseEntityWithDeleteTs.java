package cn.edu.sdtbu.model.entity;

import cn.edu.sdtbu.model.properties.Const;
import cn.edu.sdtbu.util.TimeUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * default filed
 * @author bestsort
 * @version 1.0
 * @date 2020-4-6 20:26
 */

@Data
@ToString
@EqualsAndHashCode
@MappedSuperclass
public class BaseEntityWithDeleteTs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Timestamp createAt;

    @Column
    private Timestamp updateAt;

    @Column
    private Timestamp deleteAt;

    @Column(name = "deleted")
    private Boolean isDelete;
    @PrePersist
    protected void prePersist() {
        Timestamp now = TimeUtil.now();
        if (createAt == null) {
            createAt = now;
        }
        if (updateAt == null) {
            updateAt = now;
        }
        if (deleteAt == null) {
            deleteAt = Const.TIME_ZERO;
        }
        isDelete = false;
    }
    @PreUpdate
    protected  void preUpdate() {
        updateAt = TimeUtil.now();
    }
}