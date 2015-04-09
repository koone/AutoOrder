CREATE DATABASE autoorder;

USE autoorder;

CREATE TABLE keyvalue(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	key_name VARCHAR(100) NOT NULL UNIQUE,
	key_value VARCHAR(2000),
	key_descripe VARCHAR(2000),
	key_type TINYINT(3) COMMENT "存储方式：1.map、2.list",
	is_delete TINYINT(1) COMMENT "是否删除",
	INDEX key_name_index(key_name)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE hospital(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(200) NOT NULL,
	address VARCHAR(200),
	telphone VARCHAR(100),
	hospital_type TINYINT(3) NOT NULL,
	hospital_rank TINYINT(3) NOT NULL,
	hospital_area TINYINT(3) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE outpatient(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	hospital_id INT(10) NOT NULL,
	department VARCHAR(200) NOT NULL,
	outpatient_name VARCHAR(200) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE doctor(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	outpatient_id INT(10) NOT NULL,
	doctor_name VARCHAR(100) NOT NULL,
	doctor_rank VARCHAR(100) ,
	reg_fees DOUBLE DEFAULT 0,
	descripe VARCHAR(500),
	reg_count TINYINT(4)
)ENGINE=INNODB DEFAULT CHARSET = utf8;

CREATE TABLE orders(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	patient_name VARCHAR(50),
	patient_idcard VARCHAR(50),
	patient_telphone VARCHAR(50),
	patient_hospitalcard VARCHAR(50),
	hospital_id INT(10),
	outpatient_id INT(10),
	doctor_id INT(10),
	reg_fees DOUBLE DEFAULT 0,
	order_time TIMESTAMP NOT NULL,
	operator_baiduid INT(20)
)ENGINE=INNODB DEFAULT CHARSET=utf8


INSERT INTO autoorder.keyvalue (key_name, key_value, key_descripe, key_type, is_delete) VALUES ('HospitalType', '1:卫生部直属医院,2:北京市卫生局直属医院,3:中国医科院所属医院,4:中国中医科学院,5:北京中医药大学,6:北京大学附属医院,7:驻京部队医院,8:驻京武警医院,9:部属厂矿高校医院,10:北京区县属医院,11:其它', '医院所属类型', '1', '0');
INSERT INTO autoorder.keyvalue (key_name, key_value, key_descripe, key_type, is_delete) VALUES ('HospitalRank', '3:三级,2:二级,1:一级', '医院等级', '1', '0');
INSERT INTO autoorder.keyvalue (key_name, key_value, key_descripe, key_type, is_delete) VALUES ('HospitalArea', '1:东城,2:西城,4:海淀,3:朝阳,5:丰台,6:石景山,12:昌平,15:密云,13:平谷,10:顺义,7:门头沟,8:房山,9:通州,11:大兴,14:怀柔,16:延庆 ', '医院所属区域', '1', '0'); 