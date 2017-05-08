--STGAP00014663 - Per MR - 024 STGAP00014326 Add new codes

--Per MR -024 Add new codes for code contacted by types

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES
('CCCONTBY','DFC','DFCS Staff',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES
('CCCONTBY','CCA','CPA/CCI Authorized Designee',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES
('CCCONTBY','XXX','Other',SYSDATE);



--STGAP00014673 - DBCR - PerSTGAP00014331 and STGAP00014330  new messsages

--Per STGAP00014330 and STGAP00014331 need new error messages


--STGAP00014330
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60558,'MSG_SAFETY_RES_EVENT','Investigation cannot be closed with an unapproved safety resource assessment.  Either approve or delete safety resource record.',
                            700, 500, 'N');
                            
--STGAP00014331
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60559,'MSG_ONG_SAFETY_RES_EVENT','Ongoing cannot be closed with an unapproved safety resource assessment.  Either approve or delete safety resource record.',
                            700, 500, 'N');


--STGAP00014666 - Adding validation message to Legal actions page

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60560,'MSG_REC_COURT_ORDER','Both Court Order Date and Court Order Signed are required when selecting the action of Receive Court Order.',
700,500,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (494, 'SacwisRev3', 'Release 3.2 - DBCRs 14663,14673,14666');

commit;


