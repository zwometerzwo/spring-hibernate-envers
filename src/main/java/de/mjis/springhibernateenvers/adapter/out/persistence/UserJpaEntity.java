package de.mjis.springhibernateenvers.adapter.out.persistence;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "users", schema = "public")
public class UserJpaEntity {
    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Audited
    private String name;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
