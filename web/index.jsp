<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2020/3/3
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>个人图书馆管理</title>
  </head>
  <style>
      *{
          margin: 0;
          padding: 0;
      }
      div{
          margin: auto;
          text-align: center;
      }
      a{
          text-decoration: none;
      }
      p a{
          color: red;
      }
      td a{
          color: dodgerblue;
      }

      tr:nth-child(2n){
          background-color:lightskyblue;
      }
      tr:first-child{
          background:deepskyblue;
      }
  </style>
  <body>
  <script src="js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
      function del(id) {
          var flag=confirm("确认删除这本书吗？");
          var id2="#"+id;
          if (flag==true){
              $(function(){
                  $.ajax({
                      url:"DelServlet?opr=del",
                      data:"id="+id,
                      dataType:"text",
                      type:"POST",
                      success:function(){
                          $(id2).parent().parent().remove();
                      },
                      error:function () {
                        alert(2)
                      }
                  });
              });
          }
      }
  </script>
  <div>
  <h3>图书信息</h3>
  <table  border="1px">
      <tr>
          <td>图书名称</td>
          <td>图书作者</td>
          <td>购买时间</td>
          <td>图书分类</td>
          <td>操作</td>
      </tr>
        <c:forEach items="${requestScope.list}" var="i">
      <tr>
          <td>${i.name}</td>
          <td>${i.author}</td>
          <td>${i.time}</td>
          <td>
              <c:choose>
                  <c:when test="${i.type==0}">选择所属分类</c:when>
                  <c:when test="${i.type==1}">计算机/软件</c:when>
                  <c:when test="${i.type==2}">小说/文摘</c:when>
                  <c:when test="${i.type==3}">杂类</c:when>
              </c:choose>
          </td>
          <td><a href="javascript:del(${i.id})" id="${i.id}">删除</a></td>
      </tr>
        </c:forEach>
  </table>
  <p><a href="insert.jsp">新增图书</a></p>
  </div>
  </body>
</html>
