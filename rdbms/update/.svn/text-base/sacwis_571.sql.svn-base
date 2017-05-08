--STGAP00015512 - Additional columns for Caps.CONTACT table.


ALTER TABLE CAPS.CONTACT ADD(IND_EXT_NARR_ACCEPT VARCHAR(1),
 ID_PORTAL_USER_ENTERED NUMBER(16),
CONSTRAINT FK_CNTCT_PORTAL_USER  FOREIGN KEY (ID_PORTAL_USER_ENTERED)
REFERENCES CAPS.PORTAL_USER (ID_USER));

comment on column caps.CONTACT.IND_EXT_NARR_ACCEPT  is 'To hold the checkbox value for contacts added through the portal';

comment on column caps.CONTACT.ID_PORTAL_USER_ENTERED  is 'To hold the user number of the portal user who entered the contact';


--Updates to Code_Type CCCONTBY

UPDATE CAPS.CODES_TABLES
SET DECODE = 'CPA/CCI Authorized Case Worker'
WHERE CODE = 'CCA' AND CODE_TYPE = 'CCCONTBY';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (572, 'SacwisRev3', 'Release Undetermined - DBCR 15512');

commit;



