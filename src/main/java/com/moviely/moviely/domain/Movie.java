package com.moviely.moviely.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Objects;

// ERD 완성 전이기 때문에 우선 Movie entity class만 생성함.


@Getter // lombock 이용, 모든 필드 접근 가능
@ToString // 쉽게 출력 가능
// 테이블에 인덱스를 걸어서 검색할 때 나올 수 있도록 함(우선 제목과 줄거리만)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "content")
})

@EntityListeners(AuditingEntityListener.class) // 이게 있어야 auditing 동작 가능
@Entity // 엔티티, 테이블임을 명시

public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // movie_id를 primary key로 설정
    private long movie_id;

    @Setter @Column(nullable = false)
    private String title; // 영화 제목
    @Setter @Column(nullable = false, length = 1000)
    private String overview; // 줄거리 요약

    @Setter @Column(nullable = false, length = 200)
    private String poster_path; // 포스터 주소

    @Setter private LocalDate release_date; // 개봉일, null 허용, 개봉일이므로 일부러 @CreatedDate기능 안넣었습니다.
    @Setter private int run_time; // 상영 시간, null 허용


    @Setter private String genre; //장르
    @Setter private String production_countries; //개봉국가

    @Setter private int vote_count; //평점수, 이것도 세터를 해야하는지?
    @Setter private int vote_average; //평점평균, 이것도 세터를 해야하는지?

    @Setter private int adult; // 성인용여부
    @Setter private String filtrate; //구독서비스

    @Setter @Column(nullable = false, length = 200) private String link; //TMDB 영화링크
    @Setter private int payment; //최저가


    protected Movie() {}

    // 생성자 생성 완료


    private Movie(String title, String overview, String poster_path, LocalDate release_date, int run_time, String genre,
                 String production_countries, int vote_count, int vote_average, int adult, String filtrate, String link, int payment) {
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.run_time = run_time;
        this.genre = genre;
        this.production_countries = production_countries;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.adult = adult;
        this.filtrate = filtrate;
        this.link = link;
        this.payment = payment;
    }

    public static Movie of(String title, String overview, String poster_path, LocalDate release_date, int run_time, String genre,
                  String production_countries, int vote_count, int vote_average, int adult, String filtrate, String link, int payment) {
        return new Movie (title, overview, poster_path, release_date, run_time, genre, production_countries, vote_count, vote_average, adult, filtrate, link, payment);
    }



    @Override // 나중에 데이터를 list에 담아서 뭔가를 하기 위해 중복 검사하는 것
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return movie_id == movie.movie_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie_id);
    }
}
