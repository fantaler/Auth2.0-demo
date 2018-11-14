package com.qhy.controller;

import com.qhy.domain.User;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserInfoController {

	@RequestMapping("/userInfo") 
	public HttpEntity userInfo(HttpServletRequest request) throws OAuthSystemException{
		System.out.println("-----------服务器端/userInfo-------------------------------------------------------------");
	     
		try {
			OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);
		      String accessToken = oauthRequest.getAccessToken();
		      System.out.println("accessToken is not null : " + accessToken);
		      if (accessToken == null || "".equals(accessToken)) {
		    	  System.out.println("accessToken is null");
		      OAuthResponse oauthResponse = OAuthRSResponse  
		              .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)  
		              .setError(OAuthError.ResourceResponse.INVALID_TOKEN)  
		              .buildHeaderMessage();  
		  
		        HttpHeaders headers = new HttpHeaders();  
		        headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,   
		          oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));  
		      return new ResponseEntity(headers, HttpStatus.UNAUTHORIZED);  
		      }  
				User user = new User();
				user.setUid(1);
				user.setUname("qhy");
				user.setUemail("aaa@163.com");
				user.setUpassword("bbbbb");
		      String username = user.getUname();
		      System.out.println(username);
		      return new ResponseEntity(username, HttpStatus.OK);
		} catch (OAuthProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		      String errorCode = e.getError();
		      if (OAuthUtils.isEmpty(errorCode)) {  
		        OAuthResponse oauthResponse = OAuthRSResponse  
		               .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)  
		               .buildHeaderMessage();  
		  
		        HttpHeaders headers = new HttpHeaders();  
		        headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,   
		          oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));  
		        return new ResponseEntity(headers, HttpStatus.UNAUTHORIZED);  
		      }  
		  
		      OAuthResponse oauthResponse = OAuthRSResponse  
		               .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)  
		               .setError(e.getError())  
		               .setErrorDescription(e.getDescription())  
		               .setErrorUri(e.getUri())  
		               .buildHeaderMessage();  
		  
		      HttpHeaders headers = new HttpHeaders();  
		      headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,   
		        oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));  
		      return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}  
	      
		
	}

}
