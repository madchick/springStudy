package com.example.QueryDSLTest.Post.repository;

import com.example.QueryDSLTest.Board.model.QBoardEntity;
import com.example.QueryDSLTest.Comment.model.QCommentEntity;
import com.example.QueryDSLTest.Post.model.PostBoardEntity;
import com.example.QueryDSLTest.Post.model.QPostBoardEntity;
import com.example.QueryDSLTest.Post.model.QPostEntity;
import com.example.QueryDSLTest.User.model.QUserEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostBoardQDSLRepositoryImpl implements PostBoardQDSLRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public PostBoardQDSLRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }



    QPostBoardEntity postBoard = QPostBoardEntity.postBoardEntity;
    QBoardEntity board = QBoardEntity.boardEntity;
    QPostEntity post = QPostEntity.postEntity;
    QUserEntity user = QUserEntity.userEntity;
    QCommentEntity comment = QCommentEntity.commentEntity;

    private BooleanExpression eqName(String name) {
        if(StringUtils.isNullOrEmpty(name))
            return null;
        return user.name.eq(name);
    }



    @Override
    // @Transactional(readOnly = true)
    public List<PostBoardEntity> findPostBoardAllByBoardIdQDSL(Long boardId) {
/*
        BooleanBuilder builder = new BooleanBuilder();

        if(!StringUtils.isNullOrEmpty(name))
            builder.and(acamemy.name.eq(name));
        .where(builder)
*/
        return jpaQueryFactory
                .selectFrom(postBoard)
                .innerJoin(postBoard.boardEntity, board)
                .fetchJoin()
                .innerJoin(postBoard.postEntity, post)
                .fetchJoin()
                .innerJoin(post.userEntity, user)
                .fetchJoin()
                .innerJoin(post.commentEntities, comment)
                .fetchJoin()
                .innerJoin(comment.userEntity, user)
                .fetchJoin()
                .fetch();
    }

    @Override
    public PageImpl<PostBoardEntity> findPostBoardAllByBoardIdQDSLWithPaging(Long boardId, Pageable pageable) {
        List<PostBoardEntity> postBoardEntities = jpaQueryFactory
                .selectFrom(postBoard)
                .innerJoin(postBoard.boardEntity, board)
                .fetchJoin()
                .innerJoin(postBoard.postEntity, post)
                .fetchJoin()
                .innerJoin(post.userEntity, user)
                .fetchJoin()
                .innerJoin(post.commentEntities, comment)
                .fetchJoin()
                .innerJoin(comment.userEntity, user)
                .fetchJoin()
                .where(
                        postBoard.boardId.eq(boardId)
                )
                .orderBy(postBoard.createdDate.desc().nullsLast())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long totalCount = jpaQueryFactory
                .select(postBoard.count())
                .from(postBoard)
                .where(
                        postBoard.boardId.eq(boardId)
                )
                .fetchOne();

        return new PageImpl<>(postBoardEntities, pageable, totalCount);
    }

}
