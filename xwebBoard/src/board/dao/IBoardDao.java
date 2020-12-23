package board.dao;

import java.sql.SQLException;
import java.util.List;

import board.vo.BoardVO;

public interface IBoardDao {

	// load all content finish
	public List<BoardVO> listAll() throws SQLException;

	// save post finish
	public int insertBoard(BoardVO vo) throws SQLException;;

	// delete post
	public int deleteBoard(int seq) throws SQLException;;

	// modify post
	public int updateBoard(BoardVO vo) throws SQLException;;

	// read count update
	public int updatecountBoard(BoardVO vo) throws SQLException;

}
