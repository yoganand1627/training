update caps.codes_tables set dt_end=null where code_type='CEDUCNED' and code='COL';

commit;

update caps.employee set ID_EMP_OFFICE = decode(mod(id_emp_office,164),0,164,mod(id_emp_office,164));
update caps.perf_tally set id_office=405 where id_office=404;
update caps.perf_tally set id_office=263 where id_office=262;
update caps.perf_tally set ID_OFFICE = decode(mod(id_office,164),0,164,mod(id_office,164));

truncate table caps.office_phone;
truncate table caps.case_file_management;

alter table caps.employee disable constraint fk_emp_office;
alter table caps.perf_tally disable constraint fk_perf_tally_office;
alter table caps.case_file_loc disable constraint fk_case_file_loc_office;
alter table caps.case_file_management disable constraint fk_case_file_office;
alter table caps.office_phone disable constraint fk_office_phone;

DROP SEQUENCE CAPS.SEQ_OFFICE;

CREATE SEQUENCE CAPS.SEQ_OFFICE
  START WITH 165
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;

GRANT SELECT ON  CAPS.SEQ_OFFICE TO CAPSON;

GRANT SELECT ON  CAPS.SEQ_OFFICE TO CAPSBAT;

GRANT SELECT ON  CAPS.SEQ_OFFICE TO OPERATOR;

truncate table caps.office;

