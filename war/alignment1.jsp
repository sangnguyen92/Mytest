<%@page import="java.util.Arrays"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
<link rel="stylesheet" href="css/style.css" />
</head>
	<body>
	<%
		String[] query= new String[100];
		if (request.getAttribute("s1") != null) {
		query = (String[]) request.getAttribute("s1");
		}
        
        String[] target= new String[100];
		if (request.getAttribute("s2") != null) {
		target = (String[]) request.getAttribute("s2");
		}
		
		
		String[] orPair= new String[100];
		if (request.getAttribute("orPair") != null) {
		orPair = (String[]) request.getAttribute("orPair");
		}
		
		String[] subPair= new String[100];
		if (request.getAttribute("subPair") != null) {
		subPair = (String[]) request.getAttribute("subPair");
		}
		
		String[] orPair1= new String[100];
		if (request.getAttribute("orPair1") != null) {
		orPair1 = (String[]) request.getAttribute("orPair1");
		}
		
		String[] subPair1= new String[100];
		if (request.getAttribute("subPair1") != null) {
		subPair1 = (String[]) request.getAttribute("subPair1");
		}

       
	%>
	<!--
	
		String[] orPair1= new String[100];
		if (request.getAttribute("orPair1") != null) {
		orPair1 = (String[]) request.getAttribute("orPair1");
		}
		
		String[] subPair1= new String[100];
		if (request.getAttribute("subPair1") != null) {
		subPair1 = (String[]) request.getAttribute("suPair1");
		}
	/////////////////////////////////////
		String query = "";
		if (request.getAttribute("query") != null) {
		query = (String) request.getAttribute("query");
		}
        String qu1=query.toString().substring(0,query.toString().length()/2);
        String qu2=query.toString().substring(query.toString().length()/2);
        
		String tar_1=target.toString().substring(0, target.toString().length()/2);
		String tar_2=target.toString().substring(target.toString().length()/2);
		
        String psa = "";
        if (request.getAttribute("psa") != null) {
    		psa = (String) request.getAttribute("psa");
    		}
        String psa_1 = psa.toString().substring(0, psa.toString().length()/2);
        String psa_2 = psa.toString().substring(psa.toString().length()/2);
        
        
        String psa1 = "";
        if (request.getAttribute("psa1") != null) {
    		psa1 = (String) request.getAttribute("psa1");
    		}
        String psa1_1 = psa1.toString().substring(0, psa1.toString().length()/2);
        String psa1_2 = psa1.toString().substring(psa1.toString().length()/2);
        
        int number = (psa.toString().length()/2)/300;
        -->
		<div id="main">
			<div id="head"><img src="image/banner.png" width="1057px" height="200px"/></div>
			<div id="head-link"><p align="center" style="font-size: 200%">
										<i>
												<b>Align Sequences AminoAcides</b>
										</i>
								</p>
			</div>
			<div id="content">
				<!--  <div id="left">left</div> -->
				<div id="right">
						<table border="1"  width="1050">
							<tr>
								<td colspan="2"> 
									<p align="center" style="font-size: 150%">Results:</p>
								</td>
							</tr>
							<tr>
								<td>Query Sequence: <br>
									<%for(int i=0;i<query.length;i++){ %>
									<pre><%out.print("index:"+i*60+": "+query[i]); %></pre>
									
									<%} %>
									</td>
								<td>Subject Sequence: <br>
									<%for(int i=0;i<target.length;i++){ %>
									<pre><%out.print("index:"+i*60+": "+target[i]); %></pre>
									
									<%} %>
								</td>
							</tr>
							<tr>
								<td colspan="2"><p style="font-size: 150%;color:blue">******Alignment Global******</p><br>
									<%for(int i=0;i<orPair.length;i++){ %>
									<pre><%out.print("index:"+i*100+": "+orPair[i]); %></pre>
									<pre><%out.print("index:"+i*100+": "+subPair[i]); %></pre>
									<%} %>
								
									<!--
									-->
								</td>
							</tr>
							<tr>
								<td colspan="2"><p style="font-size: 150%;color:blue">*****Alignment Local******</p><br>
										<%for(int i=0;i<subPair1.length;i++){ %>
										<pre><%out.print("index:"+i*100+": "+orPair1[i]); %></pre>
										<pre><%out.print("index:"+i*100+": "+subPair1[i]); %></pre>
										<%} %>		
								</td>
							</tr>
						</table>
							
				</div>
			</div>
			<div id="footer">
							<p><a href='Main.html'>Back to the main page</a></p>
							<p
									style="text-align: center; color: blue; margin-top: 10px; font-size: 14px; font-weight: bold; font-family: calibri;">Copyright
									© 2015 by NGUYEN Thi Sang
							</p>
			</div>
		</div>
	</body>
	<body>
		
	</body>
</html>