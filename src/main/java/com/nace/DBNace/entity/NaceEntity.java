package com.nace.DBNace.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "NACE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NaceEntity {

    @Id
    @GeneratedValue(generator = "nace")
    @GenericGenerator(name = "nace", strategy = "increment")
    private Long naceId;

    @Column(name = "level")
    private String level;

    @Column(name = "code")
    private String code;

    @Column(name = "parent")
    private String parent;

    @Column(name="description")
    private String description;

    @Column(name = "itemIncludes")
    private String itemIncludes;

    @Column(name = "itemAlsoIncludes")
    private String itemAlsoIncludes;

    @Column(name = "rulings")
    private String rulings;

    @Column(name = "itemExcludes")
    private String itemExcludes;

    @Column(name = "refToISIC")
    private String refToISIC;


}
