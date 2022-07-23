package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 이 annotation을 붙이면 Member는 jpa가 관리하는 Entity가 됨.
public class Member {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Member객체를 insert 하면 PK인 id는 데이터베이스가 알아서 생성
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
