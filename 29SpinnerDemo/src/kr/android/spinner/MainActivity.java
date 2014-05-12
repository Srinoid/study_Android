/* Spinner
 * 
 * Spinner�� �θ� AdapterView
 * 
*/
package kr.android.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
	
	Spinner spinner;
	TextView myTextView;
	String[] items = {"�츮����", "�̱�", "����", "�Ϻ�", "������ī", "������", "����Ʈ���ϸ���", "ĥ��", "������", "����", "��������", "�߱�", "�Ϻ�", "����", "ȫ��", "��۶󵥽�", "�ε�", "�˷���ī"};
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myTextView = (TextView)findViewById(R.id.tvView);
		spinner = (Spinner)findViewById(R.id.spContry);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		
		//��Ӵٿ� ȭ�鿡 ǥ���� ���ҽ� ����
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//Spinner�� ArrayAdapter�� ���
		spinner.setAdapter(adapter);
		
		//�̺�Ʈ �ҽ��� �̺�Ʈ ������ ����
		spinner.setOnItemSelectedListener(this);
	}

	//AdapterView<?>: �̺�Ʈ�� �߻��� spinner��ü
	//View: �̺�Ʈ�� �߻��� View(������ ����)
	//int: ��ġ��
	//long: position ���� ��ġ, DB���� ����ɼ� ����(primary key��)
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// 
		myTextView.setText(items[position]);
		
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		myTextView.setText("");
		
	}
}
