-- Standard Alter Table SQL

ALTER TABLE CAPS.CONTRACT_COUNTY MODIFY(CD_CNCNTY_SERVICE  NOT NULL)
;
ALTER TABLE CAPS.CONTRACT_COUNTY DROP CONSTRAINT FK_CONTRACT_COUNTY_3
;
ALTER TABLE CAPS.CONTRACT_SERVICE DROP UNIQUE (ID_CONTRACT, NBR_CNSVC_PERIOD, NBR_CNSVC_VERSION, NBR_CNSVC_LINE_ITEM) DROP INDEX
;
ALTER TABLE CAPS.CONTRACT_SERVICE ADD CONSTRAINT UK_CONTRACT_SERVICE_1
UNIQUE (ID_CONTRACT,NBR_CNSVC_PERIOD,NBR_CNSVC_VERSION,NBR_CNSVC_LINE_ITEM,CD_CNSVC_SERVICE)
USING INDEX TABLESPACE INDEX01
            PCTFREE 10
            INITRANS 2
            MAXTRANS 255
            STORAGE(INITIAL 1M
                    NEXT 1M
                    MINEXTENTS 1
                    MAXEXTENTS UNLIMITED
                    PCTINCREASE 0
                    BUFFER_POOL DEFAULT)
    LOGGING
    ENABLE
    VALIDATE
;

ALTER TABLE CAPS.CONTRACT_COUNTY ADD CONSTRAINT FK_CONTRACT_COUNTY_3 
    FOREIGN KEY (ID_CONTRACT, NBR_CNCNTY_PERIOD, NBR_CNCNTY_VERSION, NBR_CNCNTY_LINE_ITEM, CD_CNCNTY_SERVICE)
    REFERENCES CAPS.CONTRACT_SERVICE(ID_CONTRACT, NBR_CNSVC_PERIOD, NBR_CNSVC_VERSION, NBR_CNSVC_LINE_ITEM, CD_CNSVC_SERVICE) ON DELETE CASCADE
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00006753
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='Please explain why Foster Care Redetermination is no longer appropriate for this child.' WHERE TXT_MESSAGE_NAME='MSG_REVIEW_INAPPROPRIATE_COMMENTS_REQUIRED';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (268, 'SacwisRev2', 'key changes, static table updates');                        
commit;
