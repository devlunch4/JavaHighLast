package board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.vo.BoardVO;
import ibatis.config.SqlMapClientFactory;

//SqlMapClient get
// myself return
public class BoardDaoImpl implements IBoardDao {

	// create
	private SqlMapClient client;
	private static IBoardDao dao;

	// create
	private BoardDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	// myself return
	public static IBoardDao getDao() {
		if (dao == null)
			dao = new BoardDaoImpl();
		return dao;
	}

	// load all content finish
	@Override
	public List<BoardVO> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.listAll");
	}

	// save post finish
	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) client.insert("board.insertBoard", vo);
	}

	// delete post
	@Override
	public int deleteBoard(int seq) throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("board.deleteBoard", seq);
	}

	// modify post
	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("board.updateBoard", vo);
	}

	//read count update
	@Override
	public int hitUpdate(int seq) throws SQLException {
		return client.update("board.hitUpdate", seq);
	}

}
