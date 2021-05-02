<?php
	require "connect.php";

	$name = $_POST['Ten'];
	$email = $_POST['Email'];
	$matkhau = $_POST['MatKhau'];
	$sdt = $_POST['SDT'];
	$diachi = $_POST['DiaChi'];
	$quyen = 0;

	$query = "INSERT INTO user VALUES(null,'$name','$email','$matkhau','$sdt','$diachi','$quyen')";

	if (mysqli_query($connect,$query)){
		echo "success";
	}
	else{
		echo "error";
	}
?>