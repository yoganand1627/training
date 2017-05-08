--STGAP00015615 - Release(3.4) DBCR: Create new security attribute to support por


--The attached script creates a new security attribute in SHINES which will be used to determine who has access to the Vendor Staff Lists for portal.

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CSECATTR','PO','Vendor Staff Access');

UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL||'0'
WHERE CD_SECURITY_CLASS_NAME IN ('MAINTAIN_REG_01','MAINTAIN_REG_10','MAINTAIN_REG_11','RSRC_MAINT')
AND LENGTH(TXT_SECURITY_CLASS_PROFIL) = 95;

UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL||'0'
WHERE LENGTH(TXT_SECURITY_CLASS_PROFIL) = 96;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (622, 'SacwisRev3', 'Release 3.4 - DBCR 15615');

commit;



