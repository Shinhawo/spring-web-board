package kr.co.jhta.web.form;

import java.util.Date;

import kr.co.jhta.vo.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddBoardForm {

	private int no;
	private String title;
	private String content;
	private int readCount;
	private int reviewCount;
	private double reviewScore;
	private String deleted;
	private Date updateDate;
	private Date createDate;
	private User user;
	
	@Builder
	public AddBoardForm(int no, String title, String content, int readCount, int reviewCount, double reviewScore,
			String deleted, Date updateDate, Date createDate, User user) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.reviewCount = reviewCount;
		this.reviewScore = reviewScore;
		this.deleted = deleted;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.user = user;
	}
	
	
}
