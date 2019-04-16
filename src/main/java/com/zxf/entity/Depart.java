package com.zxf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;


@Table(name = "ems_depart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depart {
    private Integer d_id;
    private String  d_name;
    private String  d_des;
}
