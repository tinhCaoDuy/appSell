-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 02, 2021 lúc 05:44 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `appbanhang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietgiohang`
--

CREATE TABLE `chitietgiohang` (
  `ID` int(11) NOT NULL,
  `IDGioHang` int(11) NOT NULL,
  `IDSanPham` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietgiohang`
--

INSERT INTO `chitietgiohang` (`ID`, `IDGioHang`, `IDSanPham`, `SoLuong`) VALUES
(5, 42, 6, 2),
(6, 42, 5, 1),
(7, 43, 7, 2),
(8, 43, 3, 2),
(9, 44, 4, 3),
(10, 44, 7, 2),
(11, 44, 5, 1),
(12, 45, 4, 3),
(13, 46, 11, 2),
(14, 46, 5, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhsachhinhanh`
--

CREATE TABLE `danhsachhinhanh` (
  `ID` int(11) NOT NULL,
  `HinhAnh` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `danhsachhinhanh`
--

INSERT INTO `danhsachhinhanh` (`ID`, `HinhAnh`) VALUES
(2, 'https://images.anandtech.com/doci/14827/Blade-15-[2019-2]-Base-Model-Render-(04-2)_678x452.jpg'),
(2, 'https://lapvip.vn/upload/products/original/razer-blade-15-base-edition-model-2020-1602757941.jpg'),
(2, 'https://lapvip.vn/upload/products/original/razer-blade-15-base-edition-model-2020-1602757941.jpg'),
(3, 'https://cdn.ankhang.vn/media/product/18978_18978_laptop_msi_ge66_raider_10ug_205vn_1.jpg'),
(3, 'https://techzones.vn/Data/Sites/1/Product/24995/techzones-msi-ge66-raider-10sf-2.png'),
(3, 'https://owlgaming.vn/wp-content/uploads/2020/05/MSI-GE66-Raider-3-600x600.jpg'),
(4, 'https://img.websosanh.vn/v2/users/root_product/images/laptop-msi-gf65-thin/2d8eln84ngc1p.jpg'),
(4, 'https://xgear.vn/wp-content/uploads/2018/08/GF63_8RD_5.jpg'),
(4, 'https://laptop88.vn/media/product/5211_msi_gf65_thin_10ser_622vn_3.jpg'),
(5, 'https://tinhocngoisao.com/wp-content/uploads/2020/08/AS_A15-FA506IV-HN202T-3.jpg'),
(5, 'https://laptop123.com.vn/upload/product/asus-tuf-a15-fa506iv-hn202t.png'),
(5, 'https://timhangcongnghe.com/uploads/erp/products/product_image/image_url/112822/thumb650_Asus_TUF_Gaming_A15_FA506_1.jpg'),
(6, 'https://cdn.ankhang.vn/media/product/19044_laptop_msi_gf63_thin_9scsr_1057vn_1.jpg'),
(6, 'https://tinhocngoisao.cdn.vccloud.vn/wp-content/uploads/2020/10/MSI_GF63-Thin-9SCSR-1057VN-2.jpg'),
(6, 'https://salt.tikicdn.com/ts/product/d5/b9/83/b2d18422ce36bcc9cd49425a3e4336ce.jpg'),
(7, 'https://xgear.vn/wp-content/uploads/2020/10/stealth-15m-2.jpg'),
(7, 'https://xgear.vn/wp-content/uploads/2020/10/stealth-15m-5.jpg'),
(7, 'https://laptop88.vn/media/product/5812_msi_stealth_15m_a11sdk_061vn_i7_1185g7_1_d7e6903b66da4c879564b737c23a88bc_master.png'),
(8, 'https://anphat.com.vn/media/product/31562_screenshot_1.png'),
(8, 'https://laptop88.vn/media/product/5027_thinkpad_p1_gen_2__2_.png'),
(8, 'https://anphat.com.vn/media/product/31562_lenovo_laptop_thinkpad_p1_2nd_04.jpg'),
(9, 'https://laptopvang.vn/wp-content/uploads/2021/02/lenovo_thinkpad_p17_laptopvang-4.jpg'),
(9, 'https://m.media-amazon.com/images/I/61SW8CHnSDL._AC_SL1500_.jpg'),
(9, 'https://admin.thinkpro.vn/files/Lenovo-ThinkPad-P17/Lenovo-ThinkPad-P17-5.jpg'),
(10, 'https://laptopworld.vn/media/product/7809_asus_vivobook_15_m513ia_5.jpg'),
(10, 'https://laptop123.com.vn/upload/product/asus-m513ia-ej282t.png'),
(10, 'https://cellphones.com.vn/media/catalog/product/l/a/laptop-asus-vivobook-15-m513ia-ryzen-7.jpg'),
(11, 'https://lumen.thinkpro.vn//backend/uploads/product/color_images/2020/7/18/lenovo-thinkpad-t14s-ThinkpadT14s01NS-wAy.jpg'),
(11, 'https://ben.com.vn/Content/Images/Products/182928.png'),
(11, 'https://laptop123.com.vn/upload/product/lenovo-thinkpad-t14s-gen-1-core-i7.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giohang`
--

CREATE TABLE `giohang` (
  `ID` int(11) NOT NULL,
  `IDUser` int(11) NOT NULL,
  `NgayMua` date NOT NULL,
  `TongTien` double NOT NULL,
  `TrangThai` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `giohang`
--

INSERT INTO `giohang` (`ID`, `IDUser`, `NgayMua`, `TongTien`, `TrangThai`) VALUES
(42, 4, '2021-03-04', 65000000, 'DA GIAO'),
(43, 4, '2021-03-17', 161000000, 'DA GIAO'),
(44, 4, '2021-04-14', 168000000, 'DA GIAO'),
(45, 4, '2021-04-22', 72000000, 'DANG GIAO HANG'),
(46, 4, '2021-04-30', 92000000, 'DANG GIAO HANG');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `ID` int(11) NOT NULL,
  `TenLoaiSP` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`ID`, `TenLoaiSP`) VALUES
(1, 'LAPTOP'),
(2, 'ĐIỆN THOẠI');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `ID` int(11) NOT NULL,
  `TenSP` varchar(150) NOT NULL,
  `Gia` float NOT NULL,
  `KhuyenMai` int(11) NOT NULL,
  `MoTa` varchar(500) NOT NULL,
  `HinhAnh` varchar(200) NOT NULL,
  `IDLoaiSP` int(11) NOT NULL,
  `TTX` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ID`, `TenSP`, `Gia`, `KhuyenMai`, `MoTa`, `HinhAnh`, `IDLoaiSP`, `TTX`) VALUES
(2, 'Razer Blade 15 Base 2019 GTX 1660Ti', 31000000, 5, 'CPU: Core i7 9750H \r\nRAM: 16G DDR4 2666MHz\r\nSSD: 256GB NVMe\r\nVGA: NVidia GTX 1660Ti 6GB gDDR6\r\nMàn hình 15.6 Inch FHD IPS 144Hz\r\nWindows 10 Home', 'https://images-na.ssl-images-amazon.com/images/I/81%2Bl7hSFLYL.jpg', 1, 1),
(3, 'MSI GE66 Raider', 45000000, 5, 'CPU: Core i7 10750H \r\nRAM: 32GB DDR4\r\nSSD: 1TB\r\nVGA: RTX 2070 Super\r\nMàn hình 15.6\" FHD IPS 240Hz\r\nWindows 10', 'https://ben.com.vn/Content/Images/Products/185739..png', 1, 1),
(4, 'MSI GF65 Thin 2020', 24000000, 0, 'CPU: Core i7 10750H \r\nRAM: 8GB DDR4\r\nSSD: 512GB\r\nVGA: GTX 1660Ti\r\nMàn hình 15.6\" FHD IPS 120Hz\r\nWindows 10\r\nBảo hành 1 tháng', 'https://lumen.thinkpro.vn//backend/uploads/product/color_images/2020/9/24/msi-gf65-01.jpg', 1, 1),
(5, 'Asus TUF A15 FA506IV', 25000000, 10, 'CPU: AMD Ryzen 7 4800H\r\nRAM: 8GB 3200MHz\r\nSSD:  512GB\r\nVGA: NVidia RTX 2060\r\nMàn hình 15,6 Inch FHD IPS 60Hz\r\nWindows 10 Home', 'https://laptopaz.vn/media/product/1901_6408464_sd.jpg', 1, 1),
(6, 'MSI Gaming GF63 GF63 THIN 9SCSR-1057VN', 20000000, 0, 'CPU : Intel Core i5-9300H 2.4GHz up to 4.1GHz 8MB\r\nRAM : 8GB\r\nCard : NVIDIA GeForce GTX 1650Ti 4GB GDDR6 with Max-Q Design + Intel UHD Graphics 630\r\nỔ Cứng : 512GB SSD M.2 PCIE, x1 slot 2.5\" SATA3\r\nWindows 10 Home SL', 'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/6/3/637344707988159619_msi-gf63-9scsr-den-1.png', 1, 1),
(7, 'MSI Stealth 15M A11SDK 060VN', 35500000, 0, 'CPU Intel Core i7-1185G7 3.0GHz up to 4.8GHz 12MB\r\nRAM	16GB (8GBx2) DDR4 3200MHz (2x SO-DIMM socket, up to 64GB SDRAM)\r\nỔ cứng	512GB SSD PCIE G3X4\r\nCard đồ họa	NVIDIA GeForce GTX 1660Ti 6GB GDDR6\r\nMàn hình	15.6\" FHD (1920*1080), IPS-Level 144Hz 45%NTSC Thin Bezel', 'https://product.hstatic.net/1000026716/product/1_3cd1c2a4c64e4121b976b8e3555eba84.jpg', 1, 1),
(8, 'THINKPAD P1 GEN 2', 35500000, 10, 'CPU : Intel® Core™ Processor i7-9750H (6 Core, 12M Cache, 2.60GHz up to 4.5GHz Turbo, 45W, vPro)\r\nRAM : 16GB DDR4-2666MHz\r\nỔ cứng : 256 GB M2 PCIe ( up to 2Tb )\r\nVGA : NVIDIA® Quadro® T1000 4GB\r\nMàn hình : 15.6\" FHD (1920 x 1080) IPS 300 nits, anti-glare\r\nKết nối : Intel® AX200 Wi-Fi 6 802.11AX (2 x 2) & Bluetooth® 5.0\r\nHĐH : Windows 10 Pro 64\r\nPin/adapter4 Cell 80Wh internal battery / 135w', 'https://s4.nhattao.com/data/attachment-files/2020/06/15135087_lenovo-laptop-thinkpad-p1-2nd-01.jpg', 1, 1),
(9, 'THINKPAD P17', 43500000, 5, 'CPUI : ntel® Core™ i7-10750H Processor (2.60 GHz, up to 5.00 GHz with Turbo Boost, 6 Cores, 12 Threads, 12 MB Cache)\r\nRAM : 16GB DDR4 2933MHz ( up to 64Gb )\r\nỔ cứng : 512 GB M2 Pcie\r\nVGA : NVIDIA® Quadro® T2000 4GB\r\nMàn hình : 17.3\" FHD (1920 x 1080) IPS, anti-glare, 300 nits\r\nKết nối : Intel® Wi-Fi 6™ AX201 802.11AX (2 x 2) & Bluetooth® 5.1\r\nHĐH : Windows 10 Pro 64\r\nPin : 6 Cell 94Whr internal battery', 'https://laptopg7.vn/images/detailed/101/Thinkpad-P17-01-1602908797.jpg', 1, 1),
(10, 'Asus Vivobook 15 M513IA-EJ282T', 15000000, 10, 'CPU:Ryzen R5-4500U (2.3GHz upto 4.0GHz, 6 Cores, 6 Threads, 8MB cache)\r\nMàu sắc:Silver\r\nTình Trạng Máy :Mới 100%\r\nXuất xứ:Chính Hãng\r\nRAM:Ram 8GB DDR4 Buss 3200 Onbo\r\nỔ cứng:	512GB PCIe NVMe M.2 SSD\r\nMàn hình:15.6 inch LED Backlit Full HD (1920 x 1080) Anti-Glare NTSC 45%, 200 nits\r\nVGA/GPU:AMD Radeon Vega 6 Graphics', 'https://laptop123.com.vn/upload/product/-m513ia-ej282t.png', 1, 1),
(11, 'ThinkPad T14s', 21000000, 10, 'CPU: 10th Gen Intel® Core™ i5 10210U Processor (6MB Cache, up to 4.2GHz)\r\nRAM: 8GB DDR4 2666 MHz\r\nĐĩa cứng: 256GB M.2 PCIe NVMe Solid State Drive (M.2 SSD)\r\nMàn hình: 14\" FHD (1920 x 1080), IPS, anti-glare, 250nits\r\nCard đồ họa: Intel UHD Graphics', 'https://laptopvang.vn/wp-content/uploads/2020/08/thinkpad_t14_2020_laptopvang-5.jpg', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(150) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `MatKhau` varchar(100) NOT NULL,
  `SDT` varchar(10) NOT NULL,
  `DiaChi` varchar(150) NOT NULL,
  `Quyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`ID`, `Ten`, `Email`, `MatKhau`, `SDT`, `DiaChi`, `Quyen`) VALUES
(1, 'ADMIN', 'ad@gmail.com', '111111111', '0912345678', 'TPHCM', 1),
(2, 'QUỐC PRO', 'quocpro@gmail.com', '123123123', '987654321', 'Phú Yên,Việt Nam,Trái Đất', 0),
(3, 'TINH', 'tinh@gmail.com', '0978563412', '978563412', 'TPHCM', 0),
(4, 'VAN', 'caoduytinhfc@gmail.com', '123456', '978563412', 'TPHCM', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietgiohang`
--
ALTER TABLE `chitietgiohang`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `giohang`
--
ALTER TABLE `giohang`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietgiohang`
--
ALTER TABLE `chitietgiohang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `giohang`
--
ALTER TABLE `giohang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
