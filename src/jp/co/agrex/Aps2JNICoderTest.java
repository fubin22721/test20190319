package jp.co.agrex;
/*
 * aps2jni?��?��?��C?��u?��?��?��?�� ?��Z?��?��?��R?��[?��h?��?��?��@?��\ ?��?��?��?��m?��F?��p?��v?��?��?��O?��?��?��?��
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
	 * ?��R?��?��?��X?��g?��?��?��N?��^?��F
	 */
	public Aps2JNICoderTest() {
	}
	
	public void start() {

		SystemInfo.printSystemInfo();
		
		String iniPath = "C:\\workspace\\testConv\\src\\jp\\co\\agrex\\ini\\aps2env.ini";
		
		System.out.println( "==================================" );
		System.out.println( " aps2jni?��?��?��C?��u?��?��?��?�� ?��Z?��?��?��R?��[?��h?��?��?��@?��\ ?��?��?��?��m?��F?��v?��?��?��O?��?��?��?�� " );
		System.out.println( "==================================" );
		
		try{

			// ?��P?��j?��?��?��?��?��?��?��?��?��?��?��?��?��s?��?��?��܂�?��B
			System.out.println( "********** pre(prologue) **********" );
			System.out.println( "  IniPath:[" + iniPath + "]" );
			Aps2Controller cont = new Aps2Controller();
			cont.prologue( iniPath );
			System.out.println( "prologue --> OK" );

			// ?��Q?��j?��W?��?��?��Z?��?��?��ϊ�?��?��?��?��?��?��?��s?��?��?��܂�?��B
			BufferedReader _rd = new BufferedReader(new InputStreamReader(System.in), 1);
			Aps2Coder _cd = new Aps2Coder();
			String target;

			for(;;) {
				System.out.println("-- ?��R?��[?��h?��?��?��?��?��?��Z?��?��?��?��?��?��?��?��?��?��?��͂�?��Ă�?��?��?��?��?��?�� --");
				System.out.println("(Q=Quit)");
				target = _rd.readLine();
				if(target.equals("Q") == true || target.equals("q") == true || target.equals("?��p") == true) {
					break;
				}
				if(target.equals("") == true) {
					continue;
				}

				Aps2StdCoderResult _stdresult = _cd.standardCoder(_cd.FUNC_MODE_ADDRESS,
																  _cd.FUNC_OPTION_NEW_MASTER,
    	                                      					  target, "", ""); 

				System.out.println( "");
				System.out.println( "?��y?��?��?��͏Z?��?��:" + target + "?��z");
				System.out.println( " ----------  ?��ϊ�?��?��?��?��  ----------" );
				System.out.println( " ?��R?��[?��h             :[" + _stdresult.getCode() + "]" );
				System.out.println( " ?��X?��֔ԍ�           :[" + _stdresult.getZip() + "]" );
				System.out.println( " ?��J?��i?��Z?��?��           :[" + _stdresult.getKana() + "]" );
				System.out.println( " ?��?��?��?��?��Z?��?��           :[" + _stdresult.getKanji() + "]" );
				System.out.println( " ?��⑫?��Z?��?��           :[" + _stdresult.getRestAddress() + "]" );

				if(_stdresult.getNewMasterNo() != 0 &&
						_stdresult.getNewCodeFlag() == _stdresult.NEW_CODE_FLAG_GENZON) {

					Aps2MasterData _latest = _stdresult.getMasterData();

					System.out.println( " ----------  ?��ŐV?��Z?��?��?��?��?��  ----------" );
					System.out.println( " ?��R?��[?��h             :[" + _latest.getCode() + "]" );
					System.out.println( " ?��X?��֔ԍ�           :[" + _latest.getZip() + "]" );
					System.out.println( " ?��J?��i?��Z?��?��           :[" + _latest.getKana() + "]" );
					System.out.println( " ?��?��?��?��?��Z?��?��           :[" + _latest.getKanji() + "]" );
				}
				System.out.println("");
			}

			// ?��R?��j?��?��n?��?��?��?��?��?��?��?��?��s?��?��?��܂�?��B
			System.out.println( "********** ?��?��n?��?��?��?��?��?��(epilogue) **********" );
			cont.epilogue( cont.CLEAN_MODE_NORMAL );
			System.out.println( "  epilogue --> OK" );

		} catch( Aps2Exception e ){
			System.out.println( "***** aps2jni ?��?��?��ŗ�O?��?��?��?��?��?��?��?��?��܂�?��?�� *****" );
			System.out.println( "?��G?��?��?��[?��@[" + e.getMessage() + "]" );
			System.out.println( "?��ڍ�    [" + e.getDetailMessage() + "]" );
			System.out.println( "?��N?��?��?��X  [" + e.getClassName()  + "]" );
			System.out.println( "?��?��?��\?��b?��h[" + e.getMethodName() + "]" );
			e.printStackTrace();
		} catch( Aps2RuntimeException re ){
			System.out.println( "***** aps2jni ?��?��?���?��?��?��?��^?��C?��?��?��̗�O?��?��?��?��?��?��?��?��?��܂�?��?�� *****" );
			System.out.println( "?��G?��?��?��[?��@[" + re.getMessage() + "]" );
			System.out.println( "?��ڍ�    [" + re.getDetailMessage() + "]" );
			System.out.println( "?��N?��?��?��X  [" + re.getClassName()  + "]" );
			System.out.println( "?��?��?��\?��b?��h[" + re.getMethodName() + "]" );
			re.printStackTrace();
		} catch( IOException ie) {
			System.out.println(ie);
			ie.printStackTrace();
		}
	}
}
