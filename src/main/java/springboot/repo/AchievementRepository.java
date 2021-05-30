package springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.entity.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
