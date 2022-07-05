package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional은 id로 Member를 찾았는데 없어서 null값이 반환될 수도 있기 때문에!
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
