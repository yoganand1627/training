--STGAP00015455 - MR-55 Allegations and Intake

--This SQL statement is to update all the records with 'AP' Alleged Maltreator role to 'NO'  No Role
alter trigger caps.tubr_stage_person_link disable;
alter trigger caps.TIAR_CPRS_STAGE_PERS_LINK disable;

/
declare
   upperbound number(16);
   lowerbound number(16);
   minid number(16);
   maxid number(16);
   increment number(16);
begin
increment := 100;  -- commit very 100 records
select min(id_stage_person_link) into minid from caps.stage_person_link;
select max(id_stage_person_link) into maxid from caps.stage_person_link;
lowerbound := minid;
upperbound := lowerbound + increment;
WHILE lowerbound <=  maxid LOOP
   update caps.stage_person_link set cd_stage_pers_role = 'NO'
   where cd_stage_pers_role = 'AP' and id_stage_person_link >= lowerbound and
    id_stage_person_link <= upperbound;
   commit;
   lowerbound := lowerbound + increment;
   upperbound := upperbound + increment;
END LOOP;
END;
/

alter trigger caps.tubr_stage_person_link enable;
alter trigger caps.TIAR_CPRS_STAGE_PERS_LINK enable;

insert into caps.schema_version (id_schema_version, application_version, comments)
           values (550, 'SacwisRev3', 'Release 3.2 - DBCR 15455');

commit;


