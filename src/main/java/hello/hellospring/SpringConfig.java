package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean // 빈으로 등록하겠다는 의미
    public MemberService memberService() {
        return new MemberService(memberRepository()); // 아래의 memberRepository() 호출.
                                                      // 이렇게 하면 스프링 컨테이너에 등록된 아래의 스프링 빈 찾아줌.
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
