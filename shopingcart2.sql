-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Apr 19, 2025 at 02:59 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopingcart2`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `name`, `category_id`) VALUES
(1, 'Apple', 2),
(2, 'Asus', 2),
(3, 'Macbook', 1),
(4, 'Acer', 1),
(5, 'Oppo', 2),
(6, 'Xiaomi', 3),
(7, 'Toshiba', 3),
(8, 'Beat', 4),
(9, 'JBL', 4);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`) VALUES
(2),
(3),
(4),
(5),
(6),
(7);

-- --------------------------------------------------------

--
-- Table structure for table `cart_product`
--

CREATE TABLE `cart_product` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart_product`
--

INSERT INTO `cart_product` (`id`, `color`, `qty`, `cart_id`, `product_id`) VALUES
(17, 'Black', 7, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `icon`) VALUES
(1, 'Laptop', 'fa fa-desktop'),
(2, 'Mobile Phone', 'fa fa-tablet'),
(3, 'TV', 'fa fa-television'),
(4, 'Sound', 'fa fa-headphones');

-- --------------------------------------------------------

--
-- Table structure for table `color`
--

CREATE TABLE `color` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `color`
--

INSERT INTO `color` (`id`, `name`) VALUES
(1, 'White'),
(2, 'Black'),
(3, 'Yellow'),
(4, 'Silver'),
(5, 'Pink');

-- --------------------------------------------------------

--
-- Table structure for table `information`
--

CREATE TABLE `information` (
  `id` bigint(20) NOT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `pin` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `screen` varchar(255) DEFAULT NULL,
  `ssd` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `wifi` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `information`
--

INSERT INTO `information` (`id`, `cpu`, `os`, `pin`, `ram`, `screen`, `ssd`, `weight`, `wifi`, `product_id`) VALUES
(2, 'MacM1', 'MacM1', '8h', '8GB', '1290 x 2796', '256GB', '221 gam', 'Wi‑Fi 6E (802.11ax) với 2x2 MIMO', 2),
(4, 'Octa-core processor', 'ColorOS (based on Android)', '5000mAh', '4GB', '6.5-inch HD+ display', '64GB', '180g', 'Wi-Fi 802.11 b/g/n', 4),
(5, 'Intel Celeron N4020', 'Window', '7h', '4GB', '11.6 inc', '256GB', '1.5kg', 'wifi 4', 5),
(6, 'Octa-core processor', 'ColorOS (based on Android)', '5000mAh', '4GB', '6.5-inch HD+ display', '64GB', '180gam', 'Wi-Fi 802.11 b/g/n', 6),
(7, 'M2', 'MacOS', '16h', '8gb', '15\'\' 2k', '512GB', '1.8kg', 'wifi 6', 7),
(8, 'M2', 'MacOS', '20h', '16GB', '15inc 2k', '512GB', '2kg', 'wifi6', 8),
(9, 'Quad-core processor', 'Quad-core processor', 'none', '2GB', '65-inch display with [resolution] resolution', 'none', '16kg', 'Wi-Fi 802.11ac', 9),
(10, 'intel', 'Android 11.0 (R)', 'none', '4KG', '32\" Full HD', 'none', '4 kg', 'Wifi 2.4/5GHz', 10),
(11, 'JBL Deep Bass Sound', 'none', 'Headphones - 8 hours, Charging case - 24 hours', 'none', 'none', 'none', '50g', 'Bluetooth 5.2', 11),
(12, 'intel', 'none', '24h', 'none', 'none', 'none', '100g', 'wifi 4', 12),
(19, '12', '12', '123', '2', '123', '3', '213', '123', 19);

-- --------------------------------------------------------

--
-- Table structure for table `info_color`
--

CREATE TABLE `info_color` (
  `info_id` bigint(20) NOT NULL,
  `color_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `info_color`
--

INSERT INTO `info_color` (`info_id`, `color_id`) VALUES
(2, 1),
(2, 3),
(4, 2),
(4, 3),
(5, 2),
(6, 1),
(6, 3),
(6, 5),
(7, 2),
(7, 4),
(7, 5),
(8, 1),
(8, 2),
(9, 1),
(9, 2),
(9, 5),
(10, 2),
(10, 4),
(11, 1),
(11, 3),
(11, 5),
(12, 1),
(12, 2),
(12, 3),
(19, 2),
(19, 4),
(19, 5);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `total` int(11) NOT NULL,
  `status_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `address`, `date_time`, `phone`, `total`, `status_id`, `user_id`) VALUES
(3, 'VKU', '2023-12-29 20:31:18.000000', '999', 4000, 2, 2),
(4, 'aaaaa', '2024-01-01 22:49:57.000000', '123123', 13996, 2, 3),
(5, 'Da Nang', '2024-01-02 07:52:33.000000', '987556723', 15889, 2, 4),
(6, 'Da Nang', '2024-01-02 08:13:26.000000', '1234567', 7000, 2, 4),
(7, 'UK', '2024-01-05 22:04:52.000000', '123', 3825, 2, 2),
(8, 'UK', '2024-01-06 08:02:52.000000', '99999', 5000, 2, 2),
(9, 'aa12391239', '2024-02-24 15:08:07.000000', '129381238', 2994, 2, 2),
(10, 'Da Nang', '2024-08-12 11:47:13.000000', '123123323', 3460, 1, 6),
(11, 'aadasdasd', '2024-12-20 14:49:31.000000', '123123123123', 5819, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `order_product`
--

CREATE TABLE `order_product` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `qty` int(11) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_product`
--

