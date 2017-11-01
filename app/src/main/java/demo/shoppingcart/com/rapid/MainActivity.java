package demo.shoppingcart.com.rapid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] a = {5, 3, 9, 8, 1, 4, 2, 7};
        int start = 0;
        int end = a.length - 1;
//        sort(a, start, end);
        rapid(a, start, end);
        for (int i = 0; i < a.length; i++) {
            Log.d("zzzzzz", a[i] + "");
        }
    }

    private void rapid(int[] a, int begin, int over) {
        int stat = begin;
        int end = over;
        int key = a[begin];


        while (end > stat) {

            while (end > stat && a[end] >= key)
                end--;
            if (key >= a[end]) {
                int temp = a[end];
                a[end] = a[stat];
                a[stat] = temp;
            }

            while (end > stat && a[stat] <= key)
                stat++;
            if (a[stat] >= key) {
                int temp = a[stat];
                a[stat] = a[end];
                a[end] = temp;
            }
        }
        LoG(a);
        if (stat > begin) rapid(a, begin, stat - 1);
        if (end < over) rapid(a, end + 1, over);

    }


    public void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];


        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        LoG(a);
        //递归
        if (start > low) sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
    }

    private void LoG(int[] a) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            stringBuilder.append(a[i] + "");
        }

        Log.d("zzzzzz", stringBuilder.toString());
    }

}


