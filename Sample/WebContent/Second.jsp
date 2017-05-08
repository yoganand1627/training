<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
        <script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("a");
                var b = document.getElementById("b");
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0)
                    {
                        alert("Don't leave the field empty!");
                        valid = false;
                    }
                    else{
                        if(!IsNumeric(a.value) || !IsNumeric(b.value))
                            alert("Enter a number");
                    valid = false;
                }
                return valid;
            };
            
           

        </script>
</head>
<body bgcolor="#CDCDCC" font-family="cursive" font-size="20px;" font-weight="bold">



    <h2>Welcome <%=request.getParameter("uname")%>! Enter the numbers and the operation that you want to perform: </h2>
    <form font-size="75px;" action ="serv" method="get" onsubmit="return validate();" >
        <hr/>
        Enter the 1st number: <input type="text" name="a" /><br/>

        Enter the 2st number: <input type="text" name="b" /><br/><br/>

       <label>Add</label><input type="radio" name="option" value="Add" /><br/>

       <label>Subtract</label><input type="radio" name="option" value="Subtract"/><br/>

       <label>Multiply</label><input type="radio" name="option" value="Multiply"/><br/>

       <label>Divide</label><input type="radio" name="option" value="Divide" /><br/>

       <input type="submit" value="Submit" />


   </form>


</body>