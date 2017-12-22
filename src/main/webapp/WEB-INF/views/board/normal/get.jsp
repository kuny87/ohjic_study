<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/index/common.jsp" flush="false" />	
	<title>Board</title>
	
	<style>
		table.content, th, td {
			border: 1px solid black;
		}
		
		table.content {
			width:60%;
			height:200px;
			margin:auto;
			text-align: center;
		}
		
		.reply {
			width:60%;
			margin:auto;
			text-align: center;
		}
		
		table.table_reply_regist {
			width:100%;
			margin:auto;
			text-align: center;
		}
		
		.hide {
			display: none;
		}
	</style>
</head>

<body>

<div>
	<h1 class="center">게시판</h1>
</div>

<div>
	
	<input type="hidden" id="boardSeq" name="boardSeq" value="${board.boardSeq}" />
	
	<div>
		<table class="content">
			<colgroup>
				<col width="15%" />
				<col width="65%" />
				<col width="20%" />
			</colgroup>
			<tbody>
				<tr>
					<td>제목</td>
					<td>
						<c:if test="${user.userSeq == board.regSeq}">
							<input type="text" id="title" name="title" style="width: 100%" value="${board.title}" />
						</c:if>
						<c:if test="${user.userSeq != board.regSeq}">
							<span>${board.title}</span>
						</c:if>
					</td>
					<td>조회수 : ${board.cnt}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="2">
						<c:if test="${user.userSeq == board.regSeq}">
							<textarea id="content" rows="10" cols="50" maxlength="6000" style="overflow:hidden; line-height: 14px; height: 60px; width: 100%;" title="내용">${board.content}</textarea>
						</c:if>
						<c:if test="${user.userSeq != board.regSeq}">
							<span>${board.content}</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="2">${board.name}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td colspan="2">${board.regDate}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="reply">
		<!-- 댓글 리스트 -->
		<div style="margin-top: 50px; text-align: left;">
			<span>댓글작성</span>
		</div>
		
		<c:if test="${board.boardReplyList.size() ne 0}">
			<c:forEach var="reply" items="${board.boardReplyList}" varStatus="status">
			<c:set var="seq" value="${reply.boardReplySeq}"></c:set>
				<c:if test="${reply.redepth ne 0}">
				<span style="float: left; margin-left: ${30*reply.redepth}px;">└</span>
				</c:if>
				<div style="margin-left: ${30*reply.redepth}px;">
					<table id="replyTable" class="table_reply" style="width: 600px; height: 70px;">
						<tr>
							<td>
								<div style="text-align: left;">
									<div>
										<fmt:parseDate value="${reply.regDate}" var="regDate" pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:formatDate value="${regDate}" var="rDate" pattern="yyyy.MM.dd HH:mm" />
										
										<span>${reply.regName }  </span>
										<span>${rDate }  </span>
										<c:if test="${reply.regSeq eq user.userSeq}">
											<a href="#" onclick="replyRemove('${reply.boardReplySeq}')">삭제</a>
				        					<a href="#" onclick="replyModify('${reply.boardReplySeq}')"><span id="modifySpan${seq}">수정</span></a>										
										</c:if>
				        				<a href="#" onclick="replyReply('${reply.boardReplySeq}')"><span class="rReplySpanClass" id="replySpan${seq}">댓글달기</span></a>
									</div>
									<div>
										<span id="replyContentSpan${seq}">${reply.replyContent }</span>
										<input type="text" style="display: none;" id="replyContentInput${seq}" value="${reply.replyContent }"/>
									</div>
									<div class="rReplyDiv" id="rReplyDiv${seq}" style="display: none;">
										<div style="float: left;">
											<textarea id="rReplyContent${seq}" rows="2" cols="50" maxlength="6000" style="overflow:hidden; line-height: 14px; height: 60px;" title="대댓글입력"></textarea>
										</div>
										<div style="margin-left: 30px; margin-top: 15px;">
											<button style="width: 10%; height: 100%;" onclick="rReplyRegist(${seq}, ${reply.redepth + 1})">등록</button>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr class="hide">
	                        <td colspan="2" class="reparent">${reply.reparent}</td>
	                    </tr>
	                    <tr class="hide">
	                        <td class="redepth">${reply.redepth}</td>
	                        <td class="reorder">${reply.reorder}</td>
	                    </tr>        
	                    <tr class="hide">
	                        <td colspan="2" class="boardReplySeq">${reply.boardReplySeq}</td>
	                    </tr>             
					</table>
				</div>
			</c:forEach>
		</c:if>
		<%-- <div id="formWrapper">            
            <form id="writeReplyForm">
                <input type="hidden" id="boardSeq" name="boardSeq" value="${board.boardSeq}" />
                <input type="hidden" id="redepth" name="depth" value="0" />
                <input type="hidden" id="reparent" name="reparent" value="0" />
                <input type="hidden" id="reorder" name="reorder" value="0" />
                <input type="hidden" id="boardReplySeq" name="boardReplySeq" value="0" />
            </form>
        </div> --%>
		<!-- 기본 댓글 입력 -->
		<table class="table_reply_regist reply_wrapper">
			<colgroup>
				<col width="15%" />
				<col width="65%" />
				<col width="20%" />
			</colgroup>
			<tbody>
				<tr>
					<td>
						<div>
							<span>${user.name}</span>
						</div>
					</td>
					<td>
						<div>
							<textarea id="replyContent" rows="2" cols="50" maxlength="6000" style="overflow:hidden; line-height: 14px; height: 60px;" title="댓글입력"></textarea>
						</div>
					</td>
					<td style="border: hidden;">
						<div>
							<button style="width: 100%; height: 80px;" onclick="replyRegist()">등록</button>
						</div>
					</td>
				</tr>
			</tbody>		
		</table>
	</div>
	
	<div class="center" style="margin-top: 50px;">
		<c:if test="${user.userSeq == board.regSeq}">
			<button onclick="modify()">수정</button>
			<button onclick="remove()">삭제</button>
		</c:if>
		<button onclick="list()">목록</button>
	</div>
	
