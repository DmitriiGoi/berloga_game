package springboot.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Result;
import springboot.domain.entity.AchievementUnlocked;
import springboot.domain.entity.Quest;
import springboot.service.QuestService;

@RestController
@RequestMapping("/api/quest")
public class QuestController {

    @Autowired
    private QuestService questService;

    @PostMapping
    public Result<Quest> createQuest(@RequestBody Quest quest) {
        Quest createdQuest = questService.createQuest(quest);
        return Result.ok(createdQuest);
    }

    @PostMapping("complete")
    public Result<AchievementUnlocked> completeQuest(@RequestParam Long questId, @RequestParam Long userId) {
        return questService.completeQuest(questId, userId);
    }

    @DeleteMapping
    public Result deleteQuest(@RequestParam Long questId) {
        questService.deleteQuest(questId);
        return Result.ok(null);
    }
}
