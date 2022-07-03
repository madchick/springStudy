package com.example.QueryDSLTest.Comment.model;

import com.example.QueryDSLTest.User.model.UserEntity;
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
@Table(name="tb_comment")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class CommentEntity extends BaseTimeEntity {

    @Id
    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name="user_id", updatable=false)
    private Long userId;

    private String commentContent;

    private Boolean enabled;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private UserEntity userEntity;

}
