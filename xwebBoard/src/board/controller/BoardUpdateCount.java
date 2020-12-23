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
@WebServlet("/boardUpdateCount.do")
public class BoardUpdateCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardUpdateCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("boardUpdateCount.do 자바 진입 확인");
		request.setCharacterEncoding("UTF-8");

		// 0 writer, subject,mail,password,contet,seq
		// 가져와서 VO에 저장
		int board_no = Integer.parseInt(request.getParameter("vidx")); //게시글 번호 boardno
		int board_cnt = Integer.parseInt(request.getParameter("count")) + 1; // 게시글 조회수 count 

		BoardVO vo = new BoardVO();

		vo.setBoard_cnt(board_cnt);
		vo.setBoard_no(board_no);

		// 1
		IBoardService service = BoardServiceImpl.getService();
		// 2
		System.out.println("조회수 업데이트");
		int cnt = service.updatecountBoard(vo);
		// 3
		request.setAttribute("result", cnt);
		// 4
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}

}
