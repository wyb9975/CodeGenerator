import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        RNN rnn = new RNN(4, 1);
//        double[] task3 = {0.5, 0.5, 0.6, 0.6, 0.9};
//
//        ArrayList list3 = new ArrayList();
//        for (int i=0;i<task3.length;i++){
//            list3.add(task3[i]);
//        }
//        int count = 20000;
//        while(count>0) {
//            ArrayList list1 = new ArrayList();
//            double sum = 0;
//            for (int i=0;i<4;i++){
//                double t = Math.random();
//                sum+=t;
//                list1.add(t);
//            }
//            list1.add(sum/4.0);
//            //System.out.print(rnn.getV()+"\t");
//            rnn.train(list1);
//            count--;
//        }
//        rnn.getResult(list3);

        LSTM lstm = new LSTM(10,1,1);
        double[] task3 = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 0.55};

        ArrayList<ArrayList> data = new ArrayList();
        for (int i=0;i<task3.length;i++){
            ArrayList<Double> temp = new ArrayList();
            temp.add(task3[i]);
            data.add(temp);
        }

        ArrayList<ArrayList>[] lists = new ArrayList[4000];
        for (int i=0;i<4000;i++) {
            ArrayList<ArrayList> list1 = new ArrayList();
            double sum = 0;
            for (int j = 0; j < 10; j++) {
                double t = Math.random();
                sum += t;
                ArrayList<Double> temp = new ArrayList();
                temp.add(t);
                list1.add(temp);
            }
            ArrayList temp = new ArrayList();
            temp.add(sum/10.0);
            list1.add(temp);
            lists[i] = list1;
        }

        int count = 50;
        while(count>0) {

//            if (count%100==0)
//                System.out.print(lstm.getV()+"\t");
            for (ArrayList<ArrayList> arrayLists:lists)
                lstm.train(arrayLists);
            count--;
        }
        lstm.getResult(data);

    }
}
