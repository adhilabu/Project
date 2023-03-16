<%@ page import = "java.io.*,java.util.*" %>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Print Children</title>
   </head>
   <body>
      
    <b>  Children of the given product are</b> 
   <ul>
 
        <c:forEach var="ts" items="${ts}">
            <li>${ts}</li>
        </c:forEach>
 
    </ul> 
Please click yes to see the number of active and non-active products.
<a href="getEnabledValues"><b>Yes</b></a> &nbsp &nbsp <a href="/"><b>No</b></a>
   </body>
</html>