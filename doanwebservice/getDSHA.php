<?php
	require "connect.php";

	$ID = $_POST['IDSP'];
	//$ID = "4";

	$query = "SELECT * FROM danhsachhinhanh WHERE ID = '$ID'";
	$list = array();
	$data = mysqli_query($connect,$query);

	while($row = mysqli_fetch_assoc($data)){
		array_push($list,$row['HinhAnh']);
	}

	echo json_encode($list);
?>