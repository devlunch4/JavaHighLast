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
	$(function name() {
		// load all content get.
		boardlist();

		// modify written board one.

		// delete written board one.

		//  written board btn click.
		$("#writebtn")
				.on(
						"click",
						function() {
							code = "<div class='boardwrite'>";
							code += "<form id='wform'>";

							code += "<label>글제목(title)</label><input class='txt' type='text' id='btitle' name='btitle'><br>";
							code += "<label>작성자(writter)</label><input class='txt' type='text' id='bwriter' name='bwriter'><br>";
							code += "<label>내용(contents)</label><br>";
							code += "<textarea class='txt' rows='10' cols='50' name='bcontent'></textarea><br>";
							code += "<input type='button' id=bsend' value='글작성완료(Writing completed)'><br>";

							code += "</form>";
							code += "</div><hr>";

							//$(".showlist").remove();
							//$(".showone").remove();
							$(".writeone").html(code);

						}) //  written board btn click. end line.

		// written done click
		$("#bsend").on("click", function() {
			boardsaveserver();
			window.location.reload();
		})

	})//script last line
</script>
<body>

	<h1>평가 과제1 게시판</h1>
	<input id="writebtn" type="button" value="게시글 작성">
	<hr>
	<div class="writeone"></div>
	<div class="showlist"></div>
	<div class="showone"></div>


</body>
</html>