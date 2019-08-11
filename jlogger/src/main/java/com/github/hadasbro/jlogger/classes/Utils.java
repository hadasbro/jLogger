package com.github.hadasbro.jlogger.classes;

import java.lang.reflect.Field;

/**
 * Utils
 */
@SuppressWarnings("unused")
public abstract class Utils {

    /**
     * getField
     *
     * get object/class field via Reflection
     *
     * @param cls -
     * @param fieldName -
     * @return Field
     */
    public static Field getField(Class<?> cls, String fieldName) {

        for (Class<?> c = cls; c != null; c = c.getSuperclass()) {

            try {

                final Field field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;

            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot access field " + cls.getName());
            }
        }

        throw new IllegalArgumentException("Missing field " + cls.getName());

    }

    public static String readFieldValue(Field field, Object obj) throws IllegalAccessException {

        if(field!=null){

            Object valueaa = field.get(obj);

            return valueaa.toString().trim();

//                System.out.println("valueaa");
//                System.out.println(valueaa);

        } else{
            System.out.println("xxxxxxxxxx");
        }

        return null;

    }


    /**
     * trim
     *
     * @param string -
     * @param trimStr -
     * @return String
     */
    public static String trim(String string, String trimStr) {

        String str = string;

        while( str.startsWith( trimStr ) )
        {
            str = str.substring( trimStr.length() );
        }

        while( str.endsWith( trimStr ) )
        {
            str = str.substring( 0, str.length() - trimStr.length() );
        }

        return str;

    }

}
