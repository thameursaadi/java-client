package problems.problems;
/**
 * Example presents error handling for updateProblemTestcase() API method  
 */

import java.util.Map;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;

import com.SphereEngine.Api.ProblemsClientV3;
import com.google.gson.JsonObject;

public class updateProblemTestcaseErrorHandling 
{

	public static void main(String[] args) 
	{
		Map<String, String> env = System.getenv();
		ProblemsClientV3 client = new ProblemsClientV3(
				env.get("SE_ACCESS_TOKEN_PROBLEMS"), 
				env.get("SE_ENDPOINT_PROBLEMS"));
		
		String problemCode = "TEST";
		Integer testcaseNumber = 0;
		Integer newNonexistingJudge = 9999;
		
		try {
			JsonObject response = client.updateProblemTestcase(problemCode, testcaseNumber, null, null, null, newNonexistingJudge);
		} catch (NotAuthorizedException e) {
			System.out.println("Invalid access token");
		} catch (ForbiddenException e) {
			System.out.println("Access to the problem is forbidden");
		} catch (NotFoundException e) {
			// aggregates three possible reasons of 404 error
			// non existing problem, testcase or judge
			System.out.println("Non existing resource (problem, testcase or judge), details available in the message: " + e.getMessage());
		}
	}	
}
