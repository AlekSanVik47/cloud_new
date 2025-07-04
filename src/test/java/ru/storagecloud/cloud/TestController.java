package ru.storagecloud.cloud;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.storagecloud.cloud.entitys.User;
import ru.storagecloud.cloud.repositorys.UserRepository;

@RestController
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "Test connection to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Подключение к базе данных прошло успешно",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Предоставленные данные некорректны",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Не найден пользователь с указанным email",
                    content = @Content) })
    @GetMapping("/test")
    public String testConnection() {
        userRepository.findByEmail("test@gmail.com");
        return "Connected to the database!";
    }
}
