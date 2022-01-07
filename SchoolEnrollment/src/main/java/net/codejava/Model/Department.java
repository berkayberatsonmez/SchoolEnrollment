package net.codejava.Model;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String name;



    public Department(){
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }



    @Override
    public String toString() {
        return name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
