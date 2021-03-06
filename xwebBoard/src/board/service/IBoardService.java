package board.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface IBoardService {

	// load all content finish
	public List<BoardVO> listAll();

	// save post finish
	public int insertBoard(BoardVO vo);

	// delete post
	public int deleteBoard(int seq);

	// modify post
	public int updateBoard(BoardVO vo);

	// read count update
	public int updatecountBoard(BoardVO vo);

}
