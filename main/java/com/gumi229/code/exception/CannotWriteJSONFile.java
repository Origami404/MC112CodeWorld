package com.gumi229.code.exception;

import java.io.IOException;

/**
 * It'll throws when a JSONWriter CAN NOT write the file to disk You can get
 * more information by Exception.message() method, including WriterType and the
 * name of JSON file
 * 
 * @author gumi229
 *
 */
public class CannotWriteJSONFile extends IOException {
	public CannotWriteJSONFile(String writeTypeIn, String fileName) {
		super("Can not write the JSON file with " + writeTypeIn + " in : " + fileName);
	}
}
