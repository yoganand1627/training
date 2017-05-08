-- change STGAP00003630
-- disable id_office constraints

ALTER TABLE CAPS.EMPLOYEE DISABLE CONSTRAINT FK_emp_office;
ALTER TABLE CAPS.CASE_FILE_MANAGEMENT DISABLE CONSTRAINT FK_case_file_office;
ALTER TABLE CAPS.CASE_FILE_LOC DISABLE CONSTRAINT FK_case_file_loc_office;
ALTER TABLE CAPS.PERF_TALLY DISABLE CONSTRAINT FK_perf_tally_office;
ALTER TABLE CAPS.OFFICE_PHONE DISABLE CONSTRAINT FK_office_phone;


-- truncate tables
truncate table CAPS.office_phone;
truncate table CAPS.office_county_link;
truncate table CAPS.office;
truncate table CAPS.mail_code;
truncate table CAPS.perf_tally;

-- insert into caps.mail_code
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('001','9123661010','1160 WEST PARKER ST','','Baxley','31513-0622','001','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('002','9124223242','P.O. BOX 278','','Pearson','31642-0278','003','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('003','9126328375','P.O. BOX 447','','Alma','31510-0447','005','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('004','2297345247','P.O. BOX 540','','Newton','31770-0135','007','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('005','4784454135','P. O. BOX 430','','Milledgeville','31061-0430','009','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('195','','120 S. JEFFERSON ST.','','Milledgeville','31061-3420','009','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('006','7076772272','P.O. BOX 159','','Homer','30547-0159','011','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('007','7708684222','PO BOX 546','','Winder','30680-2040','013','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('008','7703873710','P.O. BOX 818','','Cartersville','30120-0818','015','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('009','2294265300','124 SOUTH GRANT ST','','Fitzgerald','31750-2091','017','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('010','2296865568','301 S. JEFFERSON ST.','','Nashville','31639-0000','019','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('011','4787516051','456 OGLETHORPE STREET','','Macon','31201-3278','021','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('012','4789343172','P.O. BOX 499','','Cochran','31014-0499','023','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('013','9124626171','P.O. BOX 308','','Nahunta','31553-0308','025','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('014','2292637567','201 S. BARNES ST.','','Quitman','31643-0671','027','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('015','9126532805','P. O. BOX 398','','Pembroke','31321-0398','029','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('054','','P. O. BOX 474','','Richmond Hill','31324-0474','029','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('016','9128711333','P.O. BOX 1103','','Statesboro','30459-1103','031','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('017','7065547751','P.O. BOX 390','','Waynesboro','30830-0390','033','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('018','7705042200','178 EARNEST BILES DR','','Jackson','30233-1187','035','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('019','2298495100','P.O. BOX 9','','Morgan','39866-0000','037','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('020','9127294583','P. O. BOX 68','','Kingsland','31548-0068','039','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('193','','P. O. BOX 68','','Kingsland','31548-0068','039','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('021','9126852163','P.O. BOX 46','','Metter','30439-0046','043','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('022','7708302050','165 INDEPENDENCE DR','','Carrollton','30117-9000','045','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('023','7069352368','P.O. BOX 58','','Ringgold','30736-0058','047','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('024','9124962527','P.O. BOX 395','','Folkston','31537-0395','049','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('025','9126512211','P.O. BOX 2566','','Savannah','31498-1301','051','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('026','7069893681','70 MCNAUGHTON ST','','Cusseta','31805-0070','053','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('027','7068570817','102 HWY 48','','Summerville','30747-1512','055','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('028','7707203610','P.O. BOX 826','','Canton','30169-0826','057','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('030','7062277000','P.O. BOX 1887','','Athens','30603-1887','059','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('031','2297682511','P.O. BOX 189','','Fort Gaines','39851-0189','061','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('312','','P.O. BOX 788','','Columbus','31902-0788','061','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('032','7704732300','877 BATTLECREEK ROAD','','Jonesboro','30236-1919','063','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('033','','877 BATTLECREEK RD','','Jonesboro','30236-1919','063','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('034','7705285000','P.O. BOX 396','','Homerville','31634-0396','065','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('035','9123894286','325 S. FAIRGROUND ST','','Marietta','30060-2355','067','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('036','','590 COMMERCE PARK DR','','Marietta','30060-7852','067','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('037','','325 S. FAIRGROUND ST','','Marietta','30060-2355','067','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('039','9123894286','P.O. BOX 1119','','Douglas','31534-1119','069','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('040','2292174000','P.O. BOX 3008','','Moultrie','31776-3008','071','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('041','7065411640','P. O. BOX 340','','Appling','30802-0340','073','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('194','','4408 EVANS LOCK RD','','Evans','30809-0000','073','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('042','2298963672','1010 S.HUTCHINSON AVE','','Adel','31620-5100','075','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('043','7702547234','533 HIGHWAY 29 NORTH','','Newnan','30263-1501','077','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('044','4788366030','P.O. BOX 97','','Roberta','31078-0097','079','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('045','2292762349','P.O. BOX 459','','Cordele','31010-0459','081','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('046','7066577511','P. O. BOX 159','','Trenton','30752-0159','083','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('047','7062656598','P.O. BOX 867','','Dawsonville','30534-0867','085','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('048','2292482420','P.O. BOX 1047','','Bainbridge','31718-1047','087','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('049','4043705251','178 SAMS STREET','','Decatur','30030-4134','089','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('050','4046873121','178 SAMS STREET','','Decatur','30030-4134','089','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('051','','30 WARREN STREET','','Atlanta','30317-0000','089','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('052','','178 SAMS STREET','','Decatur','30030-4134','089','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('055','4783746760','P.O. BOX 4219','','Eastman','31023-4219','091','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('313','','P.O. BOX 398','','Eastman','31023-0398','091','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('056','2292684111','P.O. BOX 385','','Vienna','31092-0385','093','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('057','2294304118','P.O. BOX 3249','','Albany','31708-4301','095','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('093','','129 WHITTLESEY COURT','','Albany','31705-2385','095','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('053','7704893000','4600 TIMBER RIDGE DR','','Douglasville','30135-0000','097','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('058','','8473 DURALEE LN #100','','Douglasville','30134-1944','097','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('059','2297242000','P.O. BOX 747','','Blakely','39823-0747','099','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('060','2295595751','106 CHURCH OF GOD ST.','','Statenville','31648-9711','101','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('061','9127546471','P.O. BOX 345','','Springfield','31329-0345','103','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('062','7062132001','P.O. BOX 1010','','Elberton','30635-1010','105','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('063','4782892400','P.O. BOX 808','','Swainsboro','30401-0808','107','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('064','9127391222','P.O. BOX 578','','Claxton','30417-0578','109','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('065','7066322296','990 E. MAIN ST, SU-10','','Blue Ridge','30513-0000','111','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('066','7704602555','905 HIGHWAY 85 SOUTH','','Fayetteville','30215-2005','113','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('067','7062956500','450 RIVERSIDE PARKWAY','','Rome','30162-0193','115','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('068','7707816700','P.O. BOX 21','','Cumming','30130-0021','117','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('069','7063844521','P.O. BOX 279','','Carnesville','30521-0279','119','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('070','4042065300','84 WALTON STREET, NW','','Atlanta','30303-2125','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('071','7707747500','515 FAIRBURN RD., S.W.','','Atlanta','30331-2066','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('072','4046994337','1249 DL HOLLOWELL PKWY','','Atlanta','30318-6657','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('073','','75 MARIETTA ST. NW','','Atlanta','30303-2815','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('074','','6075 ROSWELL RD STE300','','Atlanta','30328-4062','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('075','','341 PON.DE LEON AV.NE','','Atlanta','30308-2048','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('076','','1249 DL HOLLOWELL PKWY','','Atlanta','30318-6657','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('077','','230 PEACHTREE ST.','','Atlanta','30303-1511','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('078','','54 ELLIS STREET N.E.','','Atlanta','30303-2421','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('079','','1249 BANKHEAD AVE NW','','Atlanta','30318-6657','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('080','','75 MARIETTA ST. NW','','Atlanta','30303-2815','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('081','','P.O.BOX 1857','','Jonesboro','30236-9998','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('082','','5710 STONEWALL TELL','','College Park','30349-0000','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('192','','1033 JEFFERSON ST, NW','','Atlanta','30318-0000','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('198','','75 MARIETTA ST., NW','','Atlanta','30303-2815','121','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('084','7066352361','54 KIKER STREET','','Ellijay','30540-1325','123','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('085','7065982955','P.O. BOX 225','','Gibson','30810-0225','125','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('086','9122623200','P. O. BOX 400','','Brunswick','31521-0400','127','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('087','7066241200','P O BOX 217','','Calhoun','30703-0217','129','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('088','2293773154','P.O. BOX 269','','Cairo','31728-0269','131','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('089','7064532365','P.O. BOX 460','','Greensboro','30642-0460','133','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('090','6785185500','ONE JUSTICE SQUARE','','Lawrenceville','30045-0000','135','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('190','','2755 SAWNEE AVENUE','','Buford','30518-0000','135','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('199','','5030 GEORGIA BELLE CT','','Norcross','30093-2302','135','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('200','','2211 BEAVER RUIN ROAD','','Norcross','30071-3348','135','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('091','7067542148','P.O. BOX 160','','Clarkesville','30523-0287','137','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('092','7705325298','970 MCEVER ROAD EXT.','','Gainesville','30504-3938','139','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('094','7064441203','P. O. BOX 70','','Sparta','31087-0070','141','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('095','7706463885','P.O. BOX 324','','Buchanan','30113-0324','143','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('096','7066284226','P.O. BOX 285','','Hamilton','31811-0285','145','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('097','7068562740','P.O. BOX 518','','Hartwell','30643-0518','147','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('098','7066753361','P O BOX 385','','Franklin','30217-0385','149','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('099','7709542014','125 HENRY PARKWAY','','Mcdonough','30253-6636','151','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('100','4789887600','92 COHEN WALKER DR.','','Warner Robins','31088-2725','153','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('101','','92 COHEN WALKER DR.','','Warner Robins','31088-2725','153','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('315','','P.O. BOX 2286','','Warner Robins','31099-2286','153','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('102','2294682150','108 N. IRWIN AVENUE','','Ocilla','31774-0546','155','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('103','7063673000','456 ATHENS STREET','','Jefferson','30549-0525','157','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('104','7064686461','226 FUNDERBURG DRIVE','','Monticello','31064-1154','159','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('105','9123753942','P.O. BOX 706','','Hazlehurst','31539-0706','161','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('106','4786257259','P.O. BOX 570','','Louisville','30434-0570','163','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('107','4789821944','P.O. BOX 808','','Millen','30442-0808','165','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('108','4788644210','P. O. BOX 500','','Wrightsville','31096-0500','167','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('109','4789863126','P.O. DRAWER 1689','','Gray','31032-0192','169','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('110','7703585170','122 WESTGATE PLAZA','','Barnesville','30204-1526','171','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('111','2294823686','313 ROQUEMORE CIRCLE','','Lakeland','31635-1500','173','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('112','4782756533','P.O. BOX 68','','Dublin','31040-0068','175','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('113','2297593000','P.O. BOX 145','','Leesburg','31763-0145','177','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('114','9123702555','P.O. BOX 710','','Hinesville','31310-0710','179','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('115','7063593135','P.O. BOX 220','','Lincolnton','30817-0220','181','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('116','9125452177','P.O. BOX 369','','Ludowici','31316-0369','183','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('117','2293335200','P.O. BOX 5166','','Valdosta','31603-5166','185','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('118','7068641980','175 TIPTON DRIVE','','Dahlonega','30533-1139','187','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('119','4784723700','P.O. BOX 457','','Oglethorpe','31068-0457','193','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('120','7067952128','P.O. BOX 176','','Danielsville','30633-0176','195','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('121','2296492311','P.O. BOX 473','','Buena Vista','31803-0473','197','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('122','7065952946','P.O. BOX 507','','Thomson','30824-0507','189','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('123','9124374193','P.O. BOX 1139','','Darien','31305-1139','191','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('124','7066724244','PO BOX 1179','','Greenville','30222-9599','199','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('125','2297583387','69 THOMPSON TOWN ROAD','','Colquitt','31737-9704','201','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('126','2295523500','90 WEST OAKLAND AVE','','Camilla','31730-1254','205','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('127','4789933030','P. O. BOX 734','','Forsyth','31029-0734','207','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('128','9125833722','P.O. BOX 217','','Mt. Vernon','30445-0217','209','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('129','7063435800','P.O. BOX 89','','Madison','30650-0089','211','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('130','9126957315','P.O. BOX 1014','','Chatsworth','30705-1014','213','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('131','7066497311','2100 COMER AVE','','Columbus','31902-2627','215','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('191','','1636 SECOND AVENUE','','Columbus','31901-1852','215','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('196','','1226  10TH  AVE.','','Columbus','31901-2621','215','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('132','7707842490','P. O. BOX 1588','','Covington','30015-1588','217','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('133','7067695206','P.O. BOX 105','','Watkinsville','30677-0105','219','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('134','7067438152','P.O. BOX 160','','Lexington','30648-0160','221','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('135','7704437810','P.O. BOX 168','','Dallas','30132-0168','223','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('136','7704437810','P.O. BOX 976','','Fort Valley','31030-0976','225','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('137','7066924701','255 CHAMBERS STREET','','Jasper','30143-1219','227','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('317','','P.O. BOX 530','','Jasper','30143-0530','227','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('138','7066924701','P.O. BOX 620','','Blackshear','31516-0620','229','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('139','7705678427','P.O. BOX 387','','Zebulon','30295-0387','231','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('140','7707492232','P.O. BOX 147','','Cedartown','30125-0147','233','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('141','4787836191','P.O. BOX 567','','Hawkinsville','31036-0567','235','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('142','7064854921','PO BOX 3670','','Eatonton','31024-3670','237','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('143','2293342427','P.O. BOX 68','','Georgetown','39854-0068','239','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('144','7067824283','P.O. BOX 787','','Clayton','30525-0020','241','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('145','2297323742','311 N. WEBSTER STREET','','Cuthbert','39840-0000','243','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('146','7067212536','P.O. BOX 2277','','Augusta','30903-2277','245','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('147','','P.O. BOX 2277','','Augusta','30903-2277','245','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('148','','P.O. BOX 2277','','Augusta','30903-2277','245','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('197','','P.O. BOX 2277','','Augusta','30903-2277','245','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('149','7703885025','975 TAYLOR ST','','Conyers','30012-5924','247','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('150','2299372591','P.O. BOX 367','','Ellaville','31806-0367','249','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('151','9125642041','P.O. BOX 513','','Sylvania','30467-0513','251','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('152','2295242365','108 W 4TH ST','','Donalsonville','31745-0656','253','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('153','7702281386','P.O. BOX 1610','','Griffin','30224-1610','255','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('401','','P.O. BOX 1610','','Griffin','30224-1610','255','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('402','','P.O. BOX 1610','','Griffin','30224-1610','255','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('403','','P.O. BOX 1610','','Griffin','30224-1610','255','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('154','7062824505','1000 TUGALO ST.','','Toccoa','30577-1941','257','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('155','2298384335','P.O. BOX 308','','Lumpkin','31815-0308','259','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('156','2299312462','P.O. BOX 1669','','Americus','31709-1669','261','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('157','7066658524','P.O. BOX 96','','Talbotton','31827-0096','263','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('158','7064562339','P.O. BOX 38','','Crawfordville','30631-0038','265','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('159','9125577721','P.O. BOX 528','','Reidsville','30453-0528','267','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('160','','P O BOX 898','','Glenville','30427-1128','267','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('161','4788625221','P.O. BOX 366','','Butler','31006-0366','269','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('162','2298683030','P.O. BOX 456','','Mcrae','31055-0456','271','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('163','2292254005','P.O. BOX 30','','Dawson','31742-0030','273','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('164','2292254005','P.O. BOX 2740','','Thomasville','31799-2740','275','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('165','2293863388','P.O. BOX 7550','','Tifton','31793-7550','277','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('166','9125268117','P.O. BOX 191','','Lyons','30436-0191','279','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('167','7068963524','P.O. BOX 156','','Hiawassee','30546-0156','281','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('168','9125293757','P.O. BOX 625','','Soperton','30457-0625','283','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('169','7062987100','1220 HOGANSVILLE RD','','Lagrange','30241-4631','285','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('170','2295674353','336 NORTH STREET','','Ashburn','31714-0804','287','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('171','4789453258','P.O. BOX 530','','Jeffersonville','31044-0530','289','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('172','7067452931','P O BOX 220','','Blairsville','30514-0220','291','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('173','7066466043','711 N. BETHEL STREET','','Thomaston','30286-2202','293','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('174','7063750726','P.O. BOX 689','','Rock Spring','30739-0689','295','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('175','','P. O. BOX 689','','Rock Spring','30739-0689','295','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('318','','RR 2  BOX 187','','Rock Spring','30739-9521','295','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('176','7702074000','P.O. BOX 927','','Monroe','30655-0927','297','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('178','9122856040','P.O. BOX 2048','','Waycross','31502-2048','299','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('179','7064653326','P.O. BOX 166','','Warrenton','30828-0166','301','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('180','4785532350','P.O. BOX 108','','Sandersville','31082-0108','303','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('181','9124275866','P.O. BOX 267','','Jesup','31598-0267','305','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('182','2298286265','P.O. BOX 9','','Preston','31824-0009','307','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('183','9125687127','P.O. BOX 221','','Alamo','30411-0221','309','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('184','7068653128','1241 HELEN HWY UN-200','','Cleveland','30528-9452','311','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('185','7062722331','P.O. BOX 1203','','Dalton','30722-1203','313','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('186','2293652243','P.O. BOX 246','','Rochelle','31079-0246','315','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('187','7066782814','P.O. BOX 126','','Washington','30673-0126','317','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('188','4789462224','P.O. BOX 526','','Irwinton','31042-0526','319','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('189','2297772000','P.O. BOX 527','','Sylvester','31791-0527','321','N');
insert into caps.mail_code (cd_mail_code,nbr_mail_code_phone,addr_mail_code_st_ln_1,addr_mail_code_st_ln_2,addr_mail_code_city,addr_mail_code_zip,addr_mail_code_county,ind_mail_code_invalid) values ('999','7705937406','RSM PROJECT','','Atlanta','30303-3108','121','N');

-- insert into caps.office
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (1,'001','CPS','009','Appling');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (2,'002','CPS','011','Atkinson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (3,'003','CPS','011','Bacon');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (4,'004','CPS','010','Baker');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (5,'005','CPS','006','Baldwin-5');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (195,'195','CPS','006','Baldwin-195');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (6,'006','CPS','002','Banks');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (7,'007','CPS','005','Barrow');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (8,'008','CPS','003','Bartow');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (9,'009','CPS','011','Ben Hill');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (10,'010','CPS','011','Berrien');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (11,'011','CPS','006','Bibb');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (12,'012','CPS','009','Bleckley');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (13,'013','CPS','011','Brantley');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (14,'014','CPS','011','Brooks');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (15,'015','CPS','012','Bryan-15');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (54,'054','CPS','012','Bryan-54');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (16,'016','CPS','012','Bulloch');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (17,'017','CPS','007','Burke');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (18,'018','CPS','004','Butts');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (19,'019','CPS','010','Calhoun');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (20,'020','CPS','012','Camden-20');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (193,'193','CPS','012','Camden-193');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (21,'021','CPS','009','Candler');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (22,'022','CPS','004','Carroll');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (23,'023','CPS','001','Catoosa');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (24,'024','CPS','011','Charlton');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (25,'025','CPS','012','Chatham');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (26,'026','CPS','008','Chattahochee');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (27,'027','CPS','001','Chattooga');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (28,'028','CPS','017','Cherokee');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (30,'030','CPS','005','Clarke');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (31,'031','CPS','008','Clay-31');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (312,'312','CPS','008','Clay-312');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (32,'032','CPS','016','Clayton-32');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (33,'033','CPS','016','Clayton-33');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (34,'034','CPS','011','Clinch');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (35,'035','CPS','017','Cobb-35');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (36,'036','CPS','017','Cobb-36');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (37,'037','CPS','017','Cobb-37');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (39,'039','CPS','011','Coffee');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (40,'040','CPS','010','Colquitt');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (41,'041','CPS','007','Columbia-41');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (194,'194','CPS','007','Columbia-194');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (42,'042','CPS','011','Cook');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (43,'043','CPS','004','Coweta');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (44,'044','CPS','006','Crawford');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (45,'045','CPS','008','Crisp');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (46,'046','CPS','001','Dade');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (47,'047','CPS','002','Dawson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (48,'048','CPS','010','Decatur');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (49,'049','CPS','014','Dekalb-49');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (50,'050','CPS','014','Dekalb-50');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (51,'051','CPS','014','Dekalb-51');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (52,'052','CPS','014','Dekalb-52');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (55,'055','CPS','009','Dodge-55');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (313,'313','CPS','009','Dodge-313');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (56,'056','CPS','008','Dooly');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (57,'057','CPS','010','Dougherty-57');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (93,'093','CPS','010','Dougherty-93');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (53,'053','CPS','017','Douglas-53');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (58,'058','CPS','017','Douglas-58');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (59,'059','CPS','010','Early');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (60,'060','CPS','011','Echols');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (61,'061','CPS','012','Effingham');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (62,'062','CPS','005','Elbert');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (63,'063','CPS','009','Emanuel');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (64,'064','CPS','009','Evans');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (65,'065','CPS','001','Fannin');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (66,'066','CPS','016','Fayette');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (67,'067','CPS','003','Floyd');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (68,'068','CPS','002','Forsyth');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (69,'069','CPS','002','Franklin');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (70,'070','CPS','013','Fulton-70');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (71,'071','CPS','013','Fulton-71');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (72,'072','CPS','013','Fulton-72');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (73,'073','CPS','013','Fulton-73');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (74,'074','CPS','013','Fulton-74');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (75,'075','CPS','013','Fulton-75');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (76,'076','CPS','013','Fulton-76');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (77,'077','CPS','013','Fulton-77');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (78,'078','CPS','013','Fulton-78');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (79,'079','CPS','013','Fulton-79');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (80,'080','CPS','013','Fulton-80');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (81,'081','CPS','013','Fulton-81');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (82,'082','CPS','013','Fulton-82');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (192,'192','CPS','013','Fulton-192');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (198,'198','CPS','013','Fulton-198');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (84,'084','CPS','001','Gilmer');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (85,'085','CPS','007','Glascock');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (86,'086','CPS','012','Glynn');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (87,'087','CPS','003','Gordon');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (88,'088','CPS','010','Grady');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (89,'089','CPS','005','Greene');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (90,'090','CPS','015','Gwinnett-90');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (190,'190','CPS','015','Gwinnett-190');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (199,'199','CPS','015','Gwinnett-199');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (200,'200','CPS','015','Gwinnett-200');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (91,'091','CPS','002','Habersham');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (92,'092','CPS','002','Hall');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (94,'094','CPS','007','Hancock');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (95,'095','CPS','003','Haralson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (96,'096','CPS','008','Harris');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (97,'097','CPS','002','Hart');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (98,'098','CPS','004','Heard');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (99,'099','CPS','016','Henry');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (100,'100','CPS','006','Houston-100');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (101,'101','CPS','006','Houston-101');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (315,'315','CPS','006','Houston-315');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (102,'102','CPS','011','Irwin');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (103,'103','CPS','005','Jackson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (104,'104','CPS','005','Jasper');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (105,'105','CPS','009','Jeff Davis');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (106,'106','CPS','007','Jefferson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (107,'107','CPS','007','Jenkins');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (108,'108','CPS','009','Johnson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (109,'109','CPS','006','Jones');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (110,'110','CPS','004','Lamar');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (111,'111','CPS','011','Lanier');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (112,'112','CPS','009','Laurens');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (113,'113','CPS','010','Lee');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (114,'114','CPS','012','Liberty');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (115,'115','CPS','007','Lincoln');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (116,'116','CPS','012','Long');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (117,'117','CPS','011','Lowndes');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (118,'118','CPS','002','Lumpkin');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (119,'119','CPS','008','Macon');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (120,'120','CPS','005','Madison');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (121,'121','CPS','008','Marion');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (122,'122','CPS','007','Mcduffie');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (123,'123','CPS','012','Mcintosh');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (124,'124','CPS','004','Meriwether');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (125,'125','CPS','010','Miller');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (126,'126','CPS','010','Mitchell');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (127,'127','CPS','006','Monroe');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (128,'128','CPS','009','Montgomery');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (129,'129','CPS','005','Morgan');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (130,'130','CPS','001','Murray');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (131,'131','CPS','008','Muscogee-131');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (191,'191','CPS','008','Muscogee-191');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (196,'196','CPS','008','Muscogee-196');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (132,'132','CPS','005','Newton');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (133,'133','CPS','005','Oconee');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (134,'134','CPS','005','Oglethorpe');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (135,'135','CPS','003','Paulding');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (136,'136','CPS','006','Peach');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (137,'137','CPS','001','Pickens-137');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (317,'317','CPS','001','Pickens-317');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (138,'138','CPS','011','Pierce');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (139,'139','CPS','004','Pike');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (140,'140','CPS','003','Polk');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (141,'141','CPS','006','Pulaski');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (142,'142','CPS','006','Putnam');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (143,'143','CPS','008','Quitman');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (144,'144','CPS','002','Rabun');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (145,'145','CPS','008','Randolph');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (146,'146','CPS','007','Richmond-146');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (147,'147','CPS','007','Richmond-147');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (148,'148','CPS','007','Richmond-148');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (197,'197','CPS','007','Richmond-197');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (149,'149','CPS','015','Rockdale');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (150,'150','CPS','008','Schley');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (151,'151','CPS','007','Screven');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (152,'152','CPS','010','Seminole');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (153,'153','CPS','004','Spalding-153');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (401,'401','CPS','004','Spalding-401');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (402,'402','CPS','004','Spalding-402');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (403,'403','CPS','004','Spalding-403');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (154,'154','CPS','002','Stephens');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (155,'155','CPS','008','Stewart');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (156,'156','CPS','008','Sumter');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (157,'157','CPS','008','Talbot');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (158,'158','CPS','007','Taliaferro');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (159,'159','CPS','009','Tattnall-159');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (160,'160','CPS','009','Tattnall-160');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (161,'161','CPS','008','Taylor');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (162,'162','CPS','009','Telfair');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (163,'163','CPS','010','Terrell');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (164,'164','CPS','010','Thomas');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (165,'165','CPS','011','Tift');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (166,'166','CPS','009','Toombs');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (167,'167','CPS','002','Towns');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (168,'168','CPS','009','Treutlen');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (169,'169','CPS','004','Troup');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (170,'170','CPS','011','Turner');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (171,'171','CPS','006','Twiggs');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (172,'172','CPS','002','Union');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (173,'173','CPS','004','Upson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (174,'174','CPS','001','Walker-174');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (175,'175','CPS','001','Walker-175');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (318,'318','CPS','001','Walker-318');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (176,'176','CPS','005','Walton');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (178,'178','CPS','011','Ware');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (179,'179','CPS','007','Warren');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (180,'180','CPS','007','Washington');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (181,'181','CPS','009','Wayne');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (182,'182','CPS','008','Webster');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (183,'183','CPS','009','Wheeler');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (184,'184','CPS','002','White');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (185,'185','CPS','001','Whitfield');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (186,'186','CPS','009','Wilcox');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (187,'187','CPS','007','Wilkes');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (188,'188','CPS','006','Wilkinson');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (189,'189','CPS','010','Worth');
insert into caps.office (id_office, cd_office_mail, cd_office_program, cd_office_region, nm_office_name) values (999,'999','CPS','099','State Office');


-- inserts into caps.office_county_link
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100001,'001',1);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100002,'003',2);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100003,'005',3);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100004,'007',4);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100005,'009',5);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100006,'009',195);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100007,'011',6);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100008,'013',7);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100009,'015',8);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100010,'017',9);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100011,'019',10);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100012,'021',11);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100013,'023',12);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100014,'025',13);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100015,'027',14);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100016,'029',15);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100017,'029',54);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100018,'031',16);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100019,'033',17);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100020,'035',18);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100021,'037',19);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100022,'039',20);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100023,'039',193);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100024,'043',21);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100025,'045',22);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100026,'047',23);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100027,'049',24);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100028,'051',25);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100029,'053',26);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100030,'055',27);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100031,'057',28);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100032,'059',30);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100033,'061',31);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100034,'061',312);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100035,'063',32);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100036,'063',33);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100037,'065',34);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100038,'067',35);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100039,'067',36);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100040,'067',37);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100041,'069',39);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100042,'071',40);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100043,'073',41);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100044,'073',194);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100045,'075',42);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100046,'077',43);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100047,'079',44);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100048,'081',45);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100049,'083',46);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100050,'085',47);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100051,'087',48);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100052,'089',49);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100053,'089',50);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100054,'089',51);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100055,'089',52);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100056,'091',55);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100057,'091',313);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100058,'093',56);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100059,'095',57);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100060,'095',93);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100061,'097',53);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100062,'097',58);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100063,'099',59);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100064,'101',60);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100065,'103',61);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100066,'105',62);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100067,'107',63);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100068,'109',64);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100069,'111',65);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100070,'113',66);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100071,'115',67);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100072,'117',68);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100073,'119',69);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100074,'121',70);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100075,'121',71);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100076,'121',72);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100077,'121',73);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100078,'121',74);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100079,'121',75);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100080,'121',76);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100081,'121',77);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100082,'121',78);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100083,'121',79);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100084,'121',80);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100085,'121',81);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100086,'121',82);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100087,'121',192);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100088,'121',198);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100089,'123',84);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100090,'125',85);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100091,'127',86);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100092,'129',87);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100093,'131',88);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100094,'133',89);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100095,'135',90);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100096,'135',190);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100097,'135',199);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100098,'135',200);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100099,'137',91);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100100,'139',92);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100101,'141',94);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100102,'143',95);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100103,'145',96);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100104,'147',97);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100105,'149',98);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100106,'151',99);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100107,'153',100);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100108,'153',101);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100109,'153',315);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100110,'155',102);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100111,'157',103);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100112,'159',104);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100113,'161',105);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100114,'163',106);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100115,'165',107);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100116,'167',108);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100117,'169',109);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100118,'171',110);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100119,'173',111);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100120,'175',112);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100121,'177',113);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100122,'179',114);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100123,'181',115);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100124,'183',116);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100125,'185',117);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100126,'187',118);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100127,'193',119);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100128,'195',120);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100129,'197',121);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100130,'189',122);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100131,'191',123);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100132,'199',124);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100133,'201',125);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100134,'205',126);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100135,'207',127);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100136,'209',128);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100137,'211',129);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100138,'213',130);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100139,'215',131);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100140,'215',191);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100141,'215',196);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100142,'217',132);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100143,'219',133);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100144,'221',134);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100145,'223',135);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100146,'225',136);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100147,'227',137);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100148,'227',317);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100149,'229',138);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100150,'231',139);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100151,'233',140);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100152,'235',141);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100153,'237',142);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100154,'239',143);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100155,'241',144);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100156,'243',145);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100157,'245',146);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100158,'245',147);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100159,'245',148);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100160,'245',197);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100161,'247',149);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100162,'249',150);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100163,'251',151);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100164,'253',152);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100165,'255',153);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100166,'255',401);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100167,'255',402);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100168,'255',403);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100169,'257',154);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100170,'259',155);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100171,'261',156);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100172,'263',157);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100173,'265',158);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100174,'267',159);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100175,'267',160);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100176,'269',161);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100177,'271',162);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100178,'273',163);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100179,'275',164);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100180,'277',165);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100181,'279',166);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100182,'281',167);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100183,'283',168);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100184,'285',169);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100185,'287',170);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100186,'289',171);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100187,'291',172);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100188,'293',173);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100189,'295',174);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100190,'295',175);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100191,'295',318);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100192,'297',176);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100193,'299',178);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100194,'301',179);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100195,'303',180);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100196,'305',181);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100197,'307',182);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100198,'309',183);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100199,'311',184);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100200,'313',185);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100201,'315',186);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100202,'317',187);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100203,'319',188);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100204,'321',189);
insert into caps.office_county_link (id_office_county_link, cd_county, id_office) values (100205,'999',999);

