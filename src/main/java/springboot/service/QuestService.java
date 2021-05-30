package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.Attribute;
import springboot.domain.Result;
import springboot.domain.entity.*;
import springboot.repo.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class QuestService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private AchievementRepository achievementRepository;
    @Autowired
    private AchievementUnlockedRepository achievementUnlockedRepository;
    @Autowired
    private QuestCompletionRepository questCompletionRepository;
    @Autowired
    private UserStatsRepository userStatsRepository;

    public Quest createQuest(Quest quest) {
        return questRepository.save(quest);
    }

    public Result<AchievementUnlocked> completeQuest(Long questId, Long userId) {
        User user = userRepository.getOne(userId);
        Quest quest = questRepository.getOne(questId);
        QuestCompletion questCompletion = new QuestCompletion();
        questCompletion.setCompleteDate(LocalDate.now());
        questCompletion.setQuest(quest);
        questCompletion.setUser(user);
        try {
            QuestCompletion savedCompletion = questCompletionRepository.save(questCompletion);
            user.getCompletedQuests().add(savedCompletion);
            incrementUserStats(questCompletion);
            return Result.ok(unlockAchievements(user));
        } catch (Exception ex) {
            return Result.error(null, "Unable to complete quest");
        }
    }

    private AchievementUnlocked unlockAchievements(User user) {
        List<Achievement> achievements = achievementRepository.findAll();
        return achievements.stream()
                .filter(achievement -> achievement.isConditionSatisfied(user.getUserStats()))
                .findFirst()
                .map(achievement -> unlockAchievement(user, achievement)).orElse(null);
    }

    private AchievementUnlocked unlockAchievement(User user, Achievement achievement) {
        AchievementUnlocked achievementUnlocked = new AchievementUnlocked();
        achievementUnlocked.setAchievement(achievement);
        achievementUnlocked.setUser(user);
        achievementUnlocked.setUnlockDate(LocalDate.now());
        user.getUnlockedAchievements().add(achievementUnlocked);
        return achievementUnlockedRepository.save(achievementUnlocked);
    }

    private void incrementUserStats(QuestCompletion questCompletion) {
        Quest quest = questCompletion.getQuest();
        User user = questCompletion.getUser();
        UserStats userStats = user.getUserStats();
        Attribute mainAttribute = quest.getMainAttribute();
        int incrementValue = quest.getIncrementValue();
        mainAttribute.incrementUserStats(userStats, incrementValue);
        userStatsRepository.save(userStats);
    }

    public List<Quest> getQuestList() {
        return questRepository.findAll();
    }

    public Result deleteQuest(Long questId) {
        questRepository.deleteById(questId);
        return Result.ok(null);
    }
}
