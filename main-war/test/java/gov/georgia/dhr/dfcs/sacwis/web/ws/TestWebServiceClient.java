package gov.georgia.dhr.dfcs.sacwis.web.ws;

import java.net.MalformedURLException;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveTestRowWI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTestRowWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveTestRowWO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTestRowWO;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

public class TestWebServiceClient {
  public static void main(String[] args) {
    // We are creating a model pointing it to the Interface of our WebService
    Service srvcModel = new ObjectServiceFactory().create(TestWS.class);
    // We will create an XFire Factory
    XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
    // Url for the Web Service
    String testurl = "http://localhost:8080/ws/TestWS";
    try {
      // Preparing Test WI Object
      SaveTestRowWI saveTestRowWI = new SaveTestRowWI();
      saveTestRowWI.setNumVal(100);
      saveTestRowWI.setCharVal("Char Test");
      saveTestRowWI.setVar2Val("This text has come from Java Client");
      saveTestRowWI.setDateVal(new Date());
      // Create reference to the Service using XFire Factory
      TestWS srvc = (TestWS) factory.create(srvcModel, testurl);
      // We will create the Row and print the ID of the row
      SaveTestRowWO saveTestRowWO = srvc.saveTestRow(saveTestRowWI);
      System.out.println(">>>> saveTestRow >> \n" + "Row Created ID=" + saveTestRowWO.getId());
      // We will pass the ID created as the input to the program and retrieve it
      Integer id = Integer.valueOf(args[0]);
      RetrieveTestRowWI retrieveTestRowWI = new RetrieveTestRowWI();
      retrieveTestRowWI.setId(id);
      RetrieveTestRowWO retrieveTestRowWO = srvc.retrieveTestRow(retrieveTestRowWI);
      if (retrieveTestRowWO != null) {
        System.out.println("\n\n>>>> retrieveTestRow with ID=" + args[0] + " >> \n" +
                           " ID=" + retrieveTestRowWO.getId() + "\n" +
                           " Char=" + retrieveTestRowWO.getCharVal() + "\n" +
                           " Varchar 2=" + retrieveTestRowWO.getVar2Val() + "\n" +
                           " Date=" + retrieveTestRowWO.getDateVal());
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }
}



