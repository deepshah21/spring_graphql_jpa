package com.pluralsight.fundamentals.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Application")  // 404
public class ApplicationNotFountException  extends RuntimeException implements GraphQLError{

	private Map<String, Object> extensions = new HashMap();
	
	public ApplicationNotFountException(Integer id) {
        super("Application id not found : " + id);
        extensions.put("invalidApplicationId", id);
    }

	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		// TODO Auto-generated method stub
		return ErrorType.DataFetchingException;
	}
	
	@Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
	
}
