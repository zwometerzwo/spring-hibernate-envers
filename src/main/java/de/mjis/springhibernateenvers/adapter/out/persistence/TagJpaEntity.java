package de.mjis.springhibernateenvers.adapter.out.persistence;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "tags", schema = "public")
public class TagJpaEntity {
    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private Long tstmp;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getTstmp() {
        return tstmp;
    }

    public void setTstmp(Long tstmp) {
        this.tstmp = tstmp;
    }
}
