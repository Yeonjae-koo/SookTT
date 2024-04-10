package com.moviely.moviely.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Getter // lombock 이용, 모든 필드 접근 가능
@ToString


@EntityListeners(AuditingEntityListener.class) // 이게 있어야 auditing 동작 가능
@Entity // 엔티티, 테이블임을 명시


public class Movie_credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long credit_id; //credit_id를 primary key로 설정

    @Setter @ManyToOne (optional = false)
    private Movie movie; //movie_id와 연결
    @Setter @ManyToOne (optional = false)
    private People people; //poeple_id와 연결



    protected Movie_credit() {}

    // 생성자 생성 완료
    private Movie_credit(Movie movie, People people) {
        this.movie = movie;
        this.people = people;
    }

    public static Movie_credit of (Movie movie, People people) {
        return new Movie_credit (movie, people);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie_credit that)) return false;
        return credit_id == that.credit_id;
    }

    @Override public int hashCode() {
        return Objects.hash(credit_id);
    }
}
