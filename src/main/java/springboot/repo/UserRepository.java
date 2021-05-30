package springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
