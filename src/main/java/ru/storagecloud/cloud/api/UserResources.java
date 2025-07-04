package ru.storagecloud.cloud.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import ru.storagecloud.cloud.entitys.dto.UserDto;

@Tags(value = {
        @Tag(name = "User", description = "User API"),
})
public interface UserResources {
    @Operation(
            summary = "Test connection to the database",
            description = "Проверяет наличие пользователя по email"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Пользователь найден",
                    content = @Content(schema = @Schema(implementation = UserDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Пользователь не найден",
                    content = @Content
            )
    })
    ResponseEntity<?> getTestConnection(@RequestParam String email);
}
