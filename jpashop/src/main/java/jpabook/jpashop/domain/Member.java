package jpabook.jpashop.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = AUTO)
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;

    @Embedded
    private Address address;
    // 양방향 연관관계가 필요할 경우 (JPQL 등)
//    @OneToMany(mappedBy = "member")
//    private List<Order> orders=new ArrayList<>();

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
