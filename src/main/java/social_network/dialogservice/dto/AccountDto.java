package social_network.dialogservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Собеседник")
public class AccountDto {

    private Long id;

    private String email;

    private String phone;

    private String photo;

    private String about;

    private String city;

    private String country;

    private String token;

    private StatusCode statusCode;

    private String firstName;

    private String lastName;

    private LocalDateTime regDate;

    private LocalDateTime birthDate;

    private String messagePermission;

    private LocalDateTime lastOnlineTime;

    private Boolean isOnline;

    private Boolean isBlocked;

    private Boolean isDeleted;

    private String photoId;

    private String photoName;

    private Role role;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private String password;
}
