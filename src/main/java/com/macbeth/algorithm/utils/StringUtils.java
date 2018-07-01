package com.macbeth.algorithm.utils;

import com.macbeth.algorithm.Constants;

/**
 * author:macbeth
 * Date:2018/6/21
 * Time:17:44
 **/
public class StringUtils {

    public static boolean isEmpty(Object target){
        if (target == null) return true;
        if ("".equals(trim(target.toString()))) return true;
        return false;
    }

    public static String trim(String target){
        return target.replaceAll("^\\s*|\\s*$","");
    }

    public static void quickSort(int[] arr, int left, int right){
        if (right - left <= 0)
            return;
        else {
            int partition = partitionInt(arr,left,right);
            quickSort(arr,left,partition - 1);
            quickSort(arr,partition + 1, right);
        }

    }
    // 划分算法，数组指定范围内最右边数作为枢纽值
    public static int partitionInt(int[] arr, int left, int right){
        int endIndex = right;
        int average = arr[right--];
        boolean leftFlag = true;
        boolean rightFlag = true;
        int partition;

        while (true){
            if (left == right){
                if (arr[left] > average){
                    partition = left;
                } else {
                    partition = left + 1;
                }
                swap(arr, partition, endIndex);
                break;
            }

            if (right - left == 1){
                if (arr[left] > average){
                    if (arr[right] > average){
                        partition = left;
                    }else {
                        partition = right;
                        swap(arr, right, left);
                    }
                } else {
                    if (arr[right] > average){
                        partition = right;
                    } else {
                        partition = right + 1;
                    }
                }
                swap(arr, partition, endIndex);
                break;
            }

            if (arr[left] > average){
                leftFlag = false;
            }
            if (arr[right] <= average){
                rightFlag = false;
            }

            if ((! leftFlag) && (! rightFlag)){
                swap(arr, left, right);
                leftFlag = true;
                rightFlag = true;
            }

            if (leftFlag)
                left++;
            if (rightFlag)
                right--;
        }
        return partition;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp;
        temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    // 希尔排序
    public static int[] shellSort(int[] arr){
        int length = arr.length;
        int h = length / 2;
        int temp;
        while (h > 0) {
            for (int i = 0; i < h; i++) {
                int n = i + h;
                while (n < length) {
                    for (int j = n; j >= h; j -= h) {
                        if (arr[j] < arr[j - h]) {
                            temp = arr[j];
                            arr[j] = arr[j - h];
                            arr[j - h] = temp;
                        } else {
                            break;
                        }
                    }
                    n += h;
                }
            }
            h /= 2;
        }
        return arr;
    }
    // 划分算法
    public static int divide(int[] arr, int average){
        int left = -1;
        int right = arr.length;
        boolean leftFlag = true;
        boolean rightFlag = true;
        int temp;
        int partition;
        while (true){
            if (leftFlag)
                left++;
            if (rightFlag)
                right--;
            if (left == right){
                if (arr[left] > average)
                    partition = left;
                else
                    partition = left + 1;
                break;
            }
            if (right - left == 1){
                if (arr[left] > average){
                    if (arr[right] > average)
                        partition = left;
                    else {
                        partition = right;
                        temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;
                    }
                    break;
                } else {
                    if (arr[right] > average)
                        partition = right;
                    else
                        partition = right + 1;
                    break;
                }
            }
            if (leftFlag && arr[left] > average)
                leftFlag = false;
            if (rightFlag && arr[right] <= average)
                rightFlag = false;
            if ((! leftFlag) && (! rightFlag)){
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                leftFlag = true;
                rightFlag = true;
            }
        }
        return partition;
    }

    public static String getSuffix(String url){
        String[] suffixes = Constants.IMG_FORMAT.split("\\|");
        String targetUpperCase = url.toUpperCase();
        for (String suffix : suffixes){
            if (! targetUpperCase.endsWith("." + suffix)) continue;
            return "." + suffix;
        }
        return null;
    }

    public static boolean isLegalSuffix(String url){
        String[] suffixes = Constants.IMG_FORMAT.split("\\|");
        String targetUpperCase = url.toUpperCase();
        for (String suffix : suffixes){
            if (! targetUpperCase.endsWith("." + suffix)) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String result = getSuffix("data/attachment/common/cf/130353deqq8zk6h4ehgqqp.gif");
        System.out.println(result);
    }
}























