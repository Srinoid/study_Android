/* ImageView

- �ڵ����� ��,ȸ���� ������

pride.jpg
������ ���ڸ� ���, �ҹ��ڸ� ���(������ �����ϰ� �ϱ� ����)

pride.jpg
pride.png
�ȵ���̵�� pride�θ� ����� ����ϰ� �Ǿ� jpg�� png�� �������� ���� �浹�ϰԵ�
pride1.jpg
pride2.png
���·� ���ϸ��� ������ �־�� ��

������ R class ȣ�� ���:
java: 	R.drawable.pride
xml:	@drawable/pride

*/
package kr.android.image;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }
}