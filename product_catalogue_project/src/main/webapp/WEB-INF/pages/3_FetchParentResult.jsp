<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Fetch Parent</title>
   </head>
   <body> 
    <b> Parent of the given input product is ${parent}</b> 
	<br /> <br />
	      <form   action ="fetchChildren" method = "POST" enctype = "text">
      <br /> <br />
      <br /> <br /> 
         Please type the parent name  to print the children : 
         <input type = "text" name = "va" value = "Parent Name" /> <br /> <br />
         <input type = "submit" value = "submit" /> <br /> <br /> 
   </body>
</html>