package com.zql.compiler;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 在编译期检查名字是否符合我们自己定义的规范
 * 在编译时携带参数，指定此处理器即可使用
 * 如：javac -processor com.zql.compiler.NameCheckProcessor xxx.java
 * 在使用之前记得要使用javac先编译NameChecker和NameCheckProcessor
 * 编译时要在classpath目录下（即src）执行命令
 * demo：
 * javac -encoding utf-8 com/zql/compiler/NameChecker.java
 * javac -encoding utf-8 com/zql/compiler/NameCheckProcessor.java
 * javac -encoding utf-8 -processor com.zql.compiler.NameCheckProcessor com/zql/compiler/GenericTypeTest.java
 * @author lawliet.L
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {

    private NameChecker nameChecker;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements()) {
                nameChecker.checkNames(element);
            }
        }
        return false;
    }
}
