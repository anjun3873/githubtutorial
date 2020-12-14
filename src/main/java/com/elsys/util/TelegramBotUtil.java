package com.elsys.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 텔레그램 봇을 이용해서 특정 채널에 메시지를 전송한다.
 * @author pkw
 * 필요사항
 * api키 , 챗아이디 
 * 1. Botfather를 통해서 봇생성하고 api키 발급
 * 2.생성된봇채널에 https://api.telegram.org/bot[api키]/getUpdates 전송해서 봇을 활성화함 
 *
 * 3.별도의 업무용 채널을 생성하고 채널관리메뉴에서 만들어진 봇을 관리자로 추가함.
 * 업무용 채널에서는 봇이 관리자로 있는한 메세지를 계속 넘겨받을 수있다.
 */
public class TelegramBotUtil {

	Logger log = LoggerFactory.getLogger("텔레그램메세지전송");

	/**
	 * 봇에게 메세지를 전달.
	 * @param msgText
	 * @throws Exception
	 */
	public void sendMsg( String apiKey,
						 String chatId,	
						 String msgText
					   )throws Exception {
	
		try {
			
			String baseString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
			String urlString = String.format(baseString, apiKey, chatId, URLEncoder.encode(msgText, "UTF-8"));

			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
	
			StringBuilder sb = new StringBuilder();
			InputStream is = new BufferedInputStream(conn.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String inputLine = "";
			
			while ((inputLine = br.readLine()) != null) {
			    sb.append(inputLine);
			}
			String response = sb.toString();
			// TODO : 응답 메시지가 에러인 경우 대응
			log.info(response);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("알 수 없는 이유로 텔레그램 메세지전송에 실패하였습니다.");
		}
		
	}
	
	
	

}
