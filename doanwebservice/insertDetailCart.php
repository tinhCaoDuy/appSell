<?php
	require "connect.php";

	$list = $_POST['LIST'];
	$data = json_decode($list,true);
	foreach ($data as $value) {
		$idGH = $value['idGH'];
		$idSP = $value['idSP'];
		$sl = $value['soluong'];
		$query = "INSERT INTO chitietgiohang VALUES(null,'$idGH','$idSP','$sl')";

		$result = mysqli_query($connect,$query);
	}
	if ($result){
		echo "1";
	}
	else{
		echo "0";
	}
?>