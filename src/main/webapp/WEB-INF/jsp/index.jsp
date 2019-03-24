<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>SJB</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">SJB</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">All Books</a></li>
				<li><a href="#">New Book</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<c:choose>
			<c:when test="${mode == 'book_view'}">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Book Name</th>
							<th>Author</th>
							<th>Purchase Date</th>
							<th>Update</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td>${book.id}</td>
								<td>${book.bookName}</td>
								<td>${book.author}</td>
								<td>${book.purchaseDate}</td>
								<td><a href="updateBook?id=${book.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		
			<c:when test="${mode == 'book_update'}">
				<form action="save" method="post">
					<input type="hidden" value="${book.id}" class="form-control" id="id" name="id">
				    <div class="form-group">
				      <label for="bookName">Book Name:</label>
				      <input type="text" value="${book.bookName}" class="form-control" id="bookName" placeholder="Enter book name" name="bookName">
				    </div>
				    <div class="form-group">
				      <label for="author">Author:</label>
				      <input type="text" value="${book.author}" class="form-control" id="author" placeholder="Enter Author" name="author">
				    </div>
				    <div class="checkbox">
				      <label for="purchaseDate">Purchase Date:</label>
				      <input type="date" value="${book.purchaseDate}" class="form-control" id="purchaseDate" placeholder="Enter Purchase Date" name="purchaseDate">
				    </div>
				    <button type="submit" class="btn btn-default">Submit</button>
			  	</form>
			</c:when>
		</c:choose>
	</div>
</body>
</html>