</div>

<script>
	
	var boardSize = '${boardSearch.boardSize}';
	var startDate = '${boardSearch.startDate}'.substring(0,10);
	var endDate = '${boardSearch.endDate}'.substring(0,10);
	var searchType = '${boardSearch.searchType}';
	var keyword = '${boardSearch.keyword}';
	var pageNo = '${boardSearch.pageNo}';
	
	// 글목록
	function list() {
		if(startDate != '' && endDate != ''){
			location.href = '/test_ohjic/board_normal_list?startDate=' + startDate + '&endDate=' + endDate + '&searchType=' + searchType + '&keyword=' + keyword + '&boardSize=' + boardSize + '&pageNo=' + pageNo;
		}else {
			location.href = '/test_ohjic/board_normal_list?searchType=' + searchType + '&keyword=' + keyword + '&boardSize=' + boardSize + '&pageNo=' + pageNo;	
		}
	}
	
	// 글수정
	function modify() {

		var boardSeq = $('#boardSeq');
		var title = $('#title');
		var content = $('#content');
		
		$.ajax({
			dataType : 'json',
			url: "/test_ohjic/rest/board_modify",
			method : 'GET',
			data : {
			   "boardSeq" : boardSeq.val(),
			   "title" : title.val(),
			   "content" : content.val()
			}			
		}).done( function(result) {
			if (result.success) {
				alert("수정완료")
			}
		}).fail(function(result) {
			alert("수정실패")
		});
		
	}
	
	function remove() {
		
		var boardSeq = $('#boardSeq').val();
		
		$.ajax({
			dataType : 'json',
			url: "/test_ohjic/rest/board_remove",
			method : 'GET',
			data : {
			   "boardSeq" : boardSeq
			}			
		}).done( function(result) {
			if (result.success) {
				alert("삭제완료")
				location.href = "/test_ohjic/board_normal_list";
			}
		}).fail(function(result) {
			alert("삭제실패")
		});
		
	}
	
	// 댓글등록
	function replyRegist() {

		var userSeq = '${user.userSeq}';
		var boardSeq = $('#boardSeq').val();
		var replyContent = $('#replyContent').val();
		
		$.ajax({
			dataType : 'json',
			url: "/test_ohjic/rest/board_reply_regist",
			method : 'GET',
			data : {
			   "regSeq" : userSeq,
			   "boardSeq" : boardSeq,
			   "replyContent" : replyContent
			}			
		}).done( function(result) {
			if (result.success) {
				alert("등록완료")
				location.href = "/test_ohjic/board_normal_get?boardSeq=" + boardSeq;
			}
		}).fail(function(result) {
			alert("등록실패")
		});
	}
	
	// 댓글 삭제
	function replyRemove(boardReplySeq) {
		
		$.ajax({
			dataType : 'json',
			url: "/test_ohjic/rest/board_reply_remove",
			method : 'GET',
			data : {
			   "boardReplySeq" : boardReplySeq
			}			
		}).done( function(result) {
			if (result.success) {
				alert("삭제완료")
				location.reload();
			}
		}).fail(function(result) {
			alert("삭제실패")
		});
		
	}
	
	// 댓글 수정
	function replyModify(boardReplySeq) {
		
		var modifySpan = $('#modifySpan' + boardReplySeq);
		var replyContentSpan = $('#replyContentSpan' + boardReplySeq);
		var replyContentInput = $('#replyContentInput' + boardReplySeq);
		
		if(modifySpan.html() == '수정'){
			replyContentSpan.hide();
			replyContentInput.show();
			modifySpan.html('저장');
		} else {
			
			$.ajax({
				dataType : 'json',
				url: "/test_ohjic/rest/board_reply_modify",
				method : 'GET',
				data : {
				   "boardReplySeq" : boardReplySeq,
				   "replyContent" : replyContentInput.val()
				}			
			}).done( function(result) {
				if (result.success) {
					alert("수정완료")
					replyContentSpan.show();
					replyContentInput.hide();
					modifySpan.html('수정');
					replyContentSpan.html(replyContentInput.val());
				}
			}).fail(function(result) {
				alert("수정실패")
			});
			
		}
		
	}
	
	// 대댓글 작성
	function replyReply(seq) {
		
		var replySpan = $('#replySpan' + seq);
		var rReplyDiv = $('#rReplyDiv' + seq);
		var rReplyDivClass = $('.rReplyDiv');
		var rReplySpanClass = $('.rReplySpanClass');
		
		if(replySpan.html() == '댓글달기'){
			rReplySpanClass.html('댓글달기');
			replySpan.html('댓글취소');
			rReplyDivClass.hide();
			rReplyDiv.show();
		} else {
			replySpan.html('댓글달기');
			rReplyDivClass.hide();
		}
		
	}
	
	// 대댓글 등록
	function rReplyRegist(seq, redepth) {
		
		var userSeq = '${user.userSeq}';
		var boardSeq = $('#boardSeq');
		var rReplyContent = $('#rReplyContent' + seq);
		
		$.ajax({
			dataType : 'json',
			url: "/test_ohjic/rest/board_reply_regist",
			method : 'GET',
			data : {
			   "boardSeq" : boardSeq.val(),
			   "regSeq" : userSeq,
			   "replyContent" : rReplyContent.val(),
			   "reparent" : seq,
			   "redepth" : redepth
			}			
		}).done( function(result) {
			if (result.success) {
				alert("등록완료")
				location.reload();
			}
		}).fail(function(result) {
			alert("등록실패")
		});
		
	}
	
    
</script>
</body>
</html>
