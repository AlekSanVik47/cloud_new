package ru.storagecloud.cloud.entitys.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link ru.storagecloud.cloud.entitys.User}
 */

@Builder
public record UserDto(@NotNull Long id, String userName, String password, String firstName, String lastName, String email) implements Serializable {
  }