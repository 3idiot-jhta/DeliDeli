package kr.co.jhta.app.delideli.user.board.service;

import kr.co.jhta.app.delideli.user.board.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    //이벤트 댓글 삽입
    void getCommentsByBoardKey(CommentDTO commentDTO);
    //이벤트 댓글 조회
    List<CommentDTO> getCommentAll(int boardKey);
    //이벤트 댓글 수정
    void updateComment(CommentDTO commentDTO);
    //이벤트 댓글 삭제
    void deleteComment(int commentKey);
    //이벤트 댓글 답글삽입
    void insertReplyComment(CommentDTO commentDTO);
}
