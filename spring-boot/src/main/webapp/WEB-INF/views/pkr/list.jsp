<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 목록</title>
<script>
$(document).ready(function(){
	$("#btnWrite").click(function(){
		// 페이지 주소 변경(이동)
		location.href = "${path}/pkr/write.do";
	});
});
// 원하는 페이지로 이동시 검색조건, 키워드 값을 유지하기 위해 
function list(page){
	location.href="${path}/board/list.do?curPage="+page+"&searchOption-${map.searchOption}"+"&keyword=${map.keyword}";
}
</script>
</head>
<body>

	<%@ include file="header.jsp" %>
	<h2>게시글 목록</h2>
	<form name="form1" method="post" action="${path}/pkr/list.do">
		<select name="searchOption">
			<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
			<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >제목+이름+제목</option>
			<option value="member_name" <c:out value="${map.searchOption == 'member_name'?'selected':''}"/> >이름</option>
			<option value="contents" <c:out value="${map.searchOption == 'contents'?'selected':''}"/> >내용</option>
			<option value="title" <c:out value="${map.searchOption == 'title'?'selected':''}"/> >제목</option>
		</select>
		<input name="keyword" value="${map.keyword}">
		<input type="submit" value="조회">
	<!-- 로그인한 사용자만 글쓰기 버튼을 활성화 -->
	<c:if test="${sessionScope.memberId != null}">
		<button type="button" id="btnWrite">글쓰기</button>
	</c:if>
	</form>
	
	
	<!-- 레코드의 갯수를 출력 -->
	${map.count}개의 게시물이 있습니다.
	<table border="1" width="600px">
		<tr> <!--table row -->
			<th>번호</th>   <!--table header-->
			<th>제목</th>
			<th>이름</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	
	<c:forEach var="row" items="${map.list}"> <!-- list에 담겨있는 객체들을 화면에 보여줌(boardController에서 map에 담음)-->
	 <!--  var, items 필수로 작성해야 함. 
	 var의 경우는 items에 담겨있는 List 객체를 변수를 통하여 화면에 보여줌 -->
		<c:choose>
			<c:when test="${row.show == 'y'}">
		<!-- show 컬럼이 y일때 -->
		<tr><!--table 가로줄  -->
			<td>${row.boardNo}</td>  <!--table data ---table column --> <!-- 번호 -->
			<!-- 게시글 상세보기 페이지로 이동시 게시글 목록페이지에 있는 검색조건, 키워드, 현재페이지 값을 유지하기 위해 -->
			<td>
				<a href="${path}/pkr/view.do?boardNo=${row.boardNo}&curPage=${map.board.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}">${row.title} 
					<!-- ** 댓글이 있으면 게시글 이름 옆에 출력하기 -->
					<c:if test="${row.recnt > 0}">
						<span style="color: red;">(${row.recnt})
						</span>
					</c:if> <!-- 제목 -->
				</a>
			</td>
			<td>${row.memberName}</td> <!-- 이름 -->
			<td>
				<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
				<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> <!-- 작성일 -->
			</td>
			<td>${row.viewCount}</td> <!-- 조회수 -->
		</tr>
			</c:when>
			<c:otherwise>
			
			
		<!-- show 컬럼이 n일때(삭제된 글) -->
		<tr>
			<td colspan="5" align="left">
				<c:if test="${row.recnt > 0}">
					<a href="${path}/pkr/view.do?boardNo=${row.boardNo}&curPage=${map.board.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}">삭제된 게시물입니다.
					<!-- ** 댓글이 있으면 게시글 이름 옆에 출력하기 -->
						<span style="color: red;">(${row.recnt})
						</span>
					</a>
				</c:if>
				<c:if test="${row.recnt == 0 }">
					삭제된 게시물입니다.
				</c:if>	
			</td>
		</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
		
		<!-- 페이징 -->
		<tr>
			<td colspan="5">
				<!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
				<c:if test="${map.board.curBlock > 1}">
					<a href="javascript:list('1')">[처음]</a>
				</c:if>
				
				<!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
				<c:if test="${map.board.curBlock > 1}">
					<a href="javascript:list('${map.board.prevPage}')">[이전]</a>
				</c:if>
				
				<!-- **하나의 블럭 시작페이지부터 끝페이지까지 반복문 실행 -->
				<c:forEach var="num" begin="${map.board.blockBegin}" end="${map.board.blockEnd}">
					<!-- 현재페이지이면 하이퍼링크 제거 -->
					<c:choose>
						<c:when test="${num == map.board.curPage}">
							<span style="color: red">${num}</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:list('${num}')">${num}</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
				<c:if test="${map.board.curBlock <= map.board.totBlock}">
					<a href="javascript:list('${map.board.nextPage}')">[다음]</a>
				</c:if>
				
				<!-- 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
				<c:if test="${map.board.curPage <= map.board.totPage}">
					<a href="javascript:list('${map.board.totPage}')">[끝]</a>
				</c:if>
			</td>
		</tr>
		<!-- 페이징 -->
</table>


</body>
</html>