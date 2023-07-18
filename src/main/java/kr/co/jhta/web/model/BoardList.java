package kr.co.jhta.web.model;

import java.util.List;

import kr.co.jhta.dto.Pagination;
import kr.co.jhta.vo.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardList {

	private Pagination pagination;
	private List<Board> boards;
}