-- insert into office phone
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100001,1,'9123661010','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100002,2,'9124223242','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100003,3,'9126328375','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100004,4,'2297345247','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100005,5,'4784454135','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100006,6,'7076772272','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100007,7,'7708684222','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100008,8,'7703873710','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100009,9,'2294265300','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100010,10,'2296865568','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100011,11,'4787516051','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100012,12,'4789343172','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100013,13,'9124626171','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100014,14,'2292637567','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100015,15,'9126532805','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100016,16,'9128711333','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100017,17,'7065547751','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100018,18,'7705042200','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100019,19,'2298495100','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100020,20,'9127294583','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100021,21,'9126852163','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100022,22,'7708302050','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100023,23,'7069352368','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100024,24,'9124962527','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100025,25,'9126512211','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100026,26,'7069893681','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100027,27,'7068570817','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100028,28,'7707203610','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100029,30,'7062277000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100030,31,'2297682511','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100031,32,'7704732300','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100032,34,'9124875263','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100033,35,'7705285000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100034,39,'9123894286','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100035,40,'2292174000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100036,41,'7065411640','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100037,42,'2298963672','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100038,43,'7702547234','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100039,44,'4788366030','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100040,45,'2292762349','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100041,46,'7066577511','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100042,47,'7062656598','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100043,48,'2292482420','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100044,49,'4043705251','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100045,50,'4046873121','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100046,55,'4783746760','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100047,56,'2292684111','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100048,57,'2294304118','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100049,53,'7704893000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100050,59,'2297242000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100051,60,'2295595751','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100052,61,'9127546471','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100053,62,'7062132001','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100054,63,'4782892400','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100055,64,'9127391222','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100056,65,'7066322296','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100057,66,'7704602555','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100058,67,'7062956500','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100059,68,'7707816700','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100060,69,'7063844521','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100061,70,'4042065300','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100062,71,'7707747500','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100063,72,'4046994337','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100064,84,'7066352361','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100065,85,'7065982955','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100066,86,'9122623200','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100067,87,'7066241200','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100068,88,'2293773154','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100069,89,'7064532365','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100070,90,'6785185500','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100071,91,'7067542148','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100072,92,'7705325298','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100073,94,'7064441203','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100074,95,'7706463885','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100075,96,'7066284226','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100076,97,'7068562740','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100077,98,'7066753361','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100078,99,'7709542014','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100079,100,'4789887600','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100080,102,'2294682150','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100081,103,'7063673000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100082,104,'7064686461','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100083,105,'9123753942','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100084,106,'4786257259','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100085,107,'4789821944','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100086,108,'4788644210','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100087,109,'4789863126','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100088,110,'7703585170','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100089,111,'2294823686','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100090,112,'4782756533','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100091,113,'2297593000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100092,114,'9123702555','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100093,115,'7063593135','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100094,116,'9125452177','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100095,117,'2293335200','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100096,118,'7068641980','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100097,119,'4784723700','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100098,120,'7067952128','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100099,121,'2296492311','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100100,122,'7065952946','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100101,123,'9124374193','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100102,124,'7066724244','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100103,125,'2297583387','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100104,126,'2295523500','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100105,127,'4789933030','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100106,128,'9125833722','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100107,129,'7063435800','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100108,130,'9126957315','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100109,131,'7066497311','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100110,132,'7707842490','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100111,133,'7067695206','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100112,134,'7067438152','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100113,135,'7704437810','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100114,136,'7704437810','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100115,137,'7066924701','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100116,138,'7066924701','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100117,139,'7705678427','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100118,140,'7707492232','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100119,141,'4787836191','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100120,142,'7064854921','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100121,143,'2293342427','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100122,144,'7067824283','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100123,145,'2297323742','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100124,146,'7067212536','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100125,149,'7703885025','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100126,150,'2299372591','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100127,151,'9125642041','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100128,152,'2295242365','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100129,153,'7702281386','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100130,154,'7062824505','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100131,155,'2298384335','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100132,156,'2299312462','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100133,157,'7066658524','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100134,158,'7064562339','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100135,159,'9125577721','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100136,161,'4788625221','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100137,162,'2298683030','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100138,163,'2292254005','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100139,164,'2292254005','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100140,165,'2293863388','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100141,166,'9125268117','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100142,167,'7068963524','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100143,168,'9125293757','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100144,169,'7062987100','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100145,170,'2295674353','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100146,171,'4789453258','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100147,172,'7067452931','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100148,173,'7066466043','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100149,174,'7063750726','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100150,176,'7702074000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100151,178,'9122856040','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100152,179,'7064653326','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100153,180,'4785532350','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100154,181,'9124275866','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100155,182,'2298286265','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100156,183,'9125687127','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100157,184,'7068653128','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100158,185,'7062722331','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100159,186,'2293652243','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100160,187,'7066782814','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100161,188,'4789462224','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100162,189,'2297772000','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100163,999,'7705937406','N',to_date('6/26/2007','mm/dd/yyyy'),'Y','BS');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100164,1,'9123661045','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100165,2,'9124223538','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100166,3,'9126325007','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100167,4,'2297348442','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100168,5,'4784456531','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100169,6,'7076772196','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100170,7,'7708684235','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100171,8,'7703873944','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100172,9,'2294265338','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100173,10,'2296863933','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100174,11,'4787516578','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100175,12,'4789343332','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100176,13,'9124627255','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100177,14,'2292639014','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100178,15,'9126532803','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100179,16,'9126815990','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100180,17,'7065547093','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100181,18,'7705042204','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100182,19,'2298495101','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100183,20,'9127297969','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100184,21,'9126853690','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100185,22,'7708302106','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100186,23,'7069657727','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100187,24,'9124964232','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100188,25,'9126512890','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100189,26,'7069891066','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100190,27,'7068570823','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100191,28,'7707203680','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100192,30,'7062277925','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100193,31,'2297683265','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100194,32,'7704785948','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100195,34,'9124873599','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100196,35,'7705285154','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100197,39,'9123894419','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100198,40,'2292174034','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100199,41,'7065410330','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100200,42,'2298967709','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100201,43,'7702547500','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100202,44,'4788366053','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100203,45,'2292762713','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100204,46,'7066575368','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100205,47,'7062652085','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100206,48,'2292482696','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100207,49,'4043705499','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100208,55,'4783746764','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100209,56,'2292681703','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100210,57,'2294304355','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100211,53,'7704893035','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100212,59,'2297242005','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100213,60,'2295596167','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100214,61,'9127547638','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100215,62,'7062132039','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100216,63,'4782892462','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100217,64,'9127390284','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100218,65,'7066323521','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100219,66,'7704602464','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100220,67,'7062956718','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100221,68,'7707816742','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100222,69,'7063843212','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100223,70,'4042065799','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100224,84,'7062762367','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100225,85,'7065982540','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100226,86,'9122623056','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100227,87,'7066241206','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100228,88,'2293779157','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100229,89,'7064535132','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100230,90,'6785185505','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100231,91,'7067548065','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100232,92,'7705356967','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100233,94,'7064441207','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100234,95,'7706469373','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100235,96,'7066285392','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100236,97,'7068562792','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100237,98,'7066750516','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100238,99,'7709542329','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100239,100,'4789887617','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100240,102,'2294682177','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100241,103,'7063673044','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100242,104,'7064681338','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100243,105,'9123757997','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100244,106,'4786257984','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100245,107,'4789821279','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100246,108,'4788644214','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100247,109,'4789863127','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100248,110,'7703585169','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100249,111,'2294822334','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100250,112,'4782756700','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100251,113,'2297593004','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100252,114,'9123702525','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100253,115,'7063596000','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100254,116,'9125459769','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100255,117,'2293337027','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100256,118,'7068641651','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100257,119,'4784723732','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100258,120,'7067953651','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100259,121,'2296492428','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100260,122,'7065978525','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100261,123,'9124374170','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100262,124,'7066724342','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100263,125,'2297585084','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100264,126,'2295523561','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100265,127,'4789933035','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100266,128,'9125833739','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100267,129,'7063435827','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100268,130,'9126957541','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100269,131,'7066491342','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100270,132,'7707842479','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100271,133,'7067698684','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100272,134,'7067433019','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100273,135,'7704437820','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100274,136,'7704437820','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100275,137,'7066924700','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100276,138,'7066924700','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100277,139,'7705670784','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100278,140,'7707492262','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100279,141,'4787836195','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100280,142,'7064850073','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100281,143,'2293345606','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100282,144,'7067826193','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100283,145,'2297325412','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100284,146,'7067217140','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100285,149,'7707856828','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100286,150,'2299375641','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100287,151,'9125649372','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100288,152,'2295246632','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100289,153,'7704124702','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100290,154,'7062824502','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100291,155,'2298386280','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100292,156,'2299312427','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100293,157,'7066653843','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100294,158,'7064562976','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100295,159,'9125577774','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100296,161,'4788622999','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100297,162,'2298683033','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100298,163,'2292255278','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100299,164,'2292255278','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100300,165,'2293867236','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100301,166,'9125266986','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100302,167,'7068961457','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100303,168,'9125294305','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100304,169,'7062987122','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100305,170,'2295673954','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100306,171,'4789456508','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100307,172,'7067453560','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100308,173,'7066466048','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100309,174,'7063750798','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100310,176,'7702074007','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100311,178,'9122876626','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100312,179,'7064652819','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100313,180,'4785532390','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100314,181,'9124275885','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100315,182,'2298282032','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100316,183,'9125687196','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100317,184,'7068659586','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100318,185,'7062722895','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100319,186,'2293652575','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100320,187,'7066785325','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100321,188,'4789463821','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');
insert into caps.office_phone (id_office_phone,id_office,nbr_office_phone,ind_office_phone_invalid,dt_office_phone_start,ind_office_phone_primary,cd_office_phone_type) values (100322,189,'2297772073','N',to_date('6/26/2007','mm/dd/yyyy'),'N','BF');

