--STGAP00017890 - Release(5.1) MR-102 Service Authorization - Add Two New Views

-- STGAP00017890 - Release 5.1 MR-102 Service Authorization 
-- County office address for Service Authorization form

-- Create two views for office location that handle Service Authorization form
-- List was defined by SMEs of the MR-102

-- Create two views that hold one office per county to be used 
-- as the correspondence office for the Counties in receving the forms
-- The first view COFCNM_SVC_AUTH_PMT_CNTY_VIEW is 
-- for the Payment County Address field on the form
-- and the second view COFCNM_SVC_AUTH_LEGAL_VIEW is
-- for the Legal County Address field on the form
--
-- Below is the list of counties that have multiple offices 
-- and the office for each county selected by the SMEs of the MR-102
-- Create this view by hardcoding the list of filter county and office. 
-- Retain the code table strcuture for future expansion.
--	5	Baldwin - P. O. Box 430
--	15	Bryan - P. O. Box 398
--  20 Camden - P. O. BOX 68
--	31	Clay - P.O. Box 189
--  32 Clayton - 877 BATTLECREEK ROAD
--	35	Cobb - 325 S. Fairground St
--	41	Columbia - P. O. Box 340
--	49	Dekalb - 178 Sams Street
--	55	Dodge - P.O. Box 4219
--	57	Dougherty - P.O. Box 3249
--	58	Douglas - 8473 Duralee Ln #100
--  72	Fulton - 5710 1249 DL HOLLOWELL PKWY
--	90	Gwinnett - 446 West Crogan Street
--	100	Houston - 92 Cohen Walker Dr.
--	131	Muscogee - 2100 Comer Ave
--	137	Pickens - 255 Chambers Street
--  146 Richmond - P.O. BOX 2277
--  153 Spalding - P.O. BOX 1610
--	159	Tattnall - P.O. Box 518
--	174	Walker - P.O. Box 689

CREATE OR REPLACE VIEW CAPS.COFCNM_SVC_AUTH_PMT_CNTY_VIEW 
AS 
(select c.* -- filter off conties that have multiple offices as of current
from caps.codes_tables c, caps.office_county_link ocl
where c.code_type = 'COFCNM'
and c.code = ocl.id_office
and ocl.cd_county NOT in ('009', '029', '039', '061', '063', '067', '073', '089', '091', '095', '097', '121', '135', '153', '215', '227', '245', '255', '267', '295')
UNION
select * from caps.codes_tables -- for those counties being filtered off, add the office that the SMEs want back in for that county
  where code_type = 'COFCNM' 
  and code in ('5','15','20','31','32','35','41','49','55','57','58','72','90','100','131','137','146','153','159','174') 
);
grant select on CAPS.COFCNM_SVC_AUTH_PMT_CNTY_VIEW to operator,capson,capsbat,ops$datafix, shinesdm;
comment on table CAPS.COFCNM_SVC_AUTH_PMT_CNTY_VIEW is 'This is a filter view of codes tables COFCNM that allows one office per county; it is for the use of Payment County Address field in the Service Authorization form to identify the office that will handle their correspondence. Retain the code table strcuture for future expansion.';
comment on column CAPS.COFCNM_SVC_AUTH_PMT_CNTY_VIEW.code is 'This is mapped to office.id_office';
comment on column CAPS.COFCNM_SVC_AUTH_PMT_CNTY_VIEW.decode is 'This is concatenation of county and office address line 1';
comment on column CAPS.COFCNM_SVC_AUTH_PMT_CNTY_VIEW.decode is 'This is mapped to the code table type that this view is filtered from';

CREATE OR REPLACE VIEW CAPS.COFCNM_SVC_AUTH_LEGAL_VIEW 
AS 
(select c.* -- filter off conties that have multiple offices as of current
from caps.codes_tables c, caps.office_county_link ocl
where c.code_type = 'COFCNM'
and c.code = ocl.id_office
and ocl.cd_county NOT in ('009', '029', '039', '061', '063', '067', '073', '089', '091', '095', '097', '121', '135', '153', '215', '227', '245', '255', '267', '295')
UNION
select * from caps.codes_tables -- for those counties being filtered off, add the office that the SMEs want back in for that county
  where code_type = 'COFCNM' 
  and code in ('5','15','20','31','32','35','41','49','55','57','58','72','90','100','131','137','146','153','159','174') 
);
grant select on CAPS.COFCNM_SVC_AUTH_LEGAL_VIEW to operator,capson,capsbat,ops$datafix, shinesdm;
comment on table CAPS.COFCNM_SVC_AUTH_LEGAL_VIEW is 'This is a filter view of codes tables COFCNM that allows one office per county; it is for the use of Legal County Address field in the Service Authorization form to identify the office that will handle their correspondence. Retain the code table strcuture for future expansion.';
comment on column CAPS.COFCNM_SVC_AUTH_LEGAL_VIEW.code is 'This is mapped to office.id_office';
comment on column CAPS.COFCNM_SVC_AUTH_LEGAL_VIEW.decode is 'This is concatenation of county and office address line 1';
comment on column CAPS.COFCNM_SVC_AUTH_LEGAL_VIEW.decode is 'This is mapped to the code table type that this view is filtered from';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1203, 'SacwisRev5', 'Release 5.1 - DBCR 17890');

commit;