insert into caps.office values(1,to_date('01/01/2006','MM/DD/YYYY'),'001','CPS','09',null,'Appling');
insert into caps.office values(2,to_date('01/01/2006','MM/DD/YYYY'),'002','CPS','11',null,'Atkinson');
insert into caps.office values(3,to_date('01/01/2006','MM/DD/YYYY'),'003','CPS','11',null,'Bacon');
insert into caps.office values(4,to_date('01/01/2006','MM/DD/YYYY'),'004','CPS','10',null,'Baker');
insert into caps.office values(5,to_date('01/01/2006','MM/DD/YYYY'),'005','CPS','06',null,'Baldwin');
insert into caps.office values(6,to_date('01/01/2006','MM/DD/YYYY'),'006','CPS','02',null,'Banks');
insert into caps.office values(7,to_date('01/01/2006','MM/DD/YYYY'),'007','CPS','05',null,'Barrow');
insert into caps.office values(8,to_date('01/01/2006','MM/DD/YYYY'),'008','CPS','01',null,'Bartow');
insert into caps.office values(9,to_date('01/01/2006','MM/DD/YYYY'),'009','CPS','11',null,'Ben Hill');
insert into caps.office values(10,to_date('01/01/2006','MM/DD/YYYY'),'010','CPS','11',null,'Berrien');
insert into caps.office values(11,to_date('01/01/2006','MM/DD/YYYY'),'011','CPS','06',null,'Bibb');
insert into caps.office values(12,to_date('01/01/2006','MM/DD/YYYY'),'012','CPS','09',null,'Bleckley');
insert into caps.office values(13,to_date('01/01/2006','MM/DD/YYYY'),'013','CPS','11',null,'Brantley');
insert into caps.office values(14,to_date('01/01/2006','MM/DD/YYYY'),'014','CPS','11',null,'Brooks');
insert into caps.office values(15,to_date('01/01/2006','MM/DD/YYYY'),'015','CPS','12',null,'Bryan');
insert into caps.office values(16,to_date('01/01/2006','MM/DD/YYYY'),'016','CPS','12',null,'Bulloch');
insert into caps.office values(17,to_date('01/01/2006','MM/DD/YYYY'),'017','CPS','07',null,'Burke');
insert into caps.office values(18,to_date('01/01/2006','MM/DD/YYYY'),'018','CPS','04',null,'Butts');
insert into caps.office values(19,to_date('01/01/2006','MM/DD/YYYY'),'019','CPS','10',null,'Calhoun');
insert into caps.office values(20,to_date('01/01/2006','MM/DD/YYYY'),'020','CPS','12',null,'Camden');
insert into caps.office values(21,to_date('01/01/2006','MM/DD/YYYY'),'021','CPS','09',null,'Candler');
insert into caps.office values(22,to_date('01/01/2006','MM/DD/YYYY'),'022','CPS','04',null,'Carroll');
insert into caps.office values(23,to_date('01/01/2006','MM/DD/YYYY'),'023','CPS','01',null,'Catoosa');
insert into caps.office values(24,to_date('01/01/2006','MM/DD/YYYY'),'024','CPS','11',null,'Charlton');
insert into caps.office values(25,to_date('01/01/2006','MM/DD/YYYY'),'025','CPS','12',null,'Chatham');
insert into caps.office values(26,to_date('01/01/2006','MM/DD/YYYY'),'026','CPS','08',null,'Chattahoochee');
insert into caps.office values(27,to_date('01/01/2006','MM/DD/YYYY'),'027','CPS','01',null,'Chattooga');
insert into caps.office values(28,to_date('01/01/2006','MM/DD/YYYY'),'028','CPS','3B',null,'Cherokee');
insert into caps.office values(29,to_date('01/01/2006','MM/DD/YYYY'),'029','CPS','05',null,'Clarke');
insert into caps.office values(30,to_date('01/01/2006','MM/DD/YYYY'),'030','CPS','08',null,'Clay');
insert into caps.office values(31,to_date('01/01/2006','MM/DD/YYYY'),'031','CPS','3B',null,'Clayton');
insert into caps.office values(32,to_date('01/01/2006','MM/DD/YYYY'),'032','CPS','11',null,'Clinch');
insert into caps.office values(33,to_date('01/01/2006','MM/DD/YYYY'),'033','CPS','3B',null,'Cobb');
insert into caps.office values(34,to_date('01/01/2006','MM/DD/YYYY'),'034','CPS','11',null,'Coffee');
insert into caps.office values(35,to_date('01/01/2006','MM/DD/YYYY'),'035','CPS','10',null,'Colquitt');
insert into caps.office values(36,to_date('01/01/2006','MM/DD/YYYY'),'036','CPS','07',null,'Columbia');
insert into caps.office values(37,to_date('01/01/2006','MM/DD/YYYY'),'037','CPS','11',null,'Cook');
insert into caps.office values(38,to_date('01/01/2006','MM/DD/YYYY'),'038','CPS','04',null,'Coweta');
insert into caps.office values(39,to_date('01/01/2006','MM/DD/YYYY'),'039','CPS','06',null,'Crawford');
insert into caps.office values(40,to_date('01/01/2006','MM/DD/YYYY'),'040','CPS','08',null,'Crisp');
insert into caps.office values(41,to_date('01/01/2006','MM/DD/YYYY'),'041','CPS','01',null,'Dade');
insert into caps.office values(42,to_date('01/01/2006','MM/DD/YYYY'),'042','CPS','02',null,'Dawson');
insert into caps.office values(43,to_date('01/01/2006','MM/DD/YYYY'),'043','CPS','10',null,'Decatur');
insert into caps.office values(44,to_date('01/01/2006','MM/DD/YYYY'),'044','CPS','3A',null,'DeKalb 1');
insert into caps.office values(45,to_date('01/01/2006','MM/DD/YYYY'),'045','CPS','3A',null,'DeKalb 2');
insert into caps.office values(46,to_date('01/01/2006','MM/DD/YYYY'),'046','CPS','09',null,'Dodge');
insert into caps.office values(47,to_date('01/01/2006','MM/DD/YYYY'),'047','CPS','08',null,'Dooly');
insert into caps.office values(48,to_date('01/01/2006','MM/DD/YYYY'),'048','CPS','10',null,'Dougherty');
insert into caps.office values(49,to_date('01/01/2006','MM/DD/YYYY'),'049','CPS','3B',null,'Douglas');
insert into caps.office values(50,to_date('01/01/2006','MM/DD/YYYY'),'050','CPS','10',null,'Early');
insert into caps.office values(51,to_date('01/01/2006','MM/DD/YYYY'),'051','CPS','11',null,'Echols');
insert into caps.office values(52,to_date('01/01/2006','MM/DD/YYYY'),'052','CPS','12',null,'Effingham');
insert into caps.office values(53,to_date('01/01/2006','MM/DD/YYYY'),'053','CPS','05',null,'Elbert');
insert into caps.office values(54,to_date('01/01/2006','MM/DD/YYYY'),'054','CPS','09',null,'Emanuel');
insert into caps.office values(55,to_date('01/01/2006','MM/DD/YYYY'),'055','CPS','09',null,'Evans');
insert into caps.office values(56,to_date('01/01/2006','MM/DD/YYYY'),'056','CPS','01',null,'Fannin');
insert into caps.office values(57,to_date('01/01/2006','MM/DD/YYYY'),'057','CPS','3B',null,'Fayette');
insert into caps.office values(58,to_date('01/01/2006','MM/DD/YYYY'),'058','CPS','01',null,'Floyd');
insert into caps.office values(59,to_date('01/01/2006','MM/DD/YYYY'),'059','CPS','02',null,'Forsyth');
insert into caps.office values(60,to_date('01/01/2006','MM/DD/YYYY'),'060','CPS','02',null,'Franklin');
insert into caps.office values(61,to_date('01/01/2006','MM/DD/YYYY'),'061','CPS','3A',null,'Fulton #1');
insert into caps.office values(62,to_date('01/01/2006','MM/DD/YYYY'),'062','CPS','3A',null,'Fulton #2');
insert into caps.office values(63,to_date('01/01/2006','MM/DD/YYYY'),'063','CPS','3A',null,'Fulton #3');
insert into caps.office values(64,to_date('01/01/2006','MM/DD/YYYY'),'064','CPS','3A',null,'Fulton #4');
insert into caps.office values(65,to_date('01/01/2006','MM/DD/YYYY'),'065','CPS','3A',null,'Fulton #5');
insert into caps.office values(66,to_date('01/01/2006','MM/DD/YYYY'),'066','CPS','01',null,'Gilmer');
insert into caps.office values(67,to_date('01/01/2006','MM/DD/YYYY'),'067','CPS','07',null,'Glascock');
insert into caps.office values(68,to_date('01/01/2006','MM/DD/YYYY'),'068','CPS','12',null,'Glynn');
insert into caps.office values(69,to_date('01/01/2006','MM/DD/YYYY'),'069','CPS','01',null,'Gordon');
insert into caps.office values(70,to_date('01/01/2006','MM/DD/YYYY'),'070','CPS','10',null,'Grady');
insert into caps.office values(71,to_date('01/01/2006','MM/DD/YYYY'),'071','CPS','05',null,'Greene');
insert into caps.office values(72,to_date('01/01/2006','MM/DD/YYYY'),'072','CPS','3B',null,'Gwinnett');
insert into caps.office values(73,to_date('01/01/2006','MM/DD/YYYY'),'073','CPS','02',null,'Habersham');
insert into caps.office values(74,to_date('01/01/2006','MM/DD/YYYY'),'074','CPS','02',null,'Hall');
insert into caps.office values(75,to_date('01/01/2006','MM/DD/YYYY'),'075','CPS','07',null,'Hancock');
insert into caps.office values(76,to_date('01/01/2006','MM/DD/YYYY'),'076','CPS','01',null,'Haralson');
insert into caps.office values(77,to_date('01/01/2006','MM/DD/YYYY'),'077','CPS','08',null,'Harris');
insert into caps.office values(78,to_date('01/01/2006','MM/DD/YYYY'),'078','CPS','02',null,'Hart');
insert into caps.office values(79,to_date('01/01/2006','MM/DD/YYYY'),'079','CPS','04',null,'Heard');
insert into caps.office values(80,to_date('01/01/2006','MM/DD/YYYY'),'080','CPS','3B',null,'Henry');
insert into caps.office values(81,to_date('01/01/2006','MM/DD/YYYY'),'081','CPS','06',null,'Houston');
insert into caps.office values(82,to_date('01/01/2006','MM/DD/YYYY'),'082','CPS','11',null,'Irwin');
insert into caps.office values(83,to_date('01/01/2006','MM/DD/YYYY'),'083','CPS','05',null,'Jackson');
insert into caps.office values(84,to_date('01/01/2006','MM/DD/YYYY'),'084','CPS','05',null,'Jasper');
insert into caps.office values(85,to_date('01/01/2006','MM/DD/YYYY'),'085','CPS','09',null,'Jeff Davis');
insert into caps.office values(86,to_date('01/01/2006','MM/DD/YYYY'),'086','CPS','07',null,'Jefferson');
insert into caps.office values(87,to_date('01/01/2006','MM/DD/YYYY'),'087','CPS','07',null,'Jenkins');
insert into caps.office values(88,to_date('01/01/2006','MM/DD/YYYY'),'088','CPS','09',null,'Johnson');
insert into caps.office values(89,to_date('01/01/2006','MM/DD/YYYY'),'089','CPS','06',null,'Jones');
insert into caps.office values(90,to_date('01/01/2006','MM/DD/YYYY'),'090','CPS','04',null,'Lamar');
insert into caps.office values(91,to_date('01/01/2006','MM/DD/YYYY'),'091','CPS','11',null,'Lanier');
insert into caps.office values(92,to_date('01/01/2006','MM/DD/YYYY'),'092','CPS','09',null,'Laurens');
insert into caps.office values(93,to_date('01/01/2006','MM/DD/YYYY'),'093','CPS','10',null,'Lee');
insert into caps.office values(94,to_date('01/01/2006','MM/DD/YYYY'),'094','CPS','12',null,'Liberty');
insert into caps.office values(95,to_date('01/01/2006','MM/DD/YYYY'),'095','CPS','07',null,'Lincoln');
insert into caps.office values(96,to_date('01/01/2006','MM/DD/YYYY'),'096','CPS','12',null,'Long');
insert into caps.office values(97,to_date('01/01/2006','MM/DD/YYYY'),'097','CPS','11',null,'Lowndes');
insert into caps.office values(98,to_date('01/01/2006','MM/DD/YYYY'),'098','CPS','02',null,'Lumpkin');
insert into caps.office values(99,to_date('01/01/2006','MM/DD/YYYY'),'099','CPS','08',null,'Macon');
insert into caps.office values(100,to_date('01/01/2006','MM/DD/YYYY'),'100','CPS','05',null,'Madison');
insert into caps.office values(101,to_date('01/01/2006','MM/DD/YYYY'),'101','CPS','08',null,'Marion');
insert into caps.office values(102,to_date('01/01/2006','MM/DD/YYYY'),'102','CPS','07',null,'McDuffie');
insert into caps.office values(103,to_date('01/01/2006','MM/DD/YYYY'),'103','CPS','12',null,'McIntosh');
insert into caps.office values(104,to_date('01/01/2006','MM/DD/YYYY'),'104','CPS','04',null,'Meriwether');
insert into caps.office values(105,to_date('01/01/2006','MM/DD/YYYY'),'105','CPS','10',null,'Miller');
insert into caps.office values(106,to_date('01/01/2006','MM/DD/YYYY'),'106','CPS','10',null,'Mitchell');
insert into caps.office values(107,to_date('01/01/2006','MM/DD/YYYY'),'107','CPS','06',null,'Monroe');
insert into caps.office values(108,to_date('01/01/2006','MM/DD/YYYY'),'108','CPS','09',null,'Montgomery');
insert into caps.office values(109,to_date('01/01/2006','MM/DD/YYYY'),'109','CPS','05',null,'Morgan');
insert into caps.office values(110,to_date('01/01/2006','MM/DD/YYYY'),'110','CPS','01',null,'Murray');
insert into caps.office values(111,to_date('01/01/2006','MM/DD/YYYY'),'111','CPS','08',null,'Muscogee');
insert into caps.office values(112,to_date('01/01/2006','MM/DD/YYYY'),'112','CPS','05',null,'Newton');
insert into caps.office values(113,to_date('01/01/2006','MM/DD/YYYY'),'113','CPS','05',null,'Oconee');
insert into caps.office values(114,to_date('01/01/2006','MM/DD/YYYY'),'114','CPS','05',null,'Oglethorpe');
insert into caps.office values(115,to_date('01/01/2006','MM/DD/YYYY'),'115','CPS','01',null,'Paulding');
insert into caps.office values(116,to_date('01/01/2006','MM/DD/YYYY'),'116','CPS','06',null,'Peach');
insert into caps.office values(117,to_date('01/01/2006','MM/DD/YYYY'),'117','CPS','01',null,'Pickens');
insert into caps.office values(118,to_date('01/01/2006','MM/DD/YYYY'),'118','CPS','11',null,'Pierce');
insert into caps.office values(119,to_date('01/01/2006','MM/DD/YYYY'),'119','CPS','04',null,'Pike');
insert into caps.office values(120,to_date('01/01/2006','MM/DD/YYYY'),'120','CPS','01',null,'Polk');
insert into caps.office values(121,to_date('01/01/2006','MM/DD/YYYY'),'121','CPS','06',null,'Pulaski');
insert into caps.office values(122,to_date('01/01/2006','MM/DD/YYYY'),'122','CPS','06',null,'Putnam');
insert into caps.office values(123,to_date('01/01/2006','MM/DD/YYYY'),'123','CPS','08',null,'Quitman');
insert into caps.office values(124,to_date('01/01/2006','MM/DD/YYYY'),'124','CPS','02',null,'Rabun');
insert into caps.office values(125,to_date('01/01/2006','MM/DD/YYYY'),'125','CPS','08',null,'Randolph');
insert into caps.office values(126,to_date('01/01/2006','MM/DD/YYYY'),'126','CPS','07',null,'Richmond');
insert into caps.office values(127,to_date('01/01/2006','MM/DD/YYYY'),'127','CPS','3B',null,'Rockdale');
insert into caps.office values(128,to_date('01/01/2006','MM/DD/YYYY'),'128','CPS','08',null,'Schley');
insert into caps.office values(129,to_date('01/01/2006','MM/DD/YYYY'),'129','CPS','07',null,'Screven');
insert into caps.office values(130,to_date('01/01/2006','MM/DD/YYYY'),'130','CPS','10',null,'Seminole');
insert into caps.office values(131,to_date('01/01/2006','MM/DD/YYYY'),'131','CPS','04',null,'Spalding');
insert into caps.office values(132,to_date('01/01/2006','MM/DD/YYYY'),'132','CPS','02',null,'Stephens');
insert into caps.office values(133,to_date('01/01/2006','MM/DD/YYYY'),'133','CPS','08',null,'Stewart');
insert into caps.office values(134,to_date('01/01/2006','MM/DD/YYYY'),'134','CPS','08',null,'Sumter');
insert into caps.office values(135,to_date('01/01/2006','MM/DD/YYYY'),'135','CPS','08',null,'Talbot');
insert into caps.office values(136,to_date('01/01/2006','MM/DD/YYYY'),'136','CPS','07',null,'Taliaferro');
insert into caps.office values(137,to_date('01/01/2006','MM/DD/YYYY'),'137','CPS','09',null,'Tattnall');
insert into caps.office values(138,to_date('01/01/2006','MM/DD/YYYY'),'138','CPS','08',null,'Taylor');
insert into caps.office values(139,to_date('01/01/2006','MM/DD/YYYY'),'139','CPS','09',null,'Telfair');
insert into caps.office values(140,to_date('01/01/2006','MM/DD/YYYY'),'140','CPS','10',null,'Terrell');
insert into caps.office values(141,to_date('01/01/2006','MM/DD/YYYY'),'141','CPS','10',null,'Thomas');
insert into caps.office values(142,to_date('01/01/2006','MM/DD/YYYY'),'142','CPS','11',null,'Tift');
insert into caps.office values(143,to_date('01/01/2006','MM/DD/YYYY'),'143','CPS','09',null,'Toombs');
insert into caps.office values(144,to_date('01/01/2006','MM/DD/YYYY'),'144','CPS','02',null,'Towns');
insert into caps.office values(145,to_date('01/01/2006','MM/DD/YYYY'),'145','CPS','09',null,'Treutlen');
insert into caps.office values(146,to_date('01/01/2006','MM/DD/YYYY'),'146','CPS','04',null,'Troup');
insert into caps.office values(147,to_date('01/01/2006','MM/DD/YYYY'),'147','CPS','11',null,'Turner');
insert into caps.office values(148,to_date('01/01/2006','MM/DD/YYYY'),'148','CPS','06',null,'Twiggs');
insert into caps.office values(149,to_date('01/01/2006','MM/DD/YYYY'),'149','CPS','02',null,'Union');
insert into caps.office values(150,to_date('01/01/2006','MM/DD/YYYY'),'150','CPS','04',null,'Upson');
insert into caps.office values(151,to_date('01/01/2006','MM/DD/YYYY'),'151','CPS','01',null,'Walker');
insert into caps.office values(152,to_date('01/01/2006','MM/DD/YYYY'),'152','CPS','05',null,'Walton');
insert into caps.office values(153,to_date('01/01/2006','MM/DD/YYYY'),'153','CPS','11',null,'Ware');
insert into caps.office values(154,to_date('01/01/2006','MM/DD/YYYY'),'154','CPS','07',null,'Warren');
insert into caps.office values(155,to_date('01/01/2006','MM/DD/YYYY'),'155','CPS','07',null,'Washington');
insert into caps.office values(156,to_date('01/01/2006','MM/DD/YYYY'),'156','CPS','09',null,'Wayne');
insert into caps.office values(157,to_date('01/01/2006','MM/DD/YYYY'),'157','CPS','08',null,'Webster');
insert into caps.office values(158,to_date('01/01/2006','MM/DD/YYYY'),'158','CPS','09',null,'Wheeler');
insert into caps.office values(159,to_date('01/01/2006','MM/DD/YYYY'),'159','CPS','02',null,'White');
insert into caps.office values(160,to_date('01/01/2006','MM/DD/YYYY'),'160','CPS','01',null,'Whitfield');
insert into caps.office values(161,to_date('01/01/2006','MM/DD/YYYY'),'161','CPS','09',null,'Wilcox');
insert into caps.office values(162,to_date('01/01/2006','MM/DD/YYYY'),'162','CPS','07',null,'Wilkes');
insert into caps.office values(163,to_date('01/01/2006','MM/DD/YYYY'),'163','CPS','06',null,'Wilkinson');
insert into caps.office values(164,to_date('01/01/2006','MM/DD/YYYY'),'164','CPS','10',null,'Worth');

