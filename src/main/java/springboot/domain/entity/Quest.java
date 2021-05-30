package springboot.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import springboot.domain.Attribute;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@javax.persistence.Table(name = "quest")
public class Quest extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Attribute mainAttribute;
    private int incrementValue;
    private String title;
    private String description;
}
