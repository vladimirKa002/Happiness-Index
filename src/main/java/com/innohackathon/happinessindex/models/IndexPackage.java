package com.innohackathon.happinessindex.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="indexes")
public class IndexPackage{
    @Id
    private Long id;
    private Integer work;
    private Integer hobby;
    private Integer love;
    private Integer friends;
    private Integer money;
    private Integer health;
}