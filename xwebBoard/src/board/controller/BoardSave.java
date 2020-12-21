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

		// 0. getdata
		String btitle = request.getParameter("btitle");
		String bwriter = request.getParameter("bwriter");
		String bcontent = request.getParameter("bcontent");

		BoardVO vo = new BoardVO();

		vo.setBoard_title(btitle);
		vo.setBoard_writer(bwriter);
		vo.setBoard_content(bcontent);

		//vo.setWip(request.getRemoteAddr()); // get client IP this project not need.

		// 1

		IBoardService service = BoardServiceImpl.getService();

		// 2.
		int seq = service.insertBoard(vo);

		// 3
		request.setAttribute("result", seq);

		// 4
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}

}
