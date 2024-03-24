package de.mjis.springhibernateenvers.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "users", schema = "public")
public class UserJpaEntity {
    @Id
    private Long id;

    @Audited
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
