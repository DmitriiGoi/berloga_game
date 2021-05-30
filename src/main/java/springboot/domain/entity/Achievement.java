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
@javax.persistence.Table(name = "achievement")
public class Achievement extends BaseEntity {
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Attribute attribute;
    private int attributeValue;

    public boolean isConditionSatisfied(UserStats userStats) {
        return attribute.isConditionSatisfied(userStats, attributeValue);
    }
}
