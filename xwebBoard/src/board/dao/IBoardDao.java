package board.dao;

import java.sql.SQLException;
import java.util.List;


import board.vo.BoardVO;


public interface IBoardDao {

	// load all content
	public List<BoardVO> listAll() throws SQLException;

	// save post
	public int insertBoard(BoardVO vo) throws SQLException;;

	// delete post
	public int deleteBoard(int seq) throws SQLException;;

	// modify post
	public int updateBoard(BoardVO vo) throws SQLException;;

	//read count update
	public int hitUpdate(int seq) throws SQLException;


}
