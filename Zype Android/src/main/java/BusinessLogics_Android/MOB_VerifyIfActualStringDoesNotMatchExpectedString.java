
  package BusinessLogics_Android;

  import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import com.tyss.optimize.nlp.util.annotation.ReturnType;
  import java.util.Map;
  import java.util.ArrayList;
  import java.util.List;
  import com.tyss.optimize.common.util.CommonConstants;
  import java.util.Set;
  import org.springframework.stereotype.Component;
  
  @Component("LIC2752_PJT1004_PE_NLP1016")
  public class MOB_VerifyIfActualStringDoesNotMatchExpectedString implements Nlp {
      @InputParams({@InputParam(name = "Actual String", type = "java.lang.String"), @InputParam(name = "Expected String", type = "java.lang.String")})
      @ReturnType(name = "ifEquals", type = "java.lang.Boolean")

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
        //HI
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          String string1 = (String) attributes.get("Actual String");
          String string2 = (String) attributes.get("Expected String");

          boolean ifEquals = string1.equals(string2);
          try {
              if (ifEquals) 
              {
                 nlpResponseModel.setStatus(CommonConstants.fail);
                 nlpResponseModel.setMessage(string1 + " matches " + string2);
              }
              else
              {
                 nlpResponseModel.setStatus(CommonConstants.pass);
                 nlpResponseModel.setMessage(string1 + " doesn't match " + string2);
              }
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed compare strings");
          }

          nlpResponseModel.getAttributes().put("ifEquals", ifEquals);
          return nlpResponseModel;
      }
  } 