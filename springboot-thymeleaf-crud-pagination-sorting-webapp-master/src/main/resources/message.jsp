<%
String message = (String) session.getAttribute("message");
if (message !=null){
	System.out.println(message);
	session.removeAttribute("message");
}

%>