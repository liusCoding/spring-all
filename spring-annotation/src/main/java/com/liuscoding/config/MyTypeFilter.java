package com.liuscoding.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @className: MyTypeFilter
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:55
 */

public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader : 读取到的当前正在扫描的类信息
     * @param metadataReaderFactory ：可以获取到其它任何类的信息
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源（类路径）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("----->" + className);
        if (className.contains("er")){
            return true;
        }
        return false;
    }
}
