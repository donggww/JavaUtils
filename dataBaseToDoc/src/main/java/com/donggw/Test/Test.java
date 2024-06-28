package com.donggw.Test;

public class Test {

	public static void main(String[] args) {
		String adaptorConfig = "CNAPSMQAdaptor_TO_MBFEA-MSGMBFE_1";
		String mqAdaptorPrefix = "CNAPSMQAdaptor_TO_";
		System.out.println(adaptorConfig.replaceFirst(mqAdaptorPrefix,""));
	}
}
