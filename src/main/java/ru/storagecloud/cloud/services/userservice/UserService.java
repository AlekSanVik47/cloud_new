package ru.storagecloud.cloud.services.userservice;

import ru.storagecloud.cloud.entitys.User;
import ru.storagecloud.cloud.entitys.dto.UserDto;

import java.util.Optional;

public interface UserService {
    Optional<UserDto> findUserByEmail(String email);
}
