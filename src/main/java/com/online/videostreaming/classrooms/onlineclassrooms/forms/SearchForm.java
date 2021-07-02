package com.online.videostreaming.classrooms.onlineclassrooms.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchForm {

	private String keyword;
	private String batch;
	private String courseCategory;
}
