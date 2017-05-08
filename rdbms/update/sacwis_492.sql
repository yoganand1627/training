--STGAP00014620 - STGAP00014563: Add new column to ADO_SUBSIDY
alter table caps.ADOPTION_SUBSIDY add NBR_COUNTY_ADDON_AMT number(8,2);
comment on column caps.ADOPTION_SUBSIDY.NBR_COUNTY_ADDON_AMT is 'County Add On Amount';


--STGAP00014607 - STGAP00014563: Add newcolumns to tables

--ado_subsidy_rate
alter table caps.ado_subsidy_rate add DT_ADO_SUBSIDY_RATE_START date;
alter table caps.ado_subsidy_rate add DT_ADO_SUBSIDY_RATE_END date;
comment on column caps.ado_subsidy_rate.DT_ADO_SUBSIDY_RATE_END is 'Date when Rate ends';
comment on column caps.ado_subsidy_rate.DT_ADO_SUBSIDY_RATE_START is 'Date when Rate goes into effect';


--SPECIAL_NEEDS_DETERMINATION 
alter table caps.SPECIAL_NEEDS_DETERMINATION add DT_SPCL_NEEDS_APPRVD date;
alter table caps.SPECIAL_NEEDS_DETERMINATION add CD_BASIC_RATE_TYPE varchar2(3);
alter table caps.SPECIAL_NEEDS_DETERMINATION add NBR_COUNTY_ADDON_AMT number(8,2);
alter table caps.SPECIAL_NEEDS_DETERMINATION add TXT_ADDITIONAL_COMMENTS varchar2(1000);
alter table caps.SPECIAL_NEEDS_DETERMINATION add NBR_BASIC_RATE_AMT number(8,2);
comment on column caps.SPECIAL_NEEDS_DETERMINATION.DT_SPCL_NEEDS_APPRVD is 'Date when Special Needs approved';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.CD_BASIC_RATE_TYPE is 'Basic Rate Type';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.NBR_COUNTY_ADDON_AMT is 'County Add on Amount';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.TXT_ADDITIONAL_COMMENTS is 'Additional Comments for Special Needs Request Section';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.NBR_BASIC_RATE_AMT is 'Custom Basic Rate';

--ADOPTION_SUBSIDY
alter table caps.ADOPTION_SUBSIDY add CD_BASIC_RATE_TYPE varchar2(3);
comment on column caps.ADOPTION_SUBSIDY.CD_BASIC_RATE_TYPE is 'Basic Rate Type';


--STGAP00014604 - STGAP00014563: Add new messages for Ado Asst App

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60555,'MSG_ADO_BASIC_RATE_REQ','Base Rate is selected but Rate Type has not been selected.',700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60556,'MSG_ADO_CUSTOM_AMT_REQ','Custom Rate has been selected but Custom Amount has not been entered.',700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60557,'MSG_ADO_COUNTY_ADD_ON','County Add On can not be greater than 1.75.',700,500,'N');


--STGAP00014605 - STGAP00014563: Add new codes table

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE)
VALUES('CBRTYPE','PRE','Old Basic Rate',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE)
VALUES('CBRTYPE','POS','New Basic Rate',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE)
VALUES('CBRTYPE','CUS','Custom Basic Rate',SYSDATE);

--STGAP00014606 - STGAP00014563: Add new basic rates

delete from caps.ado_subsidy_rate;

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB, dt_ado_subsidy_rate_start, dt_ado_subsidy_rate_end) 
VALUES
(1, 'A1', 0, 5, 387.81, to_date('01/01/1850', 'MM/DD/YYYY'), to_date('06/30/2009
', 'MM/DD/YYYY'));

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB, dt_ado_subsidy_rate_start, dt_ado_subsidy_rate_end) 
VALUES
(2, 'A2', 6, 12, 410.63, to_date('01/01/1850', 'MM/DD/YYYY'), to_date('06/30/2009', 'MM/DD/YYYY'));

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB, dt_ado_subsidy_rate_start, dt_ado_subsidy_rate_end) 
VALUES
(3, 'A3', 13, 18, 433.43, to_date('01/01/1850', 'MM/DD/YYYY'), to_date('06/30/2009', 'MM/DD/YYYY'));

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB, dt_ado_subsidy_rate_start, dt_ado_subsidy_rate_end) 
VALUES
(4, 'A1', 0, 5, 441.04, to_date('07/01/2009', 'MM/DD/YYYY'), to_date('12/31/4712', 'MM/DD/YYYY'));

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB, dt_ado_subsidy_rate_start, dt_ado_subsidy_rate_end) 
VALUES
(5, 'A2', 6, 12, 463.85, to_date('07/01/2009', 'MM/DD/YYYY'), to_date('12/31/4712', 'MM/DD/YYYY'));

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB, dt_ado_subsidy_rate_start, dt_ado_subsidy_rate_end) 
VALUES
(6, 'A3', 13, 18, 486.67, to_date('07/01/2009', 'MM/DD/YYYY'), to_date('12/31/4712', 'MM/DD/YYYY'));


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (493, 'SacwisRev3', 'Release 3.12 - DBCRs 14607,14604,14605,14606,14620');

commit;

