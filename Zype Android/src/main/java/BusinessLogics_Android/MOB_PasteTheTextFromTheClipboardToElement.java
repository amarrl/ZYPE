
  package BusinessLogics_Android;

  import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import com.tyss.optimize.nlp.util.annotation.ReturnType;
  import java.util.Map;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
  import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

  @Component("LIC2752_PJT1004_PE_NLP1018")
  public class MOB_PasteTheTextFromTheClipboardToElement implements Nlp {
	  @InputParams({@InputParam(name = "elementName", type = "java.lang.String"),
          @InputParam(name = "elementType", type = "java.lang.String"),
          @InputParam(name = "Element", type = "org.openqa.selenium.WebElement")})
     
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
          WebElement Element = (WebElement) attributes.get("Element");
          
         

          // Your program element business logic goes here ...
       try {
    	   if(Element.isDisplayed()) {
    	   Element.click();
    	   }
    	   Thread.sleep(2000);
    	   Robot robo = new Robot();
    	   robo.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
  	       robo.keyPress(java.awt.event.KeyEvent.VK_V);
  	       Thread.sleep(1000);
  		   robo.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
  		   robo.keyRelease(java.awt.event.KeyEvent.VK_V);
  		   nlpResponseModel.setMessage("Paste the text successfully");
  		   nlpResponseModel.setStatus(CommonConstants.pass);
        }
       catch (NoSuchElementException e) {
    	   nlpResponseModel.setMessage("Element is not found");
		   nlpResponseModel.setStatus(CommonConstants.fail);	
		   }
       catch(Exception e) {
    	   nlpResponseModel.setMessage("Failed to paste the text");
    	   nlpResponseModel.setStatus(CommonConstants.fail);
       }
          return nlpResponseModel;
      }
  }