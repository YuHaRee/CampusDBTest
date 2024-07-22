package com.commit.dbtest1.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "camping_jpa")
@Getter
@Setter
public class CampingJpa {

    @Id
    private Long campId;
    private String campName;
    private String lineIntro;
    private String intro;
    private String doName;
    private String sigunguName;
    private String postCode;
    private String featureSummary;
    private String induty;
    private String addr;
    private String addrDetails;
    private Double mapX;
    private Double mapY;
    private String tel;
    private String homepage;
    private Integer staffCnt;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
