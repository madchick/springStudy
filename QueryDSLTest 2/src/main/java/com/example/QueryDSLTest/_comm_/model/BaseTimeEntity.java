package com.haksik.haksikapi._comm_.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
public class BaseTimeEntity {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdDate;

    @JsonIgnore
    private LocalDateTime modifiedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }

}