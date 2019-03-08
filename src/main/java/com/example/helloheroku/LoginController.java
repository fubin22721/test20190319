package com.example.helloheroku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.agrex.aps2jni.Aps2Coder;
import jp.co.agrex.aps2jni.Aps2Controller;
import jp.co.agrex.aps2jni.Aps2Exception;
import jp.co.agrex.aps2jni.Aps2IOException;
import jp.co.agrex.aps2jni.Aps2IllegalArgumentException;
import jp.co.agrex.aps2jni.Aps2IllegalEnvironmentException;
import jp.co.agrex.aps2jni.Aps2IllegalStateException;
import jp.co.agrex.aps2jni.Aps2MasterData;
import jp.co.agrex.aps2jni.Aps2ProcessException;
import jp.co.agrex.aps2jni.Aps2RuntimeException;
import jp.co.agrex.aps2jni.Aps2StdCoderResult;
import jp.co.agrex.aps2jni.Aps2TimeOverException;

@Controller
public class LoginController {
 @RequestMapping(value = "/login", method = RequestMethod.POST)
 public String login(Model model) {
	 System.out.println(System.getProperty("java.library.path"));
	 System.out.println( "===== Console Test START =====" );
		Aps2JNICoderTest test = new Aps2JNICoderTest();
		test.start();
		System.out.println( "===== Console Test END =====" );
		
		 return null;
 }
}
