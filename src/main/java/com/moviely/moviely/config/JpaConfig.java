package com.moviely.moviely.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/*
- config 패키지는 애플리케이션의 구성과 관련된 클래스를 담는 역할
- 시작, 실행 방식, 사용할 서비스나 컴포넌트 설정
- 애플리케이션 컨텍스트 구성, 데이터베이스 설정, 보안 설정, 웹 MVC 설정, 배치 처리 및 스케쥴링 설정, 외부 구성 등
 */

@EnableJpaAuditing // 자동 시간 기록, 생성자와 수정자 추적
@Configuration
public class JpaConfig {

    @Bean // 누가 입력하고 수정했는지 식별
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("cs"); // TODO: 스프링 시큐리티로 인증 기능 붙이게 될 때, 연재님께서 수정해주시기
    }

}
