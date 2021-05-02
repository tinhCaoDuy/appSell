<?php
	require "connect.php";

	$begin = $_POST['begin'];
	$end = $_POST['end'];

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

	$query = "SELECT * FROM giohang WHERE NgayMua >= '$begin' AND NgayMua < '$end'";
	$list = array();
	$data = mysqli_query($connect,$query);

	while($row = mysqli_fetch_assoc($data)){
		$id = $row['ID'];
		$query1 = "SELECT * FROM chitietgiohang WHERE IDGioHang = '$id'";
		$data1 = mysqli_query($connect,$query1);
		while($row1 = mysqli_fetch_assoc($data1)){
			$idsp = $row1['IDSanPham'];
			$query2 = "SELECT * FROM sanpham WHERE ID = '$idsp'";
			$data2 = mysqli_query($connect,$query2);	
			$row2 = mysqli_fetch_assoc($data2);
			array_push($list,new CTGH($row1['ID'],$row1['IDGioHang'],$row1['IDSanPham'],$row2['HinhAnh'],$row2['TenSP'],$row2['Gia'],$row1['SoLuong']));
		}
	}

	echo json_encode($list);
?>