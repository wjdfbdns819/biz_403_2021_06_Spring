package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Builder 패턴을 사용할수 있도록 선언하는 Anootation
 *  Builder 패턴 : GoF에서 제안하는 VO, DTO를 사용하는 중요한 개념
 *   
 */
@Builder

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BookDTO {

	private String title;			//string	
	private String link;			//string	
	private String image;			//string	
	private String author;			//string	
	private String price;			//integer	
	private String discount;		//integer	
	private String publisher;		//string	
	private String isbn;			//integer	
	private String description;		//string	
	private String pubdate;			//datetime	
	
}
