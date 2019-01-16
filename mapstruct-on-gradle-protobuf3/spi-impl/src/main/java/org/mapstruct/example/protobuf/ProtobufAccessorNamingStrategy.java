package org.mapstruct.example.protobuf;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;
import org.mapstruct.ap.spi.MapStructProcessingEnvironment;

/**
 * @author Thomas Kratz
 * @author Filip Hrisafov
 */
public class ProtobufAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    public static final String PROTOBUF_MESSAGE_OR_BUILDER = "com.google.protobuf.MessageOrBuilder";
    public static final String LIST_SUFFIX = "List";

    protected TypeMirror protobufMesageOrBuilderType;

    @Override
    public void init(MapStructProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        TypeElement typeElement = elementUtils.getTypeElement(PROTOBUF_MESSAGE_OR_BUILDER);
        if (typeElement != null) {
            protobufMesageOrBuilderType = typeElement.asType();
        }
    }

    @Override
    public String getElementName(ExecutableElement adderMethod) {

        String methodName = super.getElementName(adderMethod);
        Element receiver = adderMethod.getEnclosingElement();
        if (receiver != null && protobufMesageOrBuilderType != null && typeUtils.isAssignable(receiver.asType(), protobufMesageOrBuilderType)) {
            methodName += LIST_SUFFIX;
        }
        return methodName;
    }

}