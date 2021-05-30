package springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.entity.UserStats;

public interface UserStatsRepository extends JpaRepository<UserStats, Long> {
}
