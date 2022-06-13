package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name = "billet" )
public class billet {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String vols ;
    private int iduser ;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
