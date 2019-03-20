package com.example.helloheroku;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.agrex.aps2jni.Aps2Coder;
import jp.co.agrex.aps2jni.Aps2Controller;
import jp.co.agrex.aps2jni.Aps2Exception;
import jp.co.agrex.aps2jni.Aps2MasterData;
import jp.co.agrex.aps2jni.Aps2RuntimeException;
import jp.co.agrex.aps2jni.Aps2StdCoderResult;


@Controller
public class LoginController {
 @RequestMapping(value = "/login", method = RequestMethod.POST)
 public String login(Model model) {
	 
	 	String iniPath = "../ini/aps2env.ini";
	 	
	 	String target = "東京都立川市";
	 	
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
				
				model.addAttribute("adress_code", _latest.getCode());
				
		 	}		 	

		} catch( Aps2Exception e ){
			e.printStackTrace();
		} catch( Aps2RuntimeException re ){
			re.printStackTrace();
		}
	 
	 model.addAttribute("adress_code");//do　not delete
	 	return "top";
 }
}
