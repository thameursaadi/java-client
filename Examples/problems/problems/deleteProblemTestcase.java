package problems.problems;
/**
 * Example presents usage of the successful deleteProblemTestcase() API method  
 */

import com.SphereEngine.Api.ProblemsClientV3;
import com.google.gson.JsonObject;

public class deleteProblemTestcase 
{

	public static void main(String[] args) 
	{
		ProblemsClientV3 client = new ProblemsClientV3(
				"<access_token>", 
				"<endpoint>");
		
		String problemCode = "EXAMPLE";
		Integer testcaseNumber = 0;
		
		JsonObject response = client.deleteProblemTestcase(problemCode, testcaseNumber);
	}	
}
