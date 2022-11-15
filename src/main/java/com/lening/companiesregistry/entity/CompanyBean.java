package com.lening.companiesregistry.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_company")
public class CompanyBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cname;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datea;
    private String service;
    private String open;
}
