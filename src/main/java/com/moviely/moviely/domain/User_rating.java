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
public class User_rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rating_id; //rating_id를 primary key로 설정

    @Setter @ManyToOne(optional = false) private User user;
    @Setter @ManyToOne(optional = false) private Movie movie;

    @Setter private float rating; //

    protected User_rating() {}

    private User_rating(User user, Movie movie, float rating) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
    }

    public static User_rating of (User user, Movie movie, float rating) {
        return new User_rating(user, movie, rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User_rating that)) return false;
        return rating_id == that.rating_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating_id);
    }
}
