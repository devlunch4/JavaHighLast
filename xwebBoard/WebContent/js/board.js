// all list get and expression
var boardlist = function() {

	$
			.ajax({
				url : "/xwebBoard/list.do",
				type : "post",
				dataType : "json",
				success : function(res) {
					alert("게시글을 불러옵니다");
					code = "<h1>게시글 전체 리스트</h1>";
					code += "<table class='tablex' border='1'>";
					code += "<tr><th>글번호</th><th>글제목</th><th>작성자</th><th>작성날짜</th><th>조회수</th><th>내용(글보기클릭)</th></tr>";
					code += "<tr><th>BOARD_NO</th><th>BOARD_TITLE</th><th>BOARD_WRITER</th><th>BOARD_DATE</th><th>BOARD_CNT</th><th>BOARD_CONTENT</th></tr>";
					$
							.each(
									res,
									function(i, v) {
										// console.log(v.board_no);
										code += "<tr class='trx'>";
										code += "<td>" + v.board_no + "</td>";
										code += "<td><span class='tspan'>"
												+ v.board_title
												+ "</span></td>";
										code += "<td><span class='nspan'>"
												+ v.board_writer
												+ "</span></td>";
										code += "<td><span class='datespan'>"
												+ v.board_date + "</span></td>";
										code += "<td><span class='countspan'>"
												+ v.board_cnt + "</span></td>";
										code += "<td>글보기 클릭<span style='display:none;' class='cspan'>"
												+ v.board_content
												+ "</span></td>";
										code += "<td><button type='button' class='action' idx='"
												+ v.board_no
												+ "'  class='action btn-info' name='show'>글보기</button>";
										code += "<td><button type='button' idx='"
												+ v.board_no
												+ "'  class='action btn-warning' name='modify'>수정</button>";
										code += "<button type='button' idx='"
												+ v.board_no
												+ "' class='action btn-danger' name='delete'>삭제</button></td>";
										code += "</tr></div>";
									})
					code += "</table>";
					code += "</div>";
					$(".box").html(code);

				},
				error : function(xhr) {
					alert("게시글 불러오기 실패 상태 : " + xhr.status);
				}
			})
}

// When clicking the post completion button >> Send insert
var boardSaveServer = function() {
	console.log($("#wform").serializeJSON());
	$.ajax({
		url : "/xwebBoard/boardSave.do",
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

// When clicking the delete post that liner.
var boardDeleteServer = function(but) { // [but] is delete button.
	alert("delete boardDeleteServer 진입");
	$.get("/xwebBoard/boardDelete.do", {
		"seq" : vidx
	}, function(res) {
		alert("게시글 삭제 >> " + res.sw);
		// 화면에서 지우기
		$(but).parents(".panel").remove();
	}, "json")
}

// modify post context
var boardUpdateServer = function() {// // [but] is modify(update) button.

	$.ajax({
		url : "/xwebBoard/boardUpdate.do",
		type : "post",
		data : board, // seq, writer, subject, content, password, mail
		success : function(res) {
			alert("boardUpdateServer 성공 >> " + res.sw);
			window.location.reload();

		},
		error : function(xhr) {
			alert("boardUpdateServer 실패 : " + xhr.status);
		},
		dataType : "json"
	})

}

//modify post count >> show detail next count up
var boardShowcountServer = function() {
	console.log("show vidx : " + vidx);
	console.log("show count : " + count);
	$.ajax({
		url : "/xwebBoard/boardUpdateCount.do",
		type : "post",
		data : {
			"vidx" : vidx,
			"count" : count
		},
		success : function(res) {
			alert("boardUpdateCount 성공 >> " + res.sw);
			window.location.reload();

		},
		error : function(xhr) {
			alert("boardUpdateServer 실패 : " + xhr.status);
		},
		dataType : "json"
	})
}
