create database autoorder;

use autoorder;

create table keyvalue(
	id int(10) not null auto_increment primary key,
	key_name varchar(100) not null unique,
	key_value varchar(2000),
	key_descripe varchar(2000),
	key_type tinyint(3) comment "存储方式：1.map、2.list",
	is_delete tinyint(1) comment "是否删除",
	index key_name_index(key_name)
)engine=innodb default charset=utf8;

create table hospital(
	id int(10) not null auto_increment primary key,
	name varchar(200) not null,
	address varchar(200),
	telphone varchar(100),
	hospital_type tinyint(3) not null,
	hospital_rank tinyint(3) not null,
	hospital_area tinyint(3) not null
)engine=innodb default charset=utf8;

create table outpatient(
	id int(10) not null auto_increment primary key,
	hospital_id int(10) not null,
	department varchar(200) not null,
	outpatient_name varchar(200) not null
)engine=innodb default charset=utf8;


INSERT INTO autoorder.keyvalue (key_name, key_value, key_descripe, key_type, is_delete) VALUES ('HospitalType', '1:卫生部直属医院,2:北京市卫生局直属医院,3:中国医科院所属医院,4:中国中医科学院,5:北京中医药大学,6:北京大学附属医院,7:驻京部队医院,8:驻京武警医院,9:部属厂矿高校医院,10:北京区县属医院,11:其它', '医院所属类型', '1', '0');
INSERT INTO autoorder.keyvalue (key_name, key_value, key_descripe, key_type, is_delete) VALUES ('HospitalRank', '3:三级,2:二级,1:一级', '医院等级', '1', '0');
INSERT INTO autoorder.keyvalue (key_name, key_value, key_descripe, key_type, is_delete) VALUES ('HospitalArea', '1:东城,2:西城,4:海淀,3:朝阳,5:丰台,6:石景山,12:昌平,15:密云,13:平谷,10:顺义,7:门头沟,8:房山,9:通州,11:大兴,14:怀柔,16:延庆 ', '医院所属区域', '1', '0'); 