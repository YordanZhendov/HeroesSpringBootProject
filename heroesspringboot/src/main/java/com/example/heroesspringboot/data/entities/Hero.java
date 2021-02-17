package com.example.heroesspringboot.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heroes")
@Getter
@Setter
@NoArgsConstructor
public class Hero extends BaseEntity{

    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;
    @Column
    private Integer level;
    @Column
    private Integer stamina;
    @Column
    private Integer strength;
    @Column
    private Integer attack;
    @Column
    private Integer defence;

    @ManyToMany
    @JoinTable(
            name = "hero_item",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    @OneToOne(mappedBy = "hero")
    private User user;
}
