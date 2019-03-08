package com.example.helloheroku;
/*
 * aps2jniライブラリ 住所コード化機能 動作確認用プログラム
 * Copyright AGREX Inc. All Rights Reserved.
 */

import java.lang.*;

import ch.qos.logback.core.util.SystemInfo;

import java.io.*;

import jp.co.agrex.aps2jni.*;

public class Aps2JNICoderTest {

	/**
	 * コンストラクタ：
	 */
	public Aps2JNICoderTest() {
	}

	/**
	 * テストプログラムの実行。
	 * このプログラムでは，以下の処理を実行します。
	 *   １）準備処理(prologue)
	 * 　２）標準住所変換処理(standardCoder)
	 *   ３）後始末処理(epilogue)
	 *
	 */
	public void start() {

		//// 動作環境情報の表示
		//SystemInfo.printSystemInfo();
		
		//// 環境設定ファイル
		String iniPath = "../ini/aps2env.ini";
		
		System.out.println( "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■" );
		System.out.println( "■　　　　　　　　　　　　　　　　　　　　　　　　　　　　　■" );
		System.out.println( "■　aps2jniライブラリ 住所コード化機能 動作確認プログラム 　■" );
		System.out.println( "■　　　　　　　　　　　　　　　　　　　　　　　　　　　　　■" );
		System.out.println( "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■" );
		
		try{

			// １）準備処理を実行します。
			System.out.println( "********** 準備処理(prologue) **********" );
			System.out.println( "  IniPath:[" + iniPath + "]" );
			Aps2Controller cont = new Aps2Controller();
			cont.prologue( iniPath );
			System.out.println( "  prologue --> OK" );

			// ２）標準住所変換処理を行います。
			BufferedReader _rd = new BufferedReader(new InputStreamReader(System.in), 1);
			Aps2Coder _cd = new Aps2Coder();
			String target;

			for(;;) {
				System.out.println("-- コード化する住所文字列を入力してください --");
				System.out.println("(Q=Quit)");
				target = _rd.readLine();
				if(target.equals("Q") == true || target.equals("q") == true || target.equals("Ｑ") == true) {
					break;
				}
				if(target.equals("") == true) {
					continue;
				}

				/* 標準住所変換処理 */
				Aps2StdCoderResult _stdresult = _cd.standardCoder(_cd.FUNC_MODE_ADDRESS,
																  _cd.FUNC_OPTION_NEW_MASTER,
    	                                      					  target, "", ""); 

				// 変換結果情報の表示
				System.out.println( "");
				System.out.println( "【入力住所:" + target + "】");
				System.out.println( " ----------  変換結果  ----------" );
				System.out.println( " コード             :[" + _stdresult.getCode() + "]" );
				System.out.println( " 郵便番号           :[" + _stdresult.getZip() + "]" );
				System.out.println( " カナ住所           :[" + _stdresult.getKana() + "]" );
				System.out.println( " 漢字住所           :[" + _stdresult.getKanji() + "]" );
				System.out.println( " 補足住所           :[" + _stdresult.getRestAddress() + "]" );

				// 継承先の最新住所がある場合にその住所情報を取得する
				if(_stdresult.getNewMasterNo() != 0 &&
						_stdresult.getNewCodeFlag() == _stdresult.NEW_CODE_FLAG_GENZON) {

					Aps2MasterData _latest = _stdresult.getMasterData();

					// 最新住所情報の表示
					System.out.println( " ----------  最新住所情報  ----------" );
					System.out.println( " コード             :[" + _latest.getCode() + "]" );
					System.out.println( " 郵便番号           :[" + _latest.getZip() + "]" );
					System.out.println( " カナ住所           :[" + _latest.getKana() + "]" );
					System.out.println( " 漢字住所           :[" + _latest.getKanji() + "]" );
				}
				System.out.println("");
			}

			// ３）後始末処理を行います。
			System.out.println( "********** 後始末処理(epilogue) **********" );
			cont.epilogue( cont.CLEAN_MODE_NORMAL );
			System.out.println( "  epilogue --> OK" );

		} catch( Aps2Exception e ){
			System.out.println( "***** aps2jni 内で例外が発生しました *****" );
			System.out.println( "エラー　[" + e.getMessage() + "]" );
			System.out.println( "詳細    [" + e.getDetailMessage() + "]" );
			System.out.println( "クラス  [" + e.getClassName()  + "]" );
			System.out.println( "メソッド[" + e.getMethodName() + "]" );
			e.printStackTrace();
		} catch( Aps2RuntimeException re ){
			System.out.println( "***** aps2jni 内でランタイムの例外が発生しました *****" );
			System.out.println( "エラー　[" + re.getMessage() + "]" );
			System.out.println( "詳細    [" + re.getDetailMessage() + "]" );
			System.out.println( "クラス  [" + re.getClassName()  + "]" );
			System.out.println( "メソッド[" + re.getMethodName() + "]" );
			re.printStackTrace();
		} catch( IOException ie) {
			System.out.println(ie);
			ie.printStackTrace();
		}
	}
}
