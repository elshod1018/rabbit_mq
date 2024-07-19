package com.company.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {
    private Integer id;
    private String name;
    private String email;
}