/
DECLARE
TYPE office_id_list IS TABLE OF NUMBER;
new_office_list office_id_list := office_id_list(
1,
2,
3,
4,
5,
6,
7,
8,
9,
10,
11,
12,
13,
14,
15,
16,
17,
18,
19,
20,
21,
22,
23,
24,
25,
26,
27,
28,
30,
31,
32,
34,
35,
39,
40,
41,
42,
43,
44,
45,
46,
47,
48,
49,
51,
55,
56,
57,
53,
59,
60,
61,
62,
63,
64,
65,
66,
67,
68,
69,
70,
71,
72,
79,
82,
84,
85,
86,
87,
88,
89,
90,
91,
92,
94,
95,
96,
97,
98,
99,
100,
102,
103,
104,
105,
106,
107,
108,
109,
110,
111,
112,
113,
114,
115,
116,
117,
118,
119,
120,
121,
122,
123,
124,
125,
126,
127,
128,
129,
130,
131,
132,
133,
134,
135,
136,
137,
138,
139,
140,
141,
142,
143,
144,
145,
146,
149,
150,
151,
152,
153,
154,
155,
156,
157,
158,
159,
161,
162,
163,
164,
165,
166,
167,
168,
169,
170,
171,
172,
173,
174,
176,
178,
179,
180,
181,
182,
183,
184,
185,
186,
187,
188,
189,
999
);

