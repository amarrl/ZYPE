
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

  @Component("LIC2752_PJT1004_PE_NLP1015")
  public class MOB_ValidateIfElementIsNotSelected implements Nlp {
      @InputParams({@InputParam(name = "elementName", type = "java.lang.String"),
                    @InputParam(name = "elementType", type = "java.lang.String"),
                    @InputParam(name = "Element", type = "org.openqa.selenium.WebElement")})
      @ReturnType(name = "IsNotSelected", type = "java.lang.Boolean")

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
          boolean isNotSelected = false;
          try {
              isNotSelected = element.isSelected();
              if (!isNotSelected) {
                    nlpResponseModel.setStatus(CommonConstants.pass);
                    nlpResponseModel.setMessage("Element is not selected");
              }
              else{
                    nlpResponseModel.setStatus(CommonConstants.fail);
                    nlpResponseModel.setMessage("Element is selected");
              }
          } catch(Exception e) {
                    nlpResponseModel.setStatus(CommonConstants.fail);
                    nlpResponseModel.setMessage("Failed to check if eleement is not selected");
          }


          nlpResponseModel.getAttributes().put("IsNotSelected", isNotSelected);
          return nlpResponseModel;
      }
  } 