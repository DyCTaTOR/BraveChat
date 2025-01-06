package user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.model.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
}
