package org.mapstruct.example.repo.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.mapstruct.example.repo.AddToRepo;
import org.mapstruct.example.repo.MapperRepo;
import org.mapstruct.example.repo.StandardMapper;

/**
 * @author sjaakd
 *
 */
@SupportedAnnotationTypes( "org.mapstruct.example.repo.AddToRepo" )
public class RepositoryGenerator extends AbstractProcessor {

    private Filer filer;
    private Messager messager;
    private List<RepoItem> repoItems = new ArrayList<>(  );

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        this.filer = processingEnv.getFiler();
        this.messager = processingEnv.getMessager();
        Elements elementUtils = processingEnv.getElementUtils();
        Types typeUtils = processingEnv.getTypeUtils();

        TypeMirror standardMapperType =
                        typeUtils.erasure( elementUtils.getTypeElement( StandardMapper.class.getName() ).asType() );
        TypeMirror addToRepoType = elementUtils.getTypeElement( AddToRepo.class.getName() ).asType();


        for ( TypeElement annotation : annotations ) {

            if ( typeUtils.isSameType( addToRepoType, annotation.asType() ) ) {
                Iterator<? extends Element> i = roundEnv.getElementsAnnotatedWith( annotation ).iterator();
                List<DeclaredType> standardMappers = new ArrayList<>(  );
                while ( i.hasNext() ) {
                    Element mapperCandidateElement = i.next();
                    TypeMirror mapperCandidateType = mapperCandidateElement.asType();
                    if ( typeUtils.isAssignable( mapperCandidateType, standardMapperType ) ) {
                        repoItems.add( toRepoItem( (DeclaredType ) mapperCandidateType ) );
                    }
                    else {
                        messager.printMessage(
                                        Diagnostic.Kind.WARNING,
                                        "@AddToRepo annotated class should implement a StandardMapper",
                                        annotation
                        );
                    }
                }

            }
        }
        if ( roundEnv.processingOver() ) {
            write( elementUtils.getTypeElement( MapperRepo.class.getName() ) );
        }
        return true;
    }

    private RepoItem toRepoItem(DeclaredType mapper) {
        RepoItem result = null;
        for ( Element element : mapper.asElement().getEnclosedElements() ) {
            if ( element.getKind() == ElementKind.METHOD && "map".equals( element.getSimpleName().toString() ) ) {
                ExecutableElement method = (ExecutableElement) element;
                result = new RepoItem( (DeclaredType) method.getParameters().get( 0 ).asType(),
                                (DeclaredType) method.getReturnType(),
                                mapper
                );
            }
        }
        return result;
    }

    private void write(TypeElement mapperElement) {
        try (Writer writer = filer.createSourceFile( MapperRepo.class.getName() + "Impl", mapperElement )
                                  .openWriter()) {
            Configuration cfg = new Configuration( new Version( "2.3.21" ) );
            cfg.setClassForTemplateLoading( RepositoryGenerator.class, "/" );
            cfg.setDefaultEncoding( "UTF-8" );

            Map<String, Object> templateData = new HashMap<>();

            templateData.put( "repoItems", repoItems );
            Template template = cfg.getTemplate( "MapperRepoImpl.ftl" );
            template.process( templateData, writer );
        }
        catch ( TemplateException | IOException ex ) {
            throw new IllegalStateException( ex );
        }
    }

}
