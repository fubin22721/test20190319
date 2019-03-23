package com.example.helloheroku;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jp.co.agrex.aps2jni.Aps2Coder;
import jp.co.agrex.aps2jni.Aps2Controller;
import jp.co.agrex.aps2jni.Aps2Exception;
import jp.co.agrex.aps2jni.Aps2MasterData;
import jp.co.agrex.aps2jni.Aps2RuntimeException;
import jp.co.agrex.aps2jni.Aps2StdCoderResult;


@Controller
public class LoginController {
 	@Autowired
 	HttpSession session;
	
 @RequestMapping(value = "/login", method = RequestMethod.POST)
 public String login(Model model) {
	 
//	 	String iniPath = ".aps2env.ini";
	 	String iniPath = "ini/aps2env.ini";
	 	

	 	
//	 	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
	 	System.out.println("ContextPath:"+session.getServletContext().getContextPath()+"");
	 	
	 	String target = "譚ｱ莠ｬ驛ｽ貂玖ｰｷ蛹ｺ蛻晏床1�ｼ�47�ｼ搾ｼ�";
	 	
	 	try {
	 		System.out.println( "  JAVA.VERSION :[" + System.getProperty( "java.version" ) + "]" );
	 		System.out.println( "  JAVA.VENDOR  :[" + System.getProperty( "java.vendor" ) + "]" );
	 		System.out.println( "  JAVA.HOME    :[" + System.getProperty( "java.home" ) + "]" );
		 	
		 	Aps2Coder _cd = new Aps2Coder();
	 		
	 		Aps2Controller cont = new Aps2Controller();
	 		
	 		cont.prologue( iniPath );
		 	
		 	Aps2StdCoderResult _stdresult = _cd.standardCoder(_cd.FUNC_MODE_ADDRESS,
					  _cd.FUNC_OPTION_NEW_MASTER, target, "", "");
		 	
		 	if(_stdresult.getNewMasterNo() != 0 &&
					_stdresult.getNewCodeFlag() == _stdresult.NEW_CODE_FLAG_GENZON) {
		 		
				Aps2MasterData _latest = _stdresult.getMasterData();
				
				model.addAttribute("address_code", _latest.getCode());
				
		 	}		 	

		} catch( Aps2Exception e ){
			e.printStackTrace();
		} catch( Aps2RuntimeException re ){
			re.printStackTrace();
		}
	 
//	 model.addAttribute("address_code","address_code=21344565");//do縲�not delete
	 	return "top";
 }
}
