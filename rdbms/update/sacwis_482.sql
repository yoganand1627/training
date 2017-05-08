--STGAP00014082 - MR-51 Submit DBC For None Selected (07) value from

--Note:  no impact to conversion


--Per MR-51, the None Selected (07) value from the CPERMPLN codes tables in section 1.10 has been removed.
update caps.codes_tables set DT_END = SYSDATE where code_type='CPERMPLN' and code='NOS';

--STGAP00014083 - MR-51 Update Codes Tables Using Per Relationships

--Note:  no impact to conversion

--Per MR-51, updated the relationship codes AF to read Foster/Adoptive Parent (Legal Risk) and FP to read Foster Parent (DFCS).

--Note: There are several codes_tables that seem to have relationship values.  CRELVICT and CRPTRINT are two sure ones.  Do a search to find all uses of these codes/decodes.  Then update the decode values to be those printed above.

--Foster Parent changed to Foster Parent (DFCS)
--Foster/Adoptive Parent changed to Foster/Adoptive Parent (Legal Risk)

--The code values themselves should NOT CHANGE.  Just the DECODES.

update caps.codes_tables set decode='Foster Parent (DFCS)' where decode='Foster Parent';
update caps.codes_tables set decode='Foster/Adoptive Parent (Legal Risk)' where decode='Foster/Adoptive Parent';


--STGAP00014370 - Per MR - 024 STGAP00014326 Add new codes

--Note:  no impact to conversion


-- For  MR- 024 , STGAP00014326 per Contact Detail Detailed Design, add  3 new CCNTPURP codes and 1 new COTHCNCT code to Codes_Tables.

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CCNTPURP','CMV','CM - Mother Visit',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CCNTPURP','CFV','CM - Father Visit',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CCNTPURP','CFC','CM - Foster Parent/Caretaker',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('COTHCNCT','CRP','Consulate Representative',SYSDATE);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (483, 'SacwisRev3', 'Release 3.2 - DBCRs 14082,14083,14370');

commit;


