package com.lenycer.domain.simple;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Simple {
	
	@ApiModelProperty(notes = "pk of the user")
	private int id;
	
	@ApiModelProperty(notes = "The name of the user", required = false)
	private String name;
}
