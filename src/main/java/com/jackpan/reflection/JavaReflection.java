package com.jackpan.reflection;

import java.lang.reflect.*;
import java.util.List;

/**
 * @author jackpan
 * @version v1.0 2020/12/7 16:26
 */
public class JavaReflection {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        genericType();
    }

    private static void genericReturnType() throws NoSuchMethodException {
        Method method = Student.class.getMethod("getStringList");
        Type returnType = method.getGenericReturnType();

        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }

    private static void genericParameterTypes() throws NoSuchMethodException {
        Method method = Student.class.getMethod("setStringList", List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for(Type genericParameterType : genericParameterTypes){
            if(genericParameterType instanceof ParameterizedType){
                ParameterizedType aType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
                for(Type parameterArgType : parameterArgTypes){
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }
            }
        }
    }

    private static void genericType() throws NoSuchFieldException {
        Field field = Student.class.getField("stringList");
        Type genericFieldType = field.getGenericType();

        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for(Type fieldArgType : fieldArgTypes){
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
    }

}
