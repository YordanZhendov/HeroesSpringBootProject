package com.example.heroesspringboot.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@Setter
@Getter
@NoArgsConstructor
public class Item extends BaseEntity {

    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    @Column
    private Slot slot;
    @Column
    private Integer stamina;
    @Column
    private Integer strength;
    @Column
    private Integer attack;
    @Column
    private Integer defence;

    @ManyToMany(mappedBy = "items")
    List<Hero> heroes;
}