INSERT INTO `order_product` (`id`, `color`, `imageurl`, `img`, `name`, `price`, `qty`, `order_id`) VALUES
(4, 'Yellow', '8589img1.webp', '999', 'Iphone 15 ProMax', 4000, 4, 3),
(5, 'White', '282_54_9_2.webp', '123123', 'Macbok Air M2', 6000, 3, 4),
(6, 'Black', '80text_ng_n_16__3_3_1.webp', '123123', 'Laptop Acer TravelMate B3 TMB311', 1996, 4, 4),
(7, 'Black', '282_54_9_2.webp', '123123', 'Macbok Air M2', 6000, 3, 4),
(8, 'White', '8589img1.webp', '987556723', 'Iphone 15 ProMax', 11000, 11, 5),
(9, 'Pink', '19text_ng_n_7__104.webp', '987556723', 'MacBook Air 15 inch M2 2023', 1459, 1, 5),
(10, 'Yellow', '26oop5.webp', '987556723', 'Oppo A17 4GB/64GB ', 256, 2, 5),
(11, 'Silver', '19text_ng_n_7__104.webp', '987556723', 'MacBook Air 15 inch M2 2023', 2918, 2, 5),
(12, 'White', '26oop5.webp', '987556723', 'Oppo A17 4GB/64GB ', 256, 2, 5),
(13, 'Yellow', '8589img5.webp', '1234567', 'Iphone 15 ProMax', 3000, 3, 6),
(14, 'White', '8589img5.webp', '1234567', 'Iphone 15 ProMax', 4000, 4, 6),
(15, 'Black', '58106img3.webp', '123', 'Điện thoại ASUS ROG Phone 7', 1695, 3, 7),
(16, 'White', '8589img1.webp', '123', 'Iphone 15 ProMax', 1000, 1, 7),
(17, 'Yellow', '58106img3.webp', '123', 'Điện thoại ASUS ROG Phone 7', 1130, 2, 7),
(18, 'White', '8589img5.webp', '99999', 'Iphone 15 ProMax', 2000, 2, 8),
(19, 'Yellow', '8589img5.webp', '99999', 'Iphone 15 ProMax', 3000, 3, 8),
(20, 'Black', '80text_ng_n_15__5_6_1.webp', '129381238', 'Laptop Acer TravelMate B3 TMB311', 2994, 6, 9),
(21, 'Yellow', '58106img4.webp', '123123323', 'Điện thoại ASUS ROG Phone 7', 2260, 4, 10),
(22, 'Silver', '86a-pro-65-30-r4-1_638260631706585733.webp', '123123323', 'TV TOSHIBA 32V35KP (HD/32-inch)', 900, 3, 10),
(23, 'Black', '86a-pro-65-30-r4-1_638260631706585733.webp', '123123323', 'TV TOSHIBA 32V35KP (HD/32-inch)', 300, 1, 10),
(24, 'Black', '58106img1.webp', '123123123123', 'Điện thoại ASUS ROG Phone 7', 1695, 3, 11),
(25, 'Yellow', '58106img1.webp', '123123123123', 'Điện thoại ASUS ROG Phone 7', 1130, 2, 11),
(26, 'Black', '80text_ng_n_21__2_3.webp', '123123123123', 'Laptop Acer TravelMate B3 TMB311', 2994, 6, 11);

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_status`
--

INSERT INTO `order_status` (`id`, `status`) VALUES
(1, 'Shiping'),
(2, 'Well Done');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `brand_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `description`, `name`, `price`, `brand_id`) VALUES
(2, ' ', 'Iphone 15 ProMax', 1000, 1),
(4, '<p><strong>Mua điện thoại di động ASUS ROG Phone 7 (16GB/512GB) giá rẻ chính hãng tại Hoàng Hà Mobile&nbsp;</strong></p><p>Với sự kế thừa và phát triển từ người tiền nhiệm - ROG Phone 6, điện thoại di động ASUS ROG Phone 7 (16GB/512GB) nhanh chóng trở thành biểu tượng mới cho thế giới gaming di động. Màn hình siêu mượt, tần số quét cao, viên pin \"khủng\" và hàng loạt tính năng hiện đại đã góp phần tạo nên chiếc <a href=\"https://hoanghamobile.com/dien-thoai-di-dong\"><strong>smartphone</strong></a> này. Đừng bỏ qua thiết bị này nếu bạn đang tìm kiếm một chiếc Gaming phone cao cấp có thể đáp ứng đầy đủ nhu cầu của mình.</p><p>&nbsp;</p><h2><strong>Trải nghiệm thị giác ấn tượng với tấm nền AMOLED sắc nét</strong></h2><p>&nbsp;</p><p>Trải nghiệm thị giác chưa từng có trên một chiếc điện thoại, đó chính là những gì Asus ROG Phone 7 đem lại cho người dùng. Theo đó, mọi hình ảnh, màu sắc, đường nét trở nên chân thực hơn bao giờ hết nhờ tấm nền <strong>AMOLED 6.78</strong> <strong>inch</strong> thế hệ mới từ Samsung được tích hợp trên thiết bị này.</p><p>Với độ phân giải <strong>2448x1080</strong> pixel, cùng với màn hình sắc nét, màu sắc trung thực, và chất lượng hình ảnh tuyệt vời. Thiết bị này chắc chắn đáp ứng mọi nhu cầu hàng ngày của bạn, từ xem phim đến chụp ảnh, lướt web hay thực hiện công việc. Không chỉ dừng lại ở đó, tần số quét <strong>165Hz</strong> hứa sẽ đem đến trải nghiệm mượt mà, không giật lag trong mọi tác vụ trên điện thoại di động ASUS ROG Phone 7 (16GB/512GB).</p><h2><strong>Hiệu năng vượt trội với Snapdragon 8 Gen 2</strong></h2><p>Đối với một chiếc Gaming phone cao cấp thì không thể không nhắc đến yếu tố hiệu năng. Thiết bị này cũng không phải ngoại lệ, nó được trang bị con chip <strong>Snapdragon 8 Gen 2 </strong>Mobile Platform xung nhịp <strong>3.2 GHz</strong> cao cấp. Điều này giúp thiết bị không chỉ nhanh hơn mà còn hiệu quả về năng lượng hơn <strong>15%</strong> so với thế hệ trước.</p>', 'Điện thoại ASUS ROG Phone 7', 565, 2),
(5, '<p>Mua Laptop Acer TravelMate B3 TMB311 31 C2HB giá rẻ chính hãng tại Hoàng Hà Mobile</p><p>&nbsp;</p><p>Acer TravelMate B3 TMB311 31 C2HB chính là một mẫu laptop sinh ra là để dành cho những tệp khách hàng là học sinh, sinh viên, muốn tìm cho mình một thiết bị học tập bền bỉ qua năm tháng, có tính cơ động cao cùng một thời lượng sử dụng lâu dài.</p><p>Thiết kế nhỏ gọn, cơ động</p><p>Laptop Acer TravelMate B3 khoác bên ngoài một bộ cánh có thể nói là rất cơ bản của một chiếc máy tính xách tay, nhưng vẫn toát lên sự năng động và trẻ trung. Nếu như gập chiếc <a href=\"https://hoanghamobile.com/laptop/hang-san-xuat/acer/acer-travelmate\">Acer TravelMate</a> lại, tổng thể toàn bộ chiếc laptop như một khối liền lạc thống nhất được phủ một lớp màu đen trơn, với logo Acer quen thuộc được đặt lệch về phía bên trái để tăng thêm sự độc đáo. Quả thật nhìn vào Acer TravelMate B3, ta vừa thấy được sự quen thuộc, nhưng vẫn có gì đó rất cuốn hút.</p><p><br>Tiếp đến, vì sao lại nói Acer TravelMate B3 là chiếc laptop phù hợp với những bạn học sinh, sinh viên? Đó là bởi kích thước và trọng lượng vô cùng nhỏ gọn và nhẹ nhàng của máy. Theo đó, kích thước của máy theo như công bố của nhà sản xuất lần lượt là 95 (W) x 215 (D) x 20.99 (H) mm cùng với cân nặng chỉ là 1.4kg. Vì vậy, người dùng hoàn toàn có thể đặt vừa chiếc laptop ngay trong balo, cặp sách của mình và mang thiết bị đi tới bất cứ nơi đâu, có thể là thư viện, lớp học, quán cà phê,…</p><p>Bền bỉ với tiêu chuẩn chống va đập của quân đội</p><p>Tuy mang một hình dạng bé nhỏ là vậy, thế nhưng Acer TravelMate B3 vẫn được ưu ái trang bị tiêu chuẩn chống va đập của quân đội MIL-STD 810H. Với tiêu chuẩn này, người dùng có thể thoải mái sử dụng máy bởi theo như cam kết tới từ Acer, TravelMate B3 có thể chịu được một lực tác động lên tới 60kg.</p>', 'Laptop Acer TravelMate B3 TMB311', 499, 4),
(6, '<p><strong>Mua điện thoại OPPO A17 chính hãng, giá rẻ tại Hoàng Hà Mobile</strong></p><p>OPPO A17 là mẫu smartphone tầm trung thuộc dòng A series được hãng ưu ái đầu tư lớn cả về thiết kế lẫn hiệu năng. Với rất nhiều tính năng vượt trội cùng sự nâng cấp mạnh mẽ về pin và bộ sạc, đây chắc chắn đây là lựa chọn phù hợp cho người dùng.</p><p><strong>Thiết kế cá tính, màn hình giọt nước quen thuộc</strong></p><p>OPPO A17 sở hữu vẻ ngoài vô cùng độc đáo, ấn tượng với phần khung viền vuông vức cùng các cạnh góc được bo cong mềm mại không thua gì với những chiếc smartphone ở phân khúc cao cấp. Thân máy cực mỏng nhẹ, chỉ dày&nbsp; 0.83 cm và nặng 189g nên việc cầm nắm vô cùng thoải mái, đồng thời dễ dàng mang theo khắp mọi nơi.</p><p>Màn hình OPPO A17 có kích thước lớn 6,56 inch với kiểu dáng giọt nước quen thuộc. Thiết bị sử dụng tấm nền LCD chất lượng hiển thị đạt độ phân giải HD+, có độ bao phủ 100% DCI-P3 đem đến trải nghiệm màu sắc khi xem phim, lướt web chân thực và rõ nét nhất có thể.</p><p>Mặt lưng được hoàn thiện bằng chất liệu nhựa nhám vô cùng tỉ mỉ, hạn chế bám vân tay. Hiệu ứng gradient đổi màu tùy góc cạnh càng tăng thêm phần sang trọng cho máy. Đây cũng là nơi chứa 2 camera sau trong 1 khung viền hình oval.</p><p>OPPO A17 có 2 phiên bản màu khác nhau là Midnight Black (đen) và Lake Blue (xanh nước biển). Khi mở hộp, bên trong sẽ có đầy đủ các phụ kiện đi kèm gồm: Sách hướng dẫn sử dụng, que chọc SIM, ốp lưng trong, củ sạc và cáp sạc MicroUSB.</p><p>&nbsp;</p><p><strong>Chip Helio G35 đáp ứng mọi tác vụ cơ bản</strong></p><p>OPPO A17 được trang bị sức mạnh từ chip MediaTek Helio G35 8 nhân cortex A53 với xung nhịp 2.3 GHz. Vi xử lý này được sản xuất trên tiến trình 12nm, với hiệu suất ổn định, mượt mà. Bởi vậy, người dùng hoàn toàn có thể yên tâm sử dụng các tác vụ cơ bản như nghe gọi, lướt web, xem phim hay chơi các tựa game mobile nhẹ nhàng.</p>', 'Oppo A17 4GB/64GB ', 128, 5),
(7, '<p><strong>MacBook Pro 14\" (M3/8-core CPU/10-core GPU/8GB/1TB) - Chính hãng</strong> nằm trong bộ sản phẩm laptop thế hệ mới vừa ra mắt của Apple. Sản phẩm sở hữu <strong>CPU 8 lõi</strong> và <strong>GPU 10 lõi</strong> với <strong>chipset M3 </strong>tiên tiến bậc nhất, mang đến hiệu năng vượt trội và đa nhiệm tuyệt vời. Khi kết hợp cùng<strong> RAM 8GB</strong> và ổ cứng<strong> SSD 1TB</strong> cực khủng, tốc độ của máy càng được tăng cường, đồng thời đem đến không gian lưu trữ không giới hạn. Chiếc laptop này còn được trang bị <strong>màn hình XDR 14.2 inch </strong>tích hợp <strong>ProMotion</strong> và <strong>True Tone</strong>, cho hình ảnh mãn nhãn. Ngoài ra, người dùng còn được trải nghiệm<strong> dung lượng pin kéo dài 22 giờ</strong> cùng khả năng kết nối đa dạng các thiết bị ngoại vi.</p>', 'MacBook Air 15 inch M2 2023', 1459, 3),
(8, '<p>Tất cả Macbook chính hãng Apple Việt Nam, được phân phối tại Hoàng Hà Mobile đều được nhập trực tiếp từ Công ty TNHH Apple Việt Nam.&nbsp;HoangHa Mobile là nhà bán lẻ ủy quyền chính thức của Apple tại Việt Nam.</p><h2>Mua MacBook Pro M2 15\" 2022 - 512GB chính hãng Apple Việt Nam giá rẻ tại Hoàng Hà Mobile</h2><p>Trong tháng 6 vừa qua, Apple đã giới thiệu con chip độc quyền thế hệ thứ hai. Chip M2 được trang bị trên cả hai dòng sản phẩm <a href=\"https://hoanghamobile.com/laptop/macbook/macbook-airr\">MacBook Air</a> và <a href=\"https://hoanghamobile.com/laptop/macbook/macbook-pro\">MacBook Pro</a>. Nó hứa hẹn sẽ là một phiên bản nâng cấp mạnh mẽ so với thế hệ MacBook Pro M1. Nếu bạn đang tìm kiếm một chiếc máy tính nhỏ gọn với hiệu năng vượt trội thì chắc chắn không thể bỏ qua MacBook Pro M2 13 inch 2022 256GB chính hãng Apple Việt Nam tại Hoàng Hà Mobile.</p><p>&nbsp;</p><h3>Thiết kế mỏng hơn, sang trọng hơn</h3><p>MacBook Pro là dòng sản phẩm máy tính cao cấp của nhà Apple. Đối với phiên bản năm 2022, nhà sản xuất không thay đổi nhiều về thiết kế bên ngoài. Máy được hoàn thiện với lớp vỏ kim loại nguyên khối và bộ khung phẳng. Trọng lượng của máy chỉ khoảng 1.4kg và độ dày là 15.6mm. Nhờ đó <a href=\"https://hoanghamobile.com/laptop/macbook/macbook-pro-m2\">MacBook Pro M2</a> phiên bản mới trông sang trọng, thời thượng hơn mà vẫn vô cùng tiện lợi khi có thể có thể bỏ vào túi, cặp xách và mang theo di chuyển dễ dàng.</p><p>&nbsp;</p><p>&nbsp;</p><p><br>&nbsp;</p>', 'Macbok Air M2', 2000, 3),
(9, '<h2><strong>Mua smart Tivi Casper 32HGS610 chính hãng, giá rẻ tại Hoàng Hà Mobile</strong></h2><p>Smart Tivi Casper 32HGS610 sở hữu màn hình tràn viền đem lại trải nghiệm ấn tượng cho thị giác.</p><h2><strong>Thiết kế tràn viền tinh tế và công nghệ hình ảnh HDR10</strong></h2><p>Smart tivi Casper 32HGS610 thuộc dòng S-Series của hãng Casper, có kiểu dáng trang nhã, thiết kế hiện đại cùng với viền màn hình siêu mỏng, qua đó mang lại vẻ sang trọng cho không gian nội thất của gia đình bạn, đồng thời cho trải nghiệm hình ảnh thêm trọn vẹn. Đây cũng là xu hướng nhiều người dùng tìm đến khi chọn mua smart tivi.</p><p>Tivi có kích thước 32 inch, độ phân giải HD 1366x768, kích thước 729 x 427 x 84mm cùng khối lượng chỉ có 3.5kg, phù hợp với nhiều không gian sống, đem lại cho nơi ở sự sang trọng và gọn gàng nhờ vẻ ngoài siêu mỏng và tinh tế của nó. Chân đế nhựa chữ V úp ngược viền kim loại sẽ giúp tivi trụ vững vàng mà không làm mất đi thẩm mỹ của tivi.</p>', 'Xiaomi TV A Pro 65 ', 628, 6),
(10, '<p><strong>Mua Tivi Toshiba LED HD Smart TV 32V35KP chính hãng, giá rẻ tại Hoàng Hà Mobile</strong></p><p><strong>Tivi Toshiba LED HD Smart TV 32V35KP </strong>là chiếc tivi có kích thước 32 inch, đi cùng với đó là độ phân giải HD. SmartTV đến từ Toshiba rang bị bộ xử lý Regza Engine HG, sẽ giúp tối ưu hóa chất lượng hình ảnh lên tầm mới và Contrast Booster sẽ kiểm soát độ tương phản của màu sắc trên màn hình cho hình ảnh hiển thị chân thực hơn, hơn thế nữa, công nghệ Color Re-Master sẽ hỗ trợ khôi phục lại màu sắc một cách tự nhiên. Âm thanh của TUV cũng cực kỳ chân thực nhờ giải mã âm thanh DTS HD, Dolby Audio đem đến âm thanh vòm sống động cùng hệ điều hành Android 9.0 mở ra kho ứng dụng phong phú.</p><h2><strong>Thiết kế sang trọng</strong></h2><p><strong>Tivi Toshiba LED HD Smart TV 32V35KP </strong>sở hữu thiết kế nhỏ gọn, đi cùng tone màu đen tối giản nhưng sang trọng, tạo nên nét thanh lịch và là điểm nhấn cho không gian nhà của người dùng. Tivi còn cực kỳ phù hợp với các không gian phòng khách, phòng ngủ nhỏ vì sản phẩm này được trang bị kích thước 32 inch, không quá to cũng không quá nhỏ làm ảnh hưởng đến trải nghiệm xem phim. <strong>Tivi Toshiba LED HD Smart TV 32V35KP </strong>còn đi kèm chân đế được làm bằng nhựa chắc chắn, với thiết kế dạng chữ V úp ngược sẽ giúp tivi có thể đứng vững trên bàn hay kệ tủ mà không bị lung lay bởi các va chạm nhỏ. Tivi còn có thể tiết kiệm không gian hơn nhờ khả năng cho phép treo tường hiện đại, giúp tiết kiệm được không gian.</p>', 'TV TOSHIBA 32V35KP (HD/32-inch)', 300, 7),
(11, '<p>Nếu bạn đang tìm kiếm một tai nghe có âm bass trầm lắng đủ mạnh mẽ để tái hiện lại những âm thanh chắc nốt nhất thì hãy lựa chọn ngay một em <strong>tai nghe JBL Wave Beam</strong>. JBL Wave Beam mang đến công nghệ âm thanh <strong>Deep Bass Sound</strong> phục vụ thường thức âm nhạc đầy đam mê, công nghệ <strong>Smart Ambient</strong> và <strong>VoiceAware </strong>cho trải nghiệm người dùng thuận tiện và linh hoạt hơn bao giờ hết. Ngoài ra thiết kế <strong>công thái học</strong> và chuẩn chống nước chống bụi <strong>IPX2/IP54</strong> của tai nghe và hộp đựng đem lại cho bạn một sản phẩm chất lượng bền bỉ.</p><p><strong>Tai nghe JBL Wave Beam - âm bass trầm lắng tái tạo thế giới âm thanh chân thực</strong></p><p>Tai nghe Bluetooth True Wireless JBL Wave Beam nhỏ gọn, tiện dụng với nhiều lựa chọn đa màu sắc phong cách. Ngoài thiết kế hài hòa nịnh mắt số đông, JBL Wave Beam còn đem đến những trải nghiệm âm thanh chất lượng, mang uy tín thương hiệu.</p><p><strong>Tai nghe vừa vặn, thiết kế đa màu sắc</strong></p><p>Tai nghe JBL Wave Beam được thiết kế theo nguyên tắc công thái học, với mục tiêu đem đến một trải nghiệm đeo tai tối ưu, \"đeo như không đeo\" giúp thời gian học tập và làm việc của người dùng được thoải mái nhất có thể. Thiết kế vừa khít với kích cỡ tai phổ thông kết hợp với cấu tạo tai nghe khép kín, JBL Wave Beam tạo ra “màn chắn” hoàn hảo để tạp âm từ môi trường bên ngoài không thể xâm nhập làm nhiễu không gian giai điệu bên trong tai nghe, bạn sẽ hoàn toàn chìm đắm trong thời gian của riêng mình.</p>', 'Tai nghe Bluetooth True Wireless JBL Wave Beam', 400, 9),
(12, '<p>Nếu bạn đang tìm kiếm một tai nghe có âm bass trầm lắng đủ mạnh mẽ để tái hiện lại những âm thanh chắc nốt nhất thì hãy lựa chọn ngay một em <strong>tai nghe JBL Wave Beam</strong>. JBL Wave Beam mang đến công nghệ âm thanh <strong>Deep Bass Sound</strong> phục vụ thường thức âm nhạc đầy đam mê, công nghệ <strong>Smart Ambient</strong> và <strong>VoiceAware </strong>cho trải nghiệm người dùng thuận tiện và linh hoạt hơn bao giờ hết. Ngoài ra thiết kế <strong>công thái học</strong> và chuẩn chống nước chống bụi <strong>IPX2/IP54</strong> của tai nghe và hộp đựng đem lại cho bạn một sản phẩm chất lượng bền bỉ.</p><p><strong>Tai nghe JBL Wave Beam - âm bass trầm lắng tái tạo thế giới âm thanh chân thực</strong></p><p>Tai nghe Bluetooth True Wireless JBL Wave Beam nhỏ gọn, tiện dụng với nhiều lựa chọn đa màu sắc phong cách. Ngoài thiết kế hài hòa nịnh mắt số đông, JBL Wave Beam còn đem đến những trải nghiệm âm thanh chất lượng, mang uy tín thương hiệu.</p><p><strong>Tai nghe vừa vặn, thiết kế đa màu sắc</strong></p><p>Tai nghe JBL Wave Beam được thiết kế theo nguyên tắc công thái học, với mục tiêu đem đến một trải nghiệm đeo tai tối ưu, \"đeo như không đeo\" giúp thời gian học tập và làm việc của người dùng được thoải mái nhất có thể. Thiết kế vừa khít với kích cỡ tai phổ thông kết hợp với cấu tạo tai nghe khép kín, JBL Wave Beam tạo ra “màn chắn” hoàn hảo để tạp âm từ môi trường bên ngoài không thể xâm nhập làm nhiễu không gian giai điệu bên trong tai nghe, bạn sẽ hoàn toàn chìm đắm trong thời gian của riêng mình.</p>', 'Tai nghe Tai nghe Beats Solo3 Wireless Headphones ', 524, 9),
(19, '<p>aaaa</p>', 'DIen Thoai Iphone', 10000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product_image`
--

CREATE TABLE `product_image` (
  `id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_image`
--

INSERT INTO `product_image` (`id`, `url`, `product_id`) VALUES
(6, '8589img1.webp', 2),
(7, '8589img2.webp', 2),
(8, '8589img4.webp', 2),
(9, '8589img5.webp', 2),
(10, '8589img3.webp', 2),
(16, '58106img5.webp', 4),
(17, '58106img4.webp', 4),
(18, '58106img1.webp', 4),
(19, '58106img2.webp', 4),
(20, '58106img3.webp', 4),
(21, '80text_ng_n_16__3_3_1.webp', 5),
(22, '80text_ng_n_14__3_3_1.webp', 5),
(23, '80text_ng_n_15__5_6_1.webp', 5),
(24, '80text_ng_n_21__2_3.webp', 5),
(25, '80text_ng_n_17__4_2_1.webp', 5),
(26, '26oop1.webp', 6),
(27, '26oop2.webp', 6),
(28, '26oop4.webp', 6),
(29, '26oop3.webp', 6),
(30, '26oop5.webp', 6),
(31, '19text_ng_n_5_6.webp', 7),
(32, '19macbook_air_m2_8gb_512.webp', 7),
(33, '19text_ng_n_7__104.webp', 7),
(34, '19text_ng_n_6__107.webp', 7),
(35, '19text_ng_n_1__2_18.webp', 7),
(36, '282_54_9_2.webp', 8),
(37, '28macbook_air_m2_3_1_1.webp', 8),
(38, '28macbook_air_m2_2_1_1.webp', 8),
(39, '28macbook_air_m2_1_1_1.webp', 8),
(40, '28macbook_air_m2_4_1_1.webp', 8),
(46, '8650c350lp-2.webp', 10),
(47, '86a-pro-65-30-r4-1_638260631706585733.webp', 10),
(48, '86a-pro-65-r5-1_638260631706585733.webp', 10),
(49, '86a-pro-65-r5-1.webp', 10),
(50, '86a-pro-65-30-r4-1.webp', 10),
(51, '72true-wireless-jbl-wave-beam-4.webp', 11),
(52, '72true-wireless-jbl-wave-beam-5.webp', 11),
(53, '72true-wireless-jbl-wave-beam-3.webp', 11),
(54, '72true-wireless-jbl-wave-beam-6.webp', 11),
(55, '72true-wireless-jbl-wave-beam-8.webp', 11),
(56, '98beats-solo3-3.webp', 12),
(57, '98beats-solo3-1.webp', 12),
(58, '98beats-solo3-4.webp', 12),
(59, '98beats-solo3-2 (1).webp', 12),
(60, '98beats-solo3-2.webp', 12),
(61, '99image-removebg-preview-2022-12-06t160401-507.webp', 9),
(62, '99image-removebg-preview-2022-12-06t160402-603.webp', 9),
(63, '99image-removebg-preview-2022-12-06t160403-634.webp', 9),
(64, '99image-removebg-preview-2022-12-06t160400-641 (1).webp', 9),
(65, '99image-removebg-preview-2022-12-06t160400-641.webp', 9),
(66, '105image-removebg-preview-2022-12-06t160401-507.webp', 9),
(67, '105image-removebg-preview-2022-12-06t160402-603.webp', 9),
(68, '105image-removebg-preview-2022-12-06t160403-634.webp', 9),
(69, '105image-removebg-preview-2022-12-06t160400-641 (1).webp', 9),
(70, '105image-removebg-preview-2022-12-06t160400-641.webp', 9),
(87, '5233333.webp', 19),
(88, '5244444.webp', 19),
(89, '52222222.webp', 19),
(90, 'file null', 19),
(91, '10189img5.webp', 19);

-- --------------------------------------------------------

--
-- Table structure for table `product_user`
--

CREATE TABLE `product_user` (
  `user_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `view` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_user`
--

INSERT INTO `product_user` (`user_id`, `product_id`, `view`) VALUES
(2, 2, 10),
(2, 4, 7),
(2, 5, 3),
(2, 6, 1),
(2, 8, 4),
(2, 9, 1),
(2, 10, 3),
(2, 12, 1),
(2, 19, 1),
(3, 2, 1),
(3, 4, 3),
(3, 6, 5),
(3, 9, 5),
(3, 11, 1),
(3, 12, 1),
(6, 4, 1),
(6, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `cart_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `address`, `date`, `email`, `name`, `password`, `phone`, `cart_id`) VALUES
(2, 'Hue', '2023-12-29 20:25:07.000000', 'a@gmail.com', 'Hung Tran', 'a', '99999', 2),
(3, 'USA', '2024-01-01 22:45:58.000000', 'm@gmail.com', 'Elon Musk', 'a', '9999999', 3),
(4, 'UK', '2024-01-02 07:47:48.000000', 'b@gmail.com', 'Mark', 'a', '123456', 4),
(5, 'UK', '2024-01-04 09:57:56.000000', 'c@gmail.com', 'Lion messi', 'b', '919999239', 5),
(6, 'Da Nang', '2024-08-12 11:45:58.000000', 'aa@gmail.com', 'Cong Hung', 'aa', '9999999', 6),
(7, 'aaaaaa', '2024-09-25 09:06:31.000000', 'aaa@gmail.com', 'CongHung', 'a', '123123123', 7);

