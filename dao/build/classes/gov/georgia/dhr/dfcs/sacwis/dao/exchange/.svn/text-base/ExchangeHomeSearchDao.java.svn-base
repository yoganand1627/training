package gov.georgia.dhr.dfcs.sacwis.dao.exchange;

/**
 * **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 **  02/12/2009  bgehlot           STGAP00012436: Added the code to prioritize the home name along with resource id over other conditions
 *   04/01/2009  hjbaptiste        STGAP00012883: Use the Home's Approved Age Ranges instead of the Home's Interested Age Ranges
 *   04/07/2009  mchillman         STGAP00013145: Alter code to use sort order passed in from page for name search
 *   05/21/2009  hjbaptiste        STGAP00013232: Added an else statement to check to see if a Region was selected, when Agency name has not been selected . 
 *                                 If a Region was  selected and an Agency name has not been selected, then do not return any homes that are linked to an Agency. 
 *                                 In other words, bring back only DFCS Homes.
 *   06/11/2009  hjbaptiste        STGAP00014191: Modified criteria to that NBR_CHILD_INTEREST of the home has to be >= to the number of children set in the bean
 *   07/20/2009  hjbaptiste        STGAP00014783: Allow user to search by multiple fields in the Home Locate section                              
 *   
 */

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

public class ExchangeHomeSearchDao extends BaseDao {

  
  public static final String RESOURCE_NAME = "NM_RESOURCE";
  public static final String CATEGORY = "CD_RSRC_CATEGORY";
  public static final String AVAILABILITY_CODE = "CD_NON_AVAIL_STATUS";
  public static final String COUNTY = "CD_RSRC_CNTY";
  public static final String FA_HOME_STATUS = "CD_RSRC_FA_HOME_STATUS";
  public static final String EXCHANGE_HOME_EVENT = "ID_EVENT";
  public static final String RESOURCE_ID = "ID_RESOURCE";
  public static final String DATE_OUT = "DT_OUT";
  public static final String HOME_STAGE = "ID_RSRC_FA_HOME_STAGE";
  public static final String AGENCY = "NDFCS_CERT_ENTITY";
  
  private static final int LIMIT = 500;
  private static final String TRACE_TAG = "ExchangeHomeSearchDAO";
  private static final String EVENT_CONSTRAINT = " where exh.ID_EVENT = ev.ID_EVENT AND exh.ID_RESOURCE = cr.ID_RESOURCE ";
  private static final String BASE_TABLES = "EXCHANGE_HOME exh, EVENT ev, CAPS_RESOURCE cr ";
  private static final String SELECT = "SELECT cr." + RESOURCE_NAME + ", cr." + CATEGORY + ", exh." + AVAILABILITY_CODE + ", cr." + COUNTY + 
                                ", cr." + FA_HOME_STATUS + ", exh." + EXCHANGE_HOME_EVENT + ", exh." + RESOURCE_ID + ", exh." + 
                                DATE_OUT + ", cr." + HOME_STAGE + ", cr."  + AGENCY + " FROM ";
  
  
  public ExchangeHomeSearchDao(Connection connection) {
    super(connection);
  }

