package ru.storagecloud.cloud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.storagecloud.cloud.entitys.User;
import ru.storagecloud.cloud.entitys.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
