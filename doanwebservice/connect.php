<?php
	$hostname = "localhost";
	$user = "root";
	$pass = "";
	$database = "APPBANHANG";
	$connect = mysqli_connect($hostname,$user,$pass,$database);
	mysqli_query($connect,"SET NAMES 'utf8'");
?>