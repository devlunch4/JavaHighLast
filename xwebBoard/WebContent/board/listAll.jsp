<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
    List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
    %>

[
<%for(int i = 0; i < list.size(); i++){
    	
    	BoardVO vo = list.get(i);
    	if(i > 0){
    		out.print(",");
    	}
    	%>

{ "board_no": "<%=vo.getBoard_no()%>",
 "board_title" : "<%=vo.getBoard_title()%>",
 "board_writer" :"<%=vo.getBoard_writer()%>",
 "board_date" : "<%=vo.getBoard_date()%>",
 "board_cnt" : "<%=vo.getBoard_cnt() %>",
 "board_content" : "<%=vo.getBoard_content().replaceAll("\r","").replaceAll("\n","<br>") %>"
}


<% }  %>

]
