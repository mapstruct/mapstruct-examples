package org.mapstruct.example.repo.generator;

import javax.lang.model.type.DeclaredType;

/**
 * @author sjaakd
 *
 */
public class RepoItem {

    private DeclaredType sourceType;
    private DeclaredType targetType;
    private DeclaredType mapperType;

    public RepoItem(DeclaredType sourceType, DeclaredType targetType, DeclaredType mapperType) {
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.mapperType = mapperType;
    }

    public String getSourceType() {
        return sourceType.toString();
    }

    public String getTargetType() {
        return targetType.toString();
    }

    public String getMapperType() {
        return mapperType.toString();
    }

    public String getSourceTypeShort() {
        return sourceType.asElement().getSimpleName().toString();
    }

    public String getTargetTypeShort() {
        return targetType.asElement().getSimpleName().toString();
    }

    public String getMapperTypeShort() {
        return mapperType.asElement().getSimpleName().toString();
    }

}
