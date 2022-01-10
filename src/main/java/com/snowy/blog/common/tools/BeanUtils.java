package com.snowy.blog.common.tools;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.Builder;

import java.util.Collection;
import java.util.List;

/**
 * @author snowy
 * @date 2021/12/6 22:25
 */
public class BeanUtils {

    private BeanUtils() {

    }

    private static class OrikaTools{
        private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();
        private static final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();
    }



    public static <E,T> E  map(T data, Class<E> toClass){
        return OrikaTools.MAPPER_FACADE.map(data,toClass);
    }

    public static <E,T> List<E> mapAsList(Collection<T> data, Class<E> toClass){
        return OrikaTools.MAPPER_FACADE.mapAsList(data,toClass);
    }
}
