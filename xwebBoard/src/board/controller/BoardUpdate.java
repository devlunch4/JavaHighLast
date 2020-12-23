package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/boardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("boardupdate.do 자바 진입 확인");
		request.setCharacterEncoding("UTF-8");

		// 0 writer, subject,mail,password,contet,seq
		// 가져와서 VO에 저장

		String board_writer = request.getParameter("board_writer");
		String board_title = request.getParameter("board_title");
		int seq = Integer.parseInt(request.getParameter("seq"));
		String board_content = request.getParameter("board_content");

		BoardVO vo = new BoardVO();

		vo.setBoard_writer(board_writer);
		vo.setBoard_title(board_title);
		vo.setSeq(seq);
		vo.setBoard_content(board_content);

		// 1
		IBoardService service = BoardServiceImpl.getService();
		// 2
		System.out.println("게시글 수정 업데이트 SQL문 전송");
		int cnt = service.updateBoard(vo);
		// 3
		request.setAttribute("result", cnt);
		// 4
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}

}
