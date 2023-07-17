package kr.co.jhta.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.jhta.vo.Board;

@Mapper
public interface BoardDao {

	// 새 게시글 등록기능
	void insertBoard(Board board);
	
	// 게시글 목록 조회기능(페이징 처리 지원)
	List<Board> getBoards(Map<String, Object> param);
	
	// 게시글 번호로 게시글 조회하기
	Board getBoardByNo(int no);
	
	// 게시글 정보 변경하기(삭제 포함)
	void updateBoard(Board board);
}
