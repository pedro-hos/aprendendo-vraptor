package br.com.pedroHos.controller;

import java.util.Set;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Options;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.HttpMethod;
import br.com.caelum.vraptor.events.VRaptorRequestStarted;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.view.Results;

@Controller
public class CORSController {
	
	private Result result;
	private Router router;

	/**
	 * @deprecated
	 */
	public CORSController() { }

	@Inject
	public CORSController(Result result, Router router) {
		this.result = result;
		this.router = router;
	}

	@Options
	@Path(value = "/*")
	public void options(@Observes VRaptorRequestStarted requestInfo) {
			
		Set<HttpMethod> allowed = router.allowedMethodsFor(requestInfo.getRequest().getRequestedUri());
		String allowMethods = allowed.toString().replaceAll("\\[|\\]", "");
		
		result.use(Results.status()).header("Allow", allowMethods);
		result.use(Results.status()).header("Access-Control-Allow-Methods", allowMethods);
		result.use(Results.status()).header("Access-Control-Allow-Headers", "Content-Type, X-Requested-With, accept, Authorization, origin");
	}

}
