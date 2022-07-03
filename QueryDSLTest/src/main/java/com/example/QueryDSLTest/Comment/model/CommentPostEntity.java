package com.example.QueryDSLTest.Comment.model;

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
@Table(name="tb_comment_post")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
@IdClass(CommentPostKey.class)
public class CommentPostEntity extends BaseTimeEntity {

    @Id
    @Column(name="post_id", updatable=false)
    private Long postId;

    @Id
    @Column(name="comment_id", updatable=false)
    private Long commentId;

    private Long parentCommentId;

}
