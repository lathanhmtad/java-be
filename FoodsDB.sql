CREATE TABLE `role` (
  `r_id` int PRIMARY KEY,
  `r_name` nvarchar
);

CREATE TABLE `users` (
  `u_id` int PRIMARY KEY,
  `u_fullname` nvarchar,
  `u_email` varchar(255),
  `u_phone` varchar(255),
  `u_address` varchar(255),
  `u_password` varchar(255),
  `u_created_at` datetime,
  `u_updated_at` datetime,
  `u_deleted` bit,
  `r_id` int
);

CREATE TABLE `categories` (
  `c_id` int PRIMARY KEY,
  `c_name` nvarchar
);

CREATE TABLE `product` (
  `p_id` int PRIMARY KEY,
  `p_name` nvarchar,
  `p_trademark` nvarchar,
  `p_status` nvarchar,
  `p_amount` int,
  `p_price` int,
  `p_discount` int,
  `p_source` nvarchar,
  `p_mass` double,
  `p_description` longtext,
  `p_created_at` datetime,
  `p_updated_at` datetime,
  `p_deleted` bit,
  `c_id` int
);

CREATE TABLE `galery` (
  `g_id` int PRIMARY KEY,
  `g_thumbnail` varchar(255),
  `p_id` int
);

CREATE TABLE `feedback` (
  `fb_id` int PRIMARY KEY,
  `fb_fullname` nvarchar,
  `fb_email` varchar(255),
  `fb_note` nvarchar
);

CREATE TABLE `orders` (
  `o_id` int PRIMARY KEY,
  `o_fullname` nvarchar,
  `o_email` varchar(255),
  `o_phone` varchar(255),
  `o_address` nvarchar,
  `o_note` nvarchar,
  `o_date` datetime,
  `o_status` nvarchar,
  `o_shipped` nvarchar,
  `u_id` int
);

CREATE TABLE `order_details` (
  `od_id` int PRIMARY KEY,
  `od_price` int,
  `od_amount` int,
  `o_id` int,
  `p_id` int
);

ALTER TABLE `product` ADD FOREIGN KEY (`c_id`) REFERENCES `categories` (`c_id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`o_id`) REFERENCES `orders` (`o_id`);

ALTER TABLE `galery` ADD FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`);

ALTER TABLE `users` ADD FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`);
