package com.peihua.util;

import java.io.*;

public class OperatorObjectUtils {
    /**
     *
     * @param obj 传递的任意对象：
     * @return byte[] 字节数组
     */
    public static byte[] Object2Byte(Object obj){

        try {
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos= new ObjectOutputStream(byteOutputStream);
            oos.writeObject(obj);
            //获得byteOutputStream 内部维护的字节数组数据：
            byte[] bytes = byteOutputStream.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     *
     * @param bytes 传递的byte字节数组， 封装的字节数据
     * @return 返回的是任意的对象
     *
     */
    public static <T> T byte2Object(byte[] bytes,Class<T> clz){

        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream =new ObjectInputStream(byteArrayInputStream);
            T object = (T) objectInputStream.readObject();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
