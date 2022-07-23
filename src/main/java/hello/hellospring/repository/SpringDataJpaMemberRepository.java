package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // interface가 interface를 받을 땐 implements가 아니라 extends
    // JpaRepository<Member, Long>의 Long은 PK의 type에 맞춘 것
    // interface는 다중상속 가능. 그래서 여기서도 JpaRepository와 MemberRepository 모두 써줌

    @Override
    Optional<Member> findByName(String name);
    // 함수의 네이밍 규칙에 따라 JPQL문이 알아서 아래처럼 작성됨
    // JPQL: select m from Member m where m.name = ?
    // 예를 들어, findByNameAndId 라고 하면 name이랑 id 사용해서 조회하는 쿼리로 알아서 만들어짐.
}