commit;

alter table caps.employee enable constraint fk_emp_office;
alter table caps.perf_tally enable constraint fk_perf_tally_office;
alter table caps.case_file_loc enable constraint fk_case_file_loc_office;
alter table caps.case_file_management enable constraint fk_case_file_office;
alter table caps.office_phone enable constraint fk_office_phone;

truncate table caps.mail_code;

insert into caps.mail_code values('001',to_date('01/01/2006','MM/DD/YYYY'),'9123661010',null,'1160 West Parker Street',null,'Baxley','31513-0622','001','N');
insert into caps.mail_code values('002',to_date('01/01/2006','MM/DD/YYYY'),'9124223242',null,'204 East Legion Avenue','P.O. Box 278','Pearson','31642-0278','003','N');
insert into caps.mail_code values('003',to_date('01/01/2006','MM/DD/YYYY'),'9126328375',null,'417 South Dixon Street','P.O. Box 447','Alma','31510-0447','005','N');
insert into caps.mail_code values('004',to_date('01/01/2006','MM/DD/YYYY'),'2297345247',null,'101 Sunset Boulevard','P.O. Box 540','Newton','39870','007','N');
insert into caps.mail_code values('005',to_date('01/01/2006','MM/DD/YYYY'),'4784454135',null,'154 Robinson Mill Road','P.O. Box 430','Millegeville','31061-0430','009','N');
insert into caps.mail_code values('006',to_date('01/01/2006','MM/DD/YYYY'),'7076772272',null,'423 Evans Street','P.O. Box 159','Homer','30547-0159','011','N');
insert into caps.mail_code values('007',to_date('01/01/2006','MM/DD/YYYY'),'7708684222',null,'16 Lee Street','P.O. Box 546','Winder','30680-0546','013','N');
insert into caps.mail_code values('008',to_date('01/01/2006','MM/DD/YYYY'),'7703873710',null,'47 Brooks Drive','P.O. Box 818','Cartersville','30120-0818','015','N');
insert into caps.mail_code values('009',to_date('01/01/2006','MM/DD/YYYY'),'2294265300',null,'124 South Grant Street',null,'Fitzgerald','31750-2901','017','N');
insert into caps.mail_code values('010',to_date('01/01/2006','MM/DD/YYYY'),'2296865568',null,'301 South Jefferson Street',null,'Nashville','31639','019','N');
insert into caps.mail_code values('011',to_date('01/01/2006','MM/DD/YYYY'),'4787516051',null,'456 Oglethorpe Street',null,'Macon','31201-3278','021','N');
insert into caps.mail_code values('012',to_date('01/01/2006','MM/DD/YYYY'),'4789343172',null,'401 Peacock Street','P.O. Box 499','Cochran','31014-0499','023','N');
insert into caps.mail_code values('013',to_date('01/01/2006','MM/DD/YYYY'),'9124626171',null,'127 Bryan Street','P.O. Box 308','Nahunta','31553-0308','025','N');
insert into caps.mail_code values('014',to_date('01/01/2006','MM/DD/YYYY'),'2292637567',null,'201 South Barnes Street',null,'Quitman','31643-1838','027','N');
insert into caps.mail_code values('015',to_date('01/01/2006','MM/DD/YYYY'),'9126532805',null,'51 North Courthouse Street','P.O. Box 398','Pembroke','31321-0398','029','N');
insert into caps.mail_code values('016',to_date('01/01/2006','MM/DD/YYYY'),'9128711333',null,'41 Pulaski Highway','P.O. Box 1103','Statesboro','30459-1103','031','N');
insert into caps.mail_code values('017',to_date('01/01/2006','MM/DD/YYYY'),'7065547751',null,'729 West 6th Street','P.O. Box 390','Waynesboro','30830-0390','033','N');
insert into caps.mail_code values('018',to_date('01/01/2006','MM/DD/YYYY'),'7705042200',null,'178 Earnest Biles Drive',null,'Jackson','30223-4187','035','N');
insert into caps.mail_code values('019',to_date('01/01/2006','MM/DD/YYYY'),'2298495100',null,'28239 Main Street','P.O. Box 9','Morgan','39866','037','N');
insert into caps.mail_code values('020',to_date('01/01/2006','MM/DD/YYYY'),'9127294583',null,'800 Charles Gilman Jr. Avenue','P.O. Box 68','Kingsland','31548-0068','039','N');
insert into caps.mail_code values('021',to_date('01/01/2006','MM/DD/YYYY'),'9126852163',null,'750 South Leroy Street','P.O. Box 46','Metter','30439-0046','043','N');
insert into caps.mail_code values('022',to_date('01/01/2006','MM/DD/YYYY'),'7708302050',null,'165 Independence Drive',null,'Carrollton','30116','045','N');
insert into caps.mail_code values('023',to_date('01/01/2006','MM/DD/YYYY'),'7069352368',null,'7195 Nashville Street','P.O. Box 58','Ringgold','30736-0058','047','N');
insert into caps.mail_code values('024',to_date('01/01/2006','MM/DD/YYYY'),'9124962527',null,'401 West Oak Street','P.O. Box 395','Folkston','31537-0395','049','N');
insert into caps.mail_code values('025',to_date('01/01/2006','MM/DD/YYYY'),'9126512211',null,'761 Wheaton Street','P.O. Box 2566','Savannah','31498-1301','051','N');
insert into caps.mail_code values('026',to_date('01/01/2006','MM/DD/YYYY'),'7069893681',null,'209 McNaughton Street',null,'Cusseta','31805-0070','053','N');
insert into caps.mail_code values('027',to_date('01/01/2006','MM/DD/YYYY'),'7068570817',null,'102 Hwy 48',null,'Summerville','30747-0250','055','N');
insert into caps.mail_code values('028',to_date('01/01/2006','MM/DD/YYYY'),'7707203610',null,'105 Lamar Haley Parkway','P.O. Box 826','Canton','30169','057','N');
insert into caps.mail_code values('029',to_date('01/01/2006','MM/DD/YYYY'),'7062277000',null,'284 North Avenue','P.O. Box 1887','Athens','30603-1887','059','N');
insert into caps.mail_code values('030',to_date('01/01/2006','MM/DD/YYYY'),'2297682511',null,'202 Wilson Street','P.O Box 189','Fort Gaines','39851','061','N');
insert into caps.mail_code values('031',to_date('01/01/2006','MM/DD/YYYY'),'7704732300',null,'877 Battlecreek Road',null,'Jonesboro','30236-1942','063','N');
insert into caps.mail_code values('032',to_date('01/01/2006','MM/DD/YYYY'),'9124875263',null,'101 East Shirley Road','P.O. Box 396','Homerville','31634-0396','065','N');
insert into caps.mail_code values('033',to_date('01/01/2006','MM/DD/YYYY'),'7705285000',null,'325 Fairground Street SE',null,'Marietta','30060-2355','067','N');
insert into caps.mail_code values('034',to_date('01/01/2006','MM/DD/YYYY'),'9123894286',null,'1300 West Baker Highway','P.O. Box 1119','Douglas','31534-1119','069','N');
insert into caps.mail_code values('035',to_date('01/01/2006','MM/DD/YYYY'),'2292174000',null,'449 N. Main Street','P.O. Box 3008','Moultrie','31776-3008','071','N');
insert into caps.mail_code values('036',to_date('01/01/2006','MM/DD/YYYY'),'7065411640',null,'6358 Columbia Drive','P.O. Box 340','Appling','30802-0340','073','N');
insert into caps.mail_code values('037',to_date('01/01/2006','MM/DD/YYYY'),'2298963672',null,'1010 South Hutchinson Avenue',null,'Adel','31620','075','N');
insert into caps.mail_code values('038',to_date('01/01/2006','MM/DD/YYYY'),'7702547234',null,'533 Highway 29 North',null,'Newnan','30263-4735','077','N');
insert into caps.mail_code values('039',to_date('01/01/2006','MM/DD/YYYY'),'4788366030',null,'360 North Dugger Avenue','P.O. Box 97','Roberta','31078-0097','079','N');
insert into caps.mail_code values('040',to_date('01/01/2006','MM/DD/YYYY'),'2292762349',null,'107 West 23rd Avenue','P.O. Box 459','Cordele','31010-0459','081','N');
insert into caps.mail_code values('041',to_date('01/01/2006','MM/DD/YYYY'),'7066577511',null,'71 Case Ave.','P.O. Box 159','Trenton','30752-0159','083','N');
insert into caps.mail_code values('042',to_date('01/01/2006','MM/DD/YYYY'),'7062656598',null,'424 Highway 53','P.O. Box 867','Dawsonville','30534-0867','085','N');
insert into caps.mail_code values('043',to_date('01/01/2006','MM/DD/YYYY'),'2292482420',null,'505 Amelia Avenue','P.O. Box 1047','Bainbridge','39818-1047','087','N');
insert into caps.mail_code values('044',to_date('01/01/2006','MM/DD/YYYY'),'4043705251',null,'178 Sams Street',null,'Decatur','30030-4134','089','N');
insert into caps.mail_code values('045',to_date('01/01/2006','MM/DD/YYYY'),'4046873121',null,'30 Warren Street SE',null,'Atlanta','30317','089','N');
insert into caps.mail_code values('046',to_date('01/01/2006','MM/DD/YYYY'),'4783746760',null,'111 Plaza Ave.','P.O. Box 4219','Eastman','31023-4219','091','N');
insert into caps.mail_code values('047',to_date('01/01/2006','MM/DD/YYYY'),'2292684111',null,'1022 E. Union St.','P.O. Box 385','Vienna','31092','093','N');
insert into caps.mail_code values('048',to_date('01/01/2006','MM/DD/YYYY'),'2294304118',null,'200 W. Oglethorpe Blvd Ste 400','P.O. Box 3249','Albany','31706-3249','095','N');
insert into caps.mail_code values('049',to_date('01/01/2006','MM/DD/YYYY'),'7704893000',null,'6218 Hospital Way','P.O. Box 1135','Douglasville','30134-1135','097','N');
insert into caps.mail_code values('050',to_date('01/01/2006','MM/DD/YYYY'),'2297242000',null,'11860 Columbia Street','P.O. Box 747','Blakely','39823-2577','099','N');
insert into caps.mail_code values('051',to_date('01/01/2006','MM/DD/YYYY'),'2295595751',null,'106 Church of God Street',null,'Statenville','31648-9711','101','N');
insert into caps.mail_code values('052',to_date('01/01/2006','MM/DD/YYYY'),'9127546471',null,'204 Franklin Street','P.O. Box 345','Springfield','31329-0345','103','N');
insert into caps.mail_code values('053',to_date('01/01/2006','MM/DD/YYYY'),'7062132001',null,'121 Carey Street','P.O. Box 1010','Elberton','30635-1010','105','N');
insert into caps.mail_code values('054',to_date('01/01/2006','MM/DD/YYYY'),'4782892400',null,'143 North Anderson Drive','P.O. Box 808','Swainsboro','30401-0808','107','N');
insert into caps.mail_code values('055',to_date('01/01/2006','MM/DD/YYYY'),'9127391222',null,'Courthouse Annex','P.O. Box 578','Claxton','30417-0578','109','N');
insert into caps.mail_code values('056',to_date('01/01/2006','MM/DD/YYYY'),'7066322296',null,'990 East Main Street','Suite 10','Blue Ridge','30513-4534','111','N');
insert into caps.mail_code values('057',to_date('01/01/2006','MM/DD/YYYY'),'7704602555',null,'905 Highway 85 South','P.O. Box 128','Fayetteville','30215-2005','113','N');
insert into caps.mail_code values('058',to_date('01/01/2006','MM/DD/YYYY'),'7062956500',null,'450 Riverside Pkwy Suite 1100','P.O. Box 193','Rome','30162-0193','115','N');
insert into caps.mail_code values('059',to_date('01/01/2006','MM/DD/YYYY'),'7707816700',null,'426 Canton Road','P.O. Box 21','Cumming','30028-0021','117','N');
insert into caps.mail_code values('060',to_date('01/01/2006','MM/DD/YYYY'),'7063844521',null,'1133 Hull Street','P.O. Box 279','Carnesville','30521-0279','119','N');
insert into caps.mail_code values('061',to_date('01/01/2006','MM/DD/YYYY'),'4042065300',null,'1249 Donald Lee Hollowell Pkwy',null,'Atlanta','30318','121','N');
insert into caps.mail_code values('062',to_date('01/01/2006','MM/DD/YYYY'),'4046578000',null,'Central City North Service Ctr','84 Walton Street NW','Atlanta','30303','121','N');
insert into caps.mail_code values('063',to_date('01/01/2006','MM/DD/YYYY'),'4042522180',null,'North Fulton Service Center','6075 Roswell Road NE Suite 300','Atlanta','30328','121','N');
insert into caps.mail_code values('064',to_date('01/01/2006','MM/DD/YYYY'),'7707747500',null,'South Fulton Service Center','5710 Stonewall Tell Road','College Park','30349','121','N');
insert into caps.mail_code values('065',to_date('01/01/2006','MM/DD/YYYY'),'4046994337',null,'Southwest Service Center','515 Fairburn Road SW','Atlanta','30331','121','N');
insert into caps.mail_code values('066',to_date('01/01/2006','MM/DD/YYYY'),'7066352361',null,'54 Kiker Street',null,'Ellijay','30540-1328','123','N');
insert into caps.mail_code values('067',to_date('01/01/2006','MM/DD/YYYY'),'7065982955',null,'674 West Main Street','P.O. Box 225','Gibson','30810-0225','125','N');
insert into caps.mail_code values('068',to_date('01/01/2006','MM/DD/YYYY'),'9122623200',null,'4420 Altama Avenue Suite 9','P.O. Box 400','Brunswick','31521-0400','127','N');
insert into caps.mail_code values('069',to_date('01/01/2006','MM/DD/YYYY'),'7066241200',null,'639 Oothcalooga Street','P.O. Box 217','Calhoun','30703-0217','129','N');
insert into caps.mail_code values('070',to_date('01/01/2006','MM/DD/YYYY'),'2293773154',null,'250 2nd Avenue SE','P.O. Box 269','Cairo','39828','131','N');
insert into caps.mail_code values('071',to_date('01/01/2006','MM/DD/YYYY'),'7064532365',null,'1951 South Main Street','P.O. Box 460','Greensboro','30642-0460','133','N');
insert into caps.mail_code values('072',to_date('01/01/2006','MM/DD/YYYY'),'6785185500',null,'One Justice Square','446 W. Crogan Street','Lawrenceville','30045','135','N');
insert into caps.mail_code values('073',to_date('01/01/2006','MM/DD/YYYY'),'7067542148',null,'1045 Hollywood Highway','P.O. Box 160 ','Clarkesville','30523-0160','137','N');
insert into caps.mail_code values('074',to_date('01/01/2006','MM/DD/YYYY'),'7705325298',null,'970 McEver Road Ext.',null,'Gainesville','30504-3938','139','N');
insert into caps.mail_code values('075',to_date('01/01/2006','MM/DD/YYYY'),'7064441203',null,'220 Broad Street','P.O. Box 70','Sparta','31087-0070','141','N');
insert into caps.mail_code values('076',to_date('01/01/2006','MM/DD/YYYY'),'7706463885',null,'21 Magnolia Street','P.O. Box 324','Buchanan','30113-0324','143','N');
insert into caps.mail_code values('077',to_date('01/01/2006','MM/DD/YYYY'),'7066284226',null,'134 North College Street','P.O. Box 285','Hamilton','31811-0285','145','N');
insert into caps.mail_code values('078',to_date('01/01/2006','MM/DD/YYYY'),'7068562740',null,'267 E. Johnson Street','P.O. Box 518','Hartwell','30643-0518','147','N');
insert into caps.mail_code values('079',to_date('01/01/2006','MM/DD/YYYY'),'7066753361',null,'7686 US Highway 27','P.O. Box 385','Franklin','30217-0385','149','N');
insert into caps.mail_code values('080',to_date('01/01/2006','MM/DD/YYYY'),'7709542014',null,'125 Henry Parkway',null,'McDonough','30253-6636','151','N');
insert into caps.mail_code values('081',to_date('01/01/2006','MM/DD/YYYY'),'4789887600',null,'92 Cohen Walker Drive',null,'Warner Robins','31088-2729','153','N');
insert into caps.mail_code values('082',to_date('01/01/2006','MM/DD/YYYY'),'2294682150',null,'108 North Irwin Avenue',null,'Ocilla','31774-1507','155','N');
insert into caps.mail_code values('083',to_date('01/01/2006','MM/DD/YYYY'),'7063673000',null,'456 Athens Street','P. O. Box 526','Jefferson','30549-0526','157','N');
insert into caps.mail_code values('084',to_date('01/01/2006','MM/DD/YYYY'),'7064686461',null,'226 Funderberg Drive',null,'Monticello','31064-1154','159','N');
insert into caps.mail_code values('085',to_date('01/01/2006','MM/DD/YYYY'),'9123753942',null,'PO Box 526',null,'Jefferson','30549','161','N');
insert into caps.mail_code values('086',to_date('01/01/2006','MM/DD/YYYY'),'4786257259',null,'2459 US Hwy 1 North','P.O. Box 570','Louisville','30434-0570','163','N');
insert into caps.mail_code values('087',to_date('01/01/2006','MM/DD/YYYY'),'4789821944',null,'618 South Gray Street','P.O. Box 808','Millen','30442-0808','165','N');
insert into caps.mail_code values('088',to_date('01/01/2006','MM/DD/YYYY'),'4788644210',null,'729 West Court Street','P.O. Box 500','Wrightsville','31096-0500','167','N');
insert into caps.mail_code values('089',to_date('01/01/2006','MM/DD/YYYY'),'4789863126',null,'141 James Street','P.O. Drawer 1689','Gray','31032','169','N');
insert into caps.mail_code values('090',to_date('01/01/2006','MM/DD/YYYY'),'7703585170',null,'122 Westgate Plaza',null,'Barnesville','30204-0970','171','N');
insert into caps.mail_code values('091',to_date('01/01/2006','MM/DD/YYYY'),'2294823686',null,'313 Rougemore Circle',null,'Lakeland','31635-1500','173','N');
insert into caps.mail_code values('092',to_date('01/01/2006','MM/DD/YYYY'),'4782756533',null,'904 Claxton Dairy Road','P.O. Box 68','Dublin','31040-0068','175','N');
insert into caps.mail_code values('093',to_date('01/01/2006','MM/DD/YYYY'),'2297593000',null,'121 Fourth Street','P.O. Box 145','Leesburg','31763-0145','177','N');
insert into caps.mail_code values('094',to_date('01/01/2006','MM/DD/YYYY'),'9123702555',null,'508 North Main Street','P.O. Box 710','Hinesville','31310-0710','179','N');
insert into caps.mail_code values('095',to_date('01/01/2006','MM/DD/YYYY'),'7063593135',null,'171 North Peachtree Street','P.O. Box 220','Lincolnton','30817-0220','181','N');
insert into caps.mail_code values('096',to_date('01/01/2006','MM/DD/YYYY'),'9125452177',null,'59 North Macon Drive','P.O. Box 369','Ludowici','31316-0369','183','N');
insert into caps.mail_code values('097',to_date('01/01/2006','MM/DD/YYYY'),'2293335200',null,'206 S. Patterson Street','P.O. Box 5166','Valdosta','31603-5166','185','N');
insert into caps.mail_code values('098',to_date('01/01/2006','MM/DD/YYYY'),'7068641980',null,'175 Tipton Drive',null,'Dahlonega','30533','187','N');
insert into caps.mail_code values('099',to_date('01/01/2006','MM/DD/YYYY'),'4784723700',null,'413 Clifton Bradley Dr.','P.O. Box 457','Oglethorpe','31068','189','N');
insert into caps.mail_code values('100',to_date('01/01/2006','MM/DD/YYYY'),'7067952128',null,'Courthouse Square,Highway 29','P.O. Box 176','Danielsville','30633-0176','191','N');
insert into caps.mail_code values('101',to_date('01/01/2006','MM/DD/YYYY'),'2296492311',null,'111 Baker Street','P.O. Box 473','Buena Vista','31803-0473','193','N');
insert into caps.mail_code values('102',to_date('01/01/2006','MM/DD/YYYY'),'7065952946',null,'307 Greenway Street','P.O. Box 507','Thomson','30824-0507','195','N');
insert into caps.mail_code values('103',to_date('01/01/2006','MM/DD/YYYY'),'9124374193',null,'1221 North Way','P.O. Box 1139','Darien','31305-1139','197','N');
insert into caps.mail_code values('104',to_date('01/01/2006','MM/DD/YYYY'),'7066724244',null,'17234 Roosevelt Highway',null,'Greenville','30222-9599','199','N');
insert into caps.mail_code values('105',to_date('01/01/2006','MM/DD/YYYY'),'2297583387',null,'69 Thompson Town Road',null,'Colquitt','39837','201','N');
insert into caps.mail_code values('106',to_date('01/01/2006','MM/DD/YYYY'),'2295523500',null,'90 West Oakland Avenue',null,'Camilla','31730','205','N');
insert into caps.mail_code values('107',to_date('01/01/2006','MM/DD/YYYY'),'4789933030',null,'107 Martin Luther King Jr. Dr.','P.O. Box 734','Forsyth','31029-0734','207','N');
insert into caps.mail_code values('108',to_date('01/01/2006','MM/DD/YYYY'),'9125833722',null,'103 East Spring Street','P.O. Box 217','Mount Vernon','30445-0217','209','N');
insert into caps.mail_code values('109',to_date('01/01/2006','MM/DD/YYYY'),'7063435800',null,'2005 Main Street Suite 100','P.O. Box 89','Madison','30650-0089','211','N');
insert into caps.mail_code values('110',to_date('01/01/2006','MM/DD/YYYY'),'9126957315',null,'830 G.I. Maddox Parkway','P.O. Box 1014','Chatsworth','30705-1014','213','N');
insert into caps.mail_code values('111',to_date('01/01/2006','MM/DD/YYYY'),'7066497311',null,'2100 Comer Avenue','P.O. Box 2627','Columbus','31902-2627','215','N');
insert into caps.mail_code values('112',to_date('01/01/2006','MM/DD/YYYY'),'7707842490',null,'4117 Mill Street','P. O. Box 1588','Covington','30015-1588','217','N');
insert into caps.mail_code values('113',to_date('01/01/2006','MM/DD/YYYY'),'7067695206',null,'48 Greensboro Highway','P.O. Box 105','Watkinsville','30677-0105','219','N');
insert into caps.mail_code values('114',to_date('01/01/2006','MM/DD/YYYY'),'7067438152',null,'231 Union Point Street','P.O. Box 160','Lexingtion','30648-0160','221','N');
insert into caps.mail_code values('115',to_date('01/01/2006','MM/DD/YYYY'),'7704437810',null,'1387 Industrial Blvd N.','P. O. Box 168','Dallas','30132','223','N');
insert into caps.mail_code values('116',to_date('01/01/2006','MM/DD/YYYY'),'7704437810',null,'',null,'',null,'225','N');
insert into caps.mail_code values('117',to_date('01/01/2006','MM/DD/YYYY'),'7066924701',null,'255 Chambers Street',null,'Jasper','30143','227','N');
insert into caps.mail_code values('118',to_date('01/01/2006','MM/DD/YYYY'),'7066924701',null,'',null,'',null,'229','N');
insert into caps.mail_code values('119',to_date('01/01/2006','MM/DD/YYYY'),'7705678427',null,'581 Highway 19 South','P.O. Box 387','Zebulon','30295-0387','231','N');
insert into caps.mail_code values('120',to_date('01/01/2006','MM/DD/YYYY'),'7707492232',null,'100 County Loop Road','P.O. Box 147','Cedartown','30125-0147','233','N');
insert into caps.mail_code values('121',to_date('01/01/2006','MM/DD/YYYY'),'4787836191',null,'107 North Dooley Street','P.O. Box 567','Hawkinsville','31036-0567','235','N');
insert into caps.mail_code values('122',to_date('01/01/2006','MM/DD/YYYY'),'7064854921',null,'675 Godfrey Highway','P.O. Box 3670','Eatonton','31024-3670','237','N');
insert into caps.mail_code values('123',to_date('01/01/2006','MM/DD/YYYY'),'2293342427',null,'Main Street ','P.O. Box 68','Georgetown','39854','239','N');
insert into caps.mail_code values('124',to_date('01/01/2006','MM/DD/YYYY'),'7067824283',null,'Hiawassee Street','P.O. Box 787','Clayton','30525-0787','241','N');
insert into caps.mail_code values('125',to_date('01/01/2006','MM/DD/YYYY'),'2297323742',null,'311 North Webster Street',null,'Cuthbert','39840','243','N');
insert into caps.mail_code values('126',to_date('01/01/2006','MM/DD/YYYY'),'7067212536',null,'520 Fenwick Street','P.O. Box 2277','Augusta','30903-2277','245','N');
insert into caps.mail_code values('127',to_date('01/01/2006','MM/DD/YYYY'),'7703885025',null,'975 Taylor Street SW',null,'Conyers','30012','247','N');
insert into caps.mail_code values('128',to_date('01/01/2006','MM/DD/YYYY'),'2299372591',null,'237 West Oglethorpe Street','P.O. Box 367','Ellaville','31806-0367','249','N');
insert into caps.mail_code values('129',to_date('01/01/2006','MM/DD/YYYY'),'9125642041',null,'110 Singleton Avenue','P.O. Box 513','Sylvania','30467-0513','251','N');
insert into caps.mail_code values('130',to_date('01/01/2006','MM/DD/YYYY'),'2295242365',null,'108 West 4th Street',null,'Donalsonville','39845','253','N');
insert into caps.mail_code values('131',to_date('01/01/2006','MM/DD/YYYY'),'7702281386',null,'411 East Solomon Street','P.O. Box 1610','Griffin','30223-0039','255','N');
insert into caps.mail_code values('132',to_date('01/01/2006','MM/DD/YYYY'),'7062824505',null,'1000 East Tugalo Street',null,'Toccoa','30577-1941','257','N');
insert into caps.mail_code values('133',to_date('01/01/2006','MM/DD/YYYY'),'2298384335',null,'Highway 27,Broad Street','P.O. Box 308','Lumpkin','31835-0308','259','N');
insert into caps.mail_code values('134',to_date('01/01/2006','MM/DD/YYYY'),'2299312462',null,'1542 East Forsyth Street','P.O. Box 1669','Americus','31709-1669','261','N');
insert into caps.mail_code values('135',to_date('01/01/2006','MM/DD/YYYY'),'7066658524',null,'Jordan City Road','P.O. Box 96','Talbotton','31827-0096','263','N');
insert into caps.mail_code values('136',to_date('01/01/2006','MM/DD/YYYY'),'7064562339',null,'107 Commerce Street','P.O. Box 40','Crawfordville','30631-0040','265','N');
insert into caps.mail_code values('137',to_date('01/01/2006','MM/DD/YYYY'),'9125577721',null,'117 North Main Street','P.O. Box 518','Reidsville','30453-0518','267','N');
insert into caps.mail_code values('138',to_date('01/01/2006','MM/DD/YYYY'),'4788625221',null,'Highway 137 West','P.O. Box 366','Butler','31006-0366','269','N');
insert into caps.mail_code values('139',to_date('01/01/2006','MM/DD/YYYY'),'2298683030',null,'310 East Brewton Street','P.O. Box 456 ','McRae','31055-0456','271','N');
insert into caps.mail_code values('140',to_date('01/01/2006','MM/DD/YYYY'),'2292254005',null,'438 Smith Avenue','P.O. Box 2740','Thomasville','31799-2740','273','N');
insert into caps.mail_code values('141',to_date('01/01/2006','MM/DD/YYYY'),'2292254005',null,'438 Smith Avenue','P.O. Box 2740','Thomasville','31799-2740','275','N');
insert into caps.mail_code values('142',to_date('01/01/2006','MM/DD/YYYY'),'2293863388',null,'410 West 2nd Street','P.O. Box 7550','Tifton','31793-7550','277','N');
insert into caps.mail_code values('143',to_date('01/01/2006','MM/DD/YYYY'),'9125268117',null,'162 Oxley Drive','P.O. Box 191','Lyons','30436-0191','279','N');
insert into caps.mail_code values('144',to_date('01/01/2006','MM/DD/YYYY'),'7068963524',null,'456 North Main Street','P.O. Box 156','Hiawassee','30546-0156','281','N');
insert into caps.mail_code values('145',to_date('01/01/2006','MM/DD/YYYY'),'9125293757',null,'108 Martin Luther King Jr.','P.O. Box 625','Soperton','30457-0625','283','N');
insert into caps.mail_code values('146',to_date('01/01/2006','MM/DD/YYYY'),'7062987100',null,'1220 Hogansville Road',null,'LaGrange','30241-4631','285','N');
insert into caps.mail_code values('147',to_date('01/01/2006','MM/DD/YYYY'),'2295674353',null,'336 North Street',null,'Ashburn','31714-0804','287','N');
insert into caps.mail_code values('148',to_date('01/01/2006','MM/DD/YYYY'),'4789453258',null,'719-A Highway 80 East','P.O. Box 530','Jeffersonville','31044-0530','289','N');
insert into caps.mail_code values('149',to_date('01/01/2006','MM/DD/YYYY'),'7067452931',null,'420 Blue Ridge Highway','P.O. Box 220','Blairsville','30514-0220','291','N');
insert into caps.mail_code values('150',to_date('01/01/2006','MM/DD/YYYY'),'7066466043',null,'711 North Bethel Street',null,'Thomaston','30286-3103','293','N');
insert into caps.mail_code values('151',to_date('01/01/2006','MM/DD/YYYY'),'7063750726',null,'10056 North Highway 27','P.O. Box 689','Rock Spring','30739-0689','295','N');
insert into caps.mail_code values('152',to_date('01/01/2006','MM/DD/YYYY'),'7702074000',null,'1110 East Spring Street','P.O. Box 927','Monroe','30655-0927','297','N');
insert into caps.mail_code values('153',to_date('01/01/2006','MM/DD/YYYY'),'9122856040',null,'1200 Plant Avenue','P.O. Box 2048','Waycross','31502-2048','299','N');
insert into caps.mail_code values('154',to_date('01/01/2006','MM/DD/YYYY'),'7064653326',null,'224 North Legion Drive','P.O. Box 166','Warrenton','30828-0166','301','N');
insert into caps.mail_code values('155',to_date('01/01/2006','MM/DD/YYYY'),'4785532350',null,'1124 South Harris Street','P.O. Box 108','Sandersville','31082-0108','303','N');
insert into caps.mail_code values('156',to_date('01/01/2006','MM/DD/YYYY'),'9124275866',null,'1220 South 1st Street','P.O. Box 267','Jesup','31598-0267','305','N');
insert into caps.mail_code values('157',to_date('01/01/2006','MM/DD/YYYY'),'2298286265',null,'Highway 4','P.O. Box 9','Preston','31824-0009','307','N');
insert into caps.mail_code values('158',to_date('01/01/2006','MM/DD/YYYY'),'9125687127',null,'312 W. Third Avenue','P.O. Box 221','Alamo','30411-0221','309','N');
insert into caps.mail_code values('159',to_date('01/01/2006','MM/DD/YYYY'),'7068653128',null,'1241 Helen Highway','Suite 200','Cleveland','30528-6938','311','N');
insert into caps.mail_code values('160',to_date('01/01/2006','MM/DD/YYYY'),'7062722331',null,'1142 N. Thornton Drive','P.O. Box 1203','Dalton','30722-1203','313','N');
insert into caps.mail_code values('161',to_date('01/01/2006','MM/DD/YYYY'),'2293652243',null,'453 Second Avenue','P.O. Box 246','Rochelle','31079-0246','315','N');
insert into caps.mail_code values('162',to_date('01/01/2006','MM/DD/YYYY'),'7066782814',null,'48 Lexington Avenue','P.O. Box 126','Washington','30673-0126','317','N');
insert into caps.mail_code values('163',to_date('01/01/2006','MM/DD/YYYY'),'4789462224',null,'103 Payne Street','P.O. Box 526','Irwinton','31042-0526','319','N');
insert into caps.mail_code values('164',to_date('01/01/2006','MM/DD/YYYY'),'2297772000',null,'503 North Henderson Street','P.O. Box 527','Sylvester','31791-0527','321','N');

