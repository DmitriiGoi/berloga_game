package springboot.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.domain.Result;
import springboot.domain.entity.Achievement;
import springboot.service.AchievementService;

@RestController
@RequestMapping("/api/achievement")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @PostMapping
    public Result<Achievement> createAchievement(Achievement achievement) {
        Achievement createdAchievement = achievementService.createAchievement(achievement);
        return Result.ok(createdAchievement);
    }

}
