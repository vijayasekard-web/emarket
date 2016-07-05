package com.onemove.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.onemove.model.Corporations;
import com.onemove.model.PortalUsers;
import com.onemove.model.ResultSet;
import com.onemove.model.UserUpdateObject;
import com.onemove.util.AuthenticationUtil;
import com.onemove.util.CRUDHandler;
import com.sun.jersey.multipart.FormDataParam;
import com.onemove.authenticate.AuthenticationController;
import com.onemove.authenticate.CRUDController;
import com.onemove.exception.InvalidPasswordException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.Port;

@Path("/")
public class JSONService {

	@POST
	@Path("/userauth")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultSet getTrackInJSON(@FormParam("username") String userName, @FormParam("password") String password){

		ResultSet result = new ResultSet();
		result.setSuccess(true);
		return result;

	}

	@GET
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	public PortalUsers insertData(@QueryParam("username") String userName, @QueryParam("password") String password){
		PortalUsers portalUser = new PortalUsers();
		return portalUser;
	}

	@POST
	@Path("/authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultSet authenticatUser(@Context HttpServletRequest requestContext,@FormParam("username") String userName, @FormParam("password") String password, @FormParam("ipaddress") String sourceIp, @FormParam("appcode") int appCode){
		System.out.println("IP Address is " + requestContext.getRemoteAddr());
		return AuthenticationController.authenticateUser(requestContext,userName, password, sourceIp, appCode);
	}

	@GET
	@Path("/addcorp")
	@Produces(MediaType.APPLICATION_JSON)
	public Corporations addCorporation(@QueryParam("corp_code") int corporationCode, @QueryParam("corp_name") String corporationName){
		return CRUDController.addCorporation(corporationCode, corporationName);
	}
	
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultSet addPortalUser(UserUpdateObject userUpdateObject) {
		ResultSet resultSet = new ResultSet();
		System.out.println("PortalUser is " + userUpdateObject.getCorporationId());
		if(AuthenticationUtil.isAdminLoginSuccess(userUpdateObject)){
			System.out.println("Inside Admin Success" + userUpdateObject.getUserName());
		resultSet = CRUDController.addPortalUser(userUpdateObject);
		}else{
			resultSet.setSuccess(false);
			resultSet.setFailureMessage("Admin login failure");
		}
		return resultSet;
	}
	
	@POST
	@Path("/updateuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultSet updatePortalUser(UserUpdateObject userUpdateObject) {
		ResultSet resultSet = new ResultSet();
		if(AuthenticationUtil.isAdminLoginSuccess(userUpdateObject)){
			resultSet = CRUDController.updatePortalUser(userUpdateObject);
		}else{
			resultSet.setSuccess(false);
			resultSet.setFailureMessage("Admin login failure");
		}
		return resultSet;
	}
	
	@POST
	@Path("/deleteuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultSet deletePortalUser(UserUpdateObject userUpdateObject) {
		ResultSet resultSet = new ResultSet();
		System.out.println("PortalUser is " + userUpdateObject.getCorporationId());
		if(AuthenticationUtil.isAdminLoginSuccess(userUpdateObject)){
			resultSet = CRUDController.deletePortalUser(userUpdateObject);
		}else{
			resultSet.setSuccess(false);
			resultSet.setFailureMessage("Admin login failure");
		}
		return resultSet;
	}
	
	@POST
	@Path("/getuser")
	@Produces(MediaType.APPLICATION_JSON)
	public PortalUsers getPortalUser(@Context HttpServletRequest requestContext,@FormParam("username") String userName, @FormParam("ipaddress") String sourceIp, @FormParam("appcode") int appCode) {
		System.out.println("Username at first is " + userName);
		PortalUsers portalUser = CRUDHandler.getPortalUser(userName);
		return portalUser;
	}
	
	@POST
	@Path("/updatepwd")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultSet updatePassword(@Context HttpServletRequest requestContext,@FormParam("adminusername") String adminUserName,@FormParam("adminpassword") String adminPassword,@FormParam("username") String username,@FormParam("password") String password, @FormParam("ipaddress") String sourceIp, @FormParam("appcode") int appCode) {
		ResultSet resultSet = new ResultSet();
		if(AuthenticationUtil.isAdminLoginSuccess(adminUserName,adminPassword)){
			resultSet = AuthenticationController.updatePassword(username, password);
		}else{
			resultSet.setSuccess(false);
			resultSet.setFailureMessage("Admin login failure");
		}
		return resultSet;
	}
}