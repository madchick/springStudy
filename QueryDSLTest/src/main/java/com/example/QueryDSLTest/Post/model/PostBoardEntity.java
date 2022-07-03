package com.example.QueryDSLTest.Post.model;

import com.example.QueryDSLTest.Board.model.BoardEntity;
import com.example.QueryDSLTest._comm_.model.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_post_board")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
@IdClass(PostBoardKey.class)
public class PostBoardEntity extends BaseTimeEntity {

    @Id
    @Column(name="board_id", updatable=false)
    private Long boardId;

    @Id
    @Column(name="post_id", updatable=false)
    private Long postId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id", insertable=false, updatable=false)
    private BoardEntity boardEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", insertable=false, updatable=false)
    private PostEntity postEntity;

}
