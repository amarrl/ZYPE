
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

  @Component("LIC2752_PJT1004_PE_NLP94cc2342-2546-46eb-b903-c1610995d2c1")
  public class MOB_SelectSpecialKeys implements Nlp {
      @InputParams({@InputParam(name = "DialPad", type = "java.lang.String")})

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
          String DialPad = (String) attributes.get("DialPad");

    	  AndroidDriver driver = (AndroidDriver)  nlpRequestModel.getDriver().getSpecificIDriver();

          try {
        	  switch (DialPad) {
			case "APP_SWITCH":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.APP_SWITCH));
				break;
			case "NUMPAD_ENTER":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.NUMPAD_ENTER));
				break;
			case "ENTER":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
				break;
			case "BACK":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
				break;
			case "COPY":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.COPY));
				break;
			case "PASTE":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.PASTE));
				break;
			case "CUT":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.CUT));
				break;
			case "SPACE":
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.SPACE));
				break;
	
			default:
	      		   nlpResponseModel.setStatus(CommonConstants.fail);
	           	   nlpResponseModel.setMessage("Not match to the Dial Keypad"); 
				break;
			}
     		   nlpResponseModel.setStatus(CommonConstants.pass);
           	   nlpResponseModel.setMessage("Clicked on Dial Keypad " +DialPad);
          }
          catch(Exception e)
          {
      		   nlpResponseModel.setStatus(CommonConstants.fail);
       	   nlpResponseModel.setMessage("Failed to click on Dial Keypad");    	  
          }
		return nlpResponseModel;
      }
  } 