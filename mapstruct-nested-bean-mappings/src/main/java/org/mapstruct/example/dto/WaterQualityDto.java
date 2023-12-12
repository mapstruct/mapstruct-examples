/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.dto;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author Sjaak Derksen
 */
@Builder
public class WaterQualityDto {

    private WaterQualityReportDto report;

    public WaterQualityReportDto getReport() {
        return report;
    }

    public void setReport(WaterQualityReportDto report) {
        this.report = report;
    }

}