commit;

DROP SEQUENCE CAPS.SEQ_OFFICE_PHONE;

CREATE SEQUENCE CAPS.SEQ_OFFICE_PHONE
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


GRANT SELECT ON  CAPS.SEQ_OFFICE_PHONE TO OPERATOR;

GRANT SELECT ON  CAPS.SEQ_OFFICE_PHONE TO CAPSBAT;

GRANT SELECT ON  CAPS.SEQ_OFFICE_PHONE TO CAPSON;


truncate table caps.office_phone;


insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'1','9123661010',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'2','9124223242',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'3','9126328375',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'4','2297345247',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'5','4784454135',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'6','7076772272',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'7','7708684222',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'8','7703873710',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'9','2294265300',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'10','2296865568',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'11','4787516051',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'12','4789343172',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'13','9124626171',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'14','2292637567',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'15','9126532805',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'16','9128711333',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'17','7065547751',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'18','7705042200',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'19','2298495100',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'20','9127294583',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'21','9126852163',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'22','7708302050',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'23','7069352368',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'24','9124962527',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'25','9126512211',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'26','7069893681',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'27','7068570817',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'28','7707203610',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'29','7062277000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'30','2297682511',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'31','7704732300',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'32','9124875263',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'33','7705285000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'34','9123894286',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'35','2292174000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'36','7065411640',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'37','2298963672',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'38','7702547234',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'39','4788366030',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'40','2292762349',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'41','7066577511',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'42','7062656598',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'43','2292482420',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'44','4043705251',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'45','4046873121',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'46','4783746760',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'47','2292684111',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'48','2294304118',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'49','7704893000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'50','2297242000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'51','2295595751',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'52','9127546471',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'53','7062132001',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'54','4782892400',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'55','9127391222',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'56','7066322296',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'57','7704602555',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'58','7062956500',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'59','7707816700',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'60','7063844521',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'61','4042065300',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'62','4046578000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'63','4042522180',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'64','7707747500',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'65','4046994337',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'66','7066352361',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'67','7065982955',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'68','9122623200',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'69','7066241200',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'70','2293773154',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'71','7064532365',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'72','6785185500',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'73','7067542148',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'74','7705325298',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'75','7064441203',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'76','7706463885',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'77','7066284226',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'78','7068562740',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'79','7066753361',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'80','7709542014',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'81','4789887600',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'82','2294682150',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'83','7063673000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'84','7064686461',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'85','9123753942',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'86','4786257259',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'87','4789821944',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'88','4788644210',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'89','4789863126',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'90','7703585170',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'91','2294823686',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'92','4782756533',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'93','2297593000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'94','9123702555',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'95','7063593135',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'96','9125452177',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'97','2293335200',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'98','7068641980',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'99','4784723700',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'100','7067952128',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'101','2296492311',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'102','7065952946',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'103','9124374193',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'104','7066724244',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'105','2297583387',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'106','2295523500',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'107','4789933030',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'108','9125833722',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'109','7063435800',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'110','9126957315',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'111','7066497311',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'112','7707842490',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'113','7067695206',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'114','7067438152',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'115','7704437810',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'116','7704437810',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'117','7066924701',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'118','7066924701',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'119','7705678427',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'120','7707492232',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'121','4787836191',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'122','7064854921',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'123','2293342427',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'124','7067824283',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'125','2297323742',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'126','7067212536',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'127','7703885025',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'128','2299372591',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'129','9125642041',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'130','2295242365',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'131','7702281386',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'132','7062824505',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'133','2298384335',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'134','2299312462',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'135','7066658524',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'136','7064562339',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'137','9125577721',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'138','4788625221',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'139','2298683030',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'140','2292254005',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'141','2292254005',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'142','2293863388',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'143','9125268117',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'144','7068963524',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'145','9125293757',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'146','7062987100',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'147','2295674353',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'148','4789453258',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'149','7067452931',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'150','7066466043',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'151','7063750726',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'152','7702074000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'153','9122856040',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'154','7064653326',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'155','4785532350',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'156','9124275866',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'157','2298286265',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'158','9125687127',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'159','7068653128',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'160','7062722331',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'161','2293652243',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'162','7066782814',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'163','4789462224',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'164','2297772000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BS');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'1','9123661045',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'2','9124223538',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'3','9126325007',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'4','2297348442',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'5','4784456531',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'6','7076772196',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'7','7708684235',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'8','7703873944',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'9','2294265338',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'10','2296863933',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'11','4787516578',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'12','4789343332',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'13','9124627255',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'14','2292639014',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'15','9126532803',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'16','9126815990',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'17','7065547093',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'18','7705042204',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'19','2298495101',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'20','9127297969',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'21','9126853690',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'22','7708302106',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'23','7069657727',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'24','9124964232',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'25','9126512890',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'26','7069891066',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'27','7068570823',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'28','7707203680',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'29','7062277925',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'30','2297683265',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'31','7704785948',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'32','9124873599',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'33','7705285154',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'34','9123894419',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'35','2292174034',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'36','7065410330',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'37','2298967709',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'38','7702547500',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'39','4788366053',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'40','2292762713',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'41','7066575368',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'42','7062652085',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'43','2292482696',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'44','4043705499',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'46','4783746764',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'47','2292681703',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'48','2294304355',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'49','7704893035',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'50','2297242005',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'51','2295596167',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'52','9127547638',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'53','7062132039',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'54','4782892462',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'55','9127390284',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'56','7066323521',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'57','7704602464',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'58','7062956718',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'59','7707816742',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'60','7063843212',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'61','4042065799',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'66','7062762367',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'67','7065982540',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'68','9122623056',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'69','7066241206',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'70','2293779157',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'71','7064535132',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'72','6785185505',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'73','7067548065',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'74','7705356967',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'75','7064441207',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'76','7706469373',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'77','7066285392',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'78','7068562792',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'79','7066750516',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'80','7709542329',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'81','4789887617',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'82','2294682177',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'83','7063673044',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'84','7064681338',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'85','9123757997',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'86','4786257984',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'87','4789821279',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'88','4788644214',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'89','4789863127',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'90','7703585169',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'91','2294822334',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'92','4782756700',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'93','2297593004',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'94','9123702525',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'95','7063596000',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'96','9125459769',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'97','2293337027',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'98','7068641651',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'99','4784723732',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'100','7067953651',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'101','2296492428',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'102','7065978525',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'103','9124374170',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'104','7066724342',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'105','2297585084',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'106','2295523561',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'107','4789933035',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'108','9125833739',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'109','7063435827',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'110','9126957541',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'111','7066491342',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'112','7707842479',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'113','7067698684',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'114','7067433019',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'115','7704437820',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'116','7704437820',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'117','7066924700',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'118','7066924700',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'119','7705670784',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'120','7707492262',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'121','4787836195',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'122','7064850073',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'123','2293345606',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'124','7067826193',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'125','2297325412',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'126','7067217140',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'127','7707856828',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'128','2299375641',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'129','9125649372',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'130','2295246632',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'131','7704124702',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'132','7062824502',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'133','2298386280',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'134','2299312427',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'135','7066653843',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'136','7064562976',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'137','9125577774',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'138','4788622999',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'139','2298683033',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'140','2292255278',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'141','2292255278',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'142','2293867236',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'143','9125266986',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'144','7068961457',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'145','9125294305',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'146','7062987122',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'147','2295673954',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'148','4789456508',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'149','7067453560',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'150','7066466048',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'151','7063750798',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'152','7702074007',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'153','9122876626',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'154','7064652819',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'155','4785532390',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'156','9124275885',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'157','2298282032',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'158','9125687196',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'159','7068659586',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'160','7062722895',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'161','2293652575',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'162','7066785325',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'163','4789463821',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');
insert into caps.office_phone values(caps.seq_office_phone.nextval,to_date('01/01/2006','MM/DD/YYYY'),'164','2297772073',null,null,'N',null,to_date('12/31/4712','MM/DD/YYYY'),'Y','BF');

