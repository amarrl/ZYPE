package BusinessLogics_Android;

import com.tyss.optimize.nlp.util.Nlp;

import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;  
import java.util.List;
import org.springframework.stereotype.Component;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.common.util.CommonConstants;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.android.AndroidDriver; 

import org.openqa.selenium.WebDriver;


@Component("LIC2752_PJT1004_PE_NLP1010")
public class MOB_SwitchFromNativeToWebView implements Nlp {
    @InputParams({@InputParam(name = "contextName", type = "java.lang.String")})
    

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
        String contextName = (String) attributes.get("contextName");
        
        
        AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
      
	   try {
		   Set<String> listofCon = driver.getContextHandles();
           for (String con:listofCon
                ) {
               System.out.println("Context "+con);
               if (con.equalsIgnoreCase(contextName)){
                   driver.context(con);
                   System.out.println("Switched to "+con);
              
               }
           }
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage("Successfully switched to "+contextName);
        }
        catch(Exception e) {
            nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed to switch to "+contextName);
        }
        
        return nlpResponseModel;
    }
} 