-- --------------------------------------------------------

--
-- Table structure for table `user_comment`
--

CREATE TABLE `user_comment` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_comment`
--

INSERT INTO `user_comment` (`id`, `comment`, `date_time`, `rating`, `product_id`, `user_id`) VALUES
(2, 'may dùng khá ok', '2023-12-29 23:20:25.000000', 3, 5, 2),
(5, 'tam tam', '2023-12-29 23:57:46.000000', 5, 5, 2),
(6, 'ok', '2024-01-02 07:49:30.000000', 5, 7, 4),
(7, 'ok', '2024-01-02 08:12:57.000000', 4, 2, 4),
(8, 'tam on', '2024-01-06 07:35:34.000000', 1, 2, 2),
(9, 'ok', '2024-01-06 08:03:19.000000', 4, 2, 2),
(10, 'aaaa', '2024-12-20 10:36:53.000000', 5, 10, 2),
(11, 'aaasdsa123123123', '2024-12-20 10:37:10.000000', 1, 10, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqg4ujw966n0rdwm86l9dwgj19` (`category_id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart_product`
--
ALTER TABLE `cart_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlv5x4iresnv4xspvomrwd8ej9` (`cart_id`),
  ADD KEY `FK2kdlr8hs2bwl14u8oop49vrxi` (`product_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `color`
--
ALTER TABLE `color`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_9wbuy6m9dnq61w7e1ouwpwchy` (`product_id`);

--
-- Indexes for table `info_color`
--
ALTER TABLE `info_color`
  ADD PRIMARY KEY (`info_id`,`color_id`),
  ADD KEY `FKflhloxbh5d4krf4hpwnnhwjf8` (`color_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1abokg3ghque9pf2ujbxakng` (`status_id`),
  ADD KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`);

--
-- Indexes for table `order_product`
--
ALTER TABLE `order_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl5mnj9n0di7k1v90yxnthkc73` (`order_id`);

--
-- Indexes for table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`);

--
-- Indexes for table `product_image`
--
ALTER TABLE `product_image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`);

--
-- Indexes for table `product_user`
--
ALTER TABLE `product_user`
  ADD PRIMARY KEY (`user_id`,`product_id`),
  ADD KEY `FKiuj2a4hfnom5nla727e3ltr48` (`product_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_47dq8urpj337d3o65l3fsjph3` (`cart_id`);

--
-- Indexes for table `user_comment`
--
ALTER TABLE `user_comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmi586lvrh7vsbsr16mcuhgxe5` (`product_id`),
  ADD KEY `FKornrskknlmumgdhlohpbcvrw5` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `cart_product`
--
ALTER TABLE `cart_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `color`
--
ALTER TABLE `color`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `information`
--
ALTER TABLE `information`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `order_product`
--
ALTER TABLE `order_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `order_status`
--
ALTER TABLE `order_status`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `product_image`
--
ALTER TABLE `product_image`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user_comment`
--
ALTER TABLE `user_comment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `brand`
--
ALTER TABLE `brand`
  ADD CONSTRAINT `FKqg4ujw966n0rdwm86l9dwgj19` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `cart_product`
--
ALTER TABLE `cart_product`
  ADD CONSTRAINT `FK2kdlr8hs2bwl14u8oop49vrxi` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKlv5x4iresnv4xspvomrwd8ej9` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`);

--
-- Constraints for table `information`
--
ALTER TABLE `information`
  ADD CONSTRAINT `FKn39bb0lss87nksgb40c1u02x9` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `info_color`
--
ALTER TABLE `info_color`
  ADD CONSTRAINT `FK9lqxwt5qgp3jxuuunplp3gucn` FOREIGN KEY (`info_id`) REFERENCES `information` (`id`),
  ADD CONSTRAINT `FKflhloxbh5d4krf4hpwnnhwjf8` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK1abokg3ghque9pf2ujbxakng` FOREIGN KEY (`status_id`) REFERENCES `order_status` (`id`),
  ADD CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `order_product`
--
ALTER TABLE `order_product`
  ADD CONSTRAINT `FKl5mnj9n0di7k1v90yxnthkc73` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

--
-- Constraints for table `product_image`
--
ALTER TABLE `product_image`
  ADD CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `product_user`
--
ALTER TABLE `product_user`
  ADD CONSTRAINT `FKiuj2a4hfnom5nla727e3ltr48` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKs0h810dfkus35pvkhneqsp2vb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKtqa69bib34k2c0jhe7afqsao6` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`);

--
-- Constraints for table `user_comment`
--
ALTER TABLE `user_comment`
  ADD CONSTRAINT `FKmi586lvrh7vsbsr16mcuhgxe5` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKornrskknlmumgdhlohpbcvrw5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
