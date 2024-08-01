package kr.co.jhta.app.delideli.user.board.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserAddressDTO {
    private int userAddressKey;
    private int userKey;
    private String address;
    private String zipcode;
    private String addrDetail;
    private Integer defaultAddress; // 널 값을 처리하기 위해 Integer 사용
    private LocalDate addressRegdt;
    private LocalDate addressUpdt;
}
