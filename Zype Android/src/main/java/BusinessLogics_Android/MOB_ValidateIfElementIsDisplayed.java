
  package BusinessLogics_Android;

  import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import com.tyss.optimize.nlp.util.annotation.ReturnType;
  import com.tyss.optimize.common.util.CommonConstants;
  import org.springframework.stereotype.Component;
  import io.appium.java_client.android.AndroidDriver;
  import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
  import java.util.Map;
  import java.util.ArrayList;
  import java.util.List;

  @Component("LIC2752_PJT1004_PE_NLP5ffcf405-75d3-44dd-a4c1-bcbfd95e2cb6")
  public class MOB_ValidateIfElementIsDisplayed implements Nlp {
	  Boolean isDisplayed=null;
      @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
      @ReturnType(name = "Assign Step Return Value",  type = "java.lang.Boolean")

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
          String xpath = (String) attributes.get("Xpath");
        AndroidDriver   driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
          
       
          try {
        	  isDisplayed = true;
              driver.findElement(By.xpath(xpath)).isDisplayed();
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("Successfully Element is displayed");
          }
          catch(NoSuchElementException e) {
              isDisplayed = false;
              nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to locate the element");
              
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to verify if element is displayed");
          }
          nlpResponseModel.getAttributes().put("Assign Step Return Value", isDisplayed);
          return nlpResponseModel;
      }
  } 