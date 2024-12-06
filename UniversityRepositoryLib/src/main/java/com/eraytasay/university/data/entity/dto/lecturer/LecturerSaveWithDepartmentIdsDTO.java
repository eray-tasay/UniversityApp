package com.eraytasay.university.data.entity.dto.lecturer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LecturerSaveWithDepartmentIdsDTO extends LecturerSaveDTO {
    @JsonProperty(required = true)
    public List<Integer> departments;
}
