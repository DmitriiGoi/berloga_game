package springboot.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Result;
import springboot.domain.entity.Achievement;
import springboot.service.AchievementService;

@RestController
@RequestMapping("/api/achievement")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @PostMapping
    public Result<Achievement> createAchievement(@RequestBody Achievement achievement) {
        Achievement createdAchievement = achievementService.createAchievement(achievement);
        return Result.ok(createdAchievement);
    }

    @DeleteMapping
    public Result deleteAchievement(@RequestParam Long achievementId) {
        achievementService.deleteAchievement(achievementId);
        return Result.ok(null);
    }

}
