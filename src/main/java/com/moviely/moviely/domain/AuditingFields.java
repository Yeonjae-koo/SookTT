package com.moviely.moviely.domain;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class) // 이게 있어야 auditing 동작 가능
@MappedSuperclass
public class AuditingFields {
   //calendar에 있는 관람일, 등록시간, 등록한 사람(Setter 제외한 것들)
 //From: calendar, *Column(nullable = false)해야할지 고민해보기
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    private LocalDateTime watch_date; //관람일
    @CreatedDate @Column(updatable = false)
    private LocalDateTime created_at; //등록시간
    @CreatedBy @Column(updatable = false)
    private String created_by; //등록한 사람
}
