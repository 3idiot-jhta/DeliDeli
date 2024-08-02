package kr.co.jhta.app.delideli.user.board.service;

import kr.co.jhta.app.delideli.user.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    // 공지사항 목록
    List<BoardDTO> getBoardList(int startNo, int endNo);
    //공지사항 검색 목록
    List<BoardDTO> getAllKeyword(int startNo, int endNo, String keyword);
    //공지사항 총갯수
    int getTotalNotice();
    //공지사항 검색키워드 총갯수
    int getTotalKeyword(String keyword);
    //공지사항 상세보기
    BoardDTO readOneNotice(int num);

    //이벤트 목록
    List<BoardDTO> getEventList(int startNo, int endNo);
    //이벤트 상세보기
    BoardDTO readOneEvent(int num);
    //이벤트 총갯수
    int getTotalEvent();
    //이벤트 검색키워드 총갯수
    int getTotalKeywordEvent(String keyword);
    //이벤트 검색 목록
    List<BoardDTO> getAllKeywordEvent(int startNo, int endNo, String keyword);
}
