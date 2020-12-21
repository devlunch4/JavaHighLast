// all list get and expression
var boardlist = function() {

	$.ajax({
	url : "/xwebBoard/list.do",
	type : "post",
	dataType : "json",
	success : function(res) {
		alert("게시글을 불러옵니다");
		code = "<div class='allList'>";
		code += "<h1>게시글 전체 리스트</h1>";
		code += "<table border='1'>";
		code += "<tr><th>글번호</th><th>글제목</th><th>작성자</th><th>작성날짜</th><th>조회수</th><th>내용</th></tr>";
		code += "<tr><th>BOARD_NO</th><th>BOARD_TITLE</th><th>BOARD_TITLE</th><th>BOARD_TITLE</th><th>BOARD_TITLE</th><th>BOARD_TITLE</th></tr>";

		$.each(	res, function(i, v) {
						console.log(v.board_no);
						code += "<tr>";
						code += "<td>" + v.board_no + "</td>";
						code += "<td>" + v.board_title + "</td>";
						code += "<td>" + v.board_writer	+ "</td>";
						code += "<td>" + v.board_date + "</td>";
						code += "<td>" + v.board_cnt + "</td>";
						code += "<td>" + v.board_content + "</td>";
						code += "<td><button type='button' class='action' idx='"+ v.board_no + "' name='글보기'>글보기</button>";
						code += "<td><button type='button' class='action' idx='"+ v.board_no + "' name='수정'>수정</button>";
						code += "<button type='button' class='action' idx='" + v.board_no	+ "' name='삭제'>삭제</button></td>";
						code += "</tr>";
						})
		code += "</table>";				
		code += "</div>";
		$(".showlist").html(code);
		
	},
	error : function(xhr) {
		alert("게시글 불러오기 실패 상태 : " + xhr.status);
	}
})
}

//When clicking the post completion button >> Send insert
var boardsaveserver = function() {
	$.ajax({
		url : "/board/boardSave.do",
		data : $("#wform").serializeJSON(),
		type : "post",
		dataType : "json",
		success : function(res) {
			alert("게시글 작성 성공" + res.sw);
			window.location.reload();
		},
		error : function(xhr) {
			alert("게시글 작성 실패 : " + xhr.status);
		}
	})
	
}

