package com.annotation;

public class TestArr {

    public static int findlarge(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(result < arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr =  {1, 3, 5, 7};
        int[] arr1 =  {1, 3, 5, 6};
        int[] arr2 =  {2, 3, 6, 8};
        int[] arr3 =  {3, 5, 6, 8};

        int[] result = {findlarge(arr), findlarge(arr1), findlarge(arr2), findlarge(arr3)};

        System.out.println("args = [" + findlarge(result) + "]");

        int[][] all = {arr, arr1, arr2, arr3};



    }
}
