<?php
	require "connect.php";
	
	class SanPham{
		function SanPham($id,$ten,$gia,$km,$mota,$hinhanh,$idloaisp,$ttx){
			$this->id = $id;
			$this->ten = $ten;
			$this->gia = $gia;
			$this->km = $km;
			$this->mota = $mota;
			$this->hinhanh = $hinhanh;
			$this->idloaisp = $idloaisp;
			$this->ttx = $ttx;
		}
	}

	$list = array();
	$query = "SELECT * FROM SANPHAM ORDER BY ID DESC LIMIT 6";

	$data = mysqli_query($connect,$query);

	while($row = mysqli_fetch_assoc($data)){
		array_push($list,new SanPham($row['ID'],$row['TenSP'],$row['Gia'],$row['KhuyenMai'],$row['MoTa'],$row['HinhAnh'],$row['IDLoaiSP'],$row['TTX'],));
	}

	echo json_encode($list);
?>