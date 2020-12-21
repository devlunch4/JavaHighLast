package board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	// create
	private IBoardDao dao;
	private static IBoardService service;

	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}

	public static IBoardService getService() {
		if (service == null)
			service = new BoardServiceImpl();
		return service;
	}

	// load all content
	@Override
	public List<BoardVO> listAll() {
		List<BoardVO> list = null;
		try {
			list = dao.listAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// save post
	@Override
	public int insertBoard(BoardVO vo) {

		int seq = 0;
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seq;
	}

	// delete post
	@Override
	public int deleteBoard(int seq) {

		int cnt = 0;
		try {
			cnt = dao.deleteBoard(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	// modify post
	@Override
	public int updateBoard(BoardVO vo) {

		int cnt = 0;
		try {
			cnt = dao.updateBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	// read count update
	@Override
	public int hitUpdate(int seq) {
		int cnt = 0;

		try {
			cnt = dao.hitUpdate(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seq;
	}

}
