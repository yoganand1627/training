--STGAP00015754 - Release(3.5) Creating New Table For Screening and Referral  Form

CREATE TABLE CAPS.SCREENING_REF_NARR
   (	ID_EVENT NUMBER(16,0) NOT NULL, 
        ID_CASE NUMBER(16,0) NOT NULL, 
	DT_LAST_UPDATE DATE NOT NULL, 
	NARRATIVE LONG RAW, 
	ID_DOCUMENT_TEMPLATE NUMBER(16,0), 
	 CONSTRAINT PK_SCREENING_REF_NARR PRIMARY KEY (ID_EVENT)
              using index tablespace index01,
         CONSTRAINT FK_SCN_REF_NARR_CASE FOREIGN KEY (ID_CASE)
            REFERENCES CAPS.CAPS_CASE(ID_CASE)
     ) tablespace data01;


create index caps.ind_SCREENING_REF_NARR_1 on CAPS.SCREENING_REF_NARR(id_case) tablespace index01;


grant select,update,insert,delete on CAPS.SCREENING_REF_NARR to capson,capsbat,ops$datafix;
grant select on caps.SCREENING_REF_NARR to operator, shinesdm;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (720, 'SacwisRev3', 'Release 3.5 - DBCR 15754');

commit;


