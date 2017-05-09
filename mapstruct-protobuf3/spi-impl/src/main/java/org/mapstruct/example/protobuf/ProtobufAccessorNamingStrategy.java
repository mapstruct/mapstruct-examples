package org.mapstruct.example.protobuf;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

/**
 * @author Thomas Kratz
 */
public class ProtobufAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    public static final String PROTOBUF_GENERATED_MESSAGE_V3 = "com.google.protobuf.GeneratedMessageV3";
    public static final String LIST_SUFFIX = "List";

    @Override
    public String getElementName(ExecutableElement adderMethod) {

        String methodName = getPropertyName(adderMethod);
        Element receiver = adderMethod.getEnclosingElement();
        if (receiver != null && receiver.getKind() == ElementKind.CLASS) {
            TypeElement type = (TypeElement) receiver;
            TypeMirror superType = type.getSuperclass();
            if (superType != null && PROTOBUF_GENERATED_MESSAGE_V3.equals(superType.toString())) {
                methodName += LIST_SUFFIX;
            }
        }
        return methodName;
    }

}