package com.example.QueryDSLTest._comm_.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@MappedSuperclass
public class BaseResponse {

    @Builder.Default private String timestamp = LocalDateTime.now().toString();
    private String status;
    private String error;
    private String path;

}
