package com.springboot.employeemanagementsystem.Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class FetchAllEmployeeResponse {
    private int status;
    private String statusDesc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<FetchEmployeeWrapperResponse> data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    FetchEmployeeWrapperResponse fetchEmployeeByIdResponse;

}
