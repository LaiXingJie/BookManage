<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2020/3/3
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="UTF-8" %>
<html>
<head>
    <title>新增图片信息</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    div{
        margin: auto;
    }
</style>
<body>
<script src="js/jquery-1.12.4.js"></script>
<script>
    $(function(){

        $('#insertBook').click(function(){
            var name=$('#book').val();
            var author=$('#author').val();
            var time=$('#date').val();
            var r=new RegExp(/^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/);
            var select=document.getElementsByName("selectType")[0];
            var index=select.selectedIndex;
            if (name==""||author=="") {
                alert("图书和作者名字不为空！")
            }else if (!r.test(time)){
                alert("日期格式错误")
            }else if (index==0){
                alert("请选择图书分类");
            }else{
                window.location.href="javascript:document.form.submit()";
            }
        })
    })
</script>
<div>
    <h3>新增图书信息</h3>
<form action="InsertServlet?opr=insert" name="form"  method="post">
    图书名称:<input type="text" name="book" id="book"><br>
    图书作者:<input type="text" name="author" id="author"><br>
    购买日期:<input type="text" name="date" id="date"><span>yyyy-MM-dd格式</span><br>
    图书类别:<select name="selectType">
                <option selected>选择所属分类</option>
                <option value="1">计算机/软件</option>
                <option value="2">小说/文摘</option>
                <option value="3">杂类</option>
            </select><br>
        <input type="button" value="增加图书" id="insertBook">
</form>
</div>
</body>
</html>
