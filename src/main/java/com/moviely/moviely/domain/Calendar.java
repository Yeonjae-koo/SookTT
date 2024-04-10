package com.moviely.moviely.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter // lombock 이용, 모든 필드 접근 가능
@ToString

@Entity // 엔티티, 테이블임을 명시

public class Calendar extends AuditingFields{ //AuditingFields에다가 상속걸기

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long calendar_id; //calendar_id를 primary key로 설정

    @Setter @ManyToOne (optional = false)
    private User user; // user_id 연결

    @Setter
    private String movie_title; //영화 제목
    @Setter @Column(length = 500)
    private String movie_content; //영화 내용





    protected Calendar() {}

    private Calendar(User user, String movie_title, String movie_content) {
        this.user = user;
        this.movie_title = movie_title;
        this.movie_content = movie_content;
    }

    public static Calendar of (User user, String movie_title, String movie_content) {
        return new Calendar (user, movie_title, movie_content);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calendar calendar)) return false;
        return calendar_id == calendar.calendar_id;
    }

    @Override public int hashCode() {
        return Objects.hash(calendar_id);
    }
}
