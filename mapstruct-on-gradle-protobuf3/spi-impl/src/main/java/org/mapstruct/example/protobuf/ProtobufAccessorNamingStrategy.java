package org.mapstruct.example.protobuf;

import java.util.List;
import java.util.Map;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;
import org.mapstruct.ap.spi.MapStructProcessingEnvironment;
import org.mapstruct.ap.spi.MethodType;

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

    @Override
    public boolean isSetterMethod(ExecutableElement method) {
        if ( super.isSetterMethod( method ) && !isProtoBufMethod( method ) && !isRemoveMethod( method )
                        && !isMergeFrom( method ) ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isGetterMethod(ExecutableElement method) {
        if ( super.isGetterMethod( method ) && !isBuilderListMethod( method ) && !isGetAllFieldsMethod( method )
                        && !isBuilderListMethod( method ) && !isValueListMethod( method ) ) {
            return true;
        }
        return false;
    }

    /* the following methods might be to crude for some use cases, more precise matching might be required */
    private boolean isProtoBufMethod(ExecutableElement method) {
        String argTypeName = method.getParameters().get( 0 ).asType().toString();
        return argTypeName.startsWith( "com.google.protobuf" );
    }

    private boolean isRemoveMethod(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        String argTypeName = method.getParameters().get( 0 ).asType().toString();
        return methodName.startsWith( "remove" ) && argTypeName.equals( "int" );
    }

    private boolean isBuilderListMethod(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        String returnTypeName = typeUtils.erasure( method.getReturnType() ).toString();
        return methodName.endsWith( "BuilderList" ) && returnTypeName.equals( List.class.getName() );
    }

    private boolean isValueListMethod(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        String returnTypeName = typeUtils.erasure( method.getReturnType() ).toString();
        return methodName.endsWith( "ValueList" ) && returnTypeName.equals( List.class.getName() );
    }

    private boolean isGetAllFieldsMethod(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        String returnTypeName = typeUtils.erasure( method.getReturnType() ).toString();
        return "getAllFields".equals( methodName ) && returnTypeName.equals( Map.class.getName() );
    }

    private boolean isMergeFrom( ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        return "mergeFrom".equals( methodName );
    }

}