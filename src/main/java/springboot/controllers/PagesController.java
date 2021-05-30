package springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.domain.Attribute;
import springboot.domain.entity.Achievement;
import springboot.domain.entity.Quest;
import springboot.domain.entity.User;
import springboot.service.AchievementService;
import springboot.service.QuestService;
import springboot.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class PagesController {

    @Autowired
    private UserService userService;
    @Autowired
    private QuestService questService;
    @Autowired
    private AchievementService achievementService;

    @RequestMapping("/index")
    public String getIndexPage(Map<String, Object> model) {
        List<User> userList = userService.getUserList();
        model.put("users", userList);
        List<Achievement> achievements = achievementService.getAchievementList();
        model.put("achievements", achievements);
        List<Quest> quests = questService.getQuestList();
        model.put("quests", quests);
        return "index";
    }

    @RequestMapping("/admin")
    public String getAdminPage(Map<String, Object> model) {
        List<User> userList = userService.getUserList();
        model.put("users", userList);
        List<Attribute> attributes = Arrays.asList(Attribute.values());
        model.put("attributes", attributes);
        List<Achievement> achievements = achievementService.getAchievementList();
        model.put("achievements", achievements);
        List<Quest> quests = questService.getQuestList();
        model.put("quests", quests);
        return "admin";
    }

    @RequestMapping("/me")
    public String getMePage(Map<String, Object> model) {
        return "me";
    }
}
