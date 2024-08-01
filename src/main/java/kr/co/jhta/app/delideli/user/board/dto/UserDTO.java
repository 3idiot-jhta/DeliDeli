package kr.co.jhta.app.delideli.user.board.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserDTO {
    private int userKey;
    private String userId;
    private String userPw;
    private String userName;
    private String userNickname;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private String userProfile;
    private String userPoint;
    private String userRank;
    private String userStatus;
    private LocalDate userRegdate;
    private LocalDate userUpdate;
}
