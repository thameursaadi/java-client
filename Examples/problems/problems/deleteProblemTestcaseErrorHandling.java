package problems.problems;
/**
 * Example presents error handling for deleteProblemTestcase() API method   
 */

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;

import com.SphereEngine.Api.ProblemsClientV3;
import com.google.gson.JsonObject;

public class deleteProblemTestcaseErrorHandling 
{

	public static void main(String[] args) 
	{
		ProblemsClientV3 client = new ProblemsClientV3(
				"<access_token>", 
				"<endpoint>");
		
		String problemCode = "EXAMPLE";
		Integer nonexistingTestcaseNumber = 999;
		
		try {
			JsonObject response = client.deleteProblemTestcase(problemCode, nonexistingTestcaseNumber);
		} catch (NotAuthorizedException e) {
			System.out.println("Invalid access token");
		} catch (ForbiddenException e) {
			System.out.println("Access to the problem is forbidden");
		} catch (NotFoundException e) {
			// aggregates two possible reasons of 404 error
			// non existing problem or testcase
			System.out.println("Non existing resource (problem, testcase), details available in the message: " + e.getMessage());
		}
	}	
}
