package cr.microservicios.mantenimientos.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("msg")
public class MensajesController {

	// @Autowired
	RestTemplate restTemplate;

	@RequestMapping("/test2")
	public ResponseEntity<?> prueba2() { // System.out.println(data.toString());
		return ResponseEntity.ok("test");
	}

	@GetMapping("/test")
	// @PreAuthorize("hasRole('ROLE_group1')")
	public ResponseEntity<?> prueba() {

		/*
		 * String url = "http://example.org/path/to/api"; String response =
		 * restTemplate.getForObject(url, User.class);
		 */

		/*
		 * String url = "http://example.org/path/to/api"; User[] response =
		 * restTemplate.getForObject(url, User[].class);
		 */

		/*
		 * String url = "http://example.org/path/to/api"; ResponseEntity<List<User>>
		 * response = restTemplate.exchange(url, HttpMethod.GET, null, new
		 * ParameterizedTypeReference<List<User>>() {}); List<User> data =
		 * response.getBody();
		 */

		/*
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * HttpHeaders headers = new HttpHeaders(); headers.setBasicAuth("uBseGenSit",
		 * "Ibkubssit16+"); headers.setContentType(MediaType.APPLICATION_JSON);
		 * 
		 * HashMap<String, String> hash = new HashMap<>(); hash.put("codeID",
		 * "0050000029"); hash.put("documentIdType", "2"); hash.put("documentIdNumber",
		 * "20126709821");
		 * 
		 * HttpEntity<String> request = new HttpEntity<>(hash.toString(), headers);
		 * 
		 * String url =
		 * "https://dpisit.grupoib.local:5020/ibk/sit/api/enterprise-loan/v1/loan-limit/warranty";
		 * ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,
		 * request, String.class); String body = response.getBody();
		 */

		/*
		 * CredentialsProvider provider = new BasicCredentialsProvider();
		 * UsernamePasswordCredentials credentials = new
		 * UsernamePasswordCredentials("uBseGenSit", "Ibkubssit16+");
		 * provider.setCredentials(AuthScope.ANY, credentials);
		 * 
		 * HttpClient client =
		 * HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		 * 
		 * String url =
		 * "https://dpisit.grupoib.local:5020/ibk/sit/api/enterprise-loan/v1/loan-limit/warranty";
		 * HttpResponse response = client.execute(new HttpPost(url));
		 */

		// request url
		// String url =
		String url = "https://dpisit.grupoib.local:5020/ibk/sit/api/enterprise-loan/v1/loan-limit/warranty";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// add basic authentication
		headers.setBasicAuth("uBseGenSit", "Ibkubssit16+");

		headers.set("X-INT-Device-Id", "0");
		headers.set("APIm-Debug", "true");
		headers.set("X-INT-Timestamp",
				"${=new java.text.SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss\").format(new Date())}");
		headers.set("X-INT-Service-Id", "ATM");
		headers.set("X-INT-Net-Id", "IS");
		headers.set("X-IBM-Client-Id", "489f5b95-2507-48e8-839a-b4424ef7e447");
		headers.set("X-INT-Supervisor-Id", "SXFL0000");
		headers.set("X-INT-Consumer-Id", "ATM");
		headers.set("X-INT-Branch-Id", "100");
		headers.set("X-INT-Message-Id",
				"${=new java.text.SimpleDateFormat(\"yyyyMMddHHmmssZZZZZ\").format(new Date())}");
		headers.set("X-INT-User-Id", "BSE0000");

		Map<String, Object> bodymap = new HashMap<String, Object>();
		bodymap.put("codeID", "0050000029");
		bodymap.put("documentIdType", "2");
		bodymap.put("documentIdNumber", "20126709821");

		// build the request
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(bodymap, headers);

		// send POST request
		ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);

		// System.out.println(data.toString());
		return ResponseEntity.ok("test ok");
	}

}
