<?php
	require "connect.php";

	$id = $_POST['IDCART'];
	//$id = 42;

	class CTGH{
		function CTGH($id,$idGH,$idSP,$ha,$ten,$gia,$sl){
			$this->id = $id;
			$this->idGH = $idGH;
			$this->idSP = $idSP;
			$this->ha = $ha;
			$this->ten = $ten;
			$this->gia = $gia;
			$this->sl = $sl;
		}
	}

	$list = array();

	//$id = $value['idGH'];
	$query = "SELECT * FROM chitietgiohang WHERE IDGioHang = '$id'";
	$data = mysqli_query($connect,$query);
	while($row = mysqli_fetch_assoc($data)){
		$idsanpham = $row['IDSanPham'];
		$query1 = "SELECT * FROM sanpham WHERE ID = '$idsanpham'";
		$data1 = mysqli_query($connect,$query1);
		$row1 = mysqli_fetch_assoc($data1);

		array_push($list,new CTGH($row['ID'],$row['IDGioHang'],$row['IDSanPham'],$row1['HinhAnh'],$row1['TenSP'],$row1['Gia'],$row['SoLuong']));
	}


	echo json_encode($list);
?>