--STGAP00015707 - Release(3.5) DBCR- MR-52 Update event description in Event tabl

-- MR-52 Update event description in Event table as per  Adoption Assistance Application Design Document.

-------------------------------------------------------------------------------
--
--	       Update txt_event_descr column of Event table for 'APRV' events of type 'SND' 
--            
--	       
--	       STGAP00015707
------------------------------------------------------------------------------


-- Find all the Adoption Applications where event status is 'APRV' 
-- Statement below added so that the script also works with SQLPlus
grant select on caps.stage to operator;  

/
DECLARE
 vSndRow caps.special_needs_determination%rowtype;
 vafter NUMBER(16);
 vbefore NUMBER(16);
 txtEventDescription VARCHAR2(500);
 vIdEvent  NUMBER(16);
 spService VARCHAR2(100);
 numEvents NUMBER(16);
 idPerson NUMBER(16);
 idCase NUMBER(16);
       
   CURSOR cur_idEvents IS
   SELECT snd.*
   FROM  caps.event e , caps.special_needs_determination snd
   WHERE  e.id_event = snd.id_event AND e.cd_event_type = 'SND' AND e.cd_event_status = 'APRV';  

 BEGIN  
 
 numEvents := 0;
 
  -- COUNT(*) BEFORE UPDATE
 
  SELECT COUNT(*) into vbefore
  FROM  caps.event e , caps.special_needs_determination snd
  WHERE  e.id_event = snd.id_event AND e.cd_event_type = 'SND' AND e.cd_event_status = 'APRV';  

                   
--  DBMS_OUTPUT.PUT_LINE(' No. Of Events to be updated ' || vbefore); 
                   
   OPEN cur_idEvents;
   LOOP
   FETCH cur_idEvents INTO vSndRow;
   EXIT WHEN cur_idEvents%NOTFOUND;
   
   SELECT epl.id_person, epl.id_case INTO idPerson, idCase FROM caps.event_person_link epl WHERE epl.id_event = vSndRow.id_event; 
   vIdEvent := vSndRow.id_event;
   
      IF (vSndRow.IND_SPC_NEEDS_APPROVED = 'Y' OR vSndRow.IND_SPCL_REQ_APPROVED = 'Y' OR
            vSndRow.IND_SPCL_RATE_ADO_APPR = 'Y' OR vSndRow.IND_NON_REC_APPROVED = 'Y' ) THEN 
              txtEventDescription := ' ';
              
          if  (vSndRow.IND_SPC_NEEDS_APPROVED = 'Y' AND vSndRow.IND_REASON_SPECIAL_REQUEST IS NOT NULL) then
           txtEventDescription := 'Sp Nds';
          end if;
          
           if( vSndRow.IND_BASIC_RATE_REQ_CHILD = 'Y' AND vSndRow.IND_SPC_NEEDS_APPROVED = 'Y') then 
             if(length(txtEventDescription) < 2) then
               txtEventDescription := 'Bsc Rt';
               else
             txtEventDescription := txtEventDescription || ', Bsc Rt'; 
             end if;
           end if;
           
          if (vSndRow.IND_SPCL_RATE_ADO_APPR = 'Y') then
             if(txtEventDescription = ' ') then
              txtEventDescription := 'Splzd Rt';
            else
            txtEventDescription := txtEventDescription || ', Splzd Rt';
            end if;
           end if;
           
          if (vSndRow.IND_NON_REC_APPROVED  = 'Y') then
             if(txtEventDescription = ' ') then
              txtEventDescription := 'Non Recur';
            else
            txtEventDescription := txtEventDescription || ', Non Recur';
            end if;
           end if;
           
          if (vSndRow.IND_SPCL_REQ_APPROVED = 'Y') then
             if(txtEventDescription = ' ') then 
              txtEventDescription := 'Sp Svc ';
            else
            txtEventDescription := txtEventDescription || ', Sp Svc ';
           end if;           
           end if;
           
          if (vSndRow.IND_SPCL_REQ_APPROVED = 'Y') then
             spService := '';      
            if (vSndRow.CD_SPCL_SER_TYPE = 'DCR') then
              spService := 'Child Care';
           elsif (vSndRow.CD_SPCL_SER_TYPE = 'ORT') then
              spService := 'Dent/Ortho';
           elsif (vSndRow.CD_SPCL_SER_TYPE = 'MED') then
              spService := 'Med';
           elsif (vSndRow.CD_SPCL_SER_TYPE = 'XXX') then
              spService := 'Other';
           elsif (vSndRow.CD_SPCL_SER_TYPE = 'RES') then
              spService := 'Resp';
           elsif (vSndRow.CD_SPCL_SER_TYPE = 'TCS') then
              spService := 'Ther/Couns';
           end if;
            txtEventDescription := txtEventDescription ||  vSndRow.DT_APPRV_DATE || ' - ' || vSndRow.DT_EXPIRATION_DATE || ' ' || spService ;
          end if;
          
          if(txtEventDescription = 'Sp Nds') then
          txtEventDescription := 'Special Needs approved for child ' || idPerson;
          else
          txtEventDescription := txtEventDescription || ' approved for child ' || idPerson;
          end if;
             
       end if;
  
IF (vSndRow.IND_SPC_NEEDS_APPROVED = 'D') THEN
          txtEventDescription := 'Special Needs deferred for child ' || idPerson;
ELSIF (vSndRow.IND_SPC_NEEDS_APPROVED = 'N') THEN           
          txtEventDescription := 'Adoption Assistance Appplication is denied for child ' || idPerson;           
END IF;

IF (length(txtEventDescription) > 100) THEN
txtEventDescription := LPAD(txtEventDescription , 0 , 100);
END IF;

       
        UPDATE caps.event
        SET txt_event_descr = txtEventDescription
        WHERE id_event = vIdEvent;
        
           
--        INSERT INTO caps.datafix_audit_table (id_datafix,script_name,logfile_name,id_defect_cq, error_category,datafix_desc,dt_start,dt_completed,id_case, id_event,id_person)
--	         VALUES (0,'STGAP00015707.sql', 'STGAP00015707.lst','STGAP00015696',
--	         'MR-52', 'Update event description in the event table.' , sysdate, sysdate,idCase, vIdEvent, idPerson );
   
  numEvents := numEvents + 1;
   
   END LOOP;
   CLOSE cur_idEvents;
   
      
     --After changes
--   DBMS_OUTPUT.PUT_LINE(' ');
--   DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');
--   DBMS_OUTPUT.PUT_LINE(' ' );
--   DBMS_OUTPUT.PUT_LINE(' No. Of Events to be updated after UPDATE should be 0'); 
--   DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');
     
     -- COUNT(*) AFTER UPDATE
     
       
 vafter := vbefore - numEvents;
                   
--  DBMS_OUTPUT.PUT_LINE(' No. Of Events to be updated after UPDATE is   ' || vafter);

   
       
        
 --  EXCEPTION
end;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (688, 'SacwisRev3', 'Release 3.5 - DBCR 15707');

commit;

