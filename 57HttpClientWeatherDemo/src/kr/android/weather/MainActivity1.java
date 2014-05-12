package kr.android.weather;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity1 extends Activity {
	//���û ���� ����
	static final String WEATHER_URL ="http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
	static final String TAG="HttpClientWeatherDemo";
	
	WebView wvView;
	ArrayList<ForeCast> arrayList = new ArrayList<ForeCast>();
	ProgressBar progressBar;
	
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		wvView = (WebView)findViewById(R.id.wvView);
		progressBar = (ProgressBar)findViewById(R.id.pbProgress);
		
		
		updateForeCast();
	}
	
	//������ �����ؼ� XML������ ��û
	public InputStream getStreamFromURL(){
		InputStream input = null;
		
		try{
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(WEATHER_URL);
			
			//������ ���� ��ü
			HttpResponse httpResponse = (HttpResponse)httpClient.execute(httpGet);
			
			//���� ���� ó��
			HttpEntity httpEntity = httpResponse.getEntity();
			BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(httpEntity);
			input = bufferedHttpEntity.getContent();
			
		}catch(Exception e){
			Log.e(TAG, "���� ����", e);
			
		}
		
		return input;
	}
	
	//������ ȣ��
	public void updateForeCast(){
		//ProgressBar�� �������� ó��
		progressBar.setVisibility(View.VISIBLE);
		
		new Thread(){
			@Override
			public void run(){
				buildForeCastsbyDOM(getStreamFromURL());
				
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						
						String page = generatePage();
						
						wvView.loadDataWithBaseURL(null, page, "text/html", "UTF-8", null);
						//Toast.makeText(MainActivity.this, "����", Toast.LENGTH_SHORT).show();
						//ProgressBar �� �������� ó��
						progressBar.setVisibility(View.GONE);						
					}
				});
				
			}
		}.start();
	}
	
	//XML������ DOMƮ���� �����ؼ� �Ľ�
	public void buildForeCastsbyDOM(InputStream input){
		
		try{
			//DOM �ļ� ����
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			
			//DOM tree ����
			Document doc = builder.newDocument();
			
			NodeList weather = doc.getElementsByTagName("local");
			
			for(int i=0; i< weather.getLength();i++){
				//import org.w3c.dom.Element;
				Element local = (Element)weather.item(i);
				
				ForeCast forecast = new ForeCast();
				//����
				forecast.local = local.getFirstChild().getNodeValue();
				//����
				forecast.desc = local.getAttribute("desc");
				//�µ�
				forecast.ta = local.getAttribute("ta");			
				
				arrayList.add(forecast);
						
			}						
			
		}catch(Exception e){
			Log.e(TAG, "�Ľ� ����", e);
		}		
	}
	
	//UI�۾�(�����͸� ǥ���ϱ� ���� HTML)
	public String generatePage(){	
		
		StringBuffer result = new StringBuffer("<html><body><table width=100%>");
		result.append("<tr><th width=30%>����</th>");
			result.append("<th width=50%>����</th>");
			result.append("<th width=20%>�µ�</th></tr>");
		
			for(ForeCast foreCast: arrayList){
				result.append("<tr><td align=center>");
				result.append(foreCast.local);
				result.append("</td><td align=center>");
				result.append(foreCast.desc);
				result.append("</td><td align=center>");
				result.append(foreCast.ta);
				result.append("</td></tr>");
			}
		result.append("</table></body></html>");
		
		
		return result.toString();
	}
	
	//��������(����, ����, �µ�)�� ������ Ŭ���� ��ü ����
	class ForeCast{
		String local;
		String desc;
		String ta;
		
		public ForeCast(){}
		
		public ForeCast(String local, String desc, String ta){
			this.local = local;
			this.desc = desc;
			this.ta = ta;
		}
	}	
}
