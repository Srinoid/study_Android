/* ���� view��ü �߰��ϱ� - �������

setContentView(R.layout.activity_main); layout ��� ���ϰ� 
���� �ڹٹ������ �ڵ�
���ظ� ���� �ڵ�, ���� ���� ���� ������� �ڵ�

*/
package kr.android.text;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //���ڸ� ǥ���� �� �ִ� TextView��ü ����
        TextView tv = new TextView(this);
        
        //���� �Է�
        tv.setText("�ؽ�Ʈ ���� �Է�");
        
        //Activity�� View���
        setContentView(tv);       
    } 
}
