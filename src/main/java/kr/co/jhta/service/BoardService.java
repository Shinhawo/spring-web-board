package kr.co.jhta.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.BoardDao;
import kr.co.jhta.dto.Pagination;
import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.User;
import kr.co.jhta.web.form.AddBoardForm;
import kr.co.jhta.web.model.BoardList;

@Service
public class BoardService {

	@Autowired 
	private BoardDao boardDao;
	
	// 새 게시글 등록하기
	public void createBoard(AddBoardForm form) {
		Board board = new Board();
		BeanUtils.copyProperties(form, board);
		
		User user = new User(form.getUser().getNo());
		
		boardDao.insertBoard(board);
	}
	
	// 게시글 목록 조회하기 (페이징처리 포함)
	public BoardList getBoards(Map<String, Object> param) {
		
		int totalRows = boardDao.getTotalRows(param);
		
		int page = (int) param.get("page");
		int rows = (int) param.get("rows");
		Pagination pagination = new Pagination(rows, page, totalRows);
		
		int begin = pagination.getBegin();
		int end = pagination.getEnd();
		
		param.put("begin", begin);
		param.put("end", end);
		
		BoardList result = new BoardList();
		List<Board> boards = boardDao.getBoards(param);
		
		result.setPagination(pagination);
		result.setBoards(boards);
		
		return result;
	}
	
	// 게시글 정보 수정하기
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	
	// 상세정보
	public Board getBoardByNo(int boardNo) {
		return boardDao.getBoardByNo(boardNo);
	}
	
	
}
