package de.mjis.springhibernateenvers.domain;

public class Tag {

    private Long id;

    private String name;

    private Long tstmp;

    public void setId(Long id) {
        this.id = id;
    }

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