commit;

DROP SEQUENCE CAPS.SEQ_OFFICE_COUNTY_LINK;

CREATE SEQUENCE CAPS.SEQ_OFFICE_COUNTY_LINK
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


GRANT SELECT ON  CAPS.SEQ_OFFICE_COUNTY_LINK TO CAPSON;

GRANT SELECT ON  CAPS.SEQ_OFFICE_COUNTY_LINK TO CAPSBAT;

GRANT SELECT ON  CAPS.SEQ_OFFICE_COUNTY_LINK TO OPERATOR;

truncate table caps.office_county_link;



insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'1','001');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'2','003');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'3','005');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'4','007');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'5','009');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'6','011');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'7','013');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'8','015');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'9','017');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'10','019');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'11','021');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'12','023');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'13','025');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'14','027');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'15','029');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'16','031');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'17','033');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'18','035');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'19','037');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'20','039');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'21','043');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'22','045');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'23','047');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'24','049');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'25','051');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'26','053');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'27','055');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'28','057');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'29','059');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'30','061');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'31','063');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'32','065');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'33','067');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'34','069');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'35','071');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'36','073');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'37','075');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'38','077');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'39','079');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'40','081');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'41','083');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'42','085');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'43','087');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'44','089');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'45','089');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'46','091');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'47','093');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'48','095');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'49','097');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'50','099');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'51','101');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'52','103');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'53','105');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'54','107');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'55','109');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'56','111');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'57','113');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'58','115');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'59','117');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'60','119');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'61','121');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'62','121');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'63','121');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'64','121');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'65','121');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'66','123');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'67','125');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'68','127');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'69','129');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'70','131');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'71','133');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'72','135');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'73','137');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'74','139');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'75','141');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'76','143');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'77','145');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'78','147');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'79','149');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'80','151');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'81','153');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'82','155');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'83','157');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'84','159');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'85','161');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'86','163');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'87','165');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'88','167');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'89','169');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'90','171');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'91','173');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'92','175');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'93','177');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'94','179');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'95','181');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'96','183');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'97','185');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'98','187');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'99','189');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'100','191');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'101','193');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'102','195');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'103','197');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'104','199');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'105','201');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'106','205');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'107','207');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'108','209');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'109','211');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'110','213');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'111','215');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'112','217');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'113','219');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'114','221');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'115','223');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'116','225');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'117','227');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'118','229');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'119','231');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'120','233');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'121','235');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'122','237');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'123','239');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'124','241');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'125','243');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'126','245');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'127','247');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'128','249');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'129','251');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'130','253');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'131','255');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'132','257');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'133','259');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'134','261');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'135','263');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'136','265');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'137','267');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'138','269');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'139','271');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'140','273');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'141','275');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'142','277');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'143','279');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'144','281');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'145','283');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'146','285');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'147','287');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'148','289');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'149','291');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'150','293');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'151','295');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'152','297');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'153','299');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'154','301');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'155','303');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'156','305');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'157','307');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'158','309');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'159','311');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'160','313');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'161','315');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'162','317');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'163','319');
insert into caps.office_county_link values (caps.seq_office_county_link.nextval,to_date('01/01/2006','MM/DD/YYYY'),'164','321');
commit;

