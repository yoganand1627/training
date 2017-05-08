

-- change 157
-- Standard Alter Table SQL

ALTER TABLE CAPS.NAME ADD TXT_NAME_COMMENTS VARCHAR2(300)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 158 R1/R2

UPDATE CAPS.RISK_FACTORS_LOOKUP 
SET txt_factor = 'RI.AT1 - Does any caregiver deny, seem unaware of, or take the allegations less seriously than DFCS?' 
WHERE cd_factor = 'R51'; 

UPDATE CAPS.RISK_FACTORS_LOOKUP 
SET txt_factor = 'RI.DC1 - Is any caregiver hostile toward or refusing to cooperate with DFCS?' 
WHERE cd_factor = 'R53'; 

UPDATE CAPS.RISK_FACTORS_LOOKUP 
SET txt_factor = 'RI.DC2 - Does any caregiver offer implausible explanations, attempt to deliberately mislead DFCS or refuse to disclose important information?' 
WHERE cd_factor = 'R54';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (107, 'SacwisRev2', 'new NAME field, static updates');
commit;
