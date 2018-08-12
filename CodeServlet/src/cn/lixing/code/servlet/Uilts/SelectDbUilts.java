package cn.lixing.code.servlet.Uilts;

import static cn.lixing.code.servlet.Uilts.PropertiesFileUilt.*;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
public class SelectDbUilts {
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName(getData("device", System.getProperty("file.separator")+"configFile"+System.getProperty("file.separator")+"jdbc"));
			connection=DriverManager.getConnection(
					getData("url", System.getProperty("file.separator")+"configFile"+System.getProperty("file.separator")+"jdbc"), 
					getData("username", System.getProperty("file.separator")+"configFile"+System.getProperty("file.separator")+"jdbc"), 
					getData("password", System.getProperty("file.separator")+"configFile"+System.getProperty("file.separator")+"jdbc"));
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 
	 * @param TableName
	 * @param colValues
	 * @param status
	 * @return String[][]
	 */
	public static String[][] selectQpcode(String TableName,String[]colValues,int type,String colName) {
		Connection connection;
		String sql;
		String colValueStr;
		PreparedStatement pmt;
		List<String>colValueslist=new ArrayList<>();
		ResultSet result;
		String qpcodeValue;
		String[][] qpcodeValues = null;
		List<String>qpcodeValuesList=new ArrayList<>();
		connection=getConnection();
		for(String colValue:colValues) {
			colValueslist.add(colValue);
		}
		colValueStr=colValueslist.toString().replace("[", "").replace("]", "");
		try {
			if(type==1||type==2||type==0) {
				sql="select * FROM(select "+colValueStr+" from "+TableName+" WHERE type=? ORDER BY QRCODE_ID DESC) WHERE ROWNUM<=1";
				pmt=connection.prepareStatement(sql);
				pmt.setInt(1, type);
				result=pmt.executeQuery();
				while(result.next()) {
					qpcodeValue=result.getString("QRCODE");
					if(qpcodeValue.endsWith("==")) {
						qpcodeValuesList.add(qpcodeValue);
					}
					
				}
			}else {
				sql="select * FROM(select "+colValueStr+" from "+TableName+" WHERE type is null ORDER BY QRCODE_ID DESC) WHERE ROWNUM<=1";
				pmt=connection.prepareStatement(sql);
				result=pmt.executeQuery();
				while(result.next()) {
					qpcodeValue=result.getString("QRCODE");
					if(qpcodeValue.endsWith("==")) {
						qpcodeValuesList.add(qpcodeValue);
					}
					
				}
			}
		qpcodeValues=new String[qpcodeValuesList.size()][1];
		for(int i=0;i<qpcodeValuesList.size();i++){
			for(int j=0;j<qpcodeValues.length;j++) {
				qpcodeValues[i][j]=qpcodeValuesList.get(i);
			}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return qpcodeValues;
	}
	
	/**
	 * 
	 * @param status 
	 * @return
	 */
	public static String decrypteQpcodeData(int type) {
		OkHttpClient client = new OkHttpClient();
		JsonParser parser=new JsonParser();
		String decrypteQpcode;
		String[][] qpcodeValues=selectQpcode("TB_PQ_QRCODE",new String[] {"QRCODE"},type,"QRCODE");
		
		String[][] decrypteQpcodes = new String[qpcodeValues.length][1];
		
		for(int i=0;i<qpcodeValues.length;i++) {
			MediaType mediaType = MediaType.parse(getData("Content-Type", System.getProperty("file.separator")+"configFile"+System.getProperty("file.separator")+"http"));
			RequestBody body = RequestBody.create(mediaType, "{\"data\":{\"deText\":\""+qpcodeValues[i][0]+"\",\"key\":\"023\"}}");
			Request request = new Request.Builder()
			  .url(getData("url", System.getProperty("file.separator")+"configFile"+System.getProperty("file.separator")+"http"))
			  .post(body)
			  .addHeader("cache-control", "no-cache")
			  .addHeader("postman-token", "9c51adc7-ebf3-62de-4718-7a4527d2738c")
			  .build();

			Response response;
			try {
				response = client.newCall(request).execute();
				JsonObject obj=(JsonObject) parser.parse(response.body().string());
				decrypteQpcode=obj.get("repBody").getAsString();
				decrypteQpcodes[i][0]=decrypteQpcode;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return decrypteQpcodes[0][0];
	}
}