delete from caps.codes_tables where code_type='CCNTYREG' and decode='03' ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='121') then
into caps.codes_tables
select 'CCNTYREG','121','03A',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='089') then
into caps.codes_tables
select 'CCNTYREG','089','03A',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='057') then
into caps.codes_tables
select 'CCNTYREG','057','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='067') then
into caps.codes_tables
select 'CCNTYREG','067','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='097') then
into caps.codes_tables
select 'CCNTYREG','097','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='113') then
into caps.codes_tables
select 'CCNTYREG','113','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='063') then
into caps.codes_tables
select 'CCNTYREG','063','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='151') then
into caps.codes_tables
select 'CCNTYREG','151','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='247') then
into caps.codes_tables
select 'CCNTYREG','247','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CCNTYREG' and code='135') then
into caps.codes_tables
select 'CCNTYREG','135','03B',null,to_date('07/14/2006','MM/DD/YYYY') from dual ;

update caps.codes_tables set dt_end=to_date('01/01/2006','MM/DD/YYYY') where code_type='CREGIONS' and code='03';

commit;

delete from caps.message where nbr_message = 60046;
insert into caps.message values (caps.seq_message.nextval,sysdate,60046,'MSG_UNIT_INPUT_REQ','County or Region is required',null,null,null);

UPDATE CAPS.MESSAGE
SET txt_message = 'The person selected has no date of birth recorded in SHINES and may not be the appropriate age for the new stage.  Are you sure you want to select this person?' 
WHERE nbr_message = '55191'; 

