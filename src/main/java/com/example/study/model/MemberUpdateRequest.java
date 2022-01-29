package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    // 인스턴스를 가독성 좋게 생성할 수 있는 어노테이션
public class MemberUpdateRequest {
    private String name;
}
