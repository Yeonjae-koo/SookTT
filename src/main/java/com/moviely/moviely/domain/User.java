package com.moviely.moviely.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.LinkedHashSet;
import java.util.Objects;

@Getter // lombock 이용, 모든 필드 접근 가능
@ToString // 쉽게 출력 가능
// 테이블에 인덱스를 걸어서 검색할 때 나올 수 있도록 함(우선 제목과 줄거리만)

@EntityListeners(AuditingEntityListener.class) // 이게 있어야 auditing 동작 가능
@Entity // 엔티티, 테이블임을 명시
public class User{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id; //user_id를 primary key로 설정

    @Setter @Column(nullable = false, length = 100)
    private String user_email; //user email
    @Setter @Column(nullable = false, length = 255)
    private String user_pwd; //user 비밀번호

    @Setter @Column(nullable = false)
    private int gender; //user 성별
    @Setter @Column(nullable = false)
    private int age; //user 나이


    protected User() {
    } // Jpa entity들은 기본 생성자를 가지고 있어야함(hibernate 기준)

    // 생성자 생성 완료

    private User(String user_email, String user_pwd, int gender, int age) {
        this.user_email = user_email;
        this.user_pwd = user_pwd;
        this.gender = gender;
        this.age = age;
    }

    public static User of (String user_email, String user_pwd, int gender, int age) {
        return new User(user_email, user_pwd, gender, age);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return user_id == user.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
