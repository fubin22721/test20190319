package jp.co.agrex;
/*
 * aps2jni?¿½?¿½?¿½C?¿½u?¿½?¿½?¿½?¿½ ?¿½Z?¿½?¿½?¿½R?¿½[?¿½h?¿½?¿½?¿½@?¿½\ ?¿½?¿½?¿½?¿½m?¿½F?¿½p?¿½v?¿½?¿½?¿½O?¿½?¿½?¿½?¿½
 * Copyright AGREX Inc. All Rights Recom.example.helloheroku/
package jp.co.agrex;

public class ConsoleTest {

	/*
	 * ?¿½T?¿½?¿½?¿½v?¿½?¿½?¿½v?¿½?¿½?¿½O?¿½?¿½?¿½?¿½?¿½?¿½?¿½?¿½?¿½s?¿½?¿½?¿½Ü‚ï¿½?¿½B
	 * ?¿½y?¿½?¿½?¿½?¿½?¿½zjava ConsoleTest 
	 */
	public static void main( String[] args ){
	
		System.out.println( "===== Console Test START =====" );{
		System.load("C:/Users/SJNKSADMIN/Desktop/AP-Converter(JNI)/APU734_JNI?¿½?¿½?¿½W?¿½?¿½?¿½[?¿½?¿½/lib/libaps2jni.so");
		System.out.println(System.getProperty("java.library.path"));
		Aps2JNICoderTest test = new Aps2JNICoderTest();
		test.start();
		System.out.println( "===== Console Test END =====" );
		
      }	
	}	
}	
