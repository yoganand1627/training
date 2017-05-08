--STGAP00017081 - Release(5.0) ECEM 5.0: preload UAS Prog Code Mtnt table

-- ECEM 5.0 Fiscal Administration - STGAP00017019
-- Pre-load the UAS program code maintenance table with existing program codes, using a combination of application logic and Susan Morgan's list.
-- Load the table with program codes that can be maintained online, by Susan's list, cross-referenced with DB to get additional info
-- and to exclude endated code
INSERT INTO CAPS.UAS_PROGRAM_CODE_MTNT
SELECT DISTINCT 0,
T.CODE,
NULL,
TO_DATE('07/01/2007','MM/DD/YYYY'),
t.decode,
NULL ,
NULL ,
NULL ,
NULL ,
NULL ,
NULL ,
SYSDATE
FROM CAPS.codes_tables T
WHERE T.code_type = 'CPRGCODE'
and dt_end is null
and t.code in ('252',
'253',
'360',
'450',
'460',
'501',
'502',
'503',
'504',
'510',
'511',
'512',
'513',
'515',
'518',
'521',
'525',
'529',
'531',
'542',
'548',
'550',
'551',
'552',
'553',
'560',
'571',
'573',
'574',
'575',
'576',
'577',
'579',
'582',
'583',
'584',
'585',
'586',
'587',
'588',
'591',
'597',
'598',
'604',
'605',
'606',
'607',
'608',
'609',
'610',
'611',
'612',
'613',
'614',
'617',
'618',
'619',
'620',
'698',
'773',
'774',
'783',
'784',
'873',
'874',
'883',
'884',
'883',
'884' )
ORDER BY t.code;
-- SET IND SA
update caps.uas_program_code_mtnt u
set u.ind_serv_auth = 'Y'
where u.cd_uas in (
select substr(code,0,3) from caps.codes_tables where code_type='CPRGCOD1'
);
-- set CCI ind
update caps.uas_program_code_mtnt u
set u.ind_cci = 'Y'
where u.cd_uas in (
select substr(code,0,3) from caps.codes_tables where code_type='CCCISVCD'
);
-- set CPA ind
update caps.uas_program_code_mtnt u
set u.ind_cpa = 'Y'
where u.cd_uas in (
select substr(code,0,3) from caps.codes_tables where code_type='CCPASVCD'
);
-- set invoice add-on ind
update caps.uas_program_code_mtnt u
set u.ind_inv_addon = 'Y'
where u.cd_uas in (
select substr(code,0,3) from caps.codes_tables where code_type='CADDONLI'
);
-- set PSSF ind: used Susan's list
update caps.uas_program_code_mtnt u
set u.ind_pssf = 'Y'
where u.cd_uas in ('773','774','783','784','873','874','883','884');
-- SET PROGRAM TYPE FOSTER CARE
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='252';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='253';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='450';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='460';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='501';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='502';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='503';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='504';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='513';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='529';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='531';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='560';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='574';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='575';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='576';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='577';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='579';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='597';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='598';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='604';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='605';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='606';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='607';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='608';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='609';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='610';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='611';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='612';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='613';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='614';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='617';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='618';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='619';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='FSC' where CD_UAS='620';
-- SET PROGRAM TYPE DELIVERED SERVICES
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='360';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='511';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='518';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='521';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='525';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='551';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='571';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='573';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='582';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='583';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='584';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='585';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='586';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='588';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='591';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='698';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='773';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='774';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='783';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='784';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='873';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='874';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='883';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='DUR' where CD_UAS='884';
-- set program type relative care
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='RCS' where CD_UAS='542';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='RCS' where CD_UAS='548';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='RCS' where CD_UAS='550';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='RCS' where CD_UAS='552';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='RCS' where CD_UAS='553';
-- set program type Adotpions
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='ADS' where CD_UAS='510';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='ADS' where CD_UAS='512';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='ADS' where CD_UAS='515';
update CAPS.UAS_PROGRAM_CODE_MTNT set CD_PROGRAM_TYPE ='ADS' where CD_UAS='587';
-- new code

insert into caps.schema_version(id_schema_version,application_version,comments)
values (1097, 'SacwisRev5', 'Release 5.0 - DBCR 17081');
			
commit;
