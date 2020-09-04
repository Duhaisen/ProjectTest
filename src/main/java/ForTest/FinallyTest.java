package ForTest;

import java.util.ArrayList;

public class FinallyTest {


    int a = 0 ;
    String s = "ss";

    ArrayList list = new ArrayList();

    public int add(){
        try {
            a ++;
            return a;
        }finally {
            a++;
            return a;
        }
    }


    public String str(){
        try {
            s = "sss";
            return s;
        }finally {
            s = "ssssssssss";
        }
    }

    public ArrayList list(){
        try {
            s = "sss";
            list.add(s);
            return list;
        }finally {
            s = "ssssssssss";
            list.add(s);
        }
    }


    public static void main(String[] args){
        FinallyTest finallyTest = new FinallyTest();
        System.out.println(finallyTest.list());
        System.out.println(finallyTest.list);
    }
}