  public PaginationResultBean executeSearch(ExchangeHomeValueBean exchangeHomeValueBeanIn) throws SQLException,
                                                                                          TooManyRowsReturnedException,
                                                                                          DaoException,
                                                                                          ResourceSearchDaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "executeSearch");
    performanceTrace.enterScope();
    
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;    
    PaginationResultBean homeList = null;
    
    try {
      SqlandBindValues sqlAndBind = getSearchSQL(exchangeHomeValueBeanIn);
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sqlAndBind.sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      preparedStatement = addBindVariablesToStatement(preparedStatement, sqlAndBind.bindVariablesVector);
      
      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      
      resultSet.last();
      int numberOfResults = resultSet.getRow();
      if (numberOfResults > LIMIT) {
        throw new TooManyRowsReturnedException();
      }
      
      if(numberOfResults > 0) {
        DatabaseResultDetails details = exchangeHomeValueBeanIn.getResultDetails();
        details.obtainNumberOfResults(resultSet);
        List<ExchangeHomeValueBean> valueList = new ArrayList<ExchangeHomeValueBean>();
        resultSet.beforeFirst();
        int firstItem = details.getFirstResultRequested();
        if(firstItem > 1) {
          resultSet.absolute(firstItem - 1);
        } 
        int lastResult = details.getLastResultRequested();
        while (resultSet.next() && (resultSet.getRow() <= lastResult)) {
          ExchangeHomeValueBean returnBean = new ExchangeHomeValueBean(resultSet);
          valueList.add(returnBean);
        }
        homeList = new PaginationResultBean();
        homeList.setResults(valueList);
        homeList.setResultDetails(details);
      }
      
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      resultSet = null;
      preparedStatement = null;
    }
        
    return homeList;
  }
  
  public SqlandBindValues getSearchSQL(ExchangeHomeValueBean exchangeHomeValueBean) {
    DatabaseResultDetails details = exchangeHomeValueBean.getResultDetails();
    SqlandBindValues sqlAndBind = new SqlandBindValues();
    StringBuffer sqlBuff = new StringBuffer();
    List<Object> bindVariablesVector = new ArrayList<Object>();

    sqlBuff.append(SELECT);    
    StringBuffer tables = new StringBuffer(BASE_TABLES);
    StringBuffer constraint = new StringBuffer(EVENT_CONSTRAINT);
        
    if(exchangeHomeValueBean != null) {
      Integer idResource = exchangeHomeValueBean.getIdResource();
      if (idResource != null && idResource.intValue() > 0) {
        constraint.append("AND exh.ID_RESOURCE = ? ");
        bindVariablesVector.add(idResource);
        //if resource id is given just search on the id
        sqlBuff.append(tables);
        sqlBuff.append(constraint);
        sqlAndBind.sql = sqlBuff.toString();
        sqlAndBind.bindVariablesVector = bindVariablesVector;
        return sqlAndBind;
      }
      
      //TODO: Do we need to add some restrictions here 
      String homeName = exchangeHomeValueBean.getHomeName();
      if(StringHelper.isValid(homeName)) {
        homeName = homeName.trim().toUpperCase();
        constraint.append(" AND UPPER(cr.NM_RESOURCE) LIKE ? ");
        homeName = "%" + homeName + "%";
        bindVariablesVector.add(homeName);
      }
      
      String status = exchangeHomeValueBean.getCdStatus();
      if(StringHelper.isValid(status)) {
        constraint.append(" AND cr.CD_RSRC_FA_HOME_STATUS = ? ");
        bindVariablesVector.add(status);
      }
      
      String category = exchangeHomeValueBean.getCdCategory();
      if(StringHelper.isValid(category)) {
        constraint.append(" AND cr.CD_RSRC_CATEGORY = ? ");
        bindVariablesVector.add(category);
      }
      
      String region = exchangeHomeValueBean.getCdRegion();
      String county = exchangeHomeValueBean.getCdCounty();
      if(StringHelper.isValid(region) && StringHelper.isValid(county) == false) {
        List<String> countyList = new ArrayList<String>();
        try {
          List<CodeAttributes> codeAttrCollection = Lookup.getCategoryCollection(CodesTables.CCNTYREG);
          if (codeAttrCollection != null) {
            Iterator<CodeAttributes> it = codeAttrCollection.iterator();
            while (it.hasNext()) {
              CodeAttributes codeAttr = it.next();
              if (region.equals(codeAttr.getDecode())) {
                countyList.add(codeAttr.getCode());
              }
            }
          }
        } catch (LookupException e) {
          GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
        }
        if(countyList.size() > 0) {
          constraint.append(" AND cr.CD_RSRC_CNTY in ( ");
          Iterator<String> itr = countyList.iterator();
          while (itr.hasNext()){
            String value = itr.next();
            constraint.append((itr.hasNext() == true) ? "?, " : "?");
            bindVariablesVector.add(value);
          }
          constraint.append(" )");          
        }
      }
      
      if(StringHelper.isValid(county)) {
        constraint.append(" AND cr.CD_RSRC_CNTY = ? ");
        bindVariablesVector.add(county);
      }
      
      String agencyName = Lookup.simpleDecodeSafe(CodesTables.CADOAGEN, exchangeHomeValueBean.getAgency());
      // If a Region was selected then do not include Agency homes so that only DFCS Homes are returned
      if (StringHelper.isValid(region)) {
        constraint.append(" AND UPPER(cr.NDFCS_CERT_ENTITY) IS NULL ");
      } else if(StringHelper.isValid(agencyName)) {
        agencyName = agencyName.toUpperCase();
        constraint.append(" AND UPPER(cr.NDFCS_CERT_ENTITY) LIKE ? ");
        agencyName = "%" + agencyName + "%";
        bindVariablesVector.add(agencyName);
      } 
      
      String agencyCode = exchangeHomeValueBean.getAgencyCode();
      if(StringHelper.isValid(agencyCode)) {
        constraint.append(" AND exh.NBR_AGENCY_CONTRACT_CODE = ? ");
        bindVariablesVector.add(agencyCode);
      }
      
      Date dtInquired = exchangeHomeValueBean.getDtInquired();
      if(DateHelper.isNull(dtInquired) == false) {
        tables.append(", HOME_APPLICANT_INFO hai ");
        constraint.append(" AND hai.ID_RESOURCE = exh.ID_RESOURCE AND hai.DT_INQUIRY <= ? ");
        bindVariablesVector.add(dtInquired);
      }
      
      Integer numOfChildren = exchangeHomeValueBean.getNumOfChildren();
      if(numOfChildren != null && numOfChildren > 0) {
        constraint.append(" AND exh.NBR_CHILD_INTEREST >= ? ");
        bindVariablesVector.add(numOfChildren);
      }
      
      List<String> lstNonAvaCodes = exchangeHomeValueBean.getLstCdNonAvaCodes();
      if(lstNonAvaCodes != null && lstNonAvaCodes.size() > 0) {
        constraint.append(" AND exh.CD_NON_AVAIL_STATUS in ( ");
        Iterator<String> itr = lstNonAvaCodes.iterator();
        while (itr.hasNext()){
          String value = itr.next();
          constraint.append((itr.hasNext() == true) ? "?, " : "?");
          bindVariablesVector.add(value);
        }
        constraint.append(" )");
      }
            
      //special needs if using has entered name do not use special needs
      if(StringHelper.isValid(homeName) == false) {
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndMentalRetardation())) {
          constraint.append(" AND exh.IND_MENTAL_RETARDATION = '" + ArchitectureConstants.Y + "' ");
          String cdLevelMentalRetardation = exchangeHomeValueBean.getCdLevelMentalRetardation();
          if(cdLevelMentalRetardation != null && cdLevelMentalRetardation.length() > 0) {
            constraint.append(" AND exh.CD_SEV_MENTAL_RETARDATION ");
            if (CodesTables.CADSEVER_01.equals(cdLevelMentalRetardation)) {
              constraint.append("in ( ?, ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_01);
            } else if (CodesTables.CADSEVER_02.equals(cdLevelMentalRetardation)) {
              constraint.append("in ( ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            } else {
              constraint.append("= ? ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            }
          }
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndVisualHearingImpairments())) {
          constraint.append(" AND exh.IND_VISUAL_HEARING_IMP = '" + ArchitectureConstants.Y + "' ");
          String cdLevelVisualHearingImpairments = exchangeHomeValueBean.getCdLevelVisualHearingImpairments();
          if(cdLevelVisualHearingImpairments != null && cdLevelVisualHearingImpairments.length() > 0) {
            constraint.append(" AND exh.CD_SEV_VISUAL_HEARING_IMP ");
            if (CodesTables.CADSEVER_01.equals(cdLevelVisualHearingImpairments)) {
              constraint.append("in ( ?, ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_01);
            } else if (CodesTables.CADSEVER_02.equals(cdLevelVisualHearingImpairments)) {
              constraint.append("in ( ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            } else {
              constraint.append("= ? ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            }
          }
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndPhysicallyDisabled())) {
          constraint.append(" AND exh.IND_PHYSICALLY_DISABLED = '" + ArchitectureConstants.Y + "' ");
          String cdLevelPhysicallyDisabled = exchangeHomeValueBean.getCdLevelPhysicallyDisabled();
          if(cdLevelPhysicallyDisabled != null && cdLevelPhysicallyDisabled.length() > 0) {
            constraint.append(" AND exh.CD_SEV_PHYSICALLY_DISABLED ");
            if (CodesTables.CADSEVER_01.equals(cdLevelPhysicallyDisabled)) {
              constraint.append("in ( ?, ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_01);
            } else if (CodesTables.CADSEVER_02.equals(cdLevelPhysicallyDisabled)) {
              constraint.append("in ( ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            } else {
              constraint.append("= ? ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            }
          }
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndEmotionallyDisturbed())) {
          constraint.append(" AND exh.IND_EMOTIONALLY_DIST = '" + ArchitectureConstants.Y + "' ");
          String cdLevelEmotionallyDisturbed = exchangeHomeValueBean.getCdLevelEmotionallyDisturbed();
          if(cdLevelEmotionallyDisturbed != null && cdLevelEmotionallyDisturbed.length() > 0) {
            constraint.append(" AND exh.CD_SEV_EMOTIONALLY_DIST ");
            if (CodesTables.CADSEVER_01.equals(cdLevelEmotionallyDisturbed)) {
              constraint.append("in ( ?, ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_01);
            } else if (CodesTables.CADSEVER_02.equals(cdLevelEmotionallyDisturbed)) {
              constraint.append("in ( ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            } else {
              constraint.append("= ? ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            }
          }
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndOtherMedicalDiagnoses())) {
          constraint.append(" AND exh.IND_OTHER_MED = '" + ArchitectureConstants.Y + "' ");
          String cdLevelOtherMedicalDiagnoses = exchangeHomeValueBean.getCdlevelOtherMedicalDiagnoses();
          if(cdLevelOtherMedicalDiagnoses != null && cdLevelOtherMedicalDiagnoses.length() > 0) {
            constraint.append(" AND exh.CD_SEV_OTHER_MED ");
            if (CodesTables.CADSEVER_01.equals(cdLevelOtherMedicalDiagnoses)) {
              constraint.append("in ( ?, ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_01);
            } else if (CodesTables.CADSEVER_02.equals(cdLevelOtherMedicalDiagnoses)) {
              constraint.append("in ( ?, ?) ");
              bindVariablesVector.add(CodesTables.CADSEVER_02);
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            } else {
              constraint.append("= ? ");
              bindVariablesVector.add(CodesTables.CADSEVER_03);
            }
          }
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndFamilyHxofDrugsAlcohol())) {
          constraint.append(" AND exh.IND_FAM_HX_DRUGS_ALCOHOL = '" + ArchitectureConstants.Y + "' ");
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndFamilyHxofMentalIllness())) {
          constraint.append(" AND exh.IND_FAM_HX_MENTAL_ILL = '" + ArchitectureConstants.Y + "' ");
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndFamilyHxofMR())) {
          constraint.append(" AND exh.IND_FAM_HX_MR = '" + ArchitectureConstants.Y + "' ");
        }
        
        if(ArchitectureConstants.Y.equals(exchangeHomeValueBean.getIndChilsHxofSexualAbuse())) {
          constraint.append(" AND exh.IND_CH_HX_SEXUAL_ABUSE = '" + ArchitectureConstants.Y + "' ");
        }
        
        List<String> lstRaces = exchangeHomeValueBean.getChildRacePref();
        if(lstRaces != null && lstRaces.size() > 0) {
          constraint.append(" AND ((SELECT COUNT(*) FROM HOME_RACE hr where hr.ID_RESOURCE = exh.ID_RESOURCE and hr.CD_RACE in ( ");
          Iterator<String> itr = lstRaces.iterator();
          while (itr.hasNext()){
            String value = itr.next();
            constraint.append((itr.hasNext() == true) ? "?, " : "?");
            bindVariablesVector.add(value);
          }
          constraint.append(" )) = ? ) ");
          bindVariablesVector.add(lstRaces.size());
        }
        
        List<String> lstEthnicity = exchangeHomeValueBean.getChildEthnicityPerf();
        if(lstEthnicity != null && lstEthnicity.size() > 0) {
          constraint.append(" AND ((SELECT COUNT(*) FROM HOME_ETHNICITY he where he.ID_RESOURCE = exh.ID_RESOURCE and he.CD_ETHNICITY in ( ");
          Iterator<String> itr = lstEthnicity.iterator();
          while (itr.hasNext()){
            String value = itr.next();
            constraint.append((itr.hasNext() == true) ? "?, " : "?");
            bindVariablesVector.add(value);
          }
          constraint.append(" )) = ? ) ");
          bindVariablesVector.add(lstEthnicity.size());
        }
        
        String gender = exchangeHomeValueBean.getCdGender();
        if(StringHelper.isValid(gender)) {
          // STGAP00012883: Use the Home's Approved Age Ranges instead of the Home's Interested Age Ranges
          if(CodesTables.CRSRCSEX_B.equals(gender) || CodesTables.CRSRCSEX_F.equals(gender)) {
            constraint.append(" AND cr.NBR_RSRC_FM_AGE_MAX >= ? ");
            bindVariablesVector.add(exchangeHomeValueBean.getMaxRangeInMonths());
            constraint.append(" AND cr.NBR_RSRC_FM_AGE_MIN <= ? ");
            bindVariablesVector.add(exchangeHomeValueBean.getMinRangeInMonths());
          } 
          
          if(CodesTables.CRSRCSEX_B.equals(gender) || CodesTables.CRSRCSEX_M.equals(gender)) {
            constraint.append(" AND cr.NBR_RSRC_MA_AGE_MAX >= ? ");
            bindVariablesVector.add(exchangeHomeValueBean.getMaxRangeInMonths());
            constraint.append(" AND cr.NBR_RSRC_MA_AGE_MIN <= ? ");
            bindVariablesVector.add(exchangeHomeValueBean.getMinRangeInMonths());
          }
        }
      }
    }
    
    sqlBuff.append(tables);
    sqlBuff.append(constraint);
    sqlBuff.append(getOrderByString(details));    
    sqlAndBind.sql = sqlBuff.toString();
    sqlAndBind.bindVariablesVector = bindVariablesVector;
    return sqlAndBind;
  }
  
  protected static String getOrderByString(DatabaseResultDetails details) {
    if (details.getOrderBy() == null) {
      return " ORDER BY cr." + RESOURCE_NAME;
    }

    String orderBy = " ORDER BY " + details.getOrderBy();

    if (details.getOrderByDirection() != null) {
      orderBy += " " + details.getOrderByDirection();
    }
    return orderBy;
  }
  
  public String getListSQL(ExchangeHomeValueBean exchangeHomeValueBean, ResultSet resultSet, DatabaseResultDetails details)
  throws SQLException {
    StringBuffer sql = new StringBuffer();
    sql.append(SELECT + "WHERE FACID IN ( null");
    
    resultSet.beforeFirst();
    details.obtainNumberOfResults(resultSet);
    int lastResult = details.getLastResultRequested();
    while (resultSet.next() && (resultSet.getRow() <= lastResult)) {
      sql.append(", '").append(resultSet.getString(1)).append("' ");
    }
    
    sql.append(") ");
    sql.append(" ORDER BY cr." + RESOURCE_NAME);
    return sql.toString();
 }
  
  private class SqlandBindValues {
    List<Object> bindVariablesVector = new ArrayList<Object>();
    String sql;
  }
}
