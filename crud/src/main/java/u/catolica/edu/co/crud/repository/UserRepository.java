package u.catolica.edu.co.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import u.catolica.edu.co.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}