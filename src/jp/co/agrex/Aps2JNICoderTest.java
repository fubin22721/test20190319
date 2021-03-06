package jp.co.agrex;
/*
 * aps2jni?申?申?申C?申u?申?申?申?申 ?申Z?申?申?申R?申[?申h?申?申?申@?申\ ?申?申?申?申m?申F?申p?申v?申?申?申O?申?申?申?申
 * Copyright AGREX Inc. All Rights Resecom.example.helloheroku

package jp.co.agrex;

import java.io.*;

import jp.co.agrex.aps2jni.Aps2Coder;
import jp.co.agrex.aps2jni.Aps2Controller;
import jp.co.agrex.aps2jni.Aps2Exception;
import jp.co.agrex.aps2jni.Aps2MasterData;
import jp.co.agrex.aps2jni.Aps2RuntimeException;
import jp.co.agrex.aps2jni.Aps2StdCoderResult;

public class Aps2JNICoderTest {

	/**
	 * ?申R?申?申?申X?申g?申?申?申N?申^?申F
	 */
	public Aps2JNICoderTest() {
	}
	
	public void start() {

		SystemInfo.printSystemInfo();
		
		String iniPath = "C:\\workspace\\testConv\\src\\jp\\co\\agrex\\ini\\aps2env.ini";
		
		System.out.println( "==================================" );
		System.out.println( " aps2jni?申?申?申C?申u?申?申?申?申 ?申Z?申?申?申R?申[?申h?申?申?申@?申\ ?申?申?申?申m?申F?申v?申?申?申O?申?申?申?申 " );
		System.out.println( "==================================" );
		
		try{

			// ?申P?申j?申?申?申?申?申?申?申?申?申?申?申?申?申s?申?申?申��鐃�?申B
			System.out.println( "********** pre(prologue) **********" );
			System.out.println( "  IniPath:[" + iniPath + "]" );
			Aps2Controller cont = new Aps2Controller();
			cont.prologue( iniPath );
			System.out.println( "prologue --> OK" );

			// ?申Q?申j?申W?申?申?申Z?申?申?申��鐃�?申?申?申?申?申?申?申s?申?申?申��鐃�?申B
			BufferedReader _rd = new BufferedReader(new InputStreamReader(System.in), 1);
			Aps2Coder _cd = new Aps2Coder();
			String target;

			for(;;) {
				System.out.println("-- ?申R?申[?申h?申?申?申?申?申?申Z?申?申?申?申?申?申?申?申?申?申?申��鐃�?申��鐃�?申?申?申?申?申?申 --");
				System.out.println("(Q=Quit)");
				target = _rd.readLine();
				if(target.equals("Q") == true || target.equals("q") == true || target.equals("?申p") == true) {
					break;
				}
				if(target.equals("") == true) {
					continue;
				}

				Aps2StdCoderResult _stdresult = _cd.standardCoder(_cd.FUNC_MODE_ADDRESS,
																  _cd.FUNC_OPTION_NEW_MASTER,
    	                                      					  target, "", ""); 

				System.out.println( "");
				System.out.println( "?申y?申?申?申��Z?申?申:" + target + "?申z");
				System.out.println( " ----------  ?申��鐃�?申?申?申?申  ----------" );
				System.out.println( " ?申R?申[?申h             :[" + _stdresult.getCode() + "]" );
				System.out.println( " ?申X?申����鐃�           :[" + _stdresult.getZip() + "]" );
				System.out.println( " ?申J?申i?申Z?申?申           :[" + _stdresult.getKana() + "]" );
				System.out.println( " ?申?申?申?申?申Z?申?申           :[" + _stdresult.getKanji() + "]" );
				System.out.println( " ?申���?申Z?申?申           :[" + _stdresult.getRestAddress() + "]" );

				if(_stdresult.getNewMasterNo() != 0 &&
						_stdresult.getNewCodeFlag() == _stdresult.NEW_CODE_FLAG_GENZON) {

					Aps2MasterData _latest = _stdresult.getMasterData();

					System.out.println( " ----------  ?申��V?申Z?申?申?申?申?申  ----------" );
					System.out.println( " ?申R?申[?申h             :[" + _latest.getCode() + "]" );
					System.out.println( " ?申X?申����鐃�           :[" + _latest.getZip() + "]" );
					System.out.println( " ?申J?申i?申Z?申?申           :[" + _latest.getKana() + "]" );
					System.out.println( " ?申?申?申?申?申Z?申?申           :[" + _latest.getKanji() + "]" );
				}
				System.out.println("");
			}

			// ?申R?申j?申?申n?申?申?申?申?申?申?申?申?申s?申?申?申��鐃�?申B
			System.out.println( "********** ?申?申n?申?申?申?申?申?申(epilogue) **********" );
			cont.epilogue( cont.CLEAN_MODE_NORMAL );
			System.out.println( "  epilogue --> OK" );

		} catch( Aps2Exception e ){
			System.out.println( "***** aps2jni ?申?申?申��鐃�O?申?申?申?申?申?申?申?申?申��鐃�?申?申 *****" );
			System.out.println( "?申G?申?申?申[?申@[" + e.getMessage() + "]" );
			System.out.println( "?申��鐃�    [" + e.getDetailMessage() + "]" );
			System.out.println( "?申N?申?申?申X  [" + e.getClassName()  + "]" );
			System.out.println( "?申?申?申\?申b?申h[" + e.getMethodName() + "]" );
			e.printStackTrace();
		} catch( Aps2RuntimeException re ){
			System.out.println( "***** aps2jni ?申?申?申�?申?申?申?申^?申C?申?申?申��鐃�O?申?申?申?申?申?申?申?申?申��鐃�?申?申 *****" );
			System.out.println( "?申G?申?申?申[?申@[" + re.getMessage() + "]" );
			System.out.println( "?申��鐃�    [" + re.getDetailMessage() + "]" );
			System.out.println( "?申N?申?申?申X  [" + re.getClassName()  + "]" );
			System.out.println( "?申?申?申\?申b?申h[" + re.getMethodName() + "]" );
			re.printStackTrace();
		} catch( IOException ie) {
			System.out.println(ie);
			ie.printStackTrace();
		}
	}
}
