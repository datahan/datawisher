package com.datawisher.jpa.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Jim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVO {

    private Long id;

    private String email;

    private Integer age;

    private String name;
}
