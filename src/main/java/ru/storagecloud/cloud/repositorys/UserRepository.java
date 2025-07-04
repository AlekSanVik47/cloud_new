package ru.storagecloud.cloud.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.storagecloud.cloud.entitys.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
