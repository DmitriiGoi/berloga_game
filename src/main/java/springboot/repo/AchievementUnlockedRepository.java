package springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.entity.AchievementUnlocked;

public interface AchievementUnlockedRepository extends JpaRepository<AchievementUnlocked, Long> {
}
