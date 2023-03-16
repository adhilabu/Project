<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Data Save Example</title>
   </head>
   <body>
      
    <b> Total ${noOfRecords} records uploaded !</b> 
	<br /> <br />
	      <form   action ="fetchParent" method = "POST" enctype = "text">
      <br /> <br />
      <br /> <br /> 
         Please type the product name or product code  to print the parent name : 
         <input type = "text" name = "val" value = "Product code or name" /> <br /> <br />
         <input type = "submit" value = "submit" /> <br /> <br /> 
         
   </body>

</html>