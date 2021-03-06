package kr.android.menu2;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
	
	String[] items ={"바나나", "딸기", "배", "멜론", "사과", "망고", "감", "땅콩", "호두", "밀감", "귤", "오렌지", "애플", "파인애플", "코코아"};
	
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		
		setListAdapter(adapter);
		
		//컨텍스트 메뉴를 연결할 View의 객체를 등록
		registerForContextMenu(getListView());
		
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
		
		//컨텍스트 메뉴 생성
		menu.setHeaderTitle("Divider 변경");
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.add(Menu.NONE, 1, Menu.NONE, "16px");
		menu.add(Menu.NONE, 2, Menu.NONE, "24px");
		menu.add(Menu.NONE, 3, Menu.NONE, "32px");
		menu.add(Menu.NONE, 4, Menu.NONE, "40px");
	}
	
	//컨텍스트 메뉴의 아이템을 클릭에 따른 이벤트 발생에 대한 처리
	@Override
	public boolean onContextItemSelected(MenuItem item){
		switch(item.getItemId()){
		case 1:
			getListView().setDividerHeight(16);
			return true;
		case 2:
			getListView().setDividerHeight(24);
			return true;
		case 3:
			getListView().setDividerHeight(32);
			return true;
		case 4:
			getListView().setDividerHeight(40);
			return true;		
		}
		
		return false;
	}
}
