
  package BusinessLogics_Android;

  import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

import java.util.Map;
  import java.util.ArrayList;
  import java.util.List;
  import org.springframework.stereotype.Component;

  @Component("LIC2752_PJT1004_PE_NLP1017")
  public class MOB_SwitchToAnotherApp implements Nlp {
      @InputParams({@InputParam(name = "App Package", type = "java.lang.String"), 
      @InputParam(name = "App Activity", type = "java.lang.String")})
     
        @Override
      public List<String> getTestParameters() throws NlpException {
        List<String> params = new ArrayList<>();
        return params;
    }
    
     @Override
    public StringBuilder getTestCode() throws NlpException {
        StringBuilder sb = new StringBuilder();
        return sb;
    }
      @Override
      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          String apPackage = (String) attributes.get("App Package");
          String appActivity = (String) attributes.get("App Activity");

          // Your program element business logic goes here ...
          AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
          try {
          driver.startActivity(new Activity(apPackage, appActivity));
          Thread.sleep(3000);
          nlpResponseModel.setMessage("Successfully Switched the app");
          nlpResponseModel.setStatus(CommonConstants.pass);
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Failed to switch the app");
          }

          return nlpResponseModel;
      }
  } 
  