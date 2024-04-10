package com.moviely.moviely.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Getter // lombock 이용, 모든 필드 접근 가능
@ToString // 쉽게 출력 가능
// 테이블에 인덱스를 걸어서 검색할 때 나올 수 있도록 함(우선 제목과 줄거리만)


@EntityListeners(AuditingEntityListener.class) // 이게 있어야 auditing 동작 가능
@Entity // 엔티티, 테이블임을 명시

public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long people_id; //credit_id를 primary key로 설정

    @Setter @Column
    private String actor_name; //배우 이름
    @Setter @Column
    private String director_name; //감독 이름

    protected People() {}
    // 생성자 생성 완료
    private People(String actor_name, String director_name) {
        this.actor_name = actor_name;
        this.director_name = director_name;
    }

    public static People of (String actor_name, String director_name) {
        return new People(actor_name, director_name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People people)) return false;
        return people_id == people.people_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(people_id);
    }
}
