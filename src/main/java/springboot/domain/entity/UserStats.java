package springboot.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@javax.persistence.Table(name = "user_stats")
public class UserStats extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int intelligent;
    private int strength;
    private int dexterity;
    private int constitution;

    public UserStats() {
    }

    public UserStats(User user) {
        this.user = user;
    }

    public void incrementIntelligent(int value) {
        intelligent += value;
    }

    public void incrementStrength(int value) {
        strength += value;
    }

    public void incrementDexterity(int value) {
        dexterity += value;
    }

    public void incrementConstitution(int value) {
        constitution += value;
    }
}