CURSOR employee_cur is SELECT ID_EMP_OFFICE from CAPS.EMPLOYEE for update;
employee_rec employee_cur%ROWTYPE;
new_office number;
CURSOR case_file_loc_cur is SELECT ID_CASE_FILE_LOC_OFFICE from CAPS.CASE_FILE_LOC for update;
case_file_loc_rec case_file_loc_cur%ROWTYPE;
CURSOR case_file_management_cur is SELECT ID_CASE_FILE_OFFICE from CAPS.CASE_FILE_MANAGEMENT for update;
case_file_management_rec case_file_management_cur%ROWTYPE;

FUNCTION get_new_office(old_office number)
RETURN NUMBER
IS
   retVal number;
BEGIN
   retVal := 999;
   IF (old_office > 0 and old_office < 165) THEN
      retVal := new_office_list(old_office);
   END IF;
     
   return retVal;
END;

BEGIN
OPEN employee_cur;
LOOP
  FETCH employee_cur into employee_rec;
  IF employee_cur%NOTFOUND
  THEN
      EXIT;
  ELSE
      new_office := get_new_office(employee_rec.id_emp_office);
      UPDATE caps.employee set id_emp_office=new_office
         WHERE CURRENT OF employee_cur;
  END IF;
END LOOP;
CLOSE employee_cur;

