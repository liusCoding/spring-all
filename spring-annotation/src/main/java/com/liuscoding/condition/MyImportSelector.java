package com.liuscoding.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @className: MyImportSelector
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 11:31
 */

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {


    /**
     *
     * @param importingClassMetadata
     * @return  String[] 当前标注@Import注解类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {


        return new String[]{"com.liuscoding.bean.Yellow","com.liuscoding.bean.Blue"};
    }
}
