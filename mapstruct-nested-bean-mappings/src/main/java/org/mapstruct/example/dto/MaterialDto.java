/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.dto;

/**
 *
 * @author Sjaak Derksen
 */
public class MaterialDto {

    private String manufacturer;
    private MaterialTypeDto materialType;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public MaterialTypeDto getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialTypeDto materialType) {
        this.materialType = materialType;
    }

}
