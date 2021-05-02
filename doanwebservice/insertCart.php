<?php
	require "connect.php";
	 $iduser = $_POST['IDUSER'];
	 $ngaymua = $_POST['NGAY'];
	 $tongtien = $_POST['TONGTIEN'];
	 $trangthai = $_POST['TRANGTHAI'];
	 $list = $_POST['LIST'];
	 $data = json_decode($list,true);

	// $iduser = "2";
	// $ngaymua = "09/04/2021";
	// $tongtien = 20000000;

	$query = "INSERT INTO giohang VALUES(null,'$iduser','$ngaymua','$tongtien','$trangthai')";

	if (mysqli_query($connect,$query)){
		$id = $connect->insert_id;
		
		foreach ($data as $value) {
			$idSP = $value['idSP'];
			$sl = $value['soluong'];
			$query2 = "INSERT INTO chitietgiohang VALUES(null,'$id','$idSP','$sl')";

			$result = mysqli_query($connect,$query2);
			if ($result){
				echo "1";
			}
			else{
				echo "0";
			}
		}
	}
	else{
		echo "error";
	}
?>