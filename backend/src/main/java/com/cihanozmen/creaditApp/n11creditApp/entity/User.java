package com.cihanozmen.creaditApp.n11creditApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="USR_USER")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long identityNumber;
    private Long income;
    private Long phone;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private Long guarantee;
    private int creditScore;
    private Boolean creditStatus;
    private int amountCredit;
}
