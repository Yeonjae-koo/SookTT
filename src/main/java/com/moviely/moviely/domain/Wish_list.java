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

public class Wish_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wish_list_id; //whish_list_id를 primary key로 설정

    @Setter @ManyToOne(optional = false)
    private User user;
    @Setter @ManyToOne(optional = false)
    private Movie movie;



    protected Wish_list() {}

    private Wish_list(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
    }

    public static Wish_list of (User user, Movie movie) {
        return new Wish_list(user, movie);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wish_list wishList)) return false;
        return wish_list_id == wishList.wish_list_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wish_list_id);
    }
}
