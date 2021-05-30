package springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.entity.QuestCompletion;

public interface QuestCompletionRepository extends JpaRepository<QuestCompletion, Long> {
}
