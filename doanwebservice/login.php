<?php
	require "connect.php";
	$taikhoan = $_POST['Email'];
	$matkhau = $_POST['MatKhau'];

	 // $taikhoan = "van@gmail.com";
	 // $matkhau = "123456";

	class SinhVien{
		function SinhVien($id,$ten,$email,$matkhau,$sdt,$diachi,$quyen){
			$this->id = $id;
			$this->ten = $ten;
			$this->email = $email;
			$this->matkhau = $matkhau;
			$this->sdt = $sdt;
			$this->diachi = $diachi;
			$this->quyen = $quyen;
		}
	}


	$sv = NULL;

	if (strlen($taikhoan) > 0 && strlen($matkhau) > 0){
		$query = "SELECT * FROM user WHERE FIND_IN_SET('$taikhoan',Email) AND FIND_IN_SET('$matkhau',MatKhau)";
		$data = mysqli_query($connect,$query);
		if($data){
			while($row = mysqli_fetch_assoc($data)){
				$sv = new SinhVien($row['ID'],$row['Ten'],$row['Email'],$row['MatKhau'],$row['SDT'],$row['DiaChi'],$row['Quyen']);
			}
			echo json_encode($sv);
		}
		else{
			echo "error";
		}
	}
	else{
		echo "NULL";
	}
?>