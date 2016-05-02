<?php
	include("connect.php");
	
	$firstName = $_POST['FirstName'];
	$lastName = $_POST['LastName']; 
	$Useremail = $_POST['Email'];
	$Userpass =$_POST['Password'];
	$foreman = $_POST['Foreman'];
        	
	$Useremail = mysql_real_escape_string($Useremail);
       // echo $Useremail; exit;
	mysql_select_db("beachelectric");
	$query = "select * from userInfo";
        //echo $query;
		       $s =  mysql_query("insert into userInfo (firstName, lastName,  userPassword, userEmail, userCode) values ('$firstName','$lastName', '$Userpass', '$Useremail','$foreman')");
                       echo $s;
			if($s){

			//mysql_query($query, $connection) or die(mysql_error());
			
			echo 'Successfully added.';
			echo $query;
		
	}
	else{

		echo "nah $s";
	}

?>