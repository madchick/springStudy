package com.example.QueryDSLTest.Post.model;

import com.example.QueryDSLTest.Board.model.BoardEntity;
import com.example.QueryDSLTest.Comment.model.CommentEntity;
import com.example.QueryDSLTest.User.model.UserEntity;
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
@Table(name="tb_post")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class PostEntity extends BaseTimeEntity {

    @Id
    @Column(name="post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name="user_id", updatable=false)
    private Long userId;

    private String postTitle;

    private String postContent;

    private Boolean enabled;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tb_comment_post",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="comment_id"))
    private List<CommentEntity> commentEntities;

}
