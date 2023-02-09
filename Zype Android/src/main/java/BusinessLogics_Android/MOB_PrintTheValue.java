
  package BusinessLogics_Android;

  import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import java.util.Map;
  import java.util.ArrayList;
  import java.util.List;

import org.springframework.stereotype.Component;

  @Component("LIC2752_PJT1004_PE_NLP1020")
  public class MOB_PrintTheValue implements Nlp {
	  @InputParams({@InputParam(name = "Input", type = "java.lang.String")})
	

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
          String Input = (String) attributes.get("Input");
          
          try {
        	  nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("The value is "+Input+"");
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to print the value");
		}
          
          return nlpResponseModel;
      }
  } 