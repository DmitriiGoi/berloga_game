package springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.entity.Quest;

public interface QuestRepository extends JpaRepository<Quest, Long> {
}
