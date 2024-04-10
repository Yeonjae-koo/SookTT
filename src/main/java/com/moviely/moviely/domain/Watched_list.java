package com.moviely.moviely.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter // lombock 이용, 모든 필드 접근 가능
@ToString // 쉽게 출력 가능
// 테이블에 인덱스를 걸어서 검색할 때 나올 수 있도록 함(우선 제목과 줄거리만)


@EntityListeners(AuditingEntityListener.class) // 이게 있어야 auditing 동작 가능
@Entity // 엔티티, 테이블임을 명시

public class Watched_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wl_id; //whish_list_id를 primary key로 설정

    @Setter @ManyToOne(optional = false)
    private User user; //user_id 연결
    @Setter @ManyToOne(optional = false)
    private Movie movie; //movie_id 연결
    @Setter @ManyToOne(optional = false)
    private User_rating user_rating; //rating_id 연결

    protected Watched_list() {}

    // 생성자 생성 완료

    private Watched_list(User user, Movie movie, User_rating user_rating) {
        this.user = user;
        this.movie = movie;
        this.user_rating = user_rating;
    }

    public static Watched_list of (User user, Movie movie, User_rating user_rating) {
        return new Watched_list(user, movie, user_rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Watched_list that)) return false;
        return wl_id == that.wl_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wl_id);
    }
}
