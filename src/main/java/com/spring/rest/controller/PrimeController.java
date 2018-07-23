package com.spring.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.rest.ExceptionMapper.InvalidRequest;
import com.spring.rest.model.SuccessResponse;
import com.spring.rest.model.UpperLimitModel;
import com.spring.rest.service.PrimeNumberService;

@RestController
public class PrimeController {

	@Autowired
	private PrimeNumberService userService;

	@Autowired
	SuccessResponse successResponse;
	
	@RequestMapping("/Test")
    public String index() {
        return "Hello Test";
    }
	
	@Value("${DEFAULT_UPPERLIMIT}")
	private String defaultValue;
	
	@RequestMapping(value="/getPrimeNumbers", method=RequestMethod.GET)
	public Iterable<Integer> getPrimeNumbers() throws InvalidRequest {
		int upLimit=userService.getUpLimit();
		if(upLimit==0){
			System.out.println(defaultValue);
			upLimit=Integer.parseInt(defaultValue);
		}
		else if(upLimit==1 || upLimit<0){
			throw new InvalidRequest(600, "Ivalid input request.Upper limit is less than or equals to 1.");
		}
		return userService.getPrimeNumberList(upLimit);
	}
	
	@RequestMapping(value="/setUpperLimit", method = RequestMethod.POST)
	public ResponseEntity setUpperLimitPost(@RequestBody UpperLimitModel upperLimitRe) throws InvalidRequest{
		int upperLimit=0;
		try
		{
			upperLimit=upperLimitRe.getUpperLimit();
			if(upperLimit==1 || upperLimit<0){
				throw new InvalidRequest(600, "Ivalid input request.Upper limit is less than or equals to 1.");
			}
		    userService.setUpLimit(upperLimit);
			successResponse.setSuccessCode(200);
			successResponse.setSuccessMessage("Upper Limit Set to : "+upperLimit);
		}
		catch(InvalidRequest e){
			throw e;
		}
		catch(Exception e){
			throw new InvalidRequest(300, "Ivalid input request only accepts integer.");
		}
		
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}
	
	
}
