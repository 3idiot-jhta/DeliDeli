package kr.co.jhta.app.delideli.user.board.service;

import kr.co.jhta.app.delideli.user.board.dto.CommentDTO;
import kr.co.jhta.app.delideli.user.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;

    //이벤트 댓글 삽입
    @Override
    public void getCommentsByBoardKey(CommentDTO commentDTO) {
        userRepository.addComment(commentDTO);

    }
    //이벤트 댓글 조회
    @Override
    public List<CommentDTO> getCommentAll(int boardKey) {
        List<CommentDTO> list = userRepository.getCommentAll(boardKey);
        return list;
    }
    //이벤트 댓글 수정
    @Override
    public void updateComment(CommentDTO commentDTO) {
        userRepository.updateComment(commentDTO);
    }
    //이벤트 댓글 삭제
    @Override
    public void deleteComment(int commentKey) {
        userRepository.deleteComment(commentKey);
    }
    //이벤트 댓글 답글삽입
    @Override
    public void insertReplyComment(CommentDTO commentDTO) {
        userRepository.insertReplyComment(commentDTO);
    }
}
