package jp.co.agrex;
/*
 * aps2jni?øΩ?øΩ?øΩC?øΩu?øΩ?øΩ?øΩ?øΩ ?øΩZ?øΩ?øΩ?øΩR?øΩ[?øΩh?øΩ?øΩ?øΩ@?øΩ\ ?øΩ?øΩ?øΩ?øΩm?øΩF?øΩp?øΩv?øΩ?øΩ?øΩO?øΩ?øΩ?øΩ?øΩ
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
	 * ?øΩR?øΩ?øΩ?øΩX?øΩg?øΩ?øΩ?øΩN?øΩ^?øΩF
	 */
	public Aps2JNICoderTest() {
	}
	
	public void start() {

		SystemInfo.printSystemInfo();
		
		String iniPath = "C:\\workspace\\testConv\\src\\jp\\co\\agrex\\ini\\aps2env.ini";
		
		System.out.println( "==================================" );
		System.out.println( " aps2jni?øΩ?øΩ?øΩC?øΩu?øΩ?øΩ?øΩ?øΩ ?øΩZ?øΩ?øΩ?øΩR?øΩ[?øΩh?øΩ?øΩ?øΩ@?øΩ\ ?øΩ?øΩ?øΩ?øΩm?øΩF?øΩv?øΩ?øΩ?øΩO?øΩ?øΩ?øΩ?øΩ " );
		System.out.println( "==================================" );
		
		try{

			// ?øΩP?øΩj?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩs?øΩ?øΩ?øΩ‹ÇÔøΩ?øΩB
			System.out.println( "********** pre(prologue) **********" );
			System.out.println( "  IniPath:[" + iniPath + "]" );
			Aps2Controller cont = new Aps2Controller();
			cont.prologue( iniPath );
			System.out.println( "prologue --> OK" );

			// ?øΩQ?øΩj?øΩW?øΩ?øΩ?øΩZ?øΩ?øΩ?øΩœäÔøΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩs?øΩ?øΩ?øΩ‹ÇÔøΩ?øΩB
			BufferedReader _rd = new BufferedReader(new InputStreamReader(System.in), 1);
			Aps2Coder _cd = new Aps2Coder();
			String target;

			for(;;) {
				System.out.println("-- ?øΩR?øΩ[?øΩh?øΩ?øΩ?øΩ?øΩ?øΩ?øΩZ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩÕÇÔøΩ?øΩƒÇÔøΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ --");
				System.out.println("(Q=Quit)");
				target = _rd.readLine();
				if(target.equals("Q") == true || target.equals("q") == true || target.equals("?øΩp") == true) {
					break;
				}
				if(target.equals("") == true) {
					continue;
				}

				Aps2StdCoderResult _stdresult = _cd.standardCoder(_cd.FUNC_MODE_ADDRESS,
																  _cd.FUNC_OPTION_NEW_MASTER,
    	                                      					  target, "", ""); 

				System.out.println( "");
				System.out.println( "?øΩy?øΩ?øΩ?øΩÕèZ?øΩ?øΩ:" + target + "?øΩz");
				System.out.println( " ----------  ?øΩœäÔøΩ?øΩ?øΩ?øΩ?øΩ  ----------" );
				System.out.println( " ?øΩR?øΩ[?øΩh             :[" + _stdresult.getCode() + "]" );
				System.out.println( " ?øΩX?øΩ÷î‘çÔøΩ           :[" + _stdresult.getZip() + "]" );
				System.out.println( " ?øΩJ?øΩi?øΩZ?øΩ?øΩ           :[" + _stdresult.getKana() + "]" );
				System.out.println( " ?øΩ?øΩ?øΩ?øΩ?øΩZ?øΩ?øΩ           :[" + _stdresult.getKanji() + "]" );
				System.out.println( " ?øΩ‚ë´?øΩZ?øΩ?øΩ           :[" + _stdresult.getRestAddress() + "]" );

				if(_stdresult.getNewMasterNo() != 0 &&
						_stdresult.getNewCodeFlag() == _stdresult.NEW_CODE_FLAG_GENZON) {

					Aps2MasterData _latest = _stdresult.getMasterData();

					System.out.println( " ----------  ?øΩ≈êV?øΩZ?øΩ?øΩ?øΩ?øΩ?øΩ  ----------" );
					System.out.println( " ?øΩR?øΩ[?øΩh             :[" + _latest.getCode() + "]" );
					System.out.println( " ?øΩX?øΩ÷î‘çÔøΩ           :[" + _latest.getZip() + "]" );
					System.out.println( " ?øΩJ?øΩi?øΩZ?øΩ?øΩ           :[" + _latest.getKana() + "]" );
					System.out.println( " ?øΩ?øΩ?øΩ?øΩ?øΩZ?øΩ?øΩ           :[" + _latest.getKanji() + "]" );
				}
				System.out.println("");
			}

			// ?øΩR?øΩj?øΩ?øΩn?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩs?øΩ?øΩ?øΩ‹ÇÔøΩ?øΩB
			System.out.println( "********** ?øΩ?øΩn?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ(epilogue) **********" );
			cont.epilogue( cont.CLEAN_MODE_NORMAL );
			System.out.println( "  epilogue --> OK" );

		} catch( Aps2Exception e ){
			System.out.println( "***** aps2jni ?øΩ?øΩ?øΩ≈óÔøΩO?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ‹ÇÔøΩ?øΩ?øΩ *****" );
			System.out.println( "?øΩG?øΩ?øΩ?øΩ[?øΩ@[" + e.getMessage() + "]" );
			System.out.println( "?øΩ⁄çÔøΩ    [" + e.getDetailMessage() + "]" );
			System.out.println( "?øΩN?øΩ?øΩ?øΩX  [" + e.getClassName()  + "]" );
			System.out.println( "?øΩ?øΩ?øΩ\?øΩb?øΩh[" + e.getMethodName() + "]" );
			e.printStackTrace();
		} catch( Aps2RuntimeException re ){
			System.out.println( "***** aps2jni ?øΩ?øΩ?øΩ≈?øΩ?øΩ?øΩ?øΩ^?øΩC?øΩ?øΩ?øΩÃóÔøΩO?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ?øΩ‹ÇÔøΩ?øΩ?øΩ *****" );
			System.out.println( "?øΩG?øΩ?øΩ?øΩ[?øΩ@[" + re.getMessage() + "]" );
			System.out.println( "?øΩ⁄çÔøΩ    [" + re.getDetailMessage() + "]" );
			System.out.println( "?øΩN?øΩ?øΩ?øΩX  [" + re.getClassName()  + "]" );
			System.out.println( "?øΩ?øΩ?øΩ\?øΩb?øΩh[" + re.getMethodName() + "]" );
			re.printStackTrace();
		} catch( IOException ie) {
			System.out.println(ie);
			ie.printStackTrace();
		}
	}
}
