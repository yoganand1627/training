--STGAP00016204 - Release(4.3) MR-082: office address for Adoption forms

-- Create a view for office location that handles non-recurring only forms, that will later be used for all Adoption correspondence at the county level. List was defined by SSAU.
-- corrected the office address by SSAU

-- Create a view that holds one office per county to be used as the correspondence office for the SSAU in receving the forms
-- Below is the list of counties that have multiple offices and the office for each county selected by the SSAU.
-- Create this view by hardcoding the list of filter county and office. Retain the code table strcuture for future expansion.
--	5	Baldwin - P. O. Box 430
--	15	Bryan - P. O. Box 398
--	31	Clay - P.O. Box 189
--	35	Cobb - 325 S. Fairground St
--	41	Columbia - P. O. Box 340
--	49	Dekalb - 178 Sams Street
--	55	Dodge - P.O. Box 4219
--	57	Dougherty - P.O. Box 3249
--	58	Douglas - 8473 Duralee Ln #100
--	82	Fulton - 5710 Stonewall Tell
--	90	Gwinnett - 446 West Crogan Street
--	100	Houston - 92 Cohen Walker Dr.
--	131	Muscogee - 2100 Comer Ave
--	137	Pickens - 255 Chambers Street
--	159	Tattnall - P.O. Box 518
--	174	Walker - P.O. Box 689

CREATE OR REPLACE VIEW CAPS.COFCNM_SSAU_VIEW -- one office per each county, used for SSAU in sending correspondence from the county to their ppl
AS 
(select c.* -- filter off conties that have multiple offices as of current
from caps.codes_tables c, caps.office_county_link ocl
where c.code_type = 'COFCNM'
and c.code = ocl.id_office
and ocl.cd_county NOT in ('009', '029', '061', '067', '073', '089', '091', '095', '097', '121', '135', '153', '215', '227', '267', '295')
UNION
select * from caps.codes_tables -- for those counties being filtered off, add the office that the SSAU wants back in for that county
  where code_type = 'COFCNM' 
  and code in ('5','15','31','35','41','49','55','57','58','82','90','100','131','137','159','174') 
);
grant select on CAPS.COFCNM_SSAU_VIEW to operator,capson,capsbat,ops$datafix, shinesdm;
comment on table CAPS.COFCNM_SSAU_VIEW is 'This is a filter view of codes tables COFCNM that allows one office per county; it is for the SSAU to identify the office that will handle their correspondence. Retain the code table strcuture for future expansion.';
comment on column CAPS.COFCNM_SSAU_VIEW.code is 'This is mapped to office.id_office';
comment on column CAPS.COFCNM_SSAU_VIEW.decode is 'This is concatenation of county and office address line 1';
comment on column CAPS.COFCNM_SSAU_VIEW.decode is 'This is mapped to the code table type that this view is filtered from';


update caps.mail_code m
set m.addr_mail_code_st_ln_1 = '446 West Crogan Street'
where m.cd_mail_code = (select o.cd_office_mail from caps.office o
                      where o.id_office in ('90'))
;
update caps.codes_tables 
set decode = 'Gwinnett - 446 West Crogan Street'
where code_type = 'COFCNM' and code = '90';

update caps.mail_code m
set m.addr_mail_code_st_ln_1 = 'P.O. BOX 518'
where m.cd_mail_code = (select o.cd_office_mail from caps.office o
                      where o.id_office in ('159'))
;
update caps.codes_tables 
set decode = 'Tattnall - P.O. Box 518'
where code_type = 'COFCNM' and code = '159';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1054, 'SacwisRev4', 'Release 4.3 - DBCR 16204');

commit;


