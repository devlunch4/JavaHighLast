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
 * Servlet implementation class BoardSave
 */
@WebServlet("/boardSave.do")
public class BoardSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardSave() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
System.out.println("글작성 1");
		// 0. getdata
		String board_title = request.getParameter("board_title");
		String board_writer = request.getParameter("board_writer");
		String board_content = request.getParameter("board_content");

		System.out.println("글작성 2");
		BoardVO vo = new BoardVO();

		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		vo.setBoard_content(board_content);

		//vo.setWip(request.getRemoteAddr()); // get client IP this project not need.

		// 1
		System.out.println("글작성 3");
		IBoardService service = BoardServiceImpl.getService();
		System.out.println("글작성 4");
		// 2.
		int seq = service.insertBoard(vo);
		System.out.println("글작성 5");
		// 3
		request.setAttribute("result", seq);
		System.out.println("글작성 6");
		// 4
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}

}
