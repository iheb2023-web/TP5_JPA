<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Confirmation Ajout Sport</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@ include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout Sport
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" name="idSport" class="form-control" value="${sport.idSport }"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Nom Sport :</label>
                    <input type="text" name="nomSport" class="form-control" value="${sport.nomSport }"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Description :</label>
                    <input type="text" name="description" class="form-control" value="${sport.description }"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Date Fondation :</label>
                    <input type="text" name="dateFondation" class="form-control" value="${sport.dateFondation }"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
