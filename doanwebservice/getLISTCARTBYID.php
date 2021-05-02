<?php
	require "connect.php";

	$IDUSER = $_POST['IDUSER'];
	//$IDUSER = "4";

	class GH{
		function GH($id,$idUser,$Ngaymua,$Tongtien,$Trangthai){
			$this->id = $id;
			$this->idUser = $idUser;
			$this->Ngaymua = $Ngaymua;
			$this->Tongtien = $Tongtien;
			$this->Trangthai = $Trangthai;
		}
	}

	$query = "SELECT * FROM giohang WHERE IDUser = '$IDUSER'";
	$list = array();
	$data = mysqli_query($connect,$query);

	while($row = mysqli_fetch_assoc($data)){
		array_push($list,new GH($row['ID'],$row['IDUser'],$row['NgayMua'],$row['TongTien'],$row['TrangThai']));
	}

	echo json_encode($list);
?>