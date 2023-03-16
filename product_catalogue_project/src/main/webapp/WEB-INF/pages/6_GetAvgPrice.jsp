<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title>Average Price of products</title>
   </head>
   <body>
      
    <b> Average price of products</b> 
    
       <ul>
<c:forEach items="${map}" var="entry">
    Category_product = ${entry.key}, Average_price = ${entry.value}<br>
</c:forEach>
    </ul> 
Please click yes to go back.
<a href="/"><b>Yes</b></a> &nbsp 
         
   </body>

</html>