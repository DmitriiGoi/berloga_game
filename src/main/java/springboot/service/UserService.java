package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.entity.User;
import springboot.domain.entity.UserStats;
import springboot.repo.UserRepository;
import springboot.repo.UserStatsRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserStatsRepository userStatsRepository;

    public User createUser(User user) {
        User save = userRepository.save(user);
        formBaseStats(save);
        return save;
    }

    private void formBaseStats(User user) {
        UserStats userStats = new UserStats(user);
        userStatsRepository.save(userStats);
        user.setUserStats(userStats);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
