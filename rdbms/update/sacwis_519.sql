--STGAP00015270 - New column for EXT_DOCUMENTATION Table

--New column for  CAPS.EXT_DOCUMENTATION

ALTER TABLE CAPS.EXT_DOCUMENTATION
ADD (IND_NA_CHECKED  CHAR(1));
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.IND_NA_CHECKED is 'Indicates that no person has been associated with an external document.';  


--STGAP00015244 - Extra Codes needed for Codes Type CEXDOTYP.

--Extra Codes needed for Codes Type CEXDOTYP.

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'AA', 'Adoption Asst. Agreement (402)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'AC', 'Ansell Casey Forms');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'AH', 'Adoptive Home Updates');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'AI', 'Adoption Asst. Memo (403)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'AM', 'Adoption Asst. Memo (403)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'CN', 'Consent to Remain in FC');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'CR', 'CFSR Rev. Documentation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'CW', 'Caseworker/Child Doc Form');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'DI', 'Driver''s License');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'DJ', 'DJJ Documentation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'DM', 'Developmental Evaluation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'DR', 'Drug Screens');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'DS', 'Diligent Search Doc');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'EP', 'EPSDT');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'FA', 'Foster Parent Adoption Documents');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'FI', 'Financial Information Form (44)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'FM', 'FTM Documentation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'FO', 'Foster Parent Stmt of Child Needs/Svcs');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'GR', 'Immigration Docs');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'HE', 'Home Evaluation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'HI', 'HIPPA/Release of Info');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'HM', 'Health/Medical Records');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'IC', 'ICPC Purposeful Visit Agmt');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'IE', 'Individualized Education Plan');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'MP', 'MPI-1 Application Form');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'MT', 'MATCH Application');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'NR', 'Non-Recurring AA Agreement (402-A)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'OA', 'Court Order - Adoption Finalization');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'OC', 'Court Order - Custody');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'OP', 'Court Order - Permanency');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'OS', 'Court Order - Shelter Care');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'OT', 'Court Order - TPR');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'OX', 'Court Order - Other');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'PE', 'Physical Evidence');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'PL', 'Police/LE Reports');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'PM', 'Provider Monthly Summary');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'PN', 'Plcmt of Non Spec. Needs (271)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'PU', 'Psych Evaulation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'RB', 'RBWO Rate Memo');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'RF', 'Referral Forms');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'RM', 'Rev Max Documentation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'RN', 'Req. Narrative Statements');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SD', 'Screening Documents');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SF', 'Spec Foster Care Memo');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SG', 'Adoption Asst. Agreement - Spc. Svcs. (24) ');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SL', 'Spec Services Cover Letter');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SN', 'Spec. Needs Det Request Cover Letter');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SR', 'Specialized Rate Req. Cover Letter');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SU', 'Supv. Review Doc');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'SV', '72 Hour Hearing');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'TP', '72 Hour Hearing');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'TS', 'Treatment Provider Stmt');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'VP', 'Voluntary Placement');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'VR', 'Verif of Recepit of Info Re PAD (399)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'VS', 'Voluntary Surrender');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'BS', 'Background for State Agncy Child (419)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'CA', 'Contact Waiver and Auth Form');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'CC', 'Child Care Doc');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'CF', 'CCFA Forms');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'XA', 'Other Adoption Asst');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'XC', 'Other Case Data');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'XF', 'Other Financial Info');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'XH', 'Other Health Info');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'XI', 'Other ICPC Documents');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'XO', 'Other Foster/Adoptive Home Info');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES ('CEXDOTYP', 'XP', 'Other Person Info');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (520, 'SacwisRev3', 'Release 3.X - DBCRs 15244,15270');

commit;

