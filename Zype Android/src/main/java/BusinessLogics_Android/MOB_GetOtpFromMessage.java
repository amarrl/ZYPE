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
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.List;


	@Component("LIC2752_PJT1004_PE_NLP1019") 

	public class MOB_GetOtpFromMessage implements Nlp {
		String otp;
		@InputParams({@InputParam(name = "Message with OTP", type = "java.lang.String")})
		@ReturnType(name = "OTP", type = "java.lang.String")

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
			AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			String message = (String) attributes.get("Message with OTP");
			try {
			   
				message = message.replaceAll("[^0-9?]", "");
				otp = message.substring(0, 6);
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("OTP fetched successfully "+otp);

			} catch (Exception e) {
				e.printStackTrace();
				nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Failed to fetch OTP");


			}
			nlpResponseModel.getAttributes().put("OTP", otp);
			return nlpResponseModel;
		}
	} 



