package com.pop.factory;

import com.pop.utils.ReaderHelper;
import com.pop.utils.TextReader;
import com.pop.utils.TextWriter;
import com.pop.utils.WriterHelper;

public class InputOutputFactory {

	public static ReaderHelper getReaderInstance(String type){
		if(type.equalsIgnoreCase("text")){
			return new TextReader();
		}else{
			return null;
		}
	}
	
	public static WriterHelper getWriterInstance(String type){
		if(type.equalsIgnoreCase("text")){
			return new TextWriter();
		}else{
			return null;
		}
	}
}
