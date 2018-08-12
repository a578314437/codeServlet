package cn.lixing.code.servlet;
import static cn.lixing.code.servlet.Uilts.PropertiesFileUilt.getData;
import static cn.lixing.code.servlet.Uilts.SelectDbUilts.*;
public class CodeObject {
	private String srcUrl;
	private String textUrl;
	
	private String custPersionCode;
	private String keyPersionCode;
	private String devicesCode;
	private String unactivatedCode;
	
	private String custPersionCodeUrl;
	private String keyPersionCodeUrl;
	private String devicesCodeUrl;
	private String unactivatedCodeUrl;
	
	private String custUrl;
	private String keyPersiontUrl;
	private String devicesUrl;
	private String unactivatedUrl;
	
	
	public String getCustPersionCode() {
		custPersionCode=decrypteQpcodeData(0);
		return custPersionCode;
	}
	public void setCustPersionCode(String custPersionCode) {
		this.custPersionCode = custPersionCode;
	}
	public String getKeyPersionCode() {
		keyPersionCode=decrypteQpcodeData(1);
		return keyPersionCode;
	}
	public void setKeyPersionCode(String keyPersionCode) {
		this.keyPersionCode = keyPersionCode;
	}
	public String getDevicesCode() {
		devicesCode=decrypteQpcodeData(2);
		return devicesCode;
	}
	public void setDevicesCode(String devicesCode) {
		this.devicesCode = devicesCode;
	}
	public String getUnactivatedCode() {
		unactivatedCode=decrypteQpcodeData(5);
		return unactivatedCode;
	}
	public void setUnactivatedCode(String unactivatedCode) {
		this.unactivatedCode =unactivatedCode ;
	}
	public String getCustPersionCodeUrl() {
		custPersionCodeUrl=getSrcUrl()+"?text="+getTextUrl()+getCustPersionCode();
		return custPersionCodeUrl;
	}
	public void setCustPersionCodeUrl(String custPersionCodeUrl) {
		this.custPersionCodeUrl = custPersionCodeUrl;
	}
	public String getKeyPersionCodeUrl() {
		keyPersionCodeUrl=getSrcUrl()+"?text="+getTextUrl()+getKeyPersionCode();
		return keyPersionCodeUrl;
	}
	public void setKeyPersionCodeUrl(String keyPersionCodeUrl) {
		this.keyPersionCodeUrl = keyPersionCodeUrl;
	}
	public String getDevicesCodeUrl() {
		devicesCodeUrl=getSrcUrl()+"?text="+getTextUrl()+getDevicesCode();
		return devicesCodeUrl;
	}
	public void setDevicesCodeUrl(String devicesCodeUrl) {
		this.devicesCodeUrl = devicesCodeUrl;
	}
	public String getUnactivatedCodeUrl() {
		unactivatedCodeUrl=getSrcUrl()+"?text="+getTextUrl()+getUnactivatedCode();
		return unactivatedCodeUrl;
	}
	public void setUnactivatedCodeUrl(String unactivatedCodeUrl) {
		this.unactivatedCodeUrl = unactivatedCodeUrl;
	}
	public String getCustUrl() {
		custUrl="custPersionCode.jsp?src="+getCustPersionCodeUrl();
		return custUrl;
	}
	public void setCustUrl(String custUrl) {
		this.custUrl = custUrl;
	}
	public String getKeyPersiontUrl() {
		keyPersiontUrl="keyPersionCode.jsp?src="+getKeyPersionCodeUrl();
		return keyPersiontUrl;
	}
	public void setKeyPersiontUrl(String keyPersiontUrl) {
		this.keyPersiontUrl = keyPersiontUrl;
	}
	public String getDevicesUrl() {
		devicesUrl="devicesCode.jsp?src="+getDevicesCodeUrl();
		return devicesUrl;
	}
	public void setDevicesUrl(String devicesUrl) {
		this.devicesUrl = devicesUrl;
	}
	public String getUnactivatedUrl() {
		unactivatedUrl="unactivatedCode.jsp?src="+getUnactivatedCodeUrl();
		return unactivatedUrl;
	}
	public String getSrcUrl() {
		srcUrl="http://qr.liantu.com/api.php";
		return srcUrl;
	}
	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}
	public String getTextUrl() {
		textUrl=getData("textUrl", System.getProperty("file.separator")+"configFile"+System.getProperty("file.separator")+"http");
		return textUrl;
	}
	public void setTextUrl(String textUrl) {
		this.textUrl = textUrl;
	}
	public void setUnactivatedUrl(String unactivatedUrl) {
		this.unactivatedUrl = unactivatedUrl;
	}
}
