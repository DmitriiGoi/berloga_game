package springboot.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private User user;
    private int intelligent;
    private int strength;
    private int dexterity;
    private int constitution;

    public UserStats() {
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligent = 0;
    }

    public UserStats(User user) {
        this.user = user;
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligent = 0;
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
