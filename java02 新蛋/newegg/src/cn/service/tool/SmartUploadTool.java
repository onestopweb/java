package cn.service.tool;
import java.text.SimpleDateFormat ;
import java.util.Random ;
import java.util.Date ;

//年月日时分秒毫秒三位随机数
public class SmartUploadTool {
	private SimpleDateFormat sdf = null ;
	private String ip = null ;
	public SmartUploadTool(){
	}
	public SmartUploadTool(String ip){
		this.ip = ip ;
	}
	public SimpleDateFormat getSdf() {
		return sdf;
	}
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIPTimeRand(){
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getTimeStamp()) ;
		Random r = new Random() ;
		for(int i=0;i<3;i++){
			buf.append(r.nextInt(10)) ;
		}
		return buf.toString() ;
	}
	public String getDate(){
		this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
		return this.sdf.format(new Date()) ;
	}
	public String getTimeStamp(){
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS") ;
		return this.sdf.format(new Date()) ;
	}
	public static void main(String args[]){
		System.out.println(new SmartUploadTool("192.168.1.1").getIPTimeRand()) ;
	}
}