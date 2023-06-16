package projects.jwtauthtut.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.jwtauthtut.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
