package my.safe.repository;

import my.safe.model.User;
import my.safe.model.UserV2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserV2Repo extends JpaRepository<UserV2, UUID> {
    public Optional<UserV2> getOneByUsername(String username);
}
