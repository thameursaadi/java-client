package problems.judges;
/**
 * Example presents error handling for updateJudge() API method  
 */

import java.util.Map;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;

import com.SphereEngine.Api.ProblemsClientV3;
import com.google.gson.JsonObject;

public class updateJudgeErrorHandling 
{

	public static void main(String[] args) 
	{
		Map<String, String> env = System.getenv();
		ProblemsClientV3 client = new ProblemsClientV3(
				"your_access_token", 
				"problems.sphere-engine.com");
		
		String source = "int main() { return 0; }";
		Integer nonexistingCompiler = 9999;
		
		try {
			JsonObject response = client.updateJudge(1, source, nonexistingCompiler);
		} catch (NotAuthorizedException e) {
			System.out.println("Invalid access token");
		} catch (ForbiddenException e) {
			System.out.println("Access to the judge is forbidden");
		} catch (NotFoundException e) {
			// aggregates two possible reasons of 404 error
			// non existing judge or compiler
			System.out.println("Non existing resource (judge, compiler), details available in the message: " + e.getMessage());
		} catch (BadRequestException e) {
			System.out.println("Empty source");
		}
	}	
}
