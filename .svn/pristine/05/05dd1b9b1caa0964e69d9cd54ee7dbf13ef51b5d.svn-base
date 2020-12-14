package com.elsys.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class CsvHelper {
	
	public static void write(File file, List<Map<String, Object>> data, 
			List<Map<String, Object>> headers, String headerNmKey, String dataKey, boolean isFile) throws IOException, InvalidFormatException {
		
		FileWriter fw = new FileWriter(file.getPath(), true);
        BufferedWriter writer = new BufferedWriter(fw);
        
        PrintWriter pw = new PrintWriter(writer,true);
		
		//filewriter 한글 인코딩 문제로 다른걸로 교체
		//BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), "euc-kr"));
		
		/*// 제목 row
		if (!isFile) {
			for (int i = 0, size = headers.size(); i < size; i++) {
				Map<String, Object> header = headers.get(i);
				writer.append(String.valueOf(header.get(headerNmKey)));
				if(i+1 != size){
					writer.append(',');
				}
			}
			writer.newLine();
		}
		
		// 데이터 저장
		for (int i = 0, size = data.size(); i < size; i++) {
			Map<String, Object> d = data.get(i);
			
			for (int j = 0, size2 = headers.size(); j < size2; j++) {
				Map<String, Object> header = headers.get(j);
				writer.append(String.valueOf(d.get(header.get(dataKey))));
				if(j+1 != size2){
					writer.append(',');
				}
				if(j == (size2 - 1)){
					writer.newLine();
				}
			}
		}*/
		
        // 제목 row
        if (!isFile) {
              for (int i = 0, size = headers.size(); i < size; i++) {
                    Map<String, Object> header = headers.get(i);
                    pw.write(String.valueOf(header.get(headerNmKey)));
                    if(i+1 != size){
                          pw.write(',');
                    }
              }
              pw.println();
        }
        
        // 데이터 저장
        for (int i = 0, size = data.size(); i < size; i++) {
              Map<String, Object> d = data.get(i);
              
              for (int j = 0, size2 = headers.size(); j < size2; j++) {
                    Map<String, Object> header = headers.get(j);
                    pw.write(String.valueOf(d.get(header.get(dataKey))));
                    if(j+1 != size2){
                          pw.write(',');
                    }
                    if(j == (size2 - 1)){
                          pw.println();
                    }
              }
        }
        
        pw.flush();
        pw.close();
	}
}