UPDATE CAPS.MESSAGE
SET txt_message = 'You do not have the SHINES security attribute to assign CPS intakes.' 
WHERE nbr_message = '25553'; 

UPDATE CAPS.MESSAGE
SET txt_message = 'You are not a registered user of SHINES.  Please contact the Help Desk for assistance.' 
WHERE nbr_message = '2081'; 

UPDATE CAPS.MESSAGE
SET txt_message = 'Are you sure you want to logoff SHINES?' 
WHERE nbr_message = '25518';

commit;


-- Standard Alter Table SQL

ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_PHONE_NUM VARCHAR2(10)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_PHONE_EXT VARCHAR2(8)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_ADDR_ST_LN1 VARCHAR2(30)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_ADDR_ST_LN2 VARCHAR2(30)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_ADDR_CITY VARCHAR2(20)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_ADDR_STATE VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_ADDR_ZIP VARCHAR2(10)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD CD_INC_RSRC_SRC_ADDR_COUNTY VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD TXT_INC_RSRC_SRC_ADDR_CMNTS VARCHAR2(80)     NULL
;
ALTER TABLE CAPS.INCOMING_PERSON MODIFY(CD_INCMG_PERS_PRF_CITIZENSHIP  VARCHAR2(4))
;
ALTER TABLE CAPS.INCOMING_PERSON MODIFY(CD_INCMG_PERS_IMMGRTN_STATUS  VARCHAR2(4))
;
ALTER TABLE CAPS.INCOMING_PERSON MODIFY(CD_INCMG_PERS_CNTRY_ORIGIN  VARCHAR2(4))
;
ALTER TABLE CAPS.PERSON ADD CD_PERSON_TITLE VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PERSON ADD IND_PERSON_US_CITIZEN VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PERSON ADD CD_PERSON_IMMIGRATION_STATUS VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PERSON ADD CD_PERSON_COUNTRY_ORIGIN VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PERSON ADD TXT_CHAR_CMNTS VARCHAR2(300)     NULL
;
ALTER TABLE CAPS.PERSON ADD CD_PERS_NOT_YET_DIAG VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.PERSON ADD CD_PERSON_PROOF_CITIZENSHIP VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD IND_PERS_HIST_US_CITIZEN VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD CD_PERS_HIST_IMMG_STATUS VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD CD_PERS_HIST_COUNTRY_ORIGIN VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD CD_PERS_HIST_PROOF_CITIZEN VARCHAR2(4)     NULL
;
-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PERSON
BEFORE UPDATE
ON CAPS.PERSON
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	--------------------------------------------------------------------------------------
	-- PURPOSE of UPDATE trigger: for most cases create a record in table PERSON_HISTORY
	--   for every update of PERSON record.  Follow these 3 criteria:
	--
	--   1. if user sets field IND_PERSON_CANCEL_HIST='Y' in UPDATE statement
	--      then do NOT create a record in table PERSON_HISTORY
	--
	--   2. if user sets field IND_PERSON_CANCEL_HIST to NULL or any value other than Y
	--      in UPDATE statement, then create a record in table PERSON_HISTORY
	--
	--   3. If user did NOT set field IND_PERSON_CANCEL_HIST at all (not in UPDATE
	--      stmt) then it is considered a NULL, and hence create a PERSON_HISTORY record
	--
	-- In anyway, field IND_PERSON_CANCEL_HIST will ALWAYS be set to NULL right before
	-- update into table PERSON regardless of what the user specifies.
	--
	-- Mike Bui: Changes 11-JAN-95
	--------------------------------------------------------------------------------------
	dummy2   NUMBER;
	v_ind_input_type person_merge_pending.ind_input_type%TYPE;
        v_id_person person_merge_pending.id_person%TYPE;
        v_id_group person_merge_pending.id_group%TYPE;
