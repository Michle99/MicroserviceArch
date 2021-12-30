package com.company.entities;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Board {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer boardId;
    private String boardMemberName;
    private String boardMemberPosition;
   
    public Board() {}
    public Board(String boardMemberName, String boardMemberPosition){
        this.boardMemberName = boardMemberName;
        this.boardMemberPosition = boardMemberPosition;
    }

    @ManyToOne
	@JoinColumn(name="company_companyId")
    private Company company;

    public Company getCompany(){
        return company;
    }

    public void setCompany(Company company){
        this.company = company;
    }

    public Integer getBoardId(){
       return this.boardId;
   }
    public void setBoardId(Integer boardId){
       this.boardId = boardId;
   }
    public String getBoardMemberName(){
       return boardMemberName;
   }
    public void setBoardMemberName(String boardMemberName){
       this.boardMemberName = boardMemberName;
   }
    public String getboardMemberPosition(){
    return boardMemberPosition;
}
    public void setboardMemberPosition(String boardMemberPosition){
    this.boardMemberPosition = boardMemberPosition;
}

}
