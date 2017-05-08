--STGAP00017847 - Release(5.1) STGAP00017827(MR-085) Add codes

--Add new contact purpose

INSERT INTO caps.codes_tables (code_type, code, decode ) values('CCNTPURP'      ,'ICP'  ,'ICPC');
-- Add new event type for ICPC
INSERT INTO caps.codes_tables (code_type, code, decode ) values('CEVNTTYP'      ,'ICP'  ,'ICPC');

--New CodeType and Codes for ICPC form type 100A and 100B
INSERT INTO caps.codes_tables (code_type, code, decode ) values('CICPCTYP'      ,'100A' ,'100A');
INSERT INTO caps.codes_tables (code_type, code, decode ) values('CICPCTYP'      ,'100B' ,'100B');

--New CodeType and Codes for Type of Care
INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTYPCARE'      ,'FFH'  ,'Foster Family Home');
INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTYPCARE'      ,'PAR'  ,'Parent');
INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTYPCARE'      ,'REL'  ,'Relative (Not Parent)');

--New CodeType and Codes for Initial Report Requested
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CINRPTRQ'     ,'IRA'  ,'Parent Home Study');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CINRPTRQ'     ,'IRB'  ,'Relative Home Study');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CINRPTRQ'     ,'IRC'  ,'Adoptive Home Study');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CINRPTRQ'     ,'IRD'  ,'Foster Home Study');

 --New CodeType and Codes for Compact Placement Termination Reason
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRA'  ,'Adoption Finalized');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRB'  ,'Child Reached Majority/Legally Emancipated');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRC'  ,'Legal Custody Returned to Parent(s)');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRD'  ,'Legal Custody Given to Relative');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRE'  ,'Treatment Completed');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRF'  ,'Sending State''s Jurisdiction Terminated with the Concurrence of the Receiving State');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRG'  ,'Unilateral Termination');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRH'  ,'Child Returned to Sending State');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRI'  ,'Child Has Moved to Another State');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRJ'  ,'Proposed Placement Request Withdrawn');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRK'  ,'Approved Resource Will Not Be Used for Placement');
 INSERT INTO caps.codes_tables (code_type, code, decode ) values('CTERMRSN'     ,'TRL'  ,'Other (Specify)');

 --New CodeType for Enclosed Douments - Required
  INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDREQCBX','REA','Birth Certificate/Verification');
  INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDREQCBX','REB','Case Plan/Case Review');
  INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDREQCBX','REC','Child''s Social History/CCFA');
  INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDREQCBX','RED','Court Order');
  INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDREQCBX','REE','Cover Letter');
  INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDREQCBX','REF','Financial/Medical Plan');
  INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDREQCBX','REG','Statement of Case Manager');


  --New CodeType for Enclosed Documents - If applicable
    INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDAPLCBX','APA','Home Study of Placement Resource');
    INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDAPLCBX','APB','ICWA Enclosure');
    INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDAPLCBX','APC','IV-E Determination');
    INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDAPLCBX','APD','Proof of Paternity');
    INSERT INTO caps.codes_tables (code_type, code, decode ) values('CDAPLCBX','APE','Other Enclosures');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1185, 'SacwisRev5', 'Release 5.1 - DBCR 17847');

commit;
