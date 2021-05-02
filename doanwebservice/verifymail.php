<?php
	require "connect.php";

	//$mail = $_POST['email'];
	//$code = $_POST['code'];
	//$content = $_POST['content'];
	//$title = 'VERIFY MAIL';
	//$code = 123;
	//$message = 'Your Verify Code : ' . $code;


	$mail = 'caoduytinhfc@gmail.com';
	//$code = $_POST['code'];
	$content = 'hahahihi';
	$title = 'VERIFY MAIL';


	mail($mail, $title,$content);

	$message = "success";

	echo json_encode($message);
?>