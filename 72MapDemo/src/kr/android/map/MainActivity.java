package kr.android.map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends ActionBarActivity implements OnMarkerClickListener, OnInfoWindowClickListener{

	GoogleMap map;
	static final LatLng ADDRESS_GANGNAMSTATION = new LatLng(37.498155, 127.027642);
	static final LatLng ADDRESS_HANBIT = new LatLng(37.498908, 127.028226);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(map==null){
			map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
			if(map!=null){
				//�⺻ ��Ŀǥ��
				addBasicMarker();
				
				//ȭ�鿡 ������ ���� �浵 ǥ��
				CameraPosition cameraPosition = new CameraPosition.Builder().target(ADDRESS_GANGNAMSTATION).zoom(17).build();
				//�ʿ� ���ϴ� ��ġ ǥ��
				map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
				
				//�ʿ� �̺�Ʈ ����
				map.setOnMarkerClickListener(this);
				map.setOnInfoWindowClickListener(this);
				
				//���� ���� ��ġ �о����
				map.setMyLocationEnabled(true);
								
				//���� ���� ��ġ�� �̵��� �� �ִ� ������ ǥ��
				UiSettings uiSettings = map.getUiSettings();
				uiSettings.setMyLocationButtonEnabled(true);				
			}
		}		
	}
	
	//��Ŀ ǥ��
	private void addBasicMarker(){
		map.addMarker(new MarkerOptions().position(ADDRESS_GANGNAMSTATION).title("������").snippet("�� ����ö ž�ϴ�~").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
		//map.addMarker(new MarkerOptions().position(ADDRESS_HANBIT).title("�Ѻ�").snippet("���͵���~").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
		map.addMarker(new MarkerOptions().position(ADDRESS_HANBIT).title("�Ѻ�").snippet("���͵���~").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
	}

	@Override
	public boolean onMarkerClick(Marker m) {
			Toast.makeText(this, m.getTitle()+",��Ŀ Ŭ��", Toast.LENGTH_SHORT).show();
			
			//�̺�Ʈ�� ������ �����ؼ� ���� �ٸ� �̺�Ʈ �������� �������� false�� ����
			//true�����ϸ� ��Ŀ Ŭ���� �̺�Ʈ�� ó����
		return false;
	}

	@Override
	public void onInfoWindowClick(Marker m) {
			Toast.makeText(this, m.getTitle()+",��ǳ�� Ŭ��", Toast.LENGTH_SHORT).show();
	}
}