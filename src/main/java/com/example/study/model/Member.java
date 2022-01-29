package com.example.study.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 ID 값을 1씩 증가시켜주는 기능 (Auto increment)
    private Long id;

    private String name;

    private String number;

    private String email;

    public static Member toEntity(MemberCreateRequest request) {
        return Member.builder()
                .name(request.getName())
                .number(request.getNumber())
                .email(request.getEmail())
                .build();
    }

    public void updateName(String name) {
        this.name = name;
    }
}
