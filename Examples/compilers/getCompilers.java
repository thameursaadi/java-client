package compilers;
/**
 * Example presents usage of the successful getCompilers() API method  
 */

import java.util.Map;

import com.SphereEngine.Api.CompilersClientV3;
import com.google.gson.JsonObject;

public class getCompilers 
{

	public static void main(String[] args) 
	{
		Map<String, String> env = System.getenv();
		CompilersClientV3 client = new CompilersClientV3(
				"your_access_token", 
				"compilers.sphere-engine.com");
		
		JsonObject response = client.getCompilers();
	}	
}