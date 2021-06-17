package com.kokoa.acait.vo;

public class CommentVO extends RateVO{
	/*
	 * CREATE TABLE `tb_comment` (
	 `CMT_NO` INT(11) NOT NULL AUTO_INCREMENT COMMENT '댓글번호',
	 `UPPER_CMT_NO` INT(11) NULL DEFAULT NULL COMMENT '상위 댓글 번호',
	 `BOARD_NO` INT(11) NOT NULL COMMENT '게시판번호',
	 `CONTENT` VARCHAR(1000) NULL DEFAULT NULL COMMENT '내용' COLLATE 'utf8_general_ci',
	 `PWD` VARCHAR(100) NOT NULL COMMENT '비밀번호' COLLATE 'utf8_general_ci',
	 `DEL_YN` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제여부' COLLATE 'utf8_general_ci',
	 `REG_DATE` DATE NOT NULL COMMENT '등록일시',
	 `UPDT_DATE` DATE NULL DEFAULT NULL COMMENT '수정일시',
	 PRIMARY KEY (`CMT_NO`) USING BTREE,
	 INDEX `FK_COMMENT` (`BOARD_NO`) USING BTREE,
	 CONSTRAINT `FK_COMMENT` FOREIGN KEY (`BOARD_NO`) REFERENCES `acait`.`tb_board` (`BOARD_NO`) ON UPDATE RESTRICT ON DELETE RESTRICT
	)
	COMMENT='댓글 테이블'
	COLLATE='utf8_general_ci'
	ENGINE=InnoDB
	;
	 */
  private int cmtNo;
  private int upperCmtNo;
  private int boardNo;
  private String content;
  private String pwd;
  private String delYn;  
  private String regDate;
  private String updtDate;
  
  
	public int getCmtNo() {
		return cmtNo;
	}
	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}
	public int getUpperCmtNo() {
		return upperCmtNo;
	}
	public void setUpperCmtNo(int upperCmtNo) {
		this.upperCmtNo = upperCmtNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUpdtDate() {
		return updtDate;
	}
	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
	}
  
}