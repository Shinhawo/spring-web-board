<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>애플리케이션</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="border bg-light p-2 fs-4">게시글 상세정보</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<p>게시글 상세정보를 확인하세요.</p>
			<table class="table border ">
				<tbody>
					<tr>
						<td colspan="4" class="text-center">게시글 상세정보가 존재하지 않습니다.</td>
					</tr>
					<tr>
						<th class="table-secondary" style="width: 15%;">제목</th>
						<td colspan="3" style="widows: 85%;">연습입니다.</td>
					</tr>
					<tr>
						<th class="table-secondary" style="width: 15%;">번호</th>
						<td style="width: 35%;">100</td>
						<th class="table-secondary" style="width: 15%;">작성자</th>
						<td style="width: 35%;">hong@gmail.com</td>
					</tr>
					<tr>
						<th class="table-secondary">조회수</th>
						<td>30</td>
						<th class="table-secondary">댓글수</th>
						<td>10</td>
					</tr>
					<tr>
						<th class="table-secondary">등록일</th>
						<td>2023년 1월 1일</td>
						<th class="table-secondary">최종수정일</th>
						<td>2023년 1월 2일</td>							
					</tr>
					<tr>
						<th class="table-secondary">내용</th>
						<td colspan="3">
							내용입니다.
							내용입니다.
							내용입니다.
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<a href="modify?no=10" class="btn btn-warning btn-sm" >수정</a>
				<a href="delete?no=10" class="btn btn-danger btn-sm">삭제</a>
				<a href="list?page=2" class="btn btn-primary btn-sm float-end">목록</a>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>