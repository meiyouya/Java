package com.zql.compiler;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

/**
 * 名称检查器
 * @author lawliet.L
 */
public class NameChecker {

    private final Messager messager;
    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnvironment) {
        this.messager = processingEnvironment.getMessager();
    }

    public void checkNames(Element element) {
        nameCheckScanner.scan(element);
    }

    /**
     * 名称检查的扫描器，通过扫描语法树中的元素来进行名称检查
     */
    private class NameCheckScanner extends ElementScanner8<Void, Void> {

        /**
         * 重写Java类的检查
         * @param e
         * @param aVoid
         * @return
         */
        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            scan(e.getTypeParameters(), aVoid);
            checkCamelCase(e, true);
            super.visitType(e, aVoid);
            return null;
        }

        /**
         * 重写方法的检查
         * @param e
         * @param aVoid
         * @return
         */
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD) {
                // 方法类型的元素
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "普通方法的名字不能和类名一样");
                }
                checkCamelCase(e, false);
            }
            super.visitExecutable(e, aVoid);
            return null;
        }

        /**
         * 重写变量的检查
         * @param e
         * @param aVoid
         * @return
         */
        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || isConstant(e)) {
                // 如果是枚举或者常量，则需要按照全大写的检查
                checkAllCaps(e);
            } else {
                checkCamelCase(e, false);
            }
            return null;
        }

        /**
         * 判断元素是否是常量
         * @param element
         * @return
         */
        private boolean isConstant(VariableElement element) {
            if (element.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
                // 接口中定义的都是常量
                return true;
            } else if (element.getKind() == ElementKind.FIELD && element.getModifiers().containsAll(
                    EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL))) {
                // 修饰符有public static final的是常量
                return true;
            }
            return false;
        }
        /**
         * 驼峰命名检查
         * @param e
         * @param initialCaps
         */
        private void checkCamelCase(Element e, boolean initialCaps) {
            String name = e.getSimpleName().toString();
            // 进行规则进行驼峰命名的检查，对于不符合规则的，使用messager输出信息
            messager.printMessage(Diagnostic.Kind.ERROR, "这是错误级别的信息");
            messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "这是强制警告的信息");
            messager.printMessage(Diagnostic.Kind.WARNING, "这是警告级别的信息");
            messager.printMessage(Diagnostic.Kind.NOTE, "这是提示信息");
            messager.printMessage(Diagnostic.Kind.OTHER, "这是其它信息");
        }

        /**
         * 纯大写命名检查
         * @param e
         */
        private void checkAllCaps(VariableElement e) {
            // TODO 纯大写命名检查
            messager.printMessage(Diagnostic.Kind.NOTE, "纯大写命名检查");
        }
    }
}
