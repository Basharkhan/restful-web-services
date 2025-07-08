package com.khan.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	// uri version
	@GetMapping("/v1/person")
	public PersonV1 findPersonV1() {
		return new PersonV1("Bashar");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 findPersonV2() {
		return new PersonV2(new Name("Bashar", "Khan"));
	}
	
	// param version
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 findPersonV1ByParam() {
		return new PersonV1("Bashar");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 findPersonV2ByParam() {
		return new PersonV2(new Name("Bashar", "Khan"));
	}
	
	// header version
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 findPersonV1ByHeader() {
		return new PersonV1("Bashar");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 findPersonV2ByHeader() {
		return new PersonV2(new Name("Bashar", "Khan"));
	}
	
	// media version
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 findPersonV1ByMedia() {
		return new PersonV1("Bashar");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 findPersonV2ByMedia() {
		return new PersonV2(new Name("Bashar", "Khan"));
	}

}








