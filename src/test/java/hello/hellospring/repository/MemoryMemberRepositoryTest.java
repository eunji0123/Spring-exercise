package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// 다른 데서 실행할 거 아니니까 public 아니어도 됨
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 아래의 테스트들(e.g., save(), findByName(), ...)이 끝날 때마다 어떤 동작을 하는 메서드
    public void afterEach() {
        repository.clearStore(); // 테스트 실행이 끝날 때마다 store 싹 비워줌.
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // Optional을 까내고 받을 땐 .get() 추가해줘야 함
        assertThat(result).isEqualTo(member); // 내가 기대하는 값은 member인데 실제값인 result랑 그거랑 같아??
        // 원래 Assertions.assertThat 이었는데 alt + enter 누른 뒤에 static import 로 바꿈
        // -> 이제 assertThat만 그냥 치면 됨 :)
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
