package jp.co.agrex;
/*
 * aps2jni?��?��?��C?��u?��?��?��?�� ?��Z?��?��?��R?��[?��h?��?��?��@?��\ ?��?��?��?��m?��F?��p?��v?��?��?��O?��?��?��?��
 * Copyright AGREX Inc. All Rights Recom.example.helloheroku/
package jp.co.agrex;

public class ConsoleTest {

	/*
	 * ?��T?��?��?��v?��?��?��v?��?��?��O?��?��?��?��?��?��?��?��?��s?��?��?��܂�?��B
	 * ?��y?��?��?��?��?��zjava ConsoleTest 
	 */
	public static void main( String[] args ){
	
		System.out.println( "===== Console Test START =====" );{
		System.load("C:/Users/SJNKSADMIN/Desktop/AP-Converter(JNI)/APU734_JNI?��?��?��W?��?��?��[?��?��/lib/libaps2jni.so");
		System.out.println(System.getProperty("java.library.path"));
		Aps2JNICoderTest test = new Aps2JNICoderTest();
		test.start();
		System.out.println( "===== Console Test END =====" );
		
      }	
	}	
}	
