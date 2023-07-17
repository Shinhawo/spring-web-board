<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark border-bottom mb-3">
	<div class="container">
		<a class="navbar-brand" href="/">게시판</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" 
			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link ${menu eq '홈' ? 'active' : '' }" href="/">홈</a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${menu eq '게시판' ? 'active' : '' }" href="/post/list">게시판</a>
				</li>
			</ul>
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal" var="user"/>
				<span class="navbar-text me-5" ><strong class="text-white" >${user.email}님</strong>님 방가방가 ‪‧˚₊*̥(* ⁰̷̴͈꒳⁰̷̴͈ )‧˚₊*̥</span>				
			</sec:authorize>
			
			<ul class="navbar-nav">
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item">
						<a class="nav-link" href="/user/logout">로그아웃</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/info">내 정보 보기</a>
					</li>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<li class="nav-item">
						<a class="nav-link" href="/user/login">로그인</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/register">회원가입</a>
					</li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>