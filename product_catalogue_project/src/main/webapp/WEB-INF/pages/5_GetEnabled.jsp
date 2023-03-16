<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Data Save Example</title>
   </head>
   <body>
      
    <b> Total number of active and non-active products !</b> 
    
       <ul>
 
        <c:forEach var="en" items="${en}">
            <li>${en}</li>
        </c:forEach>
 
    </ul> 
Please click yes to view the average price of products in Category 1 and Category 2.
<a href="getAvgCatPrice"><b>Yes</b></a> &nbsp &nbsp <a href="/"><b>No</b></a>
         
   </body>

</html>