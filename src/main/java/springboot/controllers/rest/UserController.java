package springboot.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.domain.Result;
import springboot.domain.entity.User;
import springboot.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result<User> createUser(User user) {
        User createdUser = userService.createUser(user);
        return Result.ok(createdUser);
    }
}