BEGIN
   :new.DT_LAST_UPDATE := sysdate;
   --insert into table PERSON_HISTORY if field :new.IND_PERSON_CANCEL_HIST is not 'Y':
   IF :new.IND_PERS_CANCEL_HIST <> 'Y' OR
      :new.IND_PERS_CANCEL_HIST IS NULL THEN

	-- 1st: set END DATE of previous record:
	UPDATE PERSON_HISTORY  PH
	SET    PH.DT_PERS_HIST_END    = :new.DT_LAST_UPDATE
	WHERE  PH.ID_PERS_HIST_PERSON	= :old.ID_PERSON
	AND    DT_PERS_HIST_END = to_date('12/31/4712','MM/DD/YYYY');

	-- 2nd: Insert new record in PERSON_HISTORY:

	-- get next sequence value:
	SELECT SEQ_PERSON_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;

	-- (very similar to insert trigger above)
	INSERT	INTO	PERSON_HISTORY	(
		NBR_PERS_HIST_AGE,
		DT_PERS_HIST_DEATH,
		DT_PERS_HIST_BIRTH,
		CD_PERS_HIST_RELIGION,
		CD_PERS_HIST_CHAR,
		CD_PERS_HIST_GUARD_CNSRV,
		CD_PERS_HIST_STATUS,
		CD_PERS_HIST_DEATH,
		CD_PERS_HIST_MARITAL_STAT,
		TXT_PERS_HIST_OCCUPATION,
		IND_PERS_HIST_DOB_APPROX,
		CD_PERS_HIST_LIV_ARR,
		CD_PERS_HIST_LANGUAGE,
		CD_PERS_HIST_SEX,
		NM_PERS_HIST_FULL,
		CD_PERS_HIST_ETHNIC,
		ID_PERS_HIST_PERSON,
		ID_PERSON_HISTORY,
		DT_LAST_UPDATE,
		DT_PERS_HIST_EFFECT,
		DT_PERS_HIST_END,
		CD_DISASTER_RLF,
		TXT_CHAR_CMNTS,
		CD_PERS_HIST_NOT_YET_DIAG,
		IND_PERS_HIST_US_CITIZEN,
		CD_PERS_HIST_IMMG_STATUS,
		CD_PERS_HIST_COUNTRY_ORIGIN,
		CD_PERS_HIST_PROOF_CITIZEN
	)VALUES	(
		:new.NBR_PERSON_AGE,
		:new.DT_PERSON_DEATH,
		:new.DT_PERSON_BIRTH,
		:new.CD_PERSON_RELIGION,
		:new.CD_PERSON_CHAR,
		:new.CD_PERS_GUARD_CNSRV,
		:new.CD_PERSON_STATUS,
		:new.CD_PERSON_DEATH,
		:new.CD_PERSON_MARITAL_STATUS,
		:new.TXT_PERSON_OCCUPATION,
		:new.IND_PERSON_DOB_APPROX,
		:new.CD_PERSON_LIV_ARR,
		:new.CD_PERSON_LANGUAGE,
		:new.CD_PERSON_SEX,
		:new.NM_PERSON_FULL,
		:new.CD_PERSON_ETHNIC_GROUP,
		:new.ID_PERSON,
		dummy2,
		sysdate,
		:new.DT_LAST_UPDATE,
		NULL,
		:new.CD_DISASTER_RLF,
		:new.TXT_CHAR_CMNTS,
		:new.CD_PERS_NOT_YET_DIAG,
		:new.IND_PERSON_US_CITIZEN,
		:new.CD_PERSON_IMMIGRATION_STATUS,
		:new.CD_PERSON_COUNTRY_ORIGIN,
		:new.CD_PERSON_PROOF_CITIZENSHIP);
   END IF;

	--Must always set this field to NULL regardless what the user enters.
	:new.IND_PERS_CANCEL_HIST := NULL;
	--Reason: If user specifies this field in the SET clause of UPDATE statement then
	--   :new.IND_PERS_CANCEL_HIST = specified value, and
	--   :old.IND_PERS_CANCEL_HIST = old value in database.
	--
	--But if user did NOT specify it it the UPDATE state, then
	--   :new.IND_PERS_CANCEL_HIST = old value in database, and
	--   :old.IND_PERS_CANCEL_HIST = old value in database.
	-- That's righ! both :old and :new value are the same.  This will mess up the IF
	-- statement above because the current value of that record in the database will
	-- determine the path of this IF statement instead of what we really want: if user
	-- did not specify a value for this it should be NULL.  The only way to
	-- guarantee this is to always set this field to NULL.  It is a reasonable action
	-- because the main purpose of this field is determine what to do with table
	-- PERSON_HISTORY.  It has no meaning in table PERSON, therefore it will ALWAYS be
	-- set to NULL in both BEFORE INSERT and BEFORE UPDATE trigger

	BEGIN
                SELECT  id_person, ind_input_type, id_group
                INTO    v_id_person, v_ind_input_type, v_id_group
                FROM    person_merge_pending
                WHERE   id_person=:new.id_person;

        EXCEPTION
        WHEN NO_DATA_FOUND THEN
                NULL;
        END;


-- SIR  15787

  IF (  (:old.DT_PERSON_BIRTH <> :new.DT_PERSON_BIRTH) OR
        (:old.DT_PERSON_BIRTH IS NOT NULL AND :new.DT_PERSON_BIRTH IS NULL)) THEN

        INSERT INTO adjustment_request
                        (ID_ADJ_REQ,
                        DT_LAST_UPDATE,
                        ID_ADJ_REQ_EVENT,
                        ID_ADJ_REQ_PERSON,
                        ID_CASE,
                        DT_ADJ_REQ_START,
                        DT_ADJ_REQ_END,
                        CD_ADJ_REQ_TYPE)
                        VALUES
                        (0,
                        SYSDATE,
                        NULL,
                        :new.ID_PERSON,
                        NULL,
                        :old.DT_PERSON_BIRTH,
                        :new.DT_PERSON_BIRTH,
                        'PER');

	IF v_id_person is NOT NULL THEN

 	BEGIN

	IF v_ind_input_type IS NULL THEN

                        DELETE FROM person_merge_pending
                        WHERE id_person = :new.id_person;

         ELSIF v_ind_input_type =1 THEN

			DELETE FROM PERSON_MERGE_PENDING
  			WHERE id_group = v_id_group;

	END IF;

                	EXCEPTION
                	WHEN NO_DATA_FOUND THEN
                        	NULL;
        END;

	END IF;
  	END IF;


	IF v_id_person is NOT NULL THEN

	IF 	((:old.NM_PERSON_FIRST <> :new.NM_PERSON_FIRST) OR
		(:old.NM_PERSON_MIDDLE <> :new.NM_PERSON_MIDDLE) OR
		(:old.NM_PERSON_LAST <> :new.NM_PERSON_LAST) OR
		(:old.NM_PERSON_FULL <> :new.NM_PERSON_FULL)) THEN

		BEGIN

	IF v_ind_input_type IS NULL THEN

                        DELETE FROM person_merge_pending
                        WHERE id_person = :new.id_person;

        ELSIF v_ind_input_type =1 THEN

			 DELETE FROM PERSON_MERGE_PENDING
                        WHERE id_group = v_id_group;

	END IF;

                        EXCEPTION
                        WHEN NO_DATA_FOUND THEN
                                NULL;
        	END;


	END IF;
	END IF;



END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PERSON
BEFORE INSERT
ON CAPS.PERSON
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  --------------------------------------------------------------------------------------
  -- PURPOSE of INSERT trigger: for most cases create a record in table PERSON_HISTORY
  --   for every new PERSON record.  Follow these 3 criteria:
  --
  --   1. if user sets field IND_PERSON_CANCEL_HIST='Y' in Insert statement
  --      then do NOT create a record in table PERSON_HISTORY
  --
  --   2. if user sets field IND_PERSON_CANCEL_HIST to NULL or any value other than Y
  --      in Insert statement, then create a record in table PERSON_HISTORY
  --
  --   3. If user did NOT set field IND_PERSON_CANCEL_HIST at all (not in Insert
  --      stmt) then it is considered a NULL, and hence create a PERSON_HISTORY record
  --
  -- In anyway, field IND_PERSON_CANCEL_HIST will ALWAYS be set to NULL right before
  -- insertion into table PERSON regardless of what the user specifies.
  -- See reason for this decision at bottom of next UPDATE trigger.
  --
  -- Mike Bui: Changes on 11-JAN-95
  --------------------------------------------------------------------------------------
	dummy  NUMBER;
	dummy2 NUMBER;
	dummy_date DATE;
BEGIN
	:new.DT_LAST_UPDATE := sysdate;
	if :new.ID_PERSON=0 then
		SELECT SEQ_PERSON.NEXTVAL INTO dummy  FROM DUAL;
		:new.ID_PERSON := dummy;
	end if;

  --insert into table PERSON_HISTORY if field :new.IND_PERSON_CANCEL_HIST is not 'Y':
   IF nvl(:new.IND_PERS_CANCEL_HIST,' ') <> 'Y' THEN

	-- Get next sequence value:
	SELECT SEQ_PERSON_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;

	INSERT INTO PERSON_HISTORY (
		NBR_PERS_HIST_AGE,
		DT_PERS_HIST_DEATH,
		DT_PERS_HIST_BIRTH,
		CD_PERS_HIST_RELIGION,
		CD_PERS_HIST_CHAR,
		CD_PERS_HIST_GUARD_CNSRV,
		CD_PERS_HIST_STATUS,
		CD_PERS_HIST_DEATH,
		CD_PERS_HIST_MARITAL_STAT,
		TXT_PERS_HIST_OCCUPATION,
		IND_PERS_HIST_DOB_APPROX,
		CD_PERS_HIST_LIV_ARR,
		CD_PERS_HIST_LANGUAGE,
		CD_PERS_HIST_SEX,
		NM_PERS_HIST_FULL,
		CD_PERS_HIST_ETHNIC,
		ID_PERS_HIST_PERSON,
		ID_PERSON_HISTORY,
		DT_LAST_UPDATE,
		DT_PERS_HIST_EFFECT,
		DT_PERS_HIST_END,
		CD_DISASTER_RLF,
		TXT_CHAR_CMNTS,
		CD_PERS_HIST_NOT_YET_DIAG,
		IND_PERS_HIST_US_CITIZEN,
		CD_PERS_HIST_IMMG_STATUS,
		CD_PERS_HIST_COUNTRY_ORIGIN,
		CD_PERS_HIST_PROOF_CITIZEN
	)	VALUES	(
		:new.NBR_PERSON_AGE,
		:new.DT_PERSON_DEATH,
		:new.DT_PERSON_BIRTH,
		:new.CD_PERSON_RELIGION,
		:new.CD_PERSON_CHAR,
		:new.CD_PERS_GUARD_CNSRV,
		:new.CD_PERSON_STATUS,
		:new.CD_PERSON_DEATH,
		:new.CD_PERSON_MARITAL_STATUS,
		:new.TXT_PERSON_OCCUPATION,
		:new.IND_PERSON_DOB_APPROX,
		:new.CD_PERSON_LIV_ARR,
		:new.CD_PERSON_LANGUAGE,
		:new.CD_PERSON_SEX,
		:new.NM_PERSON_FULL,
		:new.CD_PERSON_ETHNIC_GROUP,
		:new.ID_PERSON,
		dummy2,
		sysdate,
		:new.DT_LAST_UPDATE,
		NULL,
		:new.CD_DISASTER_RLF,
		:new.TXT_CHAR_CMNTS,
		:new.CD_PERS_NOT_YET_DIAG,
		:new.IND_PERSON_US_CITIZEN,
		:new.CD_PERSON_IMMIGRATION_STATUS,
		:new.CD_PERSON_COUNTRY_ORIGIN,
		:new.CD_PERSON_PROOF_CITIZENSHIP);
   END IF;

	--Must always set this field to NULL regardless what the user enters.
	:new.IND_PERS_CANCEL_HIST := NULL;
		--See the bottom of UPDATE trigger below for reason.

END;
/

commit;

{ call dbms_utility.compile_schema('CAPS') };

-- Update the version.
insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (3, 'SacwisRev1', 'Schema additions to PERSON and other tables. Static updates.');
commit;


