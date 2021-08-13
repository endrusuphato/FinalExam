<%--
  Created by IntelliJ IDEA.
  User: Endru
  Date: 2021-08-12
  Time: 4:40 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>



<head>
    <title>Category Page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        h1 {
            text-align: center;
            background-color: cyan;

        }

        .btn{
            width: 100%;
        }
    </style>
</head>
<body>
<h1>Savings Investment Record</h1>


<%--//personal note of the variables in savings java--%>
<%--//    private String custno;--%>
<%--//    private String custname;--%>
<%--//    private Double cdep;--%>
<%--//    private Integer nyears;--%>
<%--//    private String savtype;--%>
<%--<div class="container">--%>
    <form method="GET">

        <table class="table table-striped">


            <thead>
            <tr>
                <th>Customer Number</th>
                <th>Customer Name</th>
                <th>Customer Deposit</th>
                <th>Number of Years</th>
                <th>Savings Type</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">


                <tr>
                    <td>${todo.custno}</td>
                    <td>${todo.custname}</td>
                    <td>${todo.cdep}</td>
                    <td>${todo.nyears}</td>
                    <td>${todo.savtype}</td>
                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.custno}" >Edit</a> </td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="delete-todo?id=${todo.custno}" >Delete</a> </td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="see-todo?id=${todo.custno}" >Projected Invesment</a> </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>

        //add button
        <a class="btn btn-success" href="add-todo">Add</a>

    </form>
</div>


</body>
<script>
    function myFucntion(){
        document.getElementById("mes").innerHTML="";
    }
</script>

</html>
