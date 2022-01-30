package com.cihanozmen.creaditApp.n11creditApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private String name;
    private Long identityNumber;
    private Long income;
    private Long phone;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private Long guarantee;
    private int creditScore;
}
