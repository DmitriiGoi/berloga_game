package springboot.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Result;
import springboot.domain.entity.User;
import springboot.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return Result.ok(createdUser);
    }

    @DeleteMapping
    public Result deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return Result.ok(null);
    }
}

