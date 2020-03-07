package com.example.springfeignjwtclient.payload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductPayload {

	private String partNumber;
	private Map<String, String> name = new HashMap<>();
	private Map<String, String> shortDescription = new HashMap<>();
	private Map<String, String> longDescription = new HashMap<>();
	private Map<String, String> auxDescription1 = new HashMap<>();
	private Map<String, String> auxDescription2 = new HashMap<>();
	private Map<String, String>  keywords = new HashMap<>();
	private Map<String, String> published = new HashMap<>();
	private String availabilityDate;
	private String field5;
	private String startDate;
	private String endDate;
	private String buyable;
	private String mfPartNumber;
	private String mfName;
	private List<String> thumbnail = new ArrayList<>();
	private List<String> fullImage = new ArrayList<>();
	private String heroImage;
	private String xupc;
	private String xTaxCode;
	Map<String,String> urlKeyword = new HashMap<>();
	Map<String,String> pageTitle = new HashMap<>();
	Map<String,String> metaDescription = new HashMap<>();
	Map<String,String> imageAltText = new HashMap<>();
	private String masterCategory;
	private String sequence;
}
