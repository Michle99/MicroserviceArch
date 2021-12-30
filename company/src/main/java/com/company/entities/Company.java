package com.company.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long companyId;
	private String companyName;
	private Double turnover;
	private String ceo;
//	private List<String> board;
	private boolean isListed;
	private String sector;
	private String writeup;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Board> boards;

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getTurnover() {
		return turnover;
	}
	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
//	public List<String> getBoard() {
//		return board;
//	}
//	public void setBoard(List<String> board) {
//		this.board = board;
//	}
	public boolean isListed() {
		return isListed;
	}
	public void setListed(boolean isListed) {
		this.isListed = isListed;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getWriteup() {
		return writeup;
	}
	public void setWriteup(String writeup) {
		this.writeup = writeup;
	}

}
