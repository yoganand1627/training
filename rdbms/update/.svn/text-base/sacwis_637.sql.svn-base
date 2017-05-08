--STGAP00015640 - Release(3.4) DBCR- Per SMS#37448 Update Sibling_Group table

--Update Sibling_Group table

--The nbr_avail field of the Sibling_Group table needs to be updated to make it equal to the nbr_in_group field.

--Target Release 3.4.

grant select on caps.person to capson;

/  
DECLARE
 vIdSiblingGroup   NUMBER(16);
 vafter            NUMBER(16);
 vbefore           NUMBER(16);
 vNbrInGroup       NUMBER(16);  
       
   CURSOR cur_idSiblingGroups IS
   SELECT sb.id_sibling_group, sb.nbr_in_group FROM  caps.sibling_group sb;

 BEGIN   
  -- COUNT(*) BEFORE UPDATE
 
  SELECT COUNT(*) into vbefore  FROM  caps.sibling_group sb;
                   
  DBMS_OUTPUT.PUT_LINE(' No. Of Sibling_Group records to be updated ' || vbefore); 
                   
   OPEN cur_idSiblingGroups;
   LOOP
   FETCH cur_idSiblingGroups INTO vIdSiblingGroup, vNbrInGroup;
   EXIT WHEN cur_idSiblingGroups%NOTFOUND;
       
   UPDATE caps.sibling_group SET nbr_avail = vNbrInGroup  WHERE Id_Sibling_Group = vIdSiblingGroup;
         
    INSERT INTO caps.datafix_audit_table (id_datafix,script_name,logfile_name,id_defect_cq,error_category,
                                          datafix_desc,dt_start,dt_completed)
	                                VALUES (0,'STGAP00015640.sql', 'STGAP00015640.lst','SMS#37448','Known Defect', 
                                          'Update Sibling_Group table.' , sysdate, sysdate);
 
   END LOOP;
   CLOSE cur_idSiblingGroups;   
      
     --After changes
   DBMS_OUTPUT.PUT_LINE(' ');
   DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE('AFTER UPDATING THE SIBLING_GROUP TABLE.');
   DBMS_OUTPUT.PUT_LINE(' No. Of Sibling_Group records to be updated should be 0'); 
   DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');
     
     -- COUNT(*) AFTER UPDATE     
       
  SELECT COUNT(*) into vafter
  FROM  caps.sibling_group sb
  WHERE  sb.nbr_avail <> sb.nbr_in_group;
                   
  DBMS_OUTPUT.PUT_LINE(' No. Of Sibling_Group records to be updated ' || vafter);       

END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (638, 'SacwisRev3', 'Release 3.4 - DBCR 15640');

commit;

