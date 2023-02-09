
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

  @Component("LIC2752_PJT1004_PE_NLP1014")
  public class MOB_ValidateIfElementIsNotDisplayed implements Nlp {
      @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
      @ReturnType(name = "isNotDisplayed", type = "java.lang.Boolean")

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
          AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
          
          boolean isNotDisplayed = false;
          try {
              driver.findElement(By.xpath(xpath)).isDisplayed();
              nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("The element is displayed");
          }
          catch(NoSuchElementException e) {
              isNotDisplayed = true;
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("The element is not displayed");
              
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to verify if element is displayed");
          }
          nlpResponseModel.getAttributes().put("isNotDisplayed", isNotDisplayed);
          return nlpResponseModel;
      }
  } 