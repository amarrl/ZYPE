
  package BusinessLogics_Android;

  import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

  @Component("LIC2752_PJT1004_PE_NLP8aa1ef68-e3d1-4d54-bd1c-1bfe4c28982b")
  public class MOB_PressNumberKey implements Nlp {
      @InputParams({@InputParam(name = "DialKey", type = "java.lang.Integer")})

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
          Integer DialKey = (Integer) attributes.get("DialKey");

    	  AndroidDriver driver = (AndroidDriver)  nlpRequestModel.getDriver().getSpecificIDriver();

          try {
        	  switch (DialKey) {
			case 1:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
				break;
			case 2:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
				break;
			case 3:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
				break;
			case 4:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
				break;
			case 5:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
				break;
			case 6:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_6));
				break;
			case 7:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_7));
				break;
			case 8:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_8));
				break;
			case 9:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_9));
				break;
			case 0:
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_0));
				break;
			default:
	      		   nlpResponseModel.setStatus(CommonConstants.fail);
	           	   nlpResponseModel.setMessage("Not match to the Dial Keypad"); 
				break;
			}
     		   nlpResponseModel.setStatus(CommonConstants.pass);
           	   nlpResponseModel.setMessage("Clicked on Dial Keypad " +DialKey);
          }
          catch(Exception e)
          {
      		   nlpResponseModel.setStatus(CommonConstants.fail);
       	   nlpResponseModel.setMessage("Failed to click on Dial Keypad");    	  
          }
		return nlpResponseModel;
      }
  } 