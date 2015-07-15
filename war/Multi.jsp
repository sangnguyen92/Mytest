<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script src="//unslider.com/unslider.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="main">
		<div id="head"><img src="image/banner1.png" width="1057px" height="200px"/></div>
		<div id="head-link">
				<p><a href='Main.html'>Pair-Alignment</a></p>
				<p align="center" style="font-size: 200%">
					<i><b>Align Sequences AminoAcides</b>
					</i>
				</p>
					
		</div>
			
		<div id="content">
			<!-- <div id="left">left</div> -->
			<div id="right">
			<!-- <form action="AlignmentServlet" method="post"> -->
			<form action="MultiAlignmentServlet" method="post">
					<fieldset>
					<legend style="font-size: 150%;color:blue">Enter Query Sequence:</legend>
					<table border="0">
							<tr>
							  <td>Upload file:</td>
							  <td> <input type="file" name="qufile" value="" width="100"> </td>
							</tr>
							<tr>
								<td>Title:</td>
								<td colspan="2"><input type="text" name="detail" width ="200"> <br>
									<p style="color:gray;font-size: 80%">Enter a descriptive title for your BLAST search</p>
									 </td> 
							</tr>
							
					<fieldset>
					<legend style="font-size: 150%;color:blue">Program Selection:</legend>
					<table border="0">
							<tr>
							  <td>Optimize for</td>
							 <td><input type="radio" checked> Clustalw<br>
							 <!-- <input type="radio">More dissimilar sequences (discontiguous megablast)<br>
							  <input type="radio" checked> Needleman-Wunsch/Gotoh algorithm<br> -->
						 		
						 		
							 </td>
							</tr>
							</table>
					</fieldset>
					<fieldset>
					<table border="0">
							<tr>
							  <td><b><input type="submit" value="SUBMIT"></b></td>
							 <td>Search"Nucleotide"  using " Clustalw algorithm" <br>
							 		
							<!--   <input type="checkbox">Show results in a new window-->
							
							 </td>
							</tr>
							</table>
					</fieldset>
			</form>
			</div>
		</div>
		<div id="footer"><p
		style="text-align: center; color: blue; margin-top: 10px; font-size: 14px; font-weight: bold; font-family: calibri;">Copyright
		© 2015 by NGUYEN Thi Sang</p></div>
	</div>
</body>
</html>