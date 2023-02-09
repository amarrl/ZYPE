
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
  import org.openqa.selenium.WebElement;
  import java.util.ArrayList;
  import java.util.Map;
  import java.util.List;

  @Component("LIC2752_PJT1004_PE_NLPe7518b61-b73a-4c8a-a12a-a5714499685a")
  public class MOB_NextButtonDisabled implements Nlp {
      @InputParams({@InputParam(name = "elementName", type = "java.lang.String"),
                    @InputParam(name = "elementType", type = "java.lang.String"),
                    @InputParam(name = "Element", type = "org.openqa.selenium.WebElement")})
      @ReturnType(name = "IsDisabled", type = "java.lang.Boolean")

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
          WebElement element = (WebElement) attributes.get("Element");
          boolean isEnabled = false;
          try {
              isEnabled = element.isEnabled();
              if (isEnabled) {
                    nlpResponseModel.setStatus(CommonConstants.pass);
                    nlpResponseModel.setMessage("Element is disabled");
              }
              else{
                    nlpResponseModel.setStatus(CommonConstants.fail);
                    nlpResponseModel.setMessage("Element is not disabled");
              }
          } catch(Exception e) {
                    nlpResponseModel.setStatus(CommonConstants.fail);
                    nlpResponseModel.setMessage("Failed to check if disabled");
          }


          nlpResponseModel.getAttributes().put("IsDisabled", isEnabled);
          return nlpResponseModel;
      }
  } 