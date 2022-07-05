package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 이렇게 공유되는 변수일 경우, 동시성 문제가 있을 수 있어서 ConcurrentHashMap 사용
    // BUT 이건 예제니까 단순한 HashMap 사용
    // store에 Member를 저장
    private static long sequence = 0L;
    // sequence는 0, 1, 2 같이 key 값을 생성해주는 애

   @Override
    public Member save(Member member) {
       member.setId(++sequence); // member의 id 값 설정
       store.put(member.getId(), member); // store에 저장
       return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null일 수도 있으니까 Optional 로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 아무거나 찾으면 바로 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
       store.clear();
    }
}
