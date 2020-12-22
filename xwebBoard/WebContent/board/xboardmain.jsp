<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>평가 과제1 게시판</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../js/board.js"></script>
<script src="../js/jquery.serializejson.min.js"></script>
<style>
label {
	width: 100px;
}

.boardwrite {
	margin-left: 10%;
}
</style>
</head>
<script type="text/javascript">
	$(function() {
		// load all content get.
		boardlist();

		// modal write
		$("#wsend").on("click", function() {
			console.log($("#wform").serializeJSON());
			boardSaveServer();
			//모달창 닫기
			$("#modal").modal("hide");
			$("#wform .txt").val("")
		})

		$(".box").on("click", ".action", function() {
			vidx = $(this).attr("idx");
			vname = $(this).attr("name");

			if (vname == "modify") {
				alert(vidx + " 번 글 수정");
				$("#uModal").modal("show");

				///////////////////////////////////////////////////////
				// modify select part show. at modify modal.
				pbody = $(this).parents(".trx");
				name = $(pbody).find(".nspan").text(); //이름
				//$(pbody).find(".hspan").text(); //조회수
				//$(pbody).find(".wspan").text(); //날짜 */
				cont = $(pbody).find(".cspan").html(); //내용
				cont = cont.replace(/<br>/g, "\n");
				title = $(pbody).find(".tspan").text(); //제목
				console.log("내용 보기>>  " +cont);
				/////////////////////////////
				//uform에 show. print.
				$("#uform #board_writer").val(name);
				$("#uform #board_title").val(title);
				$("#uform #board_content").val(cont);

			} else if (vname == "delete") {
				alert(vidx + " 번 글 삭제");
				//boardDeleteServer(this);
			}
		})

	})//script last line
</script>
<body>

	<h1>평가 과제1 게시판</h1>
	<input data-toggle="modal" data-target="#wModal" type="button"
		value="글쓰기" id="write">

	<div class="box"></div>
	<div class="showone"></div>

	<!-- 글 작성 Modal 모달 -->
	<div id="wModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>

				<!-- 모달 바디부분을 수정한다. . -->
				<div class="modal-body">
					<form id="wform">
						<!-- 일렬을 맞추기 위해 label을 사용 -->
						<label>제목</label><input class="txt" type="text" id="board_title"
							name="board_title"><br>
						<!--  -->
						<label>작성자</label><input class="txt" type="text" id="board_writer"
							name="board_writer"><br>
						<!--  -->
						<label>내용 </label><br>
						<textarea class="txt" rows="10" cols="50" id="board_content" name="board_content"></textarea>
						<br> <input type="button" id="wsend" value="작성 확인 완료"><br>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<!-- 글 수정 Modal 모달 -->
	<div id="uModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>

				<!-- 모달 바디부분을 수정한다. . -->
				<div class="modal-body">
					<form id="uform">
						<!-- 일렬을 맞추기 위해 label을 사용 -->
						<label>제목</label><input class="txt" type="text" id="board_title"
							name="board_title"><br>
						<!--  -->
						<label>작성자</label><input class="txt" type="text" id="board_writer"
							name="board_writer"><br>
						<!--  -->
						<label>내용 </label><br>
						<textarea class="txt" rows="10" cols="50" id="board_content" name="board_content"></textarea>
						<br> <input type="button" id="usend" value="수정 확인 완료"><br>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>



</body>
</html>