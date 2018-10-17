package ru.bmstu.tamplebase.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="temple")
public class Temple implements Serializable {
    private static final long serialVersionUID = 2L;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    @JsonInclude(Include.NON_NULL)
    private int id;

    @JsonInclude(Include.NON_NULL)
    @Column(name="title")
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