OPEN case_file_loc_cur;
LOOP
  FETCH case_file_loc_cur into case_file_loc_rec;
  IF case_file_loc_cur%NOTFOUND
  THEN
      EXIT;
  ELSE
      new_office := get_new_office(case_file_loc_rec.ID_CASE_FILE_LOC_OFFICE);
      UPDATE caps.case_file_loc set ID_CASE_FILE_LOC_OFFICE=new_office
         WHERE CURRENT OF case_file_loc_cur;
  END IF;
END LOOP;
CLOSE case_file_loc_cur;

OPEN case_file_management_cur;
LOOP
  FETCH case_file_management_cur into case_file_management_rec;
  IF case_file_management_cur%NOTFOUND
  THEN
      EXIT;
  ELSE
      new_office := get_new_office(case_file_management_rec.ID_CASE_FILE_OFFICE);
      UPDATE caps.case_file_management set ID_CASE_FILE_OFFICE=new_office
         WHERE CURRENT OF case_file_management_cur;
  END IF;
END LOOP;
CLOSE case_file_management_cur;

END;
/

ALTER TABLE CAPS.EMPLOYEE enable CONSTRAINT FK_emp_office;
ALTER TABLE CAPS.CASE_FILE_MANAGEMENT enable CONSTRAINT FK_case_file_office;
ALTER TABLE CAPS.CASE_FILE_LOC enable CONSTRAINT FK_case_file_loc_office;
ALTER TABLE CAPS.PERF_TALLY enable CONSTRAINT FK_perf_tally_office;
ALTER TABLE CAPS.OFFICE_PHONE enable CONSTRAINT FK_office_phone;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (213, 'SacwisRev2', 'OFFICE and related table updates');
commit;
