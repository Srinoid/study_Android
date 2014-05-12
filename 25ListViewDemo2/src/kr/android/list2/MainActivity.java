package kr.android.list2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	//���� ����
	ArrayList<String> todoItems;
	ArrayAdapter<String> adapter;
	ListView myListView;
	EditText myEditText;
	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//�ش簴ü�� ������ ��ȯ
		myListView = (ListView)findViewById(R.id.lvList);
		myEditText = (EditText)findViewById(R.id.etText);
		button = (Button)findViewById(R.id.btnAdd);
		
		//������ ����� ����
		todoItems = new ArrayList<String>();
		//������� �����͸� ListView�� �����ϴ� ������ �ϴ� adapter��ü ����
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
		//ListView�� ArrayAdapter���
		myListView.setAdapter(adapter);
		
		//�̺�Ʈ �ҽ��� �̺�Ʈ ������ ���� (�͸� ���� Ŭ����)
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//�Է��� ������ ����
				//Editable -> String
				//�ε��� 0�� �����͸� �Է��ؼ� �ֱٱ��� ���� �ö������ �Ķ���� ����
				todoItems.add(0, myEditText.getText().toString());
				
				//ListView���� ������ �����ؼ� ���� ��ϵ� ������ �о����
				adapter.notifyDataSetChanged();
				//����� �Ϸ�� �� EditText �ʱ�ȭ
				myEditText.setText("");			
				
			}
		});		
	}
}
