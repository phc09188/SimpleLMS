package com.zerobase.fastlms.history.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class History {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String userAgent;
    private String userIp;
    private LocalDateTime logDt;



}
