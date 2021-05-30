package springboot.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@javax.persistence.Table(name = "user")
public class User extends BaseEntity {

    @OneToOne
    private UserStats userStats;
    private String name;
    private String login;
    private String password;
    private boolean isAdmin;
    @OneToMany(mappedBy = "user")
    private List<QuestCompletion> completedQuests;
    @OneToMany(mappedBy = "user")
    private List<AchievementUnlocked> unlockedAchievements;
}
