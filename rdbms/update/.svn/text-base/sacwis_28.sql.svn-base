
drop sequence CAPS.SEQ_STAGE_PROG;

CREATE SEQUENCE CAPS.SEQ_STAGE_PROG
    START WITH 20000000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;

-- change 108
update caps.codes_tables 
set decode = 'Alleged Maltreator' 
where code_type = 'CINTROLE' 
and code = 'AP';

-- change 109
--mcduffie 
UPDATE caps.office_county_link 
SET cd_county = 189 
WHERE id_office_county_link = 102; 

--mcintosh 
UPDATE caps.office_county_link 
SET cd_county = 191 
WHERE id_office_county_link = 103; 

--macon 
UPDATE caps.office_county_link 
SET cd_county = 193 
WHERE id_office_county_link = 99;  

--madison 
UPDATE caps.office_county_link 
SET cd_county = 195 
WHERE id_office_county_link = 100; 

--marion 
UPDATE caps.office_county_link 
SET cd_county = 197 
WHERE id_office_county_link = 101; 

UPDATE caps.EMPLOYEE 
SET id_emp_office = 102 
WHERE id_person IN (8582, 
8726, 
5234, 
2149, 
2392, 
2545, 
8403, 
1949, 
9043, 
8506, 
8360, 
6069, 
3913, 
5376, 
3861, 
4823, 
8965);

-- change 110
INSERT INTO CAPS.STAGE_PROG (ID_STAGE_PROG, CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
      IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_EVENT_TYPE,  CD_STAGE_PROG_STATUS, TXT_STAGE_PROG_EVNT_DESC) 
VALUES (0, 'ARI', 'CLD', 'CPS', 0, 'STG', 'COMP', 'Admin Review Stage Closed');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (29, 'SacwisRev1', 'static updates, recreate STAGE_PROG sequence');
                         
commit;
