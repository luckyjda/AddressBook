package util;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class ResponseUtils {
	
	/**
	 * 后台返回JSON数据
	 * @param response
	 * @param map
	 */
	public static void responseJson(HttpServletResponse response, Map<String, String> map) {
		JSONObject json = new JSONObject();
		try {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				json.put(entry.getKey(), entry.getValue());
			}
			response.setHeader("Content-Length", String.valueOf(json.toString().getBytes("utf-8").length));
			response.setContentType("text/plain;charset=utf-8");
			response.getOutputStream().write(json.toString().getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
