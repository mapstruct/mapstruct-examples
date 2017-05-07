package org.mapstruct.example.protobuf;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

public class ProtobufAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    @Override
    public String getElementName(ExecutableElement adderMethod) {

        String methodName = super.getPropertyName(adderMethod);
        Element receiver = adderMethod.getEnclosingElement();
        if (receiver != null) {
            TypeElement type = (TypeElement) ((DeclaredType) receiver).asElement();
            if (type != null) {
                TypeMirror superType = type.getSuperclass();
                if ("com.google.protobuf.GeneratedMessageV3".equals(superType.toString())) {
                    methodName += "List";
                }
            }
        }
        return methodName;
    }

}