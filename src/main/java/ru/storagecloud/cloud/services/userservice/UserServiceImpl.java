package ru.storagecloud.cloud.services.userservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.storagecloud.cloud.entitys.User;
import ru.storagecloud.cloud.entitys.dto.UserDto;
import ru.storagecloud.cloud.mapper.UserMapper;
import ru.storagecloud.cloud.repositorys.UserRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> findUserByEmail(String email) {
        log.debug("Пользователь с email не найден: {}", email);
        Optional<User> user = userRepository.findByEmail(email);
        log.debug("Пользователь с email найден: {}", user.isPresent());
        return user.map(userMapper::toDto);
    }
}
