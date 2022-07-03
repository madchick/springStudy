package com.example.QueryDSLTest.Board.model;

import com.example.QueryDSLTest._comm_.model.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_board")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class BoardEntity extends BaseTimeEntity {

    @Id
    @Column(name="board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String boardName;

    private String boardDesc;

    private Boolean enabled;

}
