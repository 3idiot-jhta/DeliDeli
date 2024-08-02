package kr.co.jhta.app.delideli.user.board.service;

import kr.co.jhta.app.delideli.user.board.dto.BoardDTO;
import kr.co.jhta.app.delideli.user.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final UserRepository userRepository;

    // 공지사항 목록
    @Override
    public List<BoardDTO> getBoardList(int startNo, int endNo) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startNo", startNo);
        map.put("endNo", endNo);
        List<BoardDTO> list = userRepository.getAll(map);
        return list;
    }

    //공지사항 검색키워드 리스트
    @Override
    public List<BoardDTO> getAllKeyword(int startNo, int endNo, String keyword) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("keyword", keyword);
        map.put("startNo", startNo);
        map.put("endNo", endNo);
        List<BoardDTO> list = userRepository.getAllKeyword(map);
        return list;
    }

    //공지사항 총갯수
    @Override
    public int getTotalNotice() {
        return userRepository.getTotalNotice();
    }

    //공지사항 검색키워드 총갯수
    @Override
    public int getTotalKeyword(String keyword) {
        return userRepository.getTotalKeyword(keyword);
    }

    //공지사항 상세보기
    @Override
    public BoardDTO readOneNotice(int num) {
        BoardDTO dto = userRepository.getOneNotice(num);
        return dto;
    }

    //이벤트 목록
    @Override
    public List<BoardDTO> getEventList(int startNo, int endNo) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startNo", startNo);
        map.put("endNo", endNo);
        List<BoardDTO> list = userRepository.getEventList(map);
        return list;
    }

    //이벤트 상세보기
    @Override
    public BoardDTO readOneEvent(int num) {
        BoardDTO dto = userRepository.readOneEvent(num);
        return dto;
    }

    //이벤트 총갯수
    @Override
    public int getTotalEvent() {
        return userRepository.getTotalEvent();
    }

    //이벤트 검색키워드 총갯수
    @Override
    public int getTotalKeywordEvent(String keyword) {
        return userRepository.getTotalKeywordEvent(keyword);
    }

    //이벤트 검색 목록
    @Override
    public List<BoardDTO> getAllKeywordEvent(int startNo, int endNo, String keyword) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("keyword", keyword);
        map.put("startNo", startNo);
        map.put("endNo", endNo);
        List<BoardDTO> list = userRepository.getAllKeywordEvent(map);
        return list;
    }

    
}
