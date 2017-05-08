package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.service.admin.ValidateLogin;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateLoginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO;

public class ValidateLoginImpl extends BaseServiceImpl implements ValidateLogin {
  private static final String UPDATE_FAILED_LOGIN_ATTEMPT = "UPDATE_FAILED_LOGIN_ATTEMPT";
  private static final String UPDATE_NEW_PASSWORD_LOGIN_ATTEMPT = "UPDATE_NEW_PASSWORD_LOGIN_ATTEMPT";
  private static final String SELECT_USER_PASSWORD_INITIAL_LOGIN = "SELECT_USER_PASSWORD_INITIAL_LOGIN";
  private static final String SELECT_USER_PASSWORD = "SELECT_USER_PASSWORD";
  private static final String SELECT_USER_PASSWORD_BY_ID_USER = "SELECT_USER_PASSWORD_BY_ID_USER";
  private static final String CHECK_PREVIOUS_PASSWORDS = "CHECK_PREVIOUS_PASSWORDS";
  private static final String COUNT_PORTAL_USER = "COUNT_PORTAL_USER";
  private static final String COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER = "COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER";
  private static final String VALIDATE_USER_STATUS = "VALIDATE_USER_STATUS";
  private static final String VALIDATE_USER_EMAIL = "VALIDATE_USER_EMAIL";
  PortalUserDAO portalUserDAO;
  
  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }
  
  public ValidateLoginSO validateLogin(ValidateLoginSI validateLoginSI) {
    String userName = validateLoginSI.getUserName();
    String crudFlag = validateLoginSI.getCrudFlag();
    int idUser = validateLoginSI.getIdUser()!=null?validateLoginSI.getIdUser():0;
    ValidateLoginSO validateLoginSO = new ValidateLoginSO();
    if (crudFlag != null && crudFlag.equals(UPDATE_FAILED_LOGIN_ATTEMPT)){
      portalUserDAO.updatePortalUserForNumFailedAttempts(userName, validateLoginSI.getNumOfFailedLogins());
    }else if (crudFlag != null && crudFlag.equals(UPDATE_NEW_PASSWORD_LOGIN_ATTEMPT)){
      portalUserDAO.updatePortalUserForChangePassword(userName, validateLoginSI.getNumOfFailedLogins(), validateLoginSI.getPassword());
    }else if (crudFlag != null && (crudFlag.equals(SELECT_USER_PASSWORD)) || VALIDATE_USER_EMAIL.equals(crudFlag)) { //MR-067: added reset scenario
      Object[] portalUser = portalUserDAO.findValidateLoginInfoByTxtEmail(userName);
      //Set the Validation SO Object from the retrieved portal User object
      setValidateLoginSO(validateLoginSO, portalUser, userName);
    }else if (crudFlag != null && crudFlag.equals(SELECT_USER_PASSWORD_INITIAL_LOGIN)){
      Object[] portalUser = portalUserDAO.findValidateLoginInfoByTxtEmail(userName);
      //Set the Validation SO Object from the retrieved portal User object
      setValidateLoginSO(validateLoginSO, portalUser, userName);
    }else if (crudFlag != null && crudFlag.equals(SELECT_USER_PASSWORD_BY_ID_USER)){
      Object[] portalUser = portalUserDAO.findValidateLoginInfoByIdUser(idUser);
      //Set the Validation SO Object from the retrieved portal User object
      setValidateLoginSO(validateLoginSO, portalUser, userName);
    }else if(crudFlag != null && crudFlag.equals(CHECK_PREVIOUS_PASSWORDS)){
      List<Object[]> prevPasswords = portalUserDAO.findPreviousPasswordsByTxtEmail(userName, validateLoginSI.getNumOfPrevPasswords());
      ArrayList<String> prevPasswordList = new ArrayList<String>();
      for(int i=0; i<prevPasswords.size(); i++){
        Object[] prevPasswordObj = prevPasswords.get(i);
        prevPasswordList.add(i,(String)prevPasswordObj[1]!=null?(String)prevPasswordObj[1]:"");
      }
      validateLoginSO.setPrevPasswords(prevPasswordList);
    }else if(crudFlag != null && crudFlag.equals(COUNT_PORTAL_USER)){
      Long emailCount = portalUserDAO.countPortalUserByTxtEmail(userName);
      validateLoginSO.setEmailCount(emailCount);
    }else if(crudFlag != null && crudFlag.equals(VALIDATE_USER_STATUS)){
      PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser
                                      (validateLoginSI.getIdUser()!=null?
                                                      validateLoginSI.getIdUser():0);
      if (portalUser!=null){
        validateLoginSO.setCdStatus(portalUser.getCdStatus());
      }
    }else if(crudFlag != null && crudFlag.equals(COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER)){
      Long emailCount = portalUserDAO.countPortalUserByTxtEmailAndNotIdUser(userName, idUser);
      validateLoginSO.setEmailCount(emailCount);
    }
    return validateLoginSO;
  }
  
  private void setValidateLoginSO(ValidateLoginSO validateLoginSO, Object[] portalUser, String userName){
    if (portalUser != null){
      validateLoginSO.setUserName(userName);
      validateLoginSO.setPassword((String)portalUser[0]!=null?(String)portalUser[0]:"");
      validateLoginSO.setDtLastPasswordReset((Date)portalUser[1]);
      validateLoginSO.setIndPasswordTemp((String)portalUser[2]!=null?(String)portalUser[2]:"");
      validateLoginSO.setNumOfFailedLogins(((BigDecimal)portalUser[3])!=null?((BigDecimal)portalUser[3]).intValue():0);
      ArrayList<String> questionsList = new ArrayList<String>();
      //Adding Questions to the ArrayList
      questionsList.add(0,(String)portalUser[4]!=null?(String)portalUser[4]:"");
      questionsList.add(1,(String)portalUser[5]!=null?(String)portalUser[5]:"");
      questionsList.add(2,(String)portalUser[6]!=null?(String)portalUser[6]:"");          
      ArrayList<String> answersList = new ArrayList<String>();
      //Adding Answers to the ArrayList
      answersList.add(0,(String)portalUser[7]!=null?(String)portalUser[7]:"");
      answersList.add(1,(String)portalUser[8]!=null?(String)portalUser[8]:"");
      answersList.add(2,(String)portalUser[9]!=null?(String)portalUser[9]:"");
      validateLoginSO.setCdQuestion(questionsList);
      validateLoginSO.setTxtAnswer(answersList);
      validateLoginSO.setCdStatus((String)portalUser[10]!=null?(String)portalUser[10]:"");
      validateLoginSO.setIdUser(((BigDecimal)portalUser[11])!=null?((BigDecimal)portalUser[11]).intValue():0);
    }    
  }
}
