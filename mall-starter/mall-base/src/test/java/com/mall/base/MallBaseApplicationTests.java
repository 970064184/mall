package com.mall.base;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallBaseApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int sum = getSum(4);
        System.out.println(sum);
        int factorial = getFactorial(5);
        System.out.println(factorial);
    }

    /**
     *  用递归的方法，计算1~100之间所有自然数的和
     * @param n
     * @return
     */
    public static int getSum(int n){
        if(1 == n ){
           return 1;
        }else{
           return  n + getSum(n - 1);
        }
    }

    /**
     * 用递归的方法，计算1~100 阶乘
     * 4*3*2*1
     */
    public static int getFactorial(int n){
        if(1 == n){
            return 1;
        }else{
            return n * getFactorial(n - 1);
        }
    }


}
