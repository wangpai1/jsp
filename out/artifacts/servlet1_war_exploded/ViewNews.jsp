<%--
  Created by IntelliJ IDEA.
  User: 13200
  Date: 2020/6/9
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="SaveNewsServlet"  method="post">
    新闻ID<input type="text" name="newsID" value="${news.newsID}"/>
    新闻标题<input type="text" name="newsTitle" value="${news.newsTitle}"/>
    新闻内容<input type="text" name="newsContent" value="${news.newsContent}"/>
    作者<input type="text" name="newsAuthor" value="${news.newsAuthor}"/>
    时间<input type="text" name="newsDate" value="${news.newsDate}"/>
    类别<input type="text" name="newsCategory" value="${news.newsCategory}"/>
    <input type="submit" value="更新"/>
</form>
</body>
</html>